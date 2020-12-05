package com.question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
 * 创建文件并且写入字符然后在控制台上输出用FileReader来读取，用FileWriter来写入；
 * 两种方法可用；FileInputStream();FileOutputStream();
 */
public class FileReader_print_test {

	public static void main(String[] args) {
		String s="hello java";
		File f=new File("E:\\IoDemoforJava\\File.txt");
		FileReader fr=null;//FileInputStream fis=null;
		FileWriter fw=null;//FileOutputStream fos=null;
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fw=new FileWriter(f);
//				fos=new FileInputStream(f);
//				byte b[]=s.getByte();
//				fos.writer(b);
			for(int i=0;i<s.length();i++){
				fw.write(s.charAt(i));
			}
			fw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fr=new FileReader(f);
//				fis=new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		try {
			i=fr.read();
//			i=fis.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while(i!=-1){
				System.out.print((char)i);
				i=fr.read();
//				i=fis.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
