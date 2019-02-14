package com.ocean.example.business.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.ocean.example.business.BusinessService;
import com.ocean.example.order.OrderService;
import com.ocean.example.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kevin.jiang
 * @create 2019-01-12
 **/
public class BusinessServiceImpl implements BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

    @Reference
    private StorageService storageService;

    @Reference
    private OrderService orderService;

    /**
     * 用户订购商品
     *
     * @param userId        用户ID
     * @param commodityCode 商品编号
     * @param orderCount    订购数量
     */
    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-demo-tx")
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageService.deduct(commodityCode, orderCount);
        orderService.create(userId, commodityCode, orderCount);
    }
}
