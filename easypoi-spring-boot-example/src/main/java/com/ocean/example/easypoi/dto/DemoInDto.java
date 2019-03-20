package com.ocean.example.easypoi.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author kevin.jiang
 * @create 2019-02-18
 **/
public class DemoInDto {
    @Excel(name = "vin")
    private String vin;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
