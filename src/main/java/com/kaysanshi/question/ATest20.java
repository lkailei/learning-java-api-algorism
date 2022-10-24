package com.kaysanshi.question;

import java.util.ArrayList;
import java.util.List;

/**
 * user:kay三石
 * time: 15:03
 * desc:对字母进行排序，如：s,a,g,d,b，排序后是a,b,d,g,s
 **/
public class ATest20 {
    public static void main(String[] args) {
        String s = "sagdb";
        List t = new ArrayList();
        for(int i=0;i<s.length();i++){
            String xx = s.substring(i,i+1);
            t.add(xx);
        }
        java.util.Collections.sort(t);
        System.out.println(t);
    }
}
