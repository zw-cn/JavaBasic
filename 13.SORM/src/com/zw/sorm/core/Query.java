package com.zw.sorm.core;

import java.util.List;

/**
 * @program: JavaBasic
 * @description: 负责查询（对外提供服务的核心接口）
 * @author: zw-cn
 * @create: 2020-03-13 15:54
 */
@SuppressWarnings("all")
public interface Query {
    /**
     * @param sql    sql语句
     * @param params 参数
     * @description: 直接执行一个DML语句
     * @return: int 影响的行数
     * @author: zw-cn
     * @time: 3/13/2020 3:57 PM
     */
    int executeDML(String sql, Object... params);

    /**
     * @param object 要存储的对象
     * @description: 将一个对象存储到数据库中
     * @return: void
     * @author: zw-cn
     * @time: 3/13/2020 4:00 PM
     */
    void insert(Object object);

    /**
     * @param clazz 跟表对应类的Class对象
     * @param id    主键ID
     * @description: 删除clazz表示的类对应在表中的记录（指定主键ID值的记录）
     * @author: zw-cn
     * @time: 3/13/2020 4:03 PM
     */
    void delete(Class clazz, Object id);

    /**
     * @param object
     * @description: 删除对象在数据库中的记录（对象的类映射到表，主键的值映射对应的记录）
     * @return: void
     * @author: zw-cn
     * @time: 3/13/2020 4:01 PM
     */
    void delete(Object object);

    /**
     * @param object     所要更新的对象
     * @param fieldNames 更新的属性列表
     * @description: 更新对应对象指定字段的值
     * @return: int 影响的行数
     * @author: zw-cn
     * @time: 3/13/2020 4:16 PM
     */
    int update(Object object, String... fieldNames);

    /**
     * @param sql    查询sql
     * @param clazz  封装数据的JavaBean类的对象
     * @param params sql参数
     * @description: 查询多行记录，并将查询结果封装到clazz对应类的对象中
     * @return: java.util.List 返回查询的结果
     * @author: zw-cn
     * @time: 3/13/2020 4:19 PM
     */
    List queryRows(String sql, Class clazz, Object... params);

    /**
     * @param sql    查询sql
     * @param params sql参数
     * @description: 查询返回一个值（一行一列），并将该值返回
     * @return: java.lang.Object 查询结果
     * @author: zw-cn
     * @time: 3/13/2020 4:22 PM
     */
    Object queryRow(String sql, Object... params);

    /**
     * @param sql    查询sql
     * @param params sql参数
     * @description: 查询返回一个数字（一行一列），并将该值返回
     * @return: java.lang.Number
     * @author: zw-cn
     * @time: 3/13/2020 4:24 PM
     */
    Number queryValue(String sql, Object... params);
}
