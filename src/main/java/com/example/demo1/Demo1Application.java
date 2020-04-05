package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan //使用该注解后，Servlet\Filter\Listener 可以直接通过@WebServlet\@WebFilter\@WebListener注解自动注册。
@EnableAsync
/**
 * 常规重试策略的共同问题：
 *  正常逻辑 和 重试逻辑强耦合
*  基于这些问题：Spring-Retry规范正常逻辑和重试逻辑，将正常逻辑与重试逻辑解耦。
  */
@EnableRetry // 开启 Retry 重试
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
