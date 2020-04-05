package com.example.demo1.listener;

import com.example.demo1.model.AyUser;
import com.example.demo1.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author jinguodong
 * @date 2019/4/22 4:54 PM
 */
@WebListener
public class AyUserListener implements ServletContextListener {

  private Logger logger = LogManager.getLogger(AyUserListener.class);

  @Resource
  private RedisTemplate redisTemplate;

  @Resource
  private AyUserService ayUserService;

  private static final String ALL_USER = "ALL_USER_LIST";

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent){
    // 可以在此处查询所有的用户，缓存起来，提升系统性能
    logger.info("----------> ServletContext init");
//    // 查询数据库所有的用户
//    List<AyUser> ayUserList = ayUserService.findAll();
//    // 清除缓存中的用户数据
//    redisTemplate.delete(ALL_USER);
//    // 将数据存放到Redis缓存中
//    redisTemplate.opsForList().leftPushAll(ALL_USER, ayUserList);

//    // //  测试环境使用
//    List<AyUser> queryUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
//    logger.info("缓存中目前用户总数：" + queryUserList.size());
//    logger.info("----------> ServletContext init Succuess");

  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    logger.info("----------> ServletContext destroyed");
  }
}
