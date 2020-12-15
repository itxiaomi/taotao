package com.itheima.service.impl;

import com.itheima.bean.ItemCat;
import com.itheima.mapper.ItemCatMapper;
import com.itheima.service.ItemCatService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
 *  @创建时间:  2020/12/15 11:00
 *  @描述：    TODO
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public List<ItemCat> queryItemCatByParentId(Long parentId) {


        ItemCat cat = new ItemCat();
        cat .setParentId(parentId);

       // List<ItemCat> list =  itemCatMapper.selectByExample(cat);
        List<ItemCat> list =  itemCatMapper.select(cat);

        return list;
    }
}
