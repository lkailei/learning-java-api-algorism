package com.kaysanshi.shangguigu;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author kay三石
 * @date:2019/6/2
 * 适合读取很多的配置文件用，
 * 这里单例主要是用到了静态代码块中的。这些不存在线程安全问题的
 */
public class Singleton3 {

    public static final Singleton3 INSTANCE;

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    static {

        try {
            Properties properties=new Properties();
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE=new Singleton3(properties.getProperty("info"));

        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }

    }
    private Singleton3(String onfo){
        this.info=onfo;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
