package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 15:00
 * desc:用递归求N!=N*(N-1)*(N-2)*...*2*1;
 **/
public class ATest13 {
    public static void main(String[] args) {
        System.out.println(digui(8));
    }
    public static long digui(int i){
        if(i==0||i==1){
            return 1;
        }
        else{
            return i*digui(i-1);
        }
    }
}
