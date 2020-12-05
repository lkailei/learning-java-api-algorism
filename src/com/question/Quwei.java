package com.question;
//ȡ�����������ÿһλ;
public class Quwei {
	//�������;˼��Ϊ��ȡ����λ������ȡ��ʣ�µ�λ��;
	public void test(int  m){
		while (m>=10) {
			int s=m%10;
			System.out.println(s);
			m=m/10;
		}
		System.out.println(m);
	}
	//�������;��ȡ���ĸ���λ����ֵ,�洢��������Ȼ�������;
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
	//�ݹ����;�ݹ���ѭ���ĵ�������,��ʵ��ȡֵ
	public void caculate(int m){
		if(m<10){
			System.out.println(m);
			
		}else{
			System.out.println(m%10);
			this.caculate(m/10);
		}
	}
//�ݹ�����������;��ȡ�����λ������;
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
		 Quwei q=new Quwei();
		 q.test(456);
		 q.caculate(123);
		 q.test1(789);
		 q.caculate1(895);
	}

}
