package com.example.demo1.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinguodong
 * @date 2019/4/26 2:34 PM
 */
// 定义统一的异常处理类，basePackages属性用于定义扫描哪些包，默认不可设置
@ControllerAdvice(basePackages = {"com.example.demo1",})
public class GlobalDefaultExceptionHandler {
  // 用来定义函数针对的异常类型，可以传入多个需要捕获的异常类
  @ExceptionHandler({BusinessException.class})
  // 如果返回的为json数据或其他对象，就添加该注解
  @ResponseBody
  public ErrorInfo defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
    ErrorInfo errorInfo = new ErrorInfo();
    errorInfo.setMessage(e.getMessage());
    errorInfo.setUrl(request.getRequestURI());
    errorInfo.setCode(ErrorInfo.SUCCESS);
    return errorInfo;
  }
}
