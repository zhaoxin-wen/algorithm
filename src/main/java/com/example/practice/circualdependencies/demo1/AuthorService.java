package com.example.practice.circualdependencies.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wzw
 * @date 2025/4/23 17:31
 * @description

 */
@Service
public class AuthorService {
    @Autowired
    BookService bookService;
}
