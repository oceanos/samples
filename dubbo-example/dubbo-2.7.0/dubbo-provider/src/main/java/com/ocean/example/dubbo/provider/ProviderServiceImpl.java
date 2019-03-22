package com.ocean.example.dubbo.provider;

import org.apache.dubbo.config.annotation.Service;

/**
 * 提供者
 *
 * @author kevin.jiang
 * @create 2019-03-21
 **/
@Service(version = "${service.version.ProviderService}")
public class ProviderServiceImpl implements IDemoService {

    @Override
    public String calc(String expression) {
        return "123";
    }
}
