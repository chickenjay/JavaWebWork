package com.example.springboot.controller;

import com.example.springboot.common.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能：提供接口返回数据
 * 作者：程序员青戈
 * 日期：2023/8/13 15:55
 */
@RestController
@RequestMapping("/web")
public class WebController {

    @GetMapping("/hello")   //  /web/hello
    public Result hello(String name) {
        return Result.success(name);
    }

    @PostMapping("/post")
    public Result post(@RequestBody Obj obj) {
        System.out.println(obj.getName() == null ?  "是null" : obj.getName().isEmpty());
        return Result.success(obj);
    }

    @PutMapping("/put")     //
    public Result put(@RequestBody Obj obj) {
        return Result.success(obj);
    }

    @DeleteMapping("/delete")     //   http://localhost:9090/web/delete/1    /1  =>  /{id}
    public Result delete(@RequestBody List<Integer> ids) {
        return Result.success(ids);
    }

}
