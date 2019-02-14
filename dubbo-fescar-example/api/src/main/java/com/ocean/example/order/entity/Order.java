package com.ocean.example.order.entity;

import java.io.Serializable;

/**
 * @author kevin.jiang
 * @create 2019-01-12
 **/
public class Order implements Serializable {

    public long id;
    public String userId;
    public String commodityCode;
    public int count;
    public int money;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", commodityCode='" + commodityCode + '\'' +
                ", count=" + count +
                ", money=" + money +
                '}';
    }

}
