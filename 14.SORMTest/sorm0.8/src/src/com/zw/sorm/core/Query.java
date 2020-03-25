package src.com.zw.sorm.core;


import src.com.zw.sorm.bean.ColumnInfo;
import src.com.zw.sorm.bean.TableInfo;
import src.com.zw.sorm.utils.JDBCUtils;
import src.com.zw.sorm.utils.ReflectUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: 负责查询（对外提供服务的核心接口）
 * @author: zw-cn
 * @create: 2020-03-13 15:54
 */
//@SuppressWarnings("all")
public abstract class Query implements Cloneable {
    /**
     * @param sql    sql语句
     * @param params 参数
     * @description: 直接执行一个DML语句
     * @return: int 影响的行数
     * @author: zw-cn
     * @time: 3/13/2020 3:57 PM
     */
    public int executeDML(String sql, Object... params) {
        int count = 0;
        Connection conn = DBManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            JDBCUtils.handleParams(ps, params);
            System.out.println("MySqlQuery.executeDML->" + ps);
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(conn);
        }
        return count;
    }

    /**
     * @param object 要存储的对象
     * @description: 将一个对象存储到数据库中
     * @return: void
     * @author: zw-cn
     * @time: 3/13/2020 4:00 PM
     */
    public void insert(Object object) {
        Class c = object.getClass();
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(c);
        Field[] fields = c.getDeclaredFields();
        StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTableName() + " (");
        int notNullFiled = 0;//不为空的属性值
        List<Object> params = new ArrayList<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            Object fieldValue = ReflectUtils.invokeGet(fieldName, object);

            if (fieldValue != null) {
                sql.append(fieldName + ",");
                notNullFiled++;
                params.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length() - 1, ')');

        sql.append(" values (");
        for (int i = 0; i < notNullFiled; i++) {
            sql.append("?,");
        }
        sql.setCharAt(sql.length() - 1, ')');
        executeDML(sql.toString(), params.toArray());
    }

    /**
     * @param clazz 跟表对应类的Class对象
     * @param id    主键ID
     * @description: 删除clazz表示的类对应在表中的记录（指定主键ID值的记录）
     * @author: zw-cn
     * @time: 3/13/2020 4:03 PM
     */
    public void delete(Class clazz, Object id) {
        //Emp.class,2-->delete from emp where id = 2
        //通过Class对象获取TableInfo
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(clazz);
        ColumnInfo primaryKey = tableInfo.getPrimaryKey();

        String sql = "delete from " + tableInfo.getTableName() + " where " + primaryKey.getColumnName() + "= ?";
        executeDML(sql, id);
    }

    /**
     * @param object
     * @description: 删除对象在数据库中的记录（对象的类映射到表，主键的值映射对应的记录）
     * @return: void
     * @author: zw-cn
     * @time: 3/13/2020 4:01 PM
     */
    public void delete(Object object) {
        Class c = object.getClass();
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(c);
        System.out.println(TableContext.getPOClassTableMap());
        ColumnInfo columnInfo = tableInfo.getPrimaryKey();

        //通过反射机制，调用属性对应的get方法
        Object key = ReflectUtils.invokeGet(columnInfo.getColumnName(), object);

        delete(c, key);
    }

    /**
     * @param obj        所要更新的对象
     * @param fieldNames 更新的属性列表
     * @description: 更新对应对象指定字段的值
     * @return: int 影响的行数
     * @author: zw-cn
     * @time: 3/13/2020 4:16 PM
     */
    public int update(Object obj, String... fieldNames) {
        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(c);
        ColumnInfo primaryKey = tableInfo.getPrimaryKey();
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("update " + tableInfo.getTableName() + " set ");
        for (String fieldName : fieldNames) {
            Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
            params.add(fieldValue);
            sql.append(fieldName + "=?,");
        }
        sql.setCharAt(sql.length() - 1, ' ');
        sql.append("where " + primaryKey.getColumnName() + " = ?");

        params.add(ReflectUtils.invokeGet("id", obj));//设置ID
        return executeDML(sql.toString(), params.toArray());
    }

    /**
     * @param sql    查询sql
     * @param clazz  封装数据的JavaBean类的对象
     * @param params sql参数
     * @description: 查询多行记录，并将查询结果封装到clazz对应类的对象中
     * @return: java.util.List 返回查询的结果
     * @author: zw-cn
     * @time: 3/13/2020 4:19 PM
     */
    public List queryRows(String sql, Class clazz, Object... params) {
        return (List) executeQueryTemplate(sql, clazz, new CallBack() {
            @Override
            public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
                List rows;
                try {
                    ResultSetMetaData metaData = rs.getMetaData();
                    rows = new ArrayList();
                    while (rs.next()) {
                        Object rowObj = clazz.getConstructor().newInstance();
                        //多列 select uname,age from u_user where id > ? and age < ?
                        for (int i = 0; i < metaData.getColumnCount(); i++) {
                            String columnName = metaData.getColumnLabel(i + 1);
                            Object columnValue = rs.getObject(i + 1);

                            //通过反射调用rowObj的set方法
                            ReflectUtils.invokeSet(rowObj, columnName, columnValue);
                        }
                        rows.add(rowObj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    rows = null;
                }
                return rows;
            }
        }, params);
    }

    /**
     * @param sql    查询sql
     * @param clazz  封装数据的JavaBean类的对象
     * @param params sql参数
     * @description: 查询返回一个值（一行一列），并将该值返回
     * @return: java.lang.Object
     * @author: zw-cn
     * @time: 3/15/2020 11:20 PM
     */
    public Object queryRow(String sql, Class clazz, Object... params) {
        List list = queryRows(sql, clazz, params);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    /**
     * <p>Description: 根据ID获取对象</p>
     *
     * @param clazz 查询的类
     * @param id    主键ID
     * @return java.lang.Object 返回查询对象
     * @author zw-cn
     * @date: 3/24/2020 5:26 PM
     */
    public Object queryById(Class clazz, Object id) {
        //Emp.class,2-->select * from emp where id = ?
        //通过Class对象获取TableInfo
        TableInfo tableInfo = TableContext.getPOClassTableMap().get(clazz);
        ColumnInfo primaryKey = tableInfo.getPrimaryKey();

        String sql = "select * from " + tableInfo.getTableName() + " where " + primaryKey.getColumnName() + "= ?";
        return executeDML(sql, id);
    }

    /**
     * @param sql    查询sql
     * @param params sql参数
     * @description: 查询返回一个数字（一行一列），并将该值返回
     * @return: java.lang.Object
     * @author: zw-cn
     * @time: 3/13/2020 4:24 PM
     */
    public Object queryValue(String sql, Object... params) {

        return executeQueryTemplate(sql, null, new CallBack() {
            @Override
            public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
                Object value = null;
                try {
                    if (rs.next()) {
                        value = rs.getObject(1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return value;
            }
        }, params);
    }

    /**
     * @param sql    查询sql
     * @param params sql参数
     * @description: 查询返回一个数字（一行一列），并将该值返回
     * @return: java.lang.Number
     * @author: zw-cn
     * @time: 3/15/2020 11:28 PM
     */
    public Number queryNumber(String sql, Object... params) {
        return (Number) queryValue(sql, params);
    }

    /**
     * @param pageNum 页码
     * @param size    每页显示的条数
     * @description: 分页查询
     * @return: java.lang.Object
     * @author: zw-cn
     * @time: 3/23/2020 11:06 AM
     */
    public abstract Object queryPagination(int pageNum, int size);

    /**
     * @param sql      sql语句
     * @param clazz    记录要封装到的Java类
     * @param callBack CallBack的实现类，实现回调
     * @param params   sql查询参数
     * @description: 采用模板方法模式将JDBC操作封装成模板，便于重用
     * @return: java.lang.Object
     * @author: zw-cn
     * @time: 3/23/2020 12:36 PM
     */
    public Object executeQueryTemplate(String sql, Class clazz, CallBack callBack, Object... params) {
        Connection conn = DBManager.getConnection();//从连接池中获取数据库连接
        try (
                PreparedStatement ps = JDBCUtils.handleParams(conn.prepareStatement(sql), params);
                ResultSet rs = ps.executeQuery()
        ) {
            return callBack.doExecute(conn, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBManager.releaseConnection(conn);//将数据库连接存入连接池中
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
