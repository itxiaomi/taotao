package com.itheima.service.impl;

import com.itheima.bean.Item;
import com.itheima.mapper.ItemMapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/*
 *  @创建时间:  2020/12/16 14:11
 *  @描述：    TODO
 */
@Component
public class ReceiveMessage {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private SolrClient solrClient;

    //监听item的信息
    @JmsListener(destination = "item")
    public void receiveAddItemMessage(String itemId){
        //已经知道商品的id了---->   去mysql查询这件商品出来 ----> 把这件商品构建索引
        //追加到索引库中。

        //1. 查询数据库
        Item item = itemMapper.selectByPrimaryKey(Long.parseLong(itemId));
        System.out.println("搜索：" + item);


        //2. 构建索引，追加到索引库当中
        // 2. 根据获取到的数据，保存索引库
        SolrInputDocument document = new SolrInputDocument();
        // 商品id
        document.setField("id", item.getId().toString());
        // 商品标题
        document.setField("item_title", item.getTitle());
        // 商品价格
        document.setField("item_price", item.getPrice());
        // 商品图片
        document.setField("item_image", item.getImage());
        // 商品类目id
        document.setField("item_cid", item.getCid());
        // 商品状态
        document.setField("item_status", item.getStatus());

        try {
            // 保存到索引库中
            solrClient.add(document);
            solrClient.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
