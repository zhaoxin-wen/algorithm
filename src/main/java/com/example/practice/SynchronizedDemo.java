package com.example.practice;

/**
 * @author wzw
 * @date 2024/10/18 20:45
 * @description

 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }
}
