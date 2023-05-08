package com.example.asynchronouspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class AsynchronousPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronousPracticeApplication.class, args);
        System.out.println("어플리케이션 실행~~~~!");
    }

}
