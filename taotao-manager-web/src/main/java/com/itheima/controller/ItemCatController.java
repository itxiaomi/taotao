package com.itheima.controller;

import com.itheima.bean.ItemCat;
import com.itheima.service.ItemCatService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *  @创建时间:  2020/12/15 10:54
 *  @描述：    商品分类
 */
@RestController
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    //根据父亲的id 去查找属于它的子级分类
    @RequestMapping("/rest/item/cat")
    public List<ItemCat> queryItemCatByParentId(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<ItemCat> list = itemCatService.queryItemCatByParentId(parentId);
        System.out.println("list=" + list);
        return list;
    }
}
