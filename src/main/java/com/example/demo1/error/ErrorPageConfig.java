package com.example.demo1.error;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author jinguodong
 * @date 2019/4/26 2:18 PM
 */
@Configuration
public class ErrorPageConfig {
  /**
   * EmbeddedServletContainerCustomizer:
   *  在Spring Boot2.0以上配置嵌入式Servlet容器时EmbeddedServletContainerCustomizer类不存在，
   *  经网络查询发现被WebServerFactoryCustomizer替代.
   *  在WebServerFactoryCustomizer接口中使用ConfigurableWebServerFactory对象实现对customize()方法的转换，
   *  从而实现对嵌入式servlet容器的配置。
   * @return
   */
  @Bean
  public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
    return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
      @Override
      public void customize(ConfigurableWebServerFactory factory) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
        factory.addErrorPages(error404Page);
      }
    };
  }
}
