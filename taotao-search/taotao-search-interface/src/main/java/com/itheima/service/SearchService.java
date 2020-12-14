package com.itheima.service;

import com.itheima.bean.Item;
import com.itheima.bean.TaoResult;

/*
 *  @创建时间:  2020/12/14 13:35
 *  @描述：    TODO
 */
public interface SearchService {
    TaoResult<Item> search(String q , int page , int rows);
}
