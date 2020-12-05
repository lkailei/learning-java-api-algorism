package com.question;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 用字符缓冲流来实现一个文本写入到另一个文本；BufferedInputStream方法；
 * 1.先是从文件中读取数据；
 * 2.把读到的数据写到另一文件中
 * 1(1):创建文件；(2):将数据写入到文件中(3)：将文件到控制台上，
 * 2(1):创建文件(2):读取文件一并调用write()方法写入到文件中；(3):同样可以到控制台上；
 */
public class File_to_File {

	public static void main(String[] args) {
		File f1=new File("E:\\IoDemoforJava\\text1");
		File f2=new File("E:\\IoDemoforJava\\text2");
		FileInputStream fis=null;
		FileOutputStream fos=null;
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		if(!f1.exists()){
			try {
				f1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!f2.exists()){
			try {
				f2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//	写入文件中的操作；
		try {
			fos=new FileOutputStream(f1);
			bos=new BufferedOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s="hello bufferedReaderInputStream";
		byte b[]=s.getBytes();
		try {
			bos.write(b);
			bos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//写入到文件1中完毕
//读取文件一的内容到控制台上;
		try {
			fis=new FileInputStream(f1);
			bis=new BufferedInputStream(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		try {
			while(i!=-1){
				System.out.print((char)i);
				i=bis.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//将文件一的内容写到文件二中；
		try {
			fos=new FileOutputStream(f2);
			bos=new BufferedOutputStream(fos);
			fis=new FileInputStream(f1);
			bis=new BufferedInputStream(fis);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int n=0;
		try {
			while(n!=-1){
				n=bis.read();
				bos.write(n);
				bos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	将文件二读到控制台上：
		System.out.println();
		System.out.println(f2.getAbsolutePath()+"到控制台输出");
		try {
			fis=new FileInputStream(f2);
			bis=new BufferedInputStream(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int m=0;
		while(m!=-1){
			try {
				System.out.print((char)m);
				m=bis.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
