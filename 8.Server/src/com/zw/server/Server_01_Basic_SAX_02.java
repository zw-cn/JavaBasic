package com.zw.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaBasic
 * @description: SAX解析XML，升级存储为对象
 * @author: zw-cn
 * @create: 2020-02-13 18:52
 */
public class Server_01_Basic_SAX_02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        PersonXMLHandler pHandler = new PersonXMLHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xmls/p.xml"),pHandler);
        System.out.println(pHandler.toString());
    }
}
class PersonXMLHandler extends DefaultHandler{
    private List<Person> people;
    private Person currentPerson;
    private String currentTag;
    @Override
    public void startDocument() throws SAXException {
        people = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName != null){
            currentTag = qName;
        }
        if(("person").equals(currentTag)){
            currentPerson = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String elem = new String(ch, start, length).trim();
        if (elem.length() > 0){
            if (currentTag.equals("name")){
                currentPerson.setName(elem);
            }
            if (currentTag.equals("age")){
                currentPerson.setAge(Integer.valueOf(elem));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (("person").equals(qName)){
            people.add(currentPerson);
        }
        currentTag = null;
    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        System.out.println(people.size());
        for(Person p:people){
            sb.append(p.toString()).append(',');
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }
}
class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}