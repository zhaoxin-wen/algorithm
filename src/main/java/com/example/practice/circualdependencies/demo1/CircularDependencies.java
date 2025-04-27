package com.example.practice.circualdependencies.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wzw
 * @date 2025/4/23 17:29
 * @description
 *
 * 程序并不会报错，反而能够顺利输出两个服务的实例信息：

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
