package com.dmxiaoshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","b");
        List<String> b = new ArrayList<>();
        list.addAll(b);
        list.forEach(System.out::println);
        System.out.println("Hello World!");
        send(4,5);

    }

    public static void send(int a,int b,String...c){
        String[] k = c;
        System.out.println(k);
    }
}
