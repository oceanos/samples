package com.ocean.example.easypoi.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.io.Serializable;

/**
 * @author kevin.jiang
 * @create 2019-01-24
 **/
public class CsMappingImportDto implements Serializable {

    @Excel(name = "车架号")
    private String vin;

    @Excel(name = "账号")
    private String username;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
