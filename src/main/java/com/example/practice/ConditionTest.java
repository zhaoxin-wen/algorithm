package com.example.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 开启三个线程 ABC，按顺序打印ABC ABC....一直循环,使用Condition实现
 */
public class ConditionTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        ConditionTest test = new ConditionTest();
        // 开启线程A-----------------------------
        test.newThread(lock,"A",condition2,condition1);
        // 开启线程B-----------------------------
        test.newThread(lock,"B",condition3,condition2);
        // 开启线程C-----------------------------
        test.newThread(lock,"C",condition1,condition3);
    }
    /**
     * 开启新线程
     * @param name 线程名称
     * @param signalCondition  唤醒的线程
     * @param awaitCondition  等待的线程
     */
    public void newThread(Lock lock,String name,Condition signalCondition,Condition awaitCondition){
        new Thread(() -> {
            for (; ; ) {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
                try {
                    signalCondition.signal(); // 唤醒等待的线程
                    awaitCondition.await();// 让线程进入等待状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }, name).start();
    }
}
