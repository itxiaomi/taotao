package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *  @创建时间:  2020/12/9 14:20
 *  @描述：    主要是用于跳转页面的
 */
@Controller
public class PageController {


    //http://localhost:8082/index   首页
    //http://localhost:8082/a       a页面
    //http://localhost:8082/b       b页面

    // @PathVariable 的作用主要是用来截取url里面的内容

    @RequestMapping("/{path}")
    public String page(@PathVariable(name = "path") String path){

        System.out.println("page....=="+path);

        //返回页面的名字即可
        return path;
    }

}
