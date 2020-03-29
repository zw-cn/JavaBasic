package com.zw.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * <p>Title: JavaBasic-com.zw.xml</p>
 * <p>Description: 通过Dom4j创建xml</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 3/29/2020
 */
public class XML_01_Common_Basic_02_WriteXML {
    public static void main(String[] args) {
        //1.通过DocumentHelper创建Document对象
        Document doc = DocumentHelper.createDocument();
        //2.添加根节点books
        Element books = doc.addElement("books");
        //3.添加元素book
        Element book = books.addElement("book");
        //4.book添加属性id
        book.addAttribute("id","001");
        //5.book添加子元素
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        Element price = book.addElement("price");

        name.addText("Head First");
        author.addText("Freeman");
        price.addText("10.5");

        //普通输出
        try(Writer writer = new FileWriter("./17.XML/src/com/zw/xml/test01/Book2.xml")){
            doc.write(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //美化格式的输出
        try(Writer writer = new FileWriter("./17.XML/src/com/zw/xml/test01/Book3.xml")){
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(writer, format);
            xmlWriter.write(doc);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
