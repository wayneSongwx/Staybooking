package com.wayne.staybooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wayne.staybooking")
public class StaybookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaybookingApplication.class, args);
    }

}
