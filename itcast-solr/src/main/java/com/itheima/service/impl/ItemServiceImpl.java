package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.bean.Item;
import com.itheima.mapper.ItemMapper;
import com.itheima.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 *  @创建时间:  2020/12/14 10:00
 *  @描述：    TODO
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private SolrClient solrClient;

    @Override
    public void addIndex() {

        try {
            //1. 把数据库的数据给查询出来

            //2. 构建索引

            //3. 存到solr索引库去。


            // 可以使用循环来获取所有的商品数据
            int i = 1, pagesize = 500;
            do {
                // 分页查询商品数据
                PageHelper.startPage(i, 500);
                List<Item> list = this.itemMapper.select(null);

                System.out.println("list=" + list);

                // 遍历结果，把商品放到索引库中
                List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
                for (Item item : list) {  //遍历500次，把每一件商品，转化成一个SolrInputDocument对象
                    // 把获取的商品数据，批量导入到solr索引库中
                    SolrInputDocument document = new SolrInputDocument();
                    // 商品id
                    document.setField("id", item.getId().toString());
                    // 商品名称
                    document.setField("item_title", item.getTitle());
                    // 商品价格
                    document.setField("item_price", item.getPrice());
                    // 商品图片
                    if (StringUtils.isNotBlank(item.getImage())) {
                        document.setField("item_image", StringUtils.split(item.getImage(), ",")[0]);
                    } else {
                        document.setField("item_image", "");
                    }
                    // 商品类目id
                    document.setField("item_cid", item.getCid());
                    // 商品状态
                    document.setField("item_status", item.getStatus());

                    // 把Document放到集合中，统一提交
                    docs.add(document);
                }

                // 把数据保存在solr索引库中
                // cloudsolrServer 集群的对象， 集群类。
                //this.cloudSolrServer.add(docs);
                //this.cloudSolrServer.commit();

                //solr安装在哪里？ 索引库在哪里，没有指定！
                solrClient.add(docs);
                solrClient.commit();


                i++;
                pagesize = list.size();

            } while (pagesize == 500);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
