package com.example.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wzw
 * @date 2024/11/5 13:51
 * @description

 */
@Slf4j(topic = "s")
public class AwaitTest3 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        // t2线程 因为某条件不满足 进入等待队列
        Thread thread = new Thread(() -> {
            try {
                lock.lock();
                log.debug("因为某些条件无法满足，进入等待");
                condition.awaitNanos(5000000000l);//5秒
                log.debug("条件满足了被唤醒，开始工作");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
        lock.lock();
        // 创建5个线程，因为拿不到锁都进入阻塞队列
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    log.debug("t" + (finalI + 3) + "线程拿不到锁 进入阻塞队列");
                    lock.lock();
                    log.debug("t" + (finalI + 3) + "线程拿到锁，开始工作");
                    TimeUnit.SECONDS.sleep(2);//模拟工作时间2秒
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "t" + (i + 3)).start();
        }
        TimeUnit.MILLISECONDS.sleep(100);//确保t3 - t7 5个线程都进入阻塞队列
        lock.unlock();
    }
}


