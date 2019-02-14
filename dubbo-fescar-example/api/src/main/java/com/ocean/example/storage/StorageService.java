package com.ocean.example.storage;

/**
 * @author kevin.jiang
 * @create 2019-01-12
 **/
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param commodityCode 商品编号
     * @param count         扣减数量
     */
    void deduct(String commodityCode, int count);
}
