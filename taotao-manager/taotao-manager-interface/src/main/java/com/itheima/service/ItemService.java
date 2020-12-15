package com.itheima.service;

import com.itheima.bean.Item;
import com.itheima.bean.TaoResult;

/*
 *  @创建时间:  2020/12/10 9:11
 *  @描述：    TODO
 */
public interface ItemService {

    // 分页的数据，不应该返回list<Item> ，
    //List<Item> findByPage(int page , int size);

    /**
     * 分页查询
     * @param page 查询显示第几页
     * @param size 每页显示多少条
     * @return 返回当前这一页的数据。
     */
    TaoResult<Item> findByPage(int page , int size);


    //List<Item> findAll();

    /**
     * 新增商品
     * @param item 商品的信息
     * @param desc 商品的描述
     */
    void addItem(Item item  , String desc);
}

