package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 12:29
 * desc: 输出菱形空心的 完成一个10行的
 **/
public class BDiamond {
    public static void main(String[] args) {
        printHollowRhombus(10);
    }

    private static void printHollowRhombus(int size) {
        if(size%2 ==0){
            size++; // 计算菱形大小
        }
        // 上半部分
        for (int i=0;i<size/2+1;i++){
            for(int j=size/2+1;j>i+1;j--){
                // 输出左上角位置的空白
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                if(j==0||j==2*i){
                    System.out.print("*"); // 输出菱形的上班分别边缘
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
        // 下半部分
        for (int i=size/2+1;i<size;i++){
            for(int j=0;j<i-size/2;j++){
                System.out.print(" ");//
            }
            for(int j=0;j<2*size-1-2*i;j++){
                if(j==0||j==2*(size-i-1)){
                    System.out.print("*"); // 输出菱形的上班分别边缘
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }

    }
}
