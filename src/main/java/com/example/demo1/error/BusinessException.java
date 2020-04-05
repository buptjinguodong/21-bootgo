package com.example.demo1.error;

/**
 * 业务异常指正常的业务处理时，由于某些业务的特殊要求而导致处理不能继续而抛出异常。
 * @author jinguodong
 * @date 2019/4/26 2:27 PM
 */
public class BusinessException extends RuntimeException {
  public BusinessException() {}

  public BusinessException(String message) {
    super(message);
  }
}
