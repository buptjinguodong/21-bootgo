package com.example.demo1.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author jinguodong
 * @date 2019/4/22 4:44 PM
 * 描述：
 *   WebFilter 将一个类声明为过滤器
 *    实现一些特殊功能：
 *      1. 实现URL的权限访问控制
 *      2. 过滤敏感词汇
 *      3. 压缩响应
 *      4. 等一些高级功能
 */

@WebFilter(filterName = "ayUserFilter", urlPatterns = "/*")
public class AyUserFilter implements Filter {

  private Logger log = LogManager.getLogger(AyUserFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.info("===========>>> init");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    log.info("============>>> doFilter");
    filterChain.doFilter(servletRequest,servletResponse);
  }

  @Override
  public void destroy() {
    log.info("-------->>> destroy");
  }
}
