package com.ocean.example.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author kevin.jiang
 * @create 2019-01-12
 **/
@SpringBootApplication
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
//        new SpringApplicationBuilder(StorageApplication.class).web(WebApplicationType.NONE)
//                .run(args);
    }
}
