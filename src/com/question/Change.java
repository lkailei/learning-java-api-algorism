package com.question;

import java.util.Scanner;

//????i,??j;???
public class Change {
	public void test(int i,int j){
		i=i*j;
		j=i/j;
		i=i/j;
		System.out.println("????????λ");
		System.out.println(i+","+j);
	}
	public static void main(String[] args) {
		Change change=new Change();
			Scanner scanner=new Scanner(System.in);
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			change.test(x, y);
		}
}
