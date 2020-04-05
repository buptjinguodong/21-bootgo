package com.example.demo1.model;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author jinguodong
 * @date 2019/6/10 11:02 PM
 */
public class UserInfo {
  @Id
  private String id;
  private String username;
  private String userSex;
  private String userAge;
  private String userTelphone;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
}
