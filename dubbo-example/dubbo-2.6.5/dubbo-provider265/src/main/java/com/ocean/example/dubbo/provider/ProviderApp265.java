package com.ocean.example.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 提供者
 *
 * @author kevin.jiang
 * @create 2019-03-21
 **/
@SpringBootApplication
@EnableDubbo
public class ProviderApp265 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp265.class, args);
    }
}
