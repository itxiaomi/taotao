package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/*
 *  @创建时间:  2020/12/9 10:20
 *  @描述：    TODO
 */
@SpringBootApplication

//这里还需要加上一个注解
@MapperScan("com.itheima.mapper")
public class ManagerServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ManagerServiceApp.class , args);
    }
}
