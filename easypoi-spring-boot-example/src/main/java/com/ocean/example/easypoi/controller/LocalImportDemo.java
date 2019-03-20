package com.ocean.example.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.ocean.example.easypoi.dto.CsMappingImportDto;
import com.ocean.example.easypoi.dto.DemoInDto;
import com.ocean.example.easypoi.exception.NormalException;
import com.ocean.example.easypoi.util.EasypoiUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * 本地文件导入
 *
 * @author kevin.jiang
 * @create 2019-02-18
 **/
public class LocalImportDemo {

    public static void main(String[] args) throws FileNotFoundException {
        List<DemoInDto> list = EasypoiUtil.importExcel("F:\\var\\vina.xlsx",0,1,DemoInDto.class);
        Map<String, Integer> map = new HashMap<>(16);
        for (DemoInDto dto : list) {
            if (map.containsKey(dto.getVin())) {
                int v = map.get(dto.getVin());
                map.put(dto.getVin(), (v + 1));
            } else {
                map.put(dto.getVin(), 1);
            }
        }
        System.err.println(list.size()+" "+map.size());
        System.err.println(map);
    }
}
