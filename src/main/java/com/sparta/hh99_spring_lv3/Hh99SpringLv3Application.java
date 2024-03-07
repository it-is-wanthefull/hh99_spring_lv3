package com.sparta.hh99_spring_lv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hh99SpringLv3Application {

    public static void main(String[] args) {
        SpringApplication.run(Hh99SpringLv3Application.class, args);
    }

}
