package com.ocean.example.easypoi.controller;

import com.ocean.example.easypoi.dto.CsMappingImportDto;
import com.ocean.example.easypoi.util.EasypoiUtil;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 页面导入
 *
 * @author kevin.jiang
 * @create 2019-01-24
 **/
@RestController
public class ImportController {

    @PostMapping("import")
    public void importFile(@RequestParam("fileUpload") MultipartFile fileUpload, Integer manager) {
        List<CsMappingImportDto> list = EasypoiUtil
                .importExcel(fileUpload, 1, 1, CsMappingImportDto.class);
        System.err.println("==" + manager);
        System.err.println(list.size());
        if (!list.isEmpty()) {
            System.err.println(list.get(0).getUsername() + "-" + list.get(0).getVin());
        }
    }
}
