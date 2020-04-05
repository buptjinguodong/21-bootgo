package com.example.demo1.mail.impl;

import com.example.demo1.mail.SendJunkMailService;
import com.example.demo1.model.AyUser;
import com.example.demo1.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @author jinguodong
 * @date 2019/4/24 4:04 PM
 */
@Service
public class SendJunkMailServiceImpl implements SendJunkMailService {

  @Autowired
  private JavaMailSender mailSender;
  @Resource
  private AyUserService ayUserService;

  @Value("${spring.mail.username}")
  private String from;
  public final Logger logger = LogManager.getLogger(this.getClass());

  @Override
  public boolean sendJunkMail(List<AyUser> ayUserList) {
    try{
      if(ayUserList == null || ayUserList.size() <= 0) {
        return Boolean.FALSE;
      }
      for(AyUser ayUser: ayUserList) {
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        // 邮件发送方
        messageHelper.setFrom(from);
        // 邮件主题
        messageHelper.setSubject("地瓜特卖啦");
        // 邮件接收方
        messageHelper.setTo("buptjinguodong@126.com");
        // 邮件内容
        messageHelper.setText(ayUser.getName() + "你知道吗？今日地瓜特卖，一斤9元");
        // 发送邮件
        this.mailSender.send(mimeMessage);

      }
    }catch (Exception ex) {
      logger.error("sendJunkMail error and ayUser=%s", ayUserList, ex);
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
}
