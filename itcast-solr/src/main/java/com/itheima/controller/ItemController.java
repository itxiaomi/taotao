package com.itheima.controller;

import com.itheima.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @创建时间:  2020/12/14 10:01
 *  @描述：    TODO
 */
@RestController
public class ItemController {


    @Autowired
    private ItemService itemService;

    @RequestMapping("/addIndex")
    public String addIndex(){
        System.out.println("ItemController::addIndex~!~");
        itemService.addIndex();
        return "add success~!~";
    }
}
