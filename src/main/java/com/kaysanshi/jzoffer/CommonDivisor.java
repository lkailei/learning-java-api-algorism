package com.kaysanshi.jzoffer;

/**
 * user:kay三石
 * time: 21:59
 * desc:写一段代码，求出两个整数的最大公约数
 **/
public class CommonDivisor {

    /**
     * 暴力枚举法
     * @param a
     * @param b
     * @return
     */
    public  static  int getGreatestCommonDivisor(int a,int b){
        int big = a>b ? a:b;
        int min = a<b ? a:b;
        if(big%min ==0){
            return min;
        }
        for(int i= min/2;i>1;i--){
            if(min%i == 0 && big%i == 0){
                return i;
            }

        }
        return 1;
    }

    /**
     * 辗转相除法定理：如果两个正整数a,b(a>b)，他们的最大公约数等于a除以b的余数c和b之间的最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public  static  int getGreatestCommonDivisorV2(int a,int b){
        int big = a>b ? a:b;
        int min = a<b ? a:b;
        if(big%min ==0){
            return min;
        }
        return getGreatestCommonDivisorV2(big%min,min);
    }

    /**
     * 更相减损术：两个正整数a,b (a>b) 他们的最大公约数等于a-b的差值c和较小数b的最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV3(int a,int b){
        if (a==b){
            return a;
        }
        int big = a>b ? a:b;
        int min = a<b ? a:b;
        return getGreatestCommonDivisorV3(big-min,min);
    }

    /**
     * 把辗转相除法和更相减损术的优势相结合，在更相减损术的基础上使用移位运算
     * @param a
     * @param b
     * @return
     */
    public static  int getGreatestCommonDivisorV4(int a,int b){
        if (a==b) return a;
        if((a&1)==0 && (b&1)==0){
            return getGreatestCommonDivisorV3(a>>1,b>>1)<<1;
        }else if((a&1)==0 && (b&1)!=0){
            return getGreatestCommonDivisorV3(a>>1,b);
        }else if((a&1)!=0 && (b&1)==0){
            return getGreatestCommonDivisorV3(a,b>>1);
        }else{
            int big = a>b ? a:b;
            int min = a<b ? a:b;
            return getGreatestCommonDivisorV3(big-min,min);
        }
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(80,40));
        System.out.println(getGreatestCommonDivisor(160,44));
        System.out.println(getGreatestCommonDivisorV2(160,44));
    }
}
