package com.ocean.example.easypoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kevin.jiang
 * @create 2019-01-24
 **/
@SpringBootApplication
public class PoiApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(PoiApp.class);
        springApplication.run(args);
    }

}
