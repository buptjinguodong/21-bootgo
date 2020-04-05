package com.example.demo1.model;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author jinguodong
 * @date 2019/6/9 10:20 PM
 */
public class ActivityInfo {
  @Id
  private String id;
  private String activityName;
  private String activityDesc;
  private Date activityJoinStartDate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
}
