package com.ocean.example.easypoi.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.io.Serializable;

/**
 * @author kevin.jiang
 * @create 2019-02-18
 **/
public class DemoOutDto implements Serializable {

    @Excel(name = "vin")
    private String vin;

    @Excel(name = "截止12月31日里程")
    private String end1;

    @Excel(name = "截止1月31日里程")
    private String end2;

    @Excel(name = "截止2月28日里程")
    private String end3;

    public String getEnd1() {
        return end1;
    }

    public void setEnd1(String end1) {
        this.end1 = end1;
    }

    public String getEnd2() {
        return end2;
    }

    public void setEnd2(String end2) {
        this.end2 = end2;
    }

    public String getEnd3() {
        return end3;
    }

    public void setEnd3(String end3) {
        this.end3 = end3;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
