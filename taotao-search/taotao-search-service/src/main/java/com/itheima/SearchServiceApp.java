package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/*
 *  @创建时间:  2020/12/14 13:46
 *  @描述：    TODO
 */
@SpringBootApplication
@MapperScan("com.itheima.mapper")  // 让springboot帮忙构建mapper的接口实现类对象
public class SearchServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApp.class , args);
    }
}
