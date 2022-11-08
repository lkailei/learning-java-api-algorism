package com.kaysanshi.apache_commons.beanUtils;

public class Student {
    private Integer id;

    private String name;

    private Integer clazzId;

    private String clazzName;

    Student(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Student(Integer id, String name, Integer clazzId, String clazzName) {
        this.id = id;
        this.name = name;
        this.clazzId = clazzId;
        this.clazzName = clazzName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazzId=" + clazzId +
                ", clazzName='" + clazzName + '\'' +
                '}';
    }
}
