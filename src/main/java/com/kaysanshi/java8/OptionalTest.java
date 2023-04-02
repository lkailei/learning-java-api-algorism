package com.kaysanshi.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        // 如果为空否则
        String s=new String("123");
        Optional.ofNullable(s).orElse("123");
        Student student=new Student();
        student.setName("张三");
        student.setNumber(123);
        Optional.ofNullable(student).orElse(new Student());
        Optional.ofNullable(student).orElseThrow(()->new RuntimeException("123"));
        List<Student> studentList = new ArrayList<>();
        System.out.println(studentList.size());
        studentList.add(student);
        studentList.stream().filter(student1 -> student1.getName().equals("张三")).findFirst().orElseThrow(()->new RuntimeException("未找到"));

    }
}

class Student{
    private Integer number;

    private String name;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
