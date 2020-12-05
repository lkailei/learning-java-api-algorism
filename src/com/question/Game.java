package com.question;

import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args)
	{
		int x = 0;//用户的分数
		int y = 0;//电脑的分数
		int z = 0;//总共玩的局数

		System.out.println("猜拳游戏现在开始，准备好了吗？");
		System.out.println("===========游戏规则===========");
		System.out.println("    胜利加一分，否则不加分    ");
		System.out.println("    当游戏结束时分高者为胜    ");
		System.out.println("==============================");
		System.out.println("请选择数字出拳：");
		System.out.println("1 石头     2 剪刀     3 布     0 退出");
		while(true)
		{
			Scanner s = new Scanner(System.in);//获取用户输入的内容
			int a = s.nextInt();
			if(a==1||a==2||a==3||a==0){
				if (a == 1)
				{
					System.out.println("我出石头");
				} else if (a == 2)
				{
					System.out.println("我出剪刀");
				} else if (a == 3)
				{
					System.out.println("我出布");
				} else if (a == 0)//用户退出，比较用户总得分和电脑的总得分
				{
					System.out.println("我不想跟你玩了，你这个渣渣！");

					System.out.println("对战的次数：" + z );
					System.out.println("电脑的总得分："+y);
					System.out.println("我的总得分："+x);

					if ( x > y)//用户的分数比电脑的分数多
					{
						System.out.println("噢耶，完胜电脑！");
					} else if (x < y)
					{
						System.out.println("不幸输了，改日再来较量！");
					}else{
						System.out.println("彼此彼此，水平差不多嘛！");
					}
					break;//结束死循环
				}

				Random r = new Random();//获取随机数
				int b = r.nextInt(3) + 1;//0 ~ 2.999999 --> 1 ~ 3
				switch (b)
				{
					case 1:
						System.out.println("电脑出石头");
						break;
					case 2:
						System.out.println("电脑出剪刀");
						break;
					case 3:
						System.out.println("电脑出布");
						break;
				}
				if (a != 0)//用户没有退出才做比较
				{
					if (a == b)
					{
						System.out.println("平局");
					}else if ((a==1&&b==2) || (a==2&&b==3) || (a==3&&b==1))
					{
						System.out.println("用户赢！");
						x = x + 1;//x += 1; //用户赢了加一分
					}else
					{
						System.out.println("电脑赢了");
						y = y + 1;//y += 1; //电脑赢了加一分
					}
					z = z + 1;//总局数加1
				}
			}else{
				System.out.println("请按提示输入：");
			}
		}
	}
}
