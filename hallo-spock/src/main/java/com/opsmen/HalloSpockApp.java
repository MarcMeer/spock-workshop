package com.opsmen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.opsmen"})
@EnableAutoConfiguration
@RestController
public class HalloSpockApp {
    @RequestMapping("/hallospock")
    public Booschap halloSpock() {
        return new Booschap("hallo spock");
    }
    public static void main(String[] args) {
        SpringApplication.run(HalloSpockApp.class, args);
    }
}
