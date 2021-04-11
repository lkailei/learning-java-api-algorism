package com.kaysanshi.question;

/**
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 */
public class Bushizhitu_test {
    //	不死之兔
   //一对兔子从出生第三个月后每个兔子又生出一对兔子问第二十个月有多少对兔子？
    public static void main(String[] args) {
        int arr[] = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println("第二十个月是有兔子对数" + arr[19]);

    }

}

