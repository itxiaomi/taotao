package com.itheima.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/*
 *  @创建时间:  2020/12/16 13:34
 *  @描述：    TODO
 *
 * 以前知道的@controller +  @service + @repository  都属于@Component
 */
//只有类上打了注解，springBoot才会检索这个类，扫描这个类，才能知道
//这个类里面有一个监听消息的方法。以后一旦有消息了，就会调用这个方法
@Component
public class ReceiveMessage {

    //这里的方法返回值是返回给队列...
    //收到消息之后，方法不需要有任何的返回值，我们只需要接收消息即可。
    @JmsListener(destination = "CCTV")
    public void receiveQueue(String message){
        System.out.println("接收到的消息是 ：" + message);
    }


    //模拟有两个人接收消息
    @JmsListener(destination = "NBA")
    public void receiveTopic01(String message){
        System.out.println("receiveTopic01 ：" + message);
    }


    @JmsListener(destination = "NBA")
    public void receiveTopic02(String message){
        System.out.println("receiveTopic02 ：" + message);
    }
}
