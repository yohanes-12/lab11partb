package com.example.asdlab11partb;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsdLab11partbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AsdLab11partbApplication.class, args);
    }


    @Transactional
    @Override
    public void run(String... args) throws Exception {

    }
}
