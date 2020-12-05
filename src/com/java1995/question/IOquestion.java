package com.java1995.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOquestion {
	//创建一个中文字符串然后令其写入到文件在令其输出；？？？
	public static void main(String[] args) {
		String s="中国功夫";
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try {
			fos=new FileOutputStream("E:\\String");
			fis=new FileInputStream("E:\\String");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte []b=s.getBytes();
		try {
			fos.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a=0;
		try {
			a=fis.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(a!=-1){
			try {
				fis.read();
				System.out.print(a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
