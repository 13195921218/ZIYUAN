package com.example.ziyuan.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ziyuan.dao.ZiYuanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;

@Service
public class ZiYuanService {

    @Autowired
    ZiYuanDao ziyuanDao;
        public void httpRequestEcsList () {
            BufferedReader in = null;
            try {
                String s = readJsonFile("E:\\HSAF\\ziyuan.json");
                //获取数据
                JSONObject jsonObject = JSON.parseObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("objList");
                //System.out.println(jsonArray.get());
                try {
                    ZiYuanDao c = new ZiYuanDao();
                    Connection conn = c.getConn();//连接数据库
                    c.getEcsCount1();
                    c.getEcsCount2();
                    Statement sql;
                    sql = conn.createStatement();
                    int a;
                    //从jsonBean中获取封装的数据插入数据库中，得道的每条的数据都插入
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);
                        if (jsonObject2.get("vdcName") != null ){
                            //System.out.println(jsonObject2.get("flavorRamSize"));

                            a = sql.executeUpdate("insert into joke (vdcName,bizRegionNativeId,name,flavorRamSize,flavorVcpu,nativeId)"
                                            + "values('" + jsonObject2.get("vdcName").toString() + "','"
                                            + jsonObject2.get("bizRegionNativeId").toString() + "','"
                                            + jsonObject2.get("name").toString() + "','" +
                                            jsonObject2.get("flavorRamSize").toString() + "','"+
                                            jsonObject2.get("flavorVcpu").toString() +"','"+
                                            jsonObject2.get("nativeId").toString()+ "')");
                        }
                    }
                    c.getEcsCount1();
                    //System.out.println("当前时间：" + new Date() + "      数据插入成功!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    private String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void httpRequestDcsList () {
        BufferedReader in = null;
        try {
            String s = readJsonFile("E:\\HSAF\\dcs.json");
            //获取数据
            JSONObject jsonObject = JSON.parseObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("objList");
            //System.out.println(jsonArray);
            try {
                ZiYuanDao c = new ZiYuanDao();
                Connection conn = c.getConn();//连接数据库
                c.getDcsCount1();
                c.getDcsCount2();
                Statement sql;
                sql = conn.createStatement();
                int a;
                //从jsonBean中获取封装的数据插入数据库中，得道的每条的数据都插入
                for (int j = 0; j < jsonArray.size(); j++) {
                    JSONObject jsonObject2 = (JSONObject) jsonArray.get(j);
                    if (jsonObject2.get("engineVersion").equals("5.0") ) {
                        a = sql.executeUpdate("insert into dcslist (vdcName,bizRegionName,name,engineVersion,usedMemory,cacheMode)"
                               + "values('" + jsonObject2.get("vdcName").toString() + "','"
                              + jsonObject2.get("bizRegionName").toString() + "','"
                              + jsonObject2.get("name").toString() + "','" +
                              jsonObject2.get("engineVersion").toString() + "','"+
                               jsonObject2.get("usedMemory").toString() +"','"+
                               jsonObject2.get("cacheMode").toString()+ "')");
                    }
                }
                c.getDcsCount1();
                //System.out.println("当前时间：" + new Date() + "      数据插入成功!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


