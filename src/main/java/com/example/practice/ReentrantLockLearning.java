package com.example.practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wzw
 * @date 2024/11/3 21:22
 * @description

 */
public class ReentrantLockLearning {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

    }
}
