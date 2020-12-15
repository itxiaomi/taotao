package com.itheima.controller;

/*
 *  @创建时间:  2020/12/10 9:53
 *  @描述：    TODO
 */

import com.itheima.bean.Item;
import com.itheima.bean.TaoResult;
import com.itheima.service.ItemService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    //localhost:8082/page?pageNum=1&pageSize=20;

    @Reference
    private ItemService itemService;

    //分页显示商品
    @RequestMapping("/rest/item")
    public TaoResult<Item> findByPage(int page , int rows){

        TaoResult<Item> result = itemService.findByPage(page, rows);

        return result;
    }

    //新增商品
    @RequestMapping("/rest/addItem")
    public String saveItem(Item item, String desc) {

        //手动设置分类
        //item.setCid(560L);

        itemService.addItem(item, desc);
        return "add success" ;
    }
}
