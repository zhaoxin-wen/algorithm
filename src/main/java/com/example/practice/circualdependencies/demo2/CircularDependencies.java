package com.example.practice.circualdependencies.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wzw
 * @date 2025/4/23 17:29
 * @description
 *
 * 当涉及原型（prototype）作用域的Bean循环依赖时，Spring无法解决循环依赖的问题；
 * 这是因为原型Bean的特性决定了每次获取时都需要创建新的实例，无法像单例Bean那样利用缓存机制来解决循环依赖。
 *

 */
public class CircularDependencies {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        BookService bookService = (BookService)annotationConfigApplicationContext.getBean("bookService");
        System.out.println("-----------------------");
        System.out.println(bookService.authorService);
        System.out.println("-----------------------");
        AuthorService authorService = (AuthorService) annotationConfigApplicationContext.getBean("authorService");
        System.out.println(authorService.bookService);
        System.out.println("-----------------------");
    }
}
