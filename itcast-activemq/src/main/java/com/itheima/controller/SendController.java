package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @创建时间:  2020/12/16 13:32
 *  @描述：    到底是以队列的方式发送还是以主题的方式发送，取决于application.properties里面的开关
 *                  spring.jms.pub-sub-domain
 */
@RestController
public class SendController {

    //发消息需要用到这个对象
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //以队列的方式发送  队列只能一个人发送，一个人接收
    @RequestMapping("/send")
    public String send(){
        // 发送消息
        //参数一： 队列的名字
        //参数二： 发送的具体消息
        jmsMessagingTemplate.convertAndSend("CCTV" , "哈哈~~");
        return "send success";
    }



    //以主题的方式发送 ，主题一个人发送，多个人接收
    @RequestMapping("/sendTopic")
    public String sendTopic(){
        // 发送消息
        //参数一： 队列的名字
        //参数二： 发送的具体消息
        jmsMessagingTemplate.convertAndSend("NBA" , "2021年，湖人队又夺得了总冠军~");
        return "send success";
    }

}
