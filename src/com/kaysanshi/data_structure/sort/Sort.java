package com.kaysanshi.data_structure.sort;


/**
 * 排序算法
 * @author leoill
 *@date 2019��4��23��
 */
public class Sort {
	/**
	 * 冒泡排序
	 * @param arry
	 */
	public static void bubblesort(long [] arry){
		for(int i=0;i<arry.length;i++){
			for(int j=arry.length-1;j>i;j--){
				if (arry[j]<arry[j-1]) {
					//一次替换
					long temp;
					temp=arry[j];
					arry[j]=arry[j-1];
					arry[j-1]=temp;
				}
			} 
		}
	}
	/**
	 * 快速排序
	 * @param arry
	 */
	public static void quicklySort(long[] arry,int left,int right){
		if (right-left<=0) {
			return;
		}else{
			
			//设置基点
			long point=arry[right];
			//
			int partition=partition(arry, left, right, point);
			//���������������п�������
			quicklySort(arry, left, partition-1);
			//���������������п�������
			quicklySort(arry, partition+1, right);
			
		}
		
		
	}
	/**
	 * 分戈两个数组
	 * @param arry
	 * @param left
	 * @param right
	 * @param point
	 */
	public static int partition(long[] arry,int left,int right,long point){
		int leftPtr=left-1;//��ָ��
		int rightPtr=right+1;//��ָ��
		//��֤��ߵ�����������С
		while(true){
			//ѭ��:���ȹؼ���С���������
			while(leftPtr <rightPtr && arry[++leftPtr]<point);
			//ѭ�������ȹؼ��ִ�������Ҷ�
			while(rightPtr >leftPtr && arry[--rightPtr]>point);
			if (leftPtr>=rightPtr) {
				break; 
			}else {
				long temp=arry[leftPtr];
				arry[leftPtr]=arry[rightPtr];
				arry[rightPtr]=temp;
			}
		}
		//���ؼ��ֺ͵�ǰ����ָ��leftPtr��ָ�Ľ��н���
		long temp=arry[leftPtr];
		arry[leftPtr]=arry[right];
		arry[right]=temp;
		return leftPtr;
	}
	
	/**
	 * 选择排序
	 */
	public static void selectSort(long[] arry){
		int k=0;
		long temp=0;
		for(int i=0;i<arry.length-1;i++){
			k=i;// k为第0个元素
			for(int j=i;j<arry.length;j++){
				if (arry[j]<arry[k]) {
					k=j;
				}
			}
			//ָ���Ϊ��С������
			temp=arry[i];
			arry[i]=arry[k];
			arry[k]=temp;
		}
	}
	/**
	 * 插入排序
	 */
	public static void insertsort(long[]  arry){
		//�������2��λ�ÿ�ʼ i=1;
		long temp=0;
		for(int i=1;i<arry.length;i++){
			temp=arry[i];//ָ��ǰ�����
			int j=i;
			while (j>0 && arry[j]>=temp) {
				arry[j]=arry[j-1];//����
				j--;
			}
			arry[j]=temp;
		}
	}
	
	
}
