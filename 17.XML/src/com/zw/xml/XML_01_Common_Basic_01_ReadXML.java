package com.zw.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * <p>Title: JavaBasic-com.zw.xml</p>
 * <p>Description: Dom4j基本操作</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/29/2020
 */
public class XML_01_Common_Basic_01_ReadXML {
    public static void main(String[] args) throws DocumentException {
        //1.获取Reader
        SAXReader reader = new SAXReader();
        //2.获取文档对象
        Document doc = reader.read(new File("./17.XML/src/com/zw/xml/test02_dtd/innerDTD.xml"));
        //3.获取根元素
        Element root = doc.getRootElement();
        //4.迭代获取元素所有内容
        Iterator<Element> it = root.elementIterator();
        while (it.hasNext()) {
            Element e = it.next();
            System.out.println(e.getName());
            Attribute id = e.attribute("id");
            System.out.println("id = " + id.getValue());
            //获取子元素
            Element name = e.element("name");
            Element course = e.element("course");
            Element score = e.element("score");
            //打印
            System.out.println("name = " + name.getStringValue());
            System.out.println("course = " + course.getText());
            System.out.println("score = " + score.getText());
            System.out.println("*****************");
        }
    }
}
