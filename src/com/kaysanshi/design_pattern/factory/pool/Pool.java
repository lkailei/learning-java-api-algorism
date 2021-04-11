package com.kaysanshi.design_pattern.factory.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * user:kay三石
 * time: 22:27
 * desc:自定义一个连接池getInstance()，返回一个Pool的实例第一调用时执行构造函数
 * 构造函数Pool()调用装载驱动loadDriver()，createPool()函数创建连接池，loadDriver()装载驱动
 * getConnection() 返回一个连接实例，getConnection(long time) 返回一个添加时间的限制
 * getActiveNum()返回当前的使用的连接数
 **/
public abstract class Pool {
    public String propertiesName = "connection-INF.properties";
    // 定义唯一实例
    private static Pool instance = null;

    // 最大连接数
    protected int maxConnect = 100;

    // 保持连接数
    protected int normalConnect = 10;

    // 驱动字符串
    protected String driverName = null;

    // 驱动变量
    protected Driver driver = null;

    // 私有构造，外界不允许访问
    protected Pool() {
        try {
            init();
            loadDriver(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 初始化，所有从配置文件中读取的成员变量
    private void init() throws IOException {
        InputStream resourceAsStream = Pool.class.getResourceAsStream(propertiesName);
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        this.driverName = properties.getProperty("driverName");
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    // 装载和注册所有JDBC驱动程序
    protected void loadDriver(String driverName) {
        try {
            driver = (Driver) Class.forName(driverName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动" + driverName);
        } catch (Exception e) {
            System.out.println("无法注册JdBC驱动");
            e.printStackTrace();
        }
    }

    /**
     * 创建连接
     */
    public abstract void createPool();

    /**
     * 单例模式返回数据库的实例
     *
     * @return
     * @throws Exception
     */
    public static synchronized Pool getInstance() throws Exception {
        if (instance == null) {
            instance.init();
            instance = (Pool) Class.forName("org.e_book.sqlhelp.Pool").newInstance();
        }
        return instance;
    }

    public abstract Connection getConnection();


    public abstract Connection getConnection(long times);

    public abstract void freeConnection(Connection connection);

    public abstract int getNum();

    // 获取当前的连接数
    public abstract int getNumActive();

    // 释放连接
    protected synchronized void release() {
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC 驱动程序" + driver.getClass().getName());
        } catch (SQLException throwables) {
            System.out.println("无法撤销JDBC 驱动程序" + driver.getClass().getName());
            throwables.printStackTrace();
        }
    }


}
