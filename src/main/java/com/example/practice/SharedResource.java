package com.example.practice;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wzw
 * @date 2024/10/12 10:34
 * @description

 */
public class SharedResource implements Runnable {
    private volatile int count = 0;
    private final Object obj = new Object();
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {

            //synchronized (obj) {
            //    count++;
            //}
            //lock.lock();
            count++;
            System.out.println(Thread.currentThread().getName() + " counted to " + count);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(sharedResource);
        Thread thread2 = new Thread(sharedResource);

/*        thread1.start();
        thread2.start();*/

        useThreadPool();
    }


    public static void useThreadPool() {
        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        // 向线程池提交任务
        for (int i = 0; i < threadPool.getCorePoolSize(); i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int x = 0; x < 2; x++) {
                        System.out.println(Thread.currentThread().getName() + ":" + x);
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        // 关闭线程池
        threadPool.shutdown(); // 设置线程池的状态为SHUTDOWN，然后中断所有没有正在执行任务的线程
        // threadPool.shutdownNow(); // 设置线程池的状态为STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表，该方法要慎用，容易造成不可控的后果
    }
}
