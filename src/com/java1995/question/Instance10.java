package com.java1995.question;

// 反转字符串
public class Instance10 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String string = "this is a test";
        StringBuffer sb = new StringBuffer(string.length());
        for (int j = string.length() - 1; j >= 0; j--) {
            sb.append(string.charAt(j));
        }
        System.out.print(sb);
    }

}
