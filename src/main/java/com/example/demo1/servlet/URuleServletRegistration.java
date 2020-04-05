package com.example.demo1.servlet;

import com.bstek.urule.console.servlet.URuleServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author jinguodong
 * @date 2020/2/5 2:30 PM
 */
@Component
public class URuleServletRegistration {
  @Bean
  public ServletRegistrationBean registerURuleServlet(){
    return new ServletRegistrationBean(new URuleServlet(),"/urule/*");
  }
}