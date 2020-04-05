package com.example.demo1;

import com.alibaba.fastjson.JSON;
import com.example.demo1.model.ActivityInfo;
import com.example.demo1.model.OrderInfo;
import com.example.demo1.model.UserInfo;
import com.example.demo1.service.ActivityInfoService;
import com.example.demo1.service.OrderInfoService;
import com.example.demo1.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author jinguodong
 * @date 2019/6/9 10:22 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityInfoTests {
  private Logger log = LogManager.getLogger(ActivityInfoTests.class);

  @Autowired
  private ActivityInfoService activityInfoService;

  @Test
  public void test4Save() {
    ActivityInfo activityInfo = new ActivityInfo();
    activityInfo.setActivityName("我们的大家园1");
    activityInfo.setActivityDesc("我们的大家园1在20190629日于中关村家乐福举办活动");
    activityInfo.setActivityJoinStartDate(new Date());
    activityInfo.setId("1001002");
    activityInfoService.save(activityInfo);
  }

  @Test
  public void test4FindById() {
    ActivityInfo activityInfo = null;
    activityInfo = activityInfoService.findById("1001001");
    log.info(JSON.toJSONString(activityInfo));
  }

  @Test
  public void test4FindAll() {
    log.info(JSON.toJSONString(activityInfoService.findAll()));
  }

  @Autowired
  private UserInfoService userInfoService;

  @Test
  public void test4UserSave() {
    UserInfo userInfo = new UserInfo();
    userInfo.setUsername("DDDGE");
    userInfo.setUserAge("123");
    userInfo.setUserSex("1");
    userInfo.setUserTelphone("13312345678");
    userInfoService.save(userInfo);
  }

  @Test
  public void test4UserFindAll() {
    log.info(JSON.toJSONString(userInfoService.findAll()));
  }

  @Autowired
  private OrderInfoService orderInfoService;

  @Test
  public void test4OrderSave() {
    OrderInfo orderInfo = new OrderInfo();
    orderInfo.setActivityId("1001001");
    orderInfo.setUserId("5cfe7411e22ee68db889bfb5");
    orderInfo.setOrderStatus("01");
    orderInfo.setOrderCreateTime(new Date());
    orderInfoService.save(orderInfo);
  }

  @Test
  public void test4OrderFindAll() {
    log.info(JSON.toJSONString(orderInfoService.findAll()));
  }
}
