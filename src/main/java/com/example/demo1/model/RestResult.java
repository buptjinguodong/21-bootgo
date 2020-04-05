package com.example.demo1.model;


/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
public class RestResult {
  public String code;
  public String message;
  public Object data;

  public RestResult(String code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
