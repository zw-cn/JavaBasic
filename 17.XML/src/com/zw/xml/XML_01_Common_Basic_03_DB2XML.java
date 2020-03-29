package com.zw.xml;

import com.zw.sorm.core.Query;
import com.zw.sorm.core.QueryFactory;
import com.zw.sorm.core.TableContext;
import com.zw.sorm.utils.ReflectUtils;
import com.zw.xml.po.U_emp;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.XMLFormatter;

/**
 * <p>Title: JavaBasic-com.zw.xml</p>
 * <p>Description: 将数据库信息转换为xml保存起来</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/29/2020
 */
public class XML_01_Common_Basic_03_DB2XML {
    public static void main(String[] args) {

        Query query = QueryFactory.createQuery();
        TableContext.uprateJavaPOFiles();
        System.out.println(TableContext.class);
        List empList = query.queryRows("select * from u_emp", U_emp.class, null);
        writeDB2XML("./17.XML/src/com/zw/xml/test02_dtd/"+U_emp.class.getSimpleName()+".xml",empList,U_emp.class);
    }

    private static void writeDB2XML(String path, List empList, Class clazz) {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement(clazz.getSimpleName()+"s");
        for (Object o : empList) {
            Element element = root.addElement(clazz.getSimpleName());
            String primaryKeyName = TableContext.getPOClassTableMap().get(clazz).getPrimaryKey().getColumnName();
            element.addAttribute(primaryKeyName, String.valueOf(ReflectUtils.invokeGet(primaryKeyName,o)));
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if(field.getName().equals(primaryKeyName)){
                    continue;
                }
                Element subElement = element.addElement(field.getName());
                subElement.addText(String.valueOf(ReflectUtils.invokeGet(field.getName(),o)));
            }
        }

        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileWriter(path),format);
            writer.write(doc);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
