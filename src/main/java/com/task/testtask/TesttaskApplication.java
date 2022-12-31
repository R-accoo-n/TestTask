package com.task.testtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.task.testtask.repositories")
public class TesttaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesttaskApplication.class, args);
    }

}
