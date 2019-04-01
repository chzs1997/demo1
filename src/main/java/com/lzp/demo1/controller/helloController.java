package com.lzp.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: liuzipan
 * @Description
 * @Date :16:20 2019/4/1
 * @Modefied By:
 */
@Controller
@RequestMapping(value = "/test")
public class helloController {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public Object hello(){
        return "201512056";
    }
}
