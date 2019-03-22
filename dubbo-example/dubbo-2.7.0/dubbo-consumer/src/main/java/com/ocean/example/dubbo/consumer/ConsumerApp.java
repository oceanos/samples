package com.ocean.example.dubbo.consumer;

import com.ocean.example.dubbo.provider.IDemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者
 *
 * @author kevin.jiang
 * @create 2019-03-21
 **/
@SpringBootApplication
@RestController
@EnableDubbo
public class ConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }

    @Reference(version = "${service.version.ProviderService}")
    IDemoService demoService;

    @GetMapping("calc")
    public String test(String exp) {
        return demoService.calc(exp);
    }
}
