package com.kaysanshi.design_pattern.factory.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * user:kay三石
 * time: 20:49
 * desc: 数据库连接池管理类
 **/
public final class DBConnectionPool extends Pool {

    // 正在使用的连接数
    private int checkedOut;
    // 存放产生的连接对象容器
    private final Vector<Connection> freeConnections = new Vector<>();

    private String passWord = null;

    private String url = null;

    private String userName = null;

    // 空闲的连接时间
    private static int num = 0;

    // 当前可用的连接数

    private static int numActive = 0;

    // 连接池实例变量
    private static DBConnectionPool pool = null;

    // 产生数据库连接池
    public static synchronized DBConnectionPool getInstance() {
        if (pool == null) {
            pool = new DBConnectionPool();
        }
        return pool;
    }

    private DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection connection = newConnection();
                if (connection != null) {
                    freeConnections.addElement(connection);
                    num++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception {
        InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.userName = p.getProperty("userName");
        this.passWord = p.getProperty("passWord");
        this.driverName = p.getProperty("driverName");
        this.url = p.getProperty("url");
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    private Connection newConnection() {
        Connection connection = null;
        try {
            if (userName == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, userName, passWord);
                System.out.println("连接池创建了一个新的连接");
            }
        } catch (SQLException throwables) {
            System.out.println("连接池无法创建了一个新的连接");

            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public void createPool() {

    }

    @Override
    public Connection getConnection() {
        Connection con = null;
        if (freeConnections.size() > 0) { // 还有空闲的连接
            num--;
            con = (Connection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (con.isClosed()) {
                    System.out.println("从连接池删除一个无效连接");
                    con = getConnection();
                }
            } catch (SQLException e) {
                System.out.println("从连接池删除一个无效连接");
                con = getConnection();
            }
        } else if (maxConnect == 0 || checkedOut < maxConnect) { // 没有空闲连接且当前连接小于最大允许值,最大值为0则不限制
            con = newConnection();
        }
        if (con != null) { // 当前连接数加1
            checkedOut++;
        }
        numActive++;
        return con;
    }

    @Override
    public Connection getConnection(long times) {
        long startTime = new Date().getTime();
        Connection con;
        while ((con = getConnection()) == null) {
            try {
                wait(times); //线程等待
            } catch (InterruptedException e) {
            }
            if ((new Date().getTime() - startTime) >= times) {
                return null; // 如果超时,则返回
            }
        }
        return con;
    }

    @Override
    public void freeConnection(Connection connection) {
        freeConnections.addElement(connection);
        num++;
        checkedOut--;
        numActive--;
        notifyAll(); //解锁
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public int getNumActive() {
        return numActive;
    }

    /**
     * 关闭所有连接
     */
    public synchronized void release() {
        try {
            //将当前连接赋值到 枚举中
            Enumeration allConnections = freeConnections.elements();
            //使用循环关闭所用连接
            while (allConnections.hasMoreElements()) {
                //如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素
                Connection con = (Connection) allConnections.nextElement();
                try {
                    con.close();
                    num--;
                } catch (SQLException e) {
                    System.out.println("无法关闭连接池中的连接");
                }
            }
            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }
    }

}
