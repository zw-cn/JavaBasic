package com.zw.sorm.bean;

/**
 * @program: JavaBasic
 * @description: 配置信息
 * @author: zw-cn
 * @create: 2020-03-13 15:44
 */
public class Configuration {
    /*
    当前使用的数据库
     */
    private String currentDB;
    /*
    项目的源码路径
     */
    private String currentSrcPath;
    /*
    扫描生成Java类的包（PO Persistence Object持久化对象）
     */
    private String targetPackage;
    /*
    驱动类名
     */
    private String driver;
    /*
    数据库连接字符串
     */
    private String url;
    /*
    数据库用户名
     */
    private String user;
    /*
    数据库密码
     */
    private String password;
    /*
    使用的查询类
     */
    private String queryClass;
    /*
    连接池最大连接数
     */
    private Integer poolMaxSize;
    /*
    连接池最小连接数
     */
    private Integer poolMinSize;

    public String getCurrentDB() {
        return currentDB;
    }

    public void setCurrentDB(String currentDB) {
        this.currentDB = currentDB;
    }

    public String getCurrentSrcPath() {
        return currentSrcPath;
    }

    public void setCurrentSrcPath(String currentSrcPath) {
        this.currentSrcPath = currentSrcPath;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQueryClass() {
        return queryClass;
    }

    public void setQueryClass(String queryClass) {
        this.queryClass = queryClass;
    }

    public Integer getPoolMaxSize() {
        return poolMaxSize;
    }

    public void setPoolMaxSize(Integer poolMaxSize) {
        this.poolMaxSize = poolMaxSize;
    }

    public Integer getPoolMinSize() {
        return poolMinSize;
    }

    public void setPoolMinSize(Integer poolMinSize) {
        this.poolMinSize = poolMinSize;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "currentDB='" + currentDB + '\'' +
                ", currentSrcPath='" + currentSrcPath + '\'' +
                ", targetPackage='" + targetPackage + '\'' +
                ", driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
