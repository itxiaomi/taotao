package com.itheima.controller;

import com.itheima.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @创建时间:  2020/12/9 13:39
 *  @描述：    TODO
 */
@RestController
public class UserController {

    @Reference
    private UserService userService;


    @RequestMapping("/findAll")
    public String findAll(){

        userService.findAll();

        return "controller::success~!~!";
    }
}
