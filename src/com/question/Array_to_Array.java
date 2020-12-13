package com.question;

import java.util.Scanner;

public class Array_to_Array {
    //	数组反转 ；
	//	一定要找出共性和其中的原理；
    public static void change(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                int temp;
                temp = arr[i];
                arr[i] = arr[	arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        }
        System.out.println();
        System.out.println("反转后的数组");
        for (int x : arr)
            System.out.print(x + " ");
    }

    //	利用for循环来遍历数组，初始表达式定义两个指针，记录第一袁术，和最后一个元素，int min=0,max=
	//	利用boolean表达式；
    public static void Change(int[] arr) {
        for (int min = 0, max = arr.length - 1; min <= max; min++, max--) {
            int temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
        System.out.println();
        System.out.println("反转后的数组");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    //	数组元素的反转；
    public static void main(String[] args) {
        int arr[] = new int[6];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
        scan.close();
        Array_to_Array.Change(arr);
        Array_to_Array.change(arr);
    }
}
