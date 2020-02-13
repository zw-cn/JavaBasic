package com.zw.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * @program: JavaBasic
 * @description: SAX解析的基本流程
 * @author: zw-cn
 * @create: 2020-02-13 14:08
 */
public class Server_01_Basic_SAX_01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("xmls/p.xml"), handler);//这个地方卡了我很久，相当于线程的根目录

    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("start to parse document!");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement -> "+ qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (contents.length() > 0){
            System.out.println("characters ->" + contents);
        }else {
            //System.out.println("there is nothing");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("endElement -> "+ qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end to parse document!");
    }
}
