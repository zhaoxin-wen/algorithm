package com.example.practice;

/**
 * @author wzw
 * @date 2024/11/4 13:37
 * @description

 */
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    // 账户余额
    private int balance;
    // 锁对象
    private final ReentrantLock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    // 存钱
    public void deposit(int amount) {
        lock.lock();  // 获取锁
        try {
            balance += amount;
            System.out.println("存入金额: " + amount + "，当前余额: " + balance);
        } finally {
            lock.unlock();  // 释放锁
        }
    }

    // 取钱
    public void withdraw(int amount) {
        lock.lock();  // 获取锁
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("取出金额: " + amount + "，当前余额: " + balance);
            } else {
                System.out.println("余额不足，取款失败！");
            }
        } finally {
            lock.unlock();  // 释放锁
        }
    }

    // 获取账户余额
    public int getBalance() {
        return balance;
    }

    // 主函数，模拟多线程下的转账操作
    public static void main(String[] args) {
        final Account account = new Account(1000);

        // 启动一个线程进行存钱操作
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(100);  // 模拟延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 启动一个线程进行取钱操作
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(50);
                try {
                    Thread.sleep(100);  // 模拟延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
