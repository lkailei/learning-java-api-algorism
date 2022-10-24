package com.kaysanshi.question;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileOutputStream_test {
	/*
	 * 通过读入读取来把自己要写入的信息写入到文件中并且读取到控制台中
	 */
	public static void main(String[] args) {
//		fileInputStream 字节的输入流；
//		FileOutputStream字节的输出流；
		String s="中文汉字写入到程序文本中";
		String s2="abcdefasdfgghhhhh";
		FileOutputStream fos=null;
		FileOutputStream fos1=null;
		FileInputStream  fis=null;
		FileReader fir=null;
		File f=new File("E:\\IoDemoforJava\\javaString");
		File f2=new File("E:\\IoDemoforJava\\javaSubString");
		if(!f.exists()){
			try {
				System.out.println("开始创建文件");
				f.createNewFile();
				System.out.println("文件已创建");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(!f2.exists()){
			try {
				System.out.println("开始创建文件");
				f2.createNewFile();
				System.out.println("文件已创建");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fos=new FileOutputStream(f);
			fos1=new FileOutputStream(f2);
			fir=new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("现在进行写入操作");
		byte[] b=s.getBytes();
		byte[] b2=s2.getBytes();
		try {
			fos.write(b);
			fos1.write(b);
//				在fos1的对象中继续写入一些文本
			fos1.write(b, s.length()/2, s.length());
//				把s2中的信息也写入到文本程序中；
			fos.write(b2);
			fos1.write(b2);
			System.out.println("写入成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();
				fos1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fis=new FileInputStream("E:\\IoDemoforJava\\javaString");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		try {
			i=fis.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("现在进行读取工作");
		while(i!=-1){
			try {
				i=fir.read();
				System.out.print((char)i);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==-1){
				System.out.println("读取完毕");
			}
		}


	}
}
