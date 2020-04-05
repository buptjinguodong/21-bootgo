package com.example.demo1.message;

import com.example.demo1.model.AyMood;
import com.example.demo1.service.AyMoodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jinguodong
 * @date 2019/4/25 3:15 PM
 */
@Component
public class AyMoodConsumer {

  private final Logger logger = LogManager.getLogger(this.getClass());

  @JmsListener(destination = "ay.queue")
  public void receiveQueue(String text) {
    logger.info("用户发表说说【" + text + "】成功");
  }

  @Resource
  private AyMoodService ayMoodService;

  @JmsListener(destination = "ay.queue.asyn.save")
  public void receiveQueue(AyMood ayMood) {
    ayMoodService.save(ayMood);
  }
}
