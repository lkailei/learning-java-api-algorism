package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 12:42
 * desc: 百钱百鸡。公鸡五元一只，母鸡3元一致，小鸡一元3只，问100元怎样可以买100指鸡
 * 一只母鸡等价于 ： 9只小鸡
 * 一只公鸡等价于 一只母鸡+6只小鸡
 * 100元最多买20只公鸡，33只母鸡+3只小鸡。  100只小鸡（题目说买100只） 只要考虑鸡100只，花费100元即可
 **/
public class BHmhc {
    public static void main(String[] args) {
        int cock,hen,chicken=0;
        for(cock=0;cock<=19;cock++){
            for(hen=0;hen<=33;hen++){
                chicken=100-cock-hen;
                int p;
                p = chicken%3;
                if(((5*cock+3*hen+chicken/3)==100)&&(p==0)){
                    System.out.print("公鸡数："+cock);
                    System.out.print("母鸡数："+hen);
                    System.out.print("小鸡数："+chicken);
                    System.out.println("\n");
                }
            }
        }
    }
}
