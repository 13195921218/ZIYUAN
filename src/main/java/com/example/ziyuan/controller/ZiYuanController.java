package com.example.ziyuan.controller;

import com.example.ziyuan.service.ZiYuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ZiYuanController {
    private static final Logger logger = LoggerFactory.getLogger(ZiYuanController.class);

    @Autowired
    ZiYuanService ziyuanService;

    @RequestMapping(value = "/getEcsList",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String EcsListApi() throws Exception {
        ziyuanService.httpRequestEcsList();
        return "Ecs List Saved";
    }

    @RequestMapping(value = "/getDcsList",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String DcsListApi() throws Exception {
        ziyuanService.httpRequestDcsList();
        return "Dcs List Saved";
    }

}

