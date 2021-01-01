package com.example.dockertest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Hello implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Logger logger = LoggerFactory.getLogger(Hello.class);
        logger.info("Hello World!");
    }
}
