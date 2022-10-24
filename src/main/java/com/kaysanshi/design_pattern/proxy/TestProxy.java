package com.kaysanshi.design_pattern.proxy;

/**
 * user:kay三石
 * time: 21:24
 * desc:
 **/
public class TestProxy {
    public static void main(String[] args) throws Exception {
        Person obj = (Person) new KBoss().getInstance(new Customer());
        System.out.println(obj.getClass());
        obj.handlerBusiness();
    }
    /**
     * ~output
     * 我是中国移动代理商现在为你缴纳花费
     * 开始缴纳
     * 花费充值办理业务
     * 缴纳完毕，等待移动返回数据
     */
}
