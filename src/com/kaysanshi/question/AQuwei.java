package com.kaysanshi.question;
//取出输入的数的每一位;
public class AQuwei {
	//倒叙输出;思想为先取出各位在整除取出剩下的位数;
	public void test(int  m){
		while (m>=10) {
			int s=m%10;
			System.out.println(s);
			m=m/10;
		}
		System.out.println(m);
	}
	//正序输出;把取出的各个位的数值,存储到数组中然后倒叙输出;
	int a[]=new int[10];
	public void test1(int m){
		int k=0;
		while(m>=10){
			a[k]=m%10;
			k++;
			m=m/10;
		}
		a[k]=m;
		for(int j=k;j>=0;j--){
			System.out.println(a[j]);
		}
	}
	//递归调用;递归是循环的调用自身,来实现取值
	public void caculate(int m){
		if(m<10){
			System.out.println(m);

		}else{
			System.out.println(m%10);
			this.caculate(m/10);
		}
	}
	//递归调用正序输出;先取出最高位的数字;
	public void caculate1(int m){
		if (m<10) {
			System.out.println(m);
		}else{
			this.caculate1(m/10);
			System.out.println(m%10);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AQuwei q=new AQuwei();
		q.test(456);
		q.caculate(123);
		q.test1(789);
		q.caculate1(895);
	}

}
