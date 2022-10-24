package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 16:00
 * desc:
 **/
public class BSushu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要判断的数：");
        int x=scanner.nextInt();
        int i=2,flag=0;
        while (flag==0&&i<x){
            if(x%i==0){
                flag=1;
            }else{
                i++;
            }
        }
        if(flag==0){
            System.out.println(x+"是素数");
        }else{
            System.out.println(x+"不是素数");
        }
    }
}
