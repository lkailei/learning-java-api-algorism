package com.kaysanshi.sort;


/**
 * 冒泡排序
 * @author leoill
 *@date 2019年4月23日
 */
public class Sort {
	/**
	 * 冒泡排序：思想左右对比，然后是对应的左面大的话不动，  
	 * @param arry
	 */
	public static void bubblesort(long [] arry){
		for(int i=0;i<arry.length;i++){
			for(int j=arry.length-1;j>i;j--){
				if (arry[j]<arry[j-1]) {
					//进行交换
					long temp;
					temp=arry[j];
					arry[j]=arry[j-1];
					arry[j-1]=temp;
				}
			} 
		}
	}
	/**
	 * 快速排序:通过一个数组划分为若干个子数组，然后通过递归调用自身为每一个子数组进行快速排序
	 * 设定关键字比关键字大的设定为一组，比关键字小的放为一组，设置数组最右端的数据为关键字
	 * @param arry
	 */
	public static void quicklySort(long[] arry,int left,int right){
		if (right-left<=0) {
			return;
		}else{
			//这里使用递归迪调用的方式
			
			//设定point:关键字
			long point=arry[right];
			//获取切点
			int partition=partition(arry, left, right, point);
			//对左面的子数组进行快速排序
			quicklySort(arry, left, partition-1);
			//对右面的子数组进行快速排序
			quicklySort(arry, partition+1, right);
			
		}
		
		
	}
	/**
	 * 为快速排序划分数组
	 * @param arry
	 * @param left
	 * @param right
	 * @param point
	 */
	public static int partition(long[] arry,int left,int right,long point){
		int leftPtr=left-1;//左指针
		int rightPtr=right+1;//右指针
		//保证左边的数组比右面的小
		while(true){
			//循环:将比关键字小的留在左端
			while(leftPtr <rightPtr && arry[++leftPtr]<point);
			//循环：将比关键字大的留在右端
			while(rightPtr >leftPtr && arry[--rightPtr]>point);
			if (leftPtr>=rightPtr) {
				break; 
			}else {
				long temp=arry[leftPtr];
				arry[leftPtr]=arry[rightPtr];
				arry[rightPtr]=temp;
			}
		}
		//将关键字和当前的所指的leftPtr所指的进行交换
		long temp=arry[leftPtr];
		arry[leftPtr]=arry[right];
		arry[right]=temp;
		return leftPtr;
	}
	
	/**
	 * 选择排序：从未排的序列中找最大或最小的元素，存放在序列的起始位置，然后再从剩余的未排序元素中继续寻找最小的(大)的元素
	 * 然后放到已排序序列的末位
	 */
	public static void selectSort(long[] arry){
		int k=0;
		long temp=0;
		for(int i=0;i<arry.length-1;i++){
			k=i;//k指向（每次循环的首个）
			for(int j=i;j<arry.length;j++){
				if (arry[j]<arry[k]) {
					k=j;
				}
			}
			//指向的为最小的数据
			temp=arry[i];
			arry[i]=arry[k];
			arry[k]=temp;
		}
	}
	/**
	 * 插入排序
	 *  通过构建一个有序数列，对于未排序的数据在已排序的数据中进行向前扫描，找到相应的位置插入，通常采用in-place排序，因而在从后向前扫描过程中，需要反复
                把已排序元素逐步向后挪位，为新的元素提供插入的空间。
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
	
	
}
