package com.example.demo1.service.impl;

import com.example.demo1.message.AyMoodProducer;
import com.example.demo1.model.AyMood;
import com.example.demo1.repository.AyMoodRepository;
import com.example.demo1.service.AyMoodService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author jinguodong
 * @date 2019/4/25 11:48 AM
 */
@Service
public class AyMoodServiceImpl implements AyMoodService {

  @Autowired
  private AyMoodRepository ayMoodRepository;

  @Override
  public AyMood save(AyMood ayMood) {
    return ayMoodRepository.save(ayMood);
  }

  // 队列
  private static Destination destination = new ActiveMQQueue("ay.queue.asyn.save");

  @Resource
  private AyMoodProducer ayMoodProducer;

  @Override
  public String asynSave(AyMood ayMood) {
    // 向队列 ay.queue.asyn.save 推送消息，消息内容为说说实体
    ayMoodProducer.sendMessage(destination, ayMood);
    return "success";
  }


}
