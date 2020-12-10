package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
 *  @创建时间:  2020/12/9 10:13
 *  @描述：    TODO
 */
@Service
public class UserServiceImpl implements UserService {

    // service要调用mapper 所以这里必然有mapper的对象

    @Autowired
    UserMapper userMapper;


    public void findAll() {

        List<User> list = userMapper.selectAll();

        System.out.println("list=" + list);


    }
}
