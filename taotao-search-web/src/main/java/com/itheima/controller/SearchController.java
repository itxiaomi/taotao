package com.itheima.controller;

import com.itheima.bean.Item;
import com.itheima.bean.TaoResult;
import com.itheima.service.SearchService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *  @创建时间:  2020/12/14 13:46
 *  @描述：    TODO
 */
@Controller
public class SearchController {

    //@Autowired
    @Reference // 使用的是dubbo远程调用taotao-search-service的服务
    private SearchService searchService;


    //每页显示的记录数
    private Integer rows  = 16 ;

    // http://search.taotao.com/search.html?q=apple
    /**
     * 搜索商品
     *
     * @return
     */
    @RequestMapping("search")
    public String search(Model model,
                         @RequestParam("q") String query,
                         @RequestParam(value = "page", defaultValue = "1") Integer page) {

        //执行查询的操作，去索引库里面查询商品。
        TaoResult<Item> taoResult = this.searchService.search(query, page, this.rows);
        System.out.println("taoResult==" + taoResult);

        //把查询到的商品，存储到model对象里面，以便在页面上能够取出来显示。

        // 把数据放到模型中，页面展示
        // 搜索关键词
        model.addAttribute("query", query);

        // 搜索结果集list
        model.addAttribute("itemList", taoResult.getRows());

        // 当前页码数
        model.addAttribute("page", page);

        // 总页数,查询到的数据总数和每页显示条数进行计算
        long total = taoResult.getTotal();
        // long pages = total % 16 == 0 ? total / 16 : (total / 16) + 1;
        long pages = (total + this.rows - 1) / this.rows;
        model.addAttribute("totalPages", pages);

        return "search";
    }
}