package com.itheima.service;

import com.itheima.bean.ItemCat;

import java.util.List;

/*
 *  @创建时间:  2020/12/15 10:57
 *  @描述：    TODO
 */
public interface ItemCatService {

    /**
     * 查询商品的分类 ，根据商品的分类id来找它的子级分类
     * @param parentId
     * @return
     */
    List<ItemCat> queryItemCatByParentId(Long parentId);
}
