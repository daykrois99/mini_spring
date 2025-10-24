package com.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext ioc = new ApplicationContext("com.example");
        Object dog = ioc.getBean("mydog");
        System.out.println(dog);

    }
}