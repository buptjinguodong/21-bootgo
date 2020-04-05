package com.example.demo1.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo1.model.*;
import com.example.demo1.service.ActivityInfoService;
import com.example.demo1.service.OrderInfoService;
import com.example.demo1.service.UserInfoService;
import com.example.demo1.urule.UruleClient;
import com.example.demo1.utils.BeanUtilsEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
@RestController
@RequestMapping("/activity")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ActivityController{

  private Logger logger = LoggerFactory.getLogger(ActivityController.class);

  @Autowired
  private ActivityInfoService activityInfoService;

  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private OrderInfoService orderInfoService;

  @RequestMapping("/enquireAll")
  public RestResult enquireAllActivity() throws Exception {
    List<ActivityInfo> activityInfoList = activityInfoService.findAll();
    RestResult restResult = new RestResult("00", "success", activityInfoList);
    UruleClient uc = new UruleClient();
    uc.doTest();
    return restResult;
  }

  @RequestMapping("/doDealOrder")
  public RestResult doDealOrder(@RequestBody OrderBusEntity orderBusEntity) {
    logger.info(JSON.toJSONString(orderBusEntity));
    // 保存用户信息
    UserInfo userInfo = new UserInfo();
    userInfo.setUsername(orderBusEntity.getUsername());
    userInfo.setUserSex(orderBusEntity.getUserSex());
    userInfo.setUserAge(orderBusEntity.getUserAge());
    userInfo.setUserTelphone(orderBusEntity.getUserTelphone());
    userInfo = userInfoService.save(userInfo);

    // 保存订单信息
    OrderInfo orderInfo = new OrderInfo();
    orderInfo.setActivityId(orderBusEntity.getActivityId());
    orderInfo.setUserId(userInfo.getId());
    orderInfo.setOrderStatus("01");
    orderInfo.setOrderCreateTime(new Date());
    orderInfoService.save(orderInfo);

    RestResult restResult = new RestResult("00", "success", null);
    return restResult;
  }

  /**
   * 获取全部订单信息
   * @return
   */
  @RequestMapping("/enquireOrder")
  public RestResult enquireOrder() {
//    List<ActivityInfo> activityInfoList = activityInfoService.findAll();
    List<OrderBusEntity> orderBusEntityList = new ArrayList<>();
    List<OrderInfo> orderInfoList = orderInfoService.findAll();
    for (OrderInfo orderInfo : orderInfoList) {
      OrderBusEntity orderBusEntity = new OrderBusEntity();
      ActivityInfo activityInfo = activityInfoService.findById(orderInfo.getActivityId());
      UserInfo userInfo = userInfoService.findById(orderInfo.getUserId());
      BeanUtilsEx.copyProperties(orderBusEntity, userInfo);
      BeanUtilsEx.copyProperties(orderBusEntity, activityInfo);
      BeanUtilsEx.copyProperties(orderBusEntity, orderInfo);
      orderBusEntityList.add(orderBusEntity);
    }

    RestResult restResult = new RestResult("00", "success", orderBusEntityList);
    return restResult;
  }
}
