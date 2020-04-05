package com.example.demo1.model;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author jinguodong
 * @date 2019/6/9 10:20 PM
 */
public class OrderInfo {

  @Id
  private String id;
  private String orderStatus;
  private String activityId;
  private String userId;
  private Date orderCreateTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Date getOrderCreateTime() {
    return orderCreateTime;
  }

  public void setOrderCreateTime(Date orderCreateTime) {
    this.orderCreateTime = orderCreateTime;
  }
}
