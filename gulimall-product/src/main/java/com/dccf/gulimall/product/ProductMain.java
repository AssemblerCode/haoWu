package com.dccf.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductMain {
    public static void main(String[] args) {
        for (String str:args)
            System.out.println("args:"+args);
        SpringApplication.run(ProductMain.class, args);
    }
}
