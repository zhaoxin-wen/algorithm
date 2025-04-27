package com.example.practice.circualdependencies.demo4;

/**
 * @author wzw
 * @date 2025/4/23 19:31
 * @description

 */
public class Main {
    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        cycle.init();
        UserService userService = (UserService) cycle.getBean("userService");
        OrderService orderService = (OrderService) cycle.getBean("orderService");
        System.out.println(userService.orderService);
        System.out.println(orderService.userService);
    }
}
