package com.dmxiaoshen.client;

import com.dmxiaoshen.entity.Book;

/**
 * Created by hzhsg on 2018/8/20.
 */
public class ClientTest {

    public static void main(String[] args) {
        new DubboContext("dubbo-test","zookeeper://dmxiaoshen.zk.com:2888").start();
        Book temp = new Book();
        temp.setId("1");
        temp.setName("book-test");
        ApiHolder.bookService.addBook(temp);
        Book book = ApiHolder.bookService.getBookById("1");
        System.out.println(book);
    }
}
