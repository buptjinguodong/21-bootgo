package com.example.demo1.model;


import java.util.Date;

/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
public class OrderBusEntity {

  private String id;
  private String activityId;
  private String activityName;
  private String activityDesc;
  private Date activityJoinStartDate;
  private String userId;
  private String username;
  private String userSex;
  private String userAge;
  private String userTelphone;
  private Date orderCreateTime;
  private String orderStatus;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public String getActivityName() {
    return activityName;
  }

  public void setActivityName(String activityName) {
    this.activityName = activityName;
  }

  public String getActivityDesc() {
    return activityDesc;
  }

  public void setActivityDesc(String activityDesc) {
    this.activityDesc = activityDesc;
  }

  public Date getActivityJoinStartDate() {
    return activityJoinStartDate;
  }

  public void setActivityJoinStartDate(Date activityJoinStartDate) {
    this.activityJoinStartDate = activityJoinStartDate;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserSex() {
    return userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }

  public String getUserAge() {
    return userAge;
  }

  public void setUserAge(String userAge) {
    this.userAge = userAge;
  }

  public String getUserTelphone() {
    return userTelphone;
  }

  public void setUserTelphone(String userTelphone) {
    this.userTelphone = userTelphone;
  }

  public Date getOrderCreateTime() {
    return orderCreateTime;
  }

  public void setOrderCreateTime(Date orderCreateTime) {
    this.orderCreateTime = orderCreateTime;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }
}
