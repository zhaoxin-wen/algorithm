package com.example.practice.circualdependencies.demo5;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author wzw
 * @date 2025/4/23 17:31
 * @description

 */
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserService {
    @CodeBearAutowired
    OrderService orderService;
}
