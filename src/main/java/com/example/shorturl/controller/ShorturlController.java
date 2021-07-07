package com.example.shorturl.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shorturl.service.UrlService;
import com.example.shorturl.vos.ShorturlReqVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : shenhc
 * @date : 2021/7/6
 * desc:
 */
@RestController
@RequestMapping("/shorturl")
@Api(value = "BulterEstateController", description = "ShorturlController")
public class ShorturlController {

    @Autowired
    private UrlService urlService;


    @ApiOperation(value = "获取短域名", notes = "获取短域名",httpMethod="POST")
    @RequestMapping("/toShort")
    public JSONObject getShorturl(@RequestBody ShorturlReqVo input){

        String longurl = input.getUrl();
        return urlService.getShorturl(longurl);
    }

    @RequestMapping("/toLong")
    @ApiOperation(value = "获取长域名", notes = "获取长域名",httpMethod="POST")
    public JSONObject getLongurl(@RequestBody ShorturlReqVo input){
        String shorturl = input.getUrl();
        return urlService.getLongurl(shorturl);
    }
}
