package com.example.practice.circualdependencies.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wzw
 * @date 2025/4/23 17:29
 * @description
 * 在这种构造器注入的循环依赖中，Spring在创建Bean实例时，由于构造器参数相互依赖，导致无法完成实例化过程，从而抛出错误。
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
