package com.example.practice.circualdependencies.demo5;

import com.example.practice.circualdependencies.demo4.Cycle;

/**
 * @author wzw
 * @date 2025/4/23 19:31
 * @description

 */
public class Main {
    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        cycle.init();
        System.out.println(((UserService) cycle.getBean("userService")).orderService);
        System.out.println(((OrderService) cycle.getBean("orderService")).userService);
    }
}
