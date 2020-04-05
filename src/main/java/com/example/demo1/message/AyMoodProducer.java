package com.example.demo1.message;

import com.example.demo1.model.AyMood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @author jinguodong
 * @date 2019/4/25 3:12 PM
 */
@Service
public class AyMoodProducer {

  @Resource
  private JmsMessagingTemplate jmsMessagingTemplate;

  public void sendMessage(Destination destination,
                          final String message) {
    jmsMessagingTemplate.convertAndSend(destination, message);
  }

  public void sendMessage(Destination destination,
                          final AyMood ayMood) {
    jmsMessagingTemplate.convertAndSend(destination, ayMood);
  }
}
