package com.ocean.example.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ocean.example.easypoi.dto.DemoInDto;
import com.ocean.example.easypoi.dto.DemoOutDto;
import com.ocean.example.easypoi.util.EasypoiUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 查询并生成Excel
 *
 * @author kevin.jiang
 * @create 2019-01-24
 **/
//@RestController
public class ExportController {

    private static final OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
            .connectTimeout(600, TimeUnit.SECONDS)
            .writeTimeout(600, TimeUnit.SECONDS)
            .readTimeout(600, TimeUnit.SECONDS);

    public static final OkHttpClient client = builder.build();
    public static final MediaType APPLICATION_JSON = MediaType
            .parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {
        List<DemoInDto> list = EasypoiUtil.importExcel("F:\\var\\vinc.xlsx", 0, 1, DemoInDto.class);
        DemoOutDto outDto;
        List<DemoOutDto> outs = new ArrayList<>(6000);
        for (int i = 0; i < list.size(); i++) {
            outDto = new DemoOutDto();
            System.err.print("开始处理No" + (i + 1) + "," + list.get(i).getVin());
            outDto.setVin(list.get(i).getVin());
            outDto.setEnd1(
                    export(list.get(i).getVin(), "2016-12-01 00:00:00", "2018-12-31 23:59:59"));
            outDto.setEnd2(
                    export(list.get(i).getVin(), "2016-01-05 00:00:00", "2019-01-31 23:59:59"));
            outDto.setEnd3(
                    export(list.get(i).getVin(), "2016-02-04 00:00:00", "2019-02-28 23:59:59"));
            outs.add(outDto);
            System.err.println();
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, null, "里程"),
                DemoOutDto.class, outs);
        File savefile = new File("F:/var/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("F:/var/rett.xls");
        workbook.write(fos);
        fos.close();

    }

    public static String export(String vin, String start, String end) throws IOException {
        /*1，参数组装*/
        Map<String, String> input = new HashMap<>();
        input.put("vin", vin);
        input.put("startTime", start);
        input.put("endTime", end);
        String json = JSON.toJSONString(input);
        RequestBody body = RequestBody.create(APPLICATION_JSON, json);
        Request request = new Request.Builder()
                .url("http://127.0.0.1:12007/history/getLastByTime")
                .post(body)
                .build();

        /*2，接口调用*/
        Response response = client.newCall(request).execute();

        JSONObject resp = JSON.parseObject(response.body().string());
        JSONObject data = JSONObject.parseObject(JSON.toJSONString(resp.get("data")));
        System.err.print("," + data.get("endMileage"));
        return data.get("endMileage").toString();
    }
}
