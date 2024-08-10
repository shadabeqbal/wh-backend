package com.example.wh_backend;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
public class WhBackendApplication {
    private static final Logger logger = LogManager.getLogger(WhBackendApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(WhBackendApplication.class, args);
    }

}
