package com.example.springboot.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.HoneyLogs;
import com.example.springboot.common.LogType;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Notice;
import com.example.springboot.entity.SalaryType;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.SalaryTypeMapper;
import com.example.springboot.service.SalaryTypeService;
import com.example.springboot.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/salaryType")
public class SalaryTypeController {
    @Autowired
    SalaryTypeService salaryTypeService;
    @Autowired
    SalaryTypeMapper salaryTypeMapper;

    @HoneyLogs(operation = "薪资对照", type = LogType.ADD)
    @PostMapping("/add")
    public Result add(@RequestBody SalaryType salaryType) {
        User currentUser = TokenUtils.getCurrentUser();  // 获取到当前登录的用户信息
        salaryType.setId(salaryType.getId());

        salaryType.setRole(salaryType.getRole());
        salaryType.setSalary(salaryType.getSalary());//   2023-09-12 21:09:12
        salaryTypeService.save(salaryType);
        return Result.success();
    }

    /**
     * 修改信息
     */
    @HoneyLogs(operation = "薪资对照", type = LogType.UPDATE)
    @PutMapping("/update")
    public Result update(@RequestBody SalaryType salaryType) {
        salaryTypeMapper.updateById(salaryType);
        return Result.success();
    }

    /**
     * 删除信息
     */
    @HoneyLogs(operation = "薪资对照", type = LogType.DELETE)
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        salaryTypeService.removeById(id);
        return Result.success();
    }


    /**
     * 批量删除信息
     */
    @HoneyLogs(operation = "薪资对照", type = LogType.BATCH_DELETE)
    @DeleteMapping("/delete/batch")
    public Result batchDelete(@RequestBody List<Integer> ids) {
        salaryTypeService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * 查询全部信息
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<SalaryType> salaryTypeList =salaryTypeService.list(new QueryWrapper<SalaryType>().orderByDesc("id"));
        return Result.success(salaryTypeList);
    }

    /**
     * 查询用户公告
     * @return 用户公告
     */
//    @GetMapping("/selectUserData")
//    public Result selectUserData() {
//        QueryWrapper<SalaryType> queryWrapper = new QueryWrapper<SalaryType>().orderByDesc("id");
//        queryWrapper.eq("open", 1); // 用户只能看到公开的公告数据
//        List<Notice> userList = noticeService.list(queryWrapper);
//        return Result.success(userList);
//    }

    /**
     * 根据ID查询信息
     */
//    @GetMapping("/selectById/{id}")
//    public Result selectById(@PathVariable Integer id) {
//        Notice notice = noticeService.getById(id);
//        User user = userService.getById(notice.getUserid());
//        if (user != null) {
//            notice.setUser(user.getName());
//        }
//        return Result.success(notice);
//    }
    @GetMapping("/selectByRole/{role}")
    public Result selectById(@PathVariable String role) {
        QueryWrapper<SalaryType> queryWrapper = new QueryWrapper<SalaryType>().orderByDesc("id");
        queryWrapper.eq("role",role);
        SalaryType salaryType=salaryTypeService.getOne(queryWrapper);
        return Result.success(salaryType);
    }



    /**
     * 多条件模糊查询信息
     * pageNum 当前的页码
     * pageSize 每页查询的个数
     */
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam String role) {
        QueryWrapper<SalaryType> queryWrapper = new QueryWrapper<SalaryType>().orderByDesc("id");  // 默认倒序，让最新的数据在最上面
        queryWrapper.like(StrUtil.isNotBlank(role), "role", role);
        Page<SalaryType> page = salaryTypeService.page(new Page<>(pageNum, pageSize), queryWrapper);
        List<SalaryType> records = page.getRecords();
        return Result.success(page);
    }
//    @GetMapping("/selectByUserIdPage")
//    public Result selectByPage(@RequestParam Integer pageNum,
//                               @RequestParam Integer pageSize,
//                               @RequestParam String title,
//                               @RequestParam Integer userid) {
//        QueryWrapper<Notice> queryWrapper = new QueryWrapper<Notice>().orderByDesc("id");  // 默认倒序，让最新的数据在最上面
//        queryWrapper.eq("userid",userid);
//        Page<Notice> page = noticeService.page(new Page<>(pageNum, pageSize), queryWrapper);
//        List<Notice> records = page.getRecords();
////        List<User> list = userService.list();
//        for (Notice record : records) {
//            Integer authorid = record.getUserid();
//            User user = userService.getById(authorid);
////            String author = list.stream().filter(u -> u.getId().equals(authorid)).findFirst().map(User::getName).orElse("");
//            if (user != null) {
//                record.setUser(user.getName());
//            }
//        }
//        return Result.success(page);
//    }



}
