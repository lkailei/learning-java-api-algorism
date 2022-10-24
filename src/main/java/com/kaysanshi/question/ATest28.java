package com.kaysanshi.question;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * user:kay三石
 * time: 15:04
 * desc: 统计字符串的个数 "I'm go to swimming"
 * 例如：I:1 // ':1 // m:3 // 空格：3 // g:2// ...
 **/
public class ATest28 {
    public static void main(String[] args) {
        String str = "I'm go to swimming";
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            set.add(s);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String sr = (String) it.next();
            int k = 0;
            for (int j = 0; j < str.length(); j++) {
                if (sr.equals(str.substring(j, j + 1))) {
                    k++;
                }
            }
            System.out.println(sr + "有" + k + "个");
        }
    }
}
