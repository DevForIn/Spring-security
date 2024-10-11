package com.kblife.reviewuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.kblife.reviewuserservice.domain.entity",})
public class ReviewUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewUserServiceApplication.class, args);
    }

}
