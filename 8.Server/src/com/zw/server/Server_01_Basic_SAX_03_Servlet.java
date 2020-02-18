package com.zw.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @program: JavaBasic
 * @description: 使用SAX解析web.xml
 * @author: zw-cn
 * @create: 2020-02-14 01:00
 */
public class Server_01_Basic_SAX_03_Servlet {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        WebXMLHandler webXMLHandler = new WebXMLHandler();
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xmls/web.xml"), webXMLHandler);
        System.out.println(webXMLHandler.toString());
        WebContext webContext = new WebContext(webXMLHandler.getServletList(), webXMLHandler.getMappingList());
        String servletName = webContext.getClazz("/reg");
        Class servletClass = Class.forName(servletName);
        System.out.println(servletClass);
        Servlet servlet = (Servlet) (servletClass.getConstructor().newInstance());
        servlet.service();
    }
}

class WebXMLHandler extends DefaultHandler {
    private List<SAXServlet> servletList;//servlet列表
    private List<SAXMapping> mappingList;//mapping列表
    private SAXServlet servlet;//当前servlet对象
    private SAXMapping mapping;//当前mapping对象
    private String currentElement;//当前元素
    private String tag;//当前标签

    public WebXMLHandler() {
        this.servletList = new ArrayList<>();
        this.mappingList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("servlet".equals(qName)) {
            servlet = new SAXServlet();
            currentElement = "servlet";
        }
        if ("servlet-mapping".equals(qName)) {
            mapping = new SAXMapping();
            currentElement = "servlet-mapping";
        }
        tag = qName;
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (contents.length() > 0) {
            if ("servlet".equals(currentElement)) {
                if ("servlet-name".equals(tag)) {
                    servlet.setName(contents);
                }
                if ("servlet-class".equals(tag)) {
                    servlet.setClazz(contents);
                }
            }
            if ("servlet-mapping".equals(currentElement)) {
                if ("servlet-name".equals(tag)) {
                    mapping.setName(contents);
                }
                if ("url-pattern".equals(tag)) {
                    mapping.addPattern(contents);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("servlet".equals(qName)) {
            servletList.add(servlet);
            currentElement = null;
        }
        if ("servlet-mapping".equals(qName)) {
            mappingList.add(mapping);
            currentElement = null;
        }
        tag = null;
    }

    @Override
    public String toString() {
        System.out.println("servlets number->" + servletList.size());
        System.out.println("mappings number->" + mappingList.size());
        StringBuilder servlets = new StringBuilder();
        for (SAXServlet s : servletList) {
            servlets.append(s.toString());
        }
        StringBuilder mappings = new StringBuilder();
        for (SAXMapping s : mappingList) {
            mappings.append(s.toString());
        }
        return servlets.toString() + "\n" + mappings.toString();
    }

    public List<SAXServlet> getServletList() {
        return servletList;
    }

    public List<SAXMapping> getMappingList() {
        return mappingList;
    }
}

/**
 * @description: servlet实体类
 * @author: zw-cn
 * @create: 2020/2/14 1:17
 */
class SAXServlet {
    private String name;
    private String clazz;

    public SAXServlet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "SAXServlet{" +
                "name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}

/**
 * @description: servlet-mapping实体类
 * @author: zw-cn
 * @create: 2020/2/14 1:17
 */
class SAXMapping {
    private String name;
    private Set<String> pattern;

    public SAXMapping() {
        pattern = new HashSet<>();
    }

    public void addPattern(String pattern) {
        this.pattern.add(pattern);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPattern() {
        return pattern;
    }

    public void setPattern(Set<String> pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "SAXMapping{" +
                "name='" + name + '\'' +
                ", pattern=" + pattern +
                '}';
    }
}

/**
 * @description: 处理xml类
 * @author: zw-cn
 * @create: 2020/2/14 18:25
 */
class WebContext {
    private HashMap<String, String> servletMap;
    private HashMap<String, String> mappingMap;

    public WebContext(List<SAXServlet> servletList, List<SAXMapping> mappingList) {
        servletMap = new HashMap<>();
        mappingMap = new HashMap<>();
        for (SAXServlet servlet : servletList) {
            servletMap.put(servlet.getName(), servlet.getClazz());
        }
        for (SAXMapping mapping : mappingList) {
            for (String s : mapping.getPattern()) {
                mappingMap.put(s, mapping.getName());
            }
        }
    }

    public String getClazz(String pattern) {
        String clazz;
        clazz = servletMap.get(mappingMap.get(pattern));
        return clazz;
    }
}

interface Servlet {
    void service();
}

class LoginServlet implements Servlet {
    /**
     * @description: 若不写空构造器，会在反射生成对象时报错
     *              java.lang.NoSuchMethodException: com.zw.server.LoginServlet.<init>()
     * @param
     * @return:
     * @author: zw-cn
     * @time: 2020/2/14 18:48
     */
    public LoginServlet() {//
    }

    @Override
    public void service() {
        System.out.println("loading loginServlet...");
    }
}

class RegisterServlet implements Servlet {
    public RegisterServlet() {
    }

    @Override
    public void service() {
        System.out.println("loading RegisterServlet...");
    }
}