package com.opsmen.klantensysteem;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.opsmen"})
public class KlantenSysteemApp {
    public static void main(String[] args) {
        SpringApplication.run(KlantenSysteemApp.class, args);
    }

}
