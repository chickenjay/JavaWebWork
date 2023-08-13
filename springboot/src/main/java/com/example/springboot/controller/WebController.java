package com.example.springboot.controller;

import com.example.springboot.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：提供接口返回数据
 * 作者：程序员青戈
 * 日期：2023/8/13 15:55
 */
@RestController
public class WebController {

    @RequestMapping
    public Result hello(String name) {
        return Result.success(name);
    }

}
