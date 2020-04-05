package com.example.demo1.model;

import javax.persistence.Id;

/**
 * @author jinguodong
 * @date 2019/4/25 6:00 PM
 */
public class AyUserAttachmentRel {
  @Id
  private String id;
  private String userId;
  private String fileName;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
}
