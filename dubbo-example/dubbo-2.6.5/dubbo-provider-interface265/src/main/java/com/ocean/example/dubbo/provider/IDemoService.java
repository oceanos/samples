package com.ocean.example.dubbo.provider;

/**
 * 接口
 *
 * @author kevin.jiang
 * @create 2019-03-21
 **/
public interface IDemoService {

    /**
     * 计算
     *
     * @param expression
     * @param flag
     *
     * @return
     */
    String calc(String expression, boolean flag);
}
