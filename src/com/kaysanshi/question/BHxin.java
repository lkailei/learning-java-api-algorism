package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 13:50
 * desc: 韩信点兵 韩信带兵不足百人，3人一行排列多一人，7人一行排列少两人
 * 5人一行正好拍好：
 * 思路：只要将7人少两人转换为7人多5人即可
 **/
public class BHxin {
    public static void main(String[] args) {
        int a=0,b=0,c=0,person;
        for(person=0;person<100;person++){
            a=person%3; // 每排3人的剩余人数
            b=person%7;//每排7人剩余的人数
            c=person%5;// 每排5人剩余的人数
            if(a==1&&b==5&&c==0){
                System.out.println("韩信带的兵数:"+person);
            }
        }
    }
}
