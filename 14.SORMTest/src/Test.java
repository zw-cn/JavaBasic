
import com.zw.sorm.core.Query;
import com.zw.sorm.core.QueryFactory;
import com.zw.sorm.core.TableContext;
import com.zw.sorm.po.U_dept;
import com.zw.sorm.po.U_emp;

/**
 * <p>Title: JavaBasic-PACKAGE_NAME</p>
 * <p>Description: 测试SORM</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/24/2020
 */
public class Test {
    public static void main(String[] args) {
        TableContext.uprateJavaPOFiles();
        Query query = QueryFactory.createQuery();
        System.out.println(query.queryRows("select * from u_emp", U_emp.class));
        U_dept dept = new U_dept();
        dept.setName("abc");
        query.insert(dept);
        System.out.println(query.queryById(U_dept.class,2));
    }

}
