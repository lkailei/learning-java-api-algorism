package com.kaysanshi.java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture cf =
                CompletableFuture.supplyAsync(CompletableFutureDemo::evenNumbersSum)
                        // 链式编程：基于上个任务的返回继续执行新的任务
                        .thenApply(r -> {
                            System.out.println("获取上个任务的执行结果：" + r);
                            // 通过上个任务的执行结果完成计算：求和100所有数
                            return r + oddNumbersSum();
                        }).thenApplyAsync(r -> {
                    System.out.println("获取上个任务的执行结果：" + r);
                    Integer i = r / 0; // 拋出异常
                    return r;
                }).handle((param, throwable) -> {
                    if (throwable == null) {
                        return param * 2;
                    }
                    // 获取捕获的异常
                    System.out.println(throwable.getMessage());
                    System.out.println("我可以在上个任务" +
                            "抛出异常时依旧执行....");
                    return -1;
                }).thenCompose(x ->
                        CompletableFuture.supplyAsync(() -> x+1
                        )).thenRun(() -> {
                    System.out.println("我是串行无返回任务....");
                });

        // 主线程执行休眠一段时间
        // 因为如果不为CompletableFuture指定线程池执行任务的情况下，
        // CompletableFuture默认是使用ForkJoinPool.commonPool()的线程
        // 同时是作为main线程的守护线程进行的，如果main挂了，执行异步任
        // 务的线程也会随之终止结束，并不会继续执行异步任务
        Thread.sleep(2000);
    }
    // 求和100内的偶数
    private static int evenNumbersSum() {
        int sum = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) sum += i;
        }
        return sum;
    }

    // 求和100内的奇数
    private static int oddNumbersSum() {
        int sum = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) sum += i;
        }
        return sum;
    }
}
