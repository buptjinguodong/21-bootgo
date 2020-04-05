package com.example.demo1.filter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;

@Configuration
public class DruidConfiguration {
  @Bean
  public ServletRegistrationBean druidStatViewServlet() {
    // ServletRegistrationBean 提供进行注册的类
    ServletRegistrationBean servletRegistrationBean
            = new ServletRegistrationBean(new StatViewServlet(),
            "/druid/*");
    // 添加初始化参数：initParams
    // 白名单：
    servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
    // IP黑名单
    // 登录查看信息的账号和密码
    servletRegistrationBean.addInitParameter("loginUserName", "admin");
    servletRegistrationBean.addInitParameter("loginPassword", "123456");
    // 是否能够重置密码
    servletRegistrationBean.addInitParameter("resetEnable", "false");
    return servletRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean druidStatFilter() {
    FilterRegistrationBean filterRegistrationBean
            = new FilterRegistrationBean(new WebStatFilter());
    // 添加过滤规则
    filterRegistrationBean.addUrlPatterns("/*");
    // 添加需要忽略的格式信息
    filterRegistrationBean.addInitParameter("exclusions",
            "*.js,*.ico,/druid/*");
    return filterRegistrationBean;
  }
}
