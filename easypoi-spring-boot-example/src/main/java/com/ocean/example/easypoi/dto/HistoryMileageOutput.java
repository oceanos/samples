package com.ocean.example.easypoi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 历史里程查询
 *
 * @author  kevin.jiang
 * @create 2018-09-26
 **/
public class HistoryMileageOutput implements Serializable {

    private String vin;
    /**
     * 里程总计
     */
    private BigDecimal totalMileage;
    private BigDecimal endMileage;
    private BigDecimal startMileage;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public BigDecimal getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(BigDecimal endMileage) {
        this.endMileage = endMileage;
    }

    public BigDecimal getStartMileage() {
        return startMileage;
    }

    public void setStartMileage(BigDecimal startMileage) {
        this.startMileage = startMileage;
    }

    public BigDecimal getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(BigDecimal totalMileage) {
        this.totalMileage = totalMileage;
    }
}
