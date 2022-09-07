package com.springBootDemo;

/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/7 下午2:54
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ApplicationClass {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClass.class, args) ;
    }
}
