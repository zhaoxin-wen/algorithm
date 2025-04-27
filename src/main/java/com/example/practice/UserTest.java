package com.example.practice;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author wzw
 * @date 2024/11/2 21:22
 * @description

 */
public class UserTest {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        //lightweightLocking(user);
        //basedLocking(user);
        //heavyweightLocking(user);


        //lightweightLocking2(user);
        lightweightLockingToHeavyweightLocking(user);
    }

    static void lightweightLocking(User user) throws InterruptedException {
        /**
         * 如果没有在vm参数加上-XX:BiasedLockingStartupDelay=0，在这里让当前线程沉睡4秒并不能看到偏向锁
         */
        //Thread.sleep(8000);

        synchronized (user) {
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }

        /**
         * 当沉睡的代码加在这里的时候，可以看到偏向锁
         */
        //Thread.sleep(4000);

        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        synchronized (user) {
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }
    }

    static void basedLocking(User user) throws InterruptedException {
        synchronized (user){
            System.out.println("--MAIN--:"+ClassLayout.parseInstance(user).toPrintable());
        }

        Thread thread = new Thread(() -> {
            synchronized (user) {
                System.out.println("--THREAD--:"+ClassLayout.parseInstance(user).toPrintable());
            }
        });
        thread.start();
        thread.join();
        System.out.println("--END--:"+ClassLayout.parseInstance(user).toPrintable());
    }


    static void heavyweightLocking(User user) throws InterruptedException {
        new Thread(() -> {
            synchronized (user) {
                System.out.println("--THREAD1--:" + ClassLayout.parseInstance(user).toPrintable());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (user) {
                System.out.println("--THREAD2--:" + ClassLayout.parseInstance(user).toPrintable());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    //VM参数加上：-XX:-UseBiasedLocking
    static void lightweightLocking2(User user) throws InterruptedException {

/*        TimeUnit.SECONDS.sleep(5);
        System.out.println(ClassLayout.parseInstance(user).toPrintable());*/

        synchronized (user){
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }
    }

    static  void lightweightLockingToHeavyweightLocking(User user) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (user) {
                System.out.println("--THREAD1--:" + ClassLayout.parseInstance(user).toPrintable());
                try {
                    user.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--THREAD END--:" + ClassLayout.parseInstance(user).toPrintable());
            }
        });
        thread.start();
        thread.join();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }


}
