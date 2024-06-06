package com.jnu.gonggam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GonggamApplication {
    public static void main(String[] args) {
        SpringApplication.run(GonggamApplication.class, args);
    }
}
