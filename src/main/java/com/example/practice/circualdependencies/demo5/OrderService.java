package com.example.practice.circualdependencies.demo5;

/**
 * @author wzw
 * @date 2025/4/23 17:31
 * @description

 */
public class OrderService {

    @CodeBearAutowired
    UserService userService;
}
