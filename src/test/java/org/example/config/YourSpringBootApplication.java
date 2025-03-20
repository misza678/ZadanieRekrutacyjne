package org.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "org.example")
@ComponentScan(basePackages = "org.example")
public class YourSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourSpringBootApplication.class, args);
    }
}

