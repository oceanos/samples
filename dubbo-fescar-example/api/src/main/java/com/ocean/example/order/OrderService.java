package com.ocean.example.order;

import com.ocean.example.order.entity.Order;

/**
 * @author kevin.jiang
 * @create 2019-01-12
 **/
public interface OrderService {

    /**
     * 创建订单
     *
     * @param userId        用户ID
     * @param commodityCode 商品编号
     * @param orderCount    订购数量
     *
     * @return 生成的订单
     */
    Order create(String userId, String commodityCode, int orderCount);
}
