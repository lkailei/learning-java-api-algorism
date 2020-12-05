package com.kaysanshi.sort;
/**
 * 希尔排序：
 * 	通过加大插入排序中元素之间的间隔，并对这些间隔的元素，进行插入排序，从而使得数据可以大浮动的，当完成该间隔的排序后，希尔排序
 * 会减少数据的间隔在进行排序，依次进行下去
 * 
 * @author leoill
 *@date 2019年4月27日
 */
public class ShellSort {
	
	
	/**
	 * 插入排序：
	 * 缺陷：假如很小的数据在靠右端的位置，那么要将该数据排序到正确的位置上，则所有的中间的数据都需要向右移动
	 * 
	 */
	public static void insertsort(long[]  arry){
		//从数组的2号位置开始 i=1;
		long temp=0;
		for(int i=1;i<arry.length;i++){
			temp=arry[i];//指向当前的这个
			int j=i;
			while (j>0 && arry[j]>=temp) {
				arry[j]=arry[j-1];//右移
				j--;
			}
			arry[j]=temp;
		}
	}
	/**
	 * 希尔排序
	 * @param arry
	 */
	public static void shellsort(long[] arry){
		//初始化一个间隔
		int h=1;
		
		//计算最大间隔
		while(h<arry.length/3 ){
			h=h*3+1;
		}
		
		while(h>0){
			//进行插入排序
			long temp=0;
			for(int i=h;i<arry.length;i++){
				temp=arry[i];//指向当前的这个
				int j=i;
				while (j> h-1 && arry[j-h]>=temp) {
					arry[j]=arry[j-h];//右移
					j-=h;
				}
				arry[j]=temp;
			}	
			//减小间隔
			h=(h-1)/3;
		}
	}
	
	public static void main(String[] args) {
		long[] arry=new long[5];
		arry[0]=10;
		arry[1]=122;
		arry[2]=123;
		arry[3]=112;
		arry[4]=90;
		System.out.print("[");
		for(long num: arry){
			System.out.print(num + " ");
		}
		System.out.print("]");
		
		//
		ShellSort.shellsort(arry);
		//
		
		System.out.print("[");
		for(long num: arry){
			System.out.print(num + " ");
		}
		System.out.print("]");
	}
}
