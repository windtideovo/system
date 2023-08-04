package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.Dao")
//@ComponentScan("com.example.config")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
