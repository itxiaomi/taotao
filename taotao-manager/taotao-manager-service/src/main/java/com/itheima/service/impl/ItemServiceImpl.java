package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.bean.Item;
import com.itheima.bean.TaoResult;
import com.itheima.mapper.ItemMapper;
import com.itheima.service.ItemService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/*
 *  @创建时间:  2020/12/10 9:48
 *  @描述：    TODO
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public TaoResult<Item> findByPage(int page, int size) {

        //1. 设置查询第几页，每页显示多少条
        PageHelper.startPage(page , size);

        //2. 开始查询 得到这一页的数据返回。
        Page<Item> pageData = (Page<Item>)itemMapper.selectByExample(null);

        //3. 返回taoresult
        TaoResult<Item> result = new TaoResult<>(pageData.getTotal() , pageData.getResult());

        return result;
    }
}
