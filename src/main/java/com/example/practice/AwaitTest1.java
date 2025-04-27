package com.example.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wzw
 * @date 2024/11/5 11:56
 * @description

 */
@Slf4j(topic = "s")
public class AwaitTest1 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                lock.lock();
                log.debug("因为某些条件无法满足，进入等待");
                condition.await();
                log.debug("条件满足了被唤醒，开始工作");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        TimeUnit.SECONDS.sleep(4);

        lock.lock();

        condition.signal();
        lock.unlock();
    }
}


