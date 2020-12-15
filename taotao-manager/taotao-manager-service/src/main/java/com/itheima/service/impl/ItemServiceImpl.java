package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.bean.Item;
import com.itheima.bean.TaoResult;
import com.itheima.mapper.ItemMapper;
import com.itheima.service.ItemService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

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

    @Override
    public void addItem(Item item , String desc) {
        // 保存商品
        // 设置商品的状态，商品是上架还是下架，如果商品是上架， 1 ，下架 ，0
        item.setStatus(1);

        //设置商品的创建时间和更新时间
        item.setCreated(new Date());
        item.setUpdated(item.getCreated());
        //super.save(item);
        itemMapper.insert(item);

        // 保存商品描述
       /* ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);

        this.itemDescService.save(itemDesc);*/
    }
}
