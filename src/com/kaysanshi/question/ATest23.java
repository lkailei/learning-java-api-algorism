package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 15:03
 * desc:写一个函数，给你一个字符串，倒序输出来
 **/
public class ATest23 {
    public static void main(String[] args) {
        System.out.println(getString("ABCDFERG"));;
    }
    public static String getString(String str){
        if(str!=null){
            String newStr = "";
            for(int i=0;i<str.length();i++){
                char c = str.charAt(str.length()-1-i);
                newStr = newStr + c;
            }
            return newStr;
        }else{
            return null;
        }
    }
}
