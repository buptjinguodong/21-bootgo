package com.example.demo1.quartz;

import com.example.demo1.mail.SendJunkMailService;
import com.example.demo1.model.AyUser;
import com.example.demo1.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jinguodong
 * @date 2019/4/24 3:40 PM
 */
@Component
@Configurable // 加了此注释的类相当于XML配置文件，可以被SpringBoot扫描初始化
@EnableScheduling // 开启对计划任务的支持，然后在要执行计划任务的方案上注解@Scheduled，生命这是一个计划任务。
public class SendMailQuartz {

  private Logger logger = LogManager.getLogger(this.getClass());

  @Resource
  private SendJunkMailService sendJunkMailService;
  @Resource
  private AyUserService ayUserService;

  // 注解为定时任务，在Cron 表达式里写执行的时机
  @Scheduled(cron = "0 0 12 * * ?")
  public void reportCurrentByCron() {
    logger.info("------定时器运行了！！！");
    List<AyUser> userList = ayUserService.findAll();
    if(userList == null || userList.size() <= 0) return;
    // 发送邮件
    sendJunkMailService.sendJunkMail(userList);

    logger.info("======定时器运行了 完了！！！");
  }
}
