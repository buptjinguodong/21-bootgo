//package com.example.demo1.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * @author jinguodong
// * @date 2019/4/26 3:55 PM
// */
//@Configuration
///**
// * 开启Security安全框架
// */
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//  @Bean
//  public CustomUserService customUserService() {
//    return new CustomUserService();
//  }
//
//  /**
//   * 通过formLogin方法配置启用默认登录页面
//   * 通过failureUrl方法配置登录失败返回URL
//   * 通过defaultSuccessUrl配置登录成功跳转URL
//   * 通过permitAll方法设置登录页面全部权限可访问
//   * @param httpSecurity
//   * @throws Exception
//   */
//  @Override
//  protected void configure(HttpSecurity httpSecurity) throws Exception {
//    // 路由策略 和 访问权限的 简单配置
//    httpSecurity
//            .formLogin() // 启动默认登录页面
//            .failureUrl("/login?error")
//            .defaultSuccessUrl("/ayUser/test")
//            .permitAll();
//    super.configure(httpSecurity);
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    // 使用 BCrypt 加密
//    return new BCryptPasswordEncoder();
//  }
//
//  /**
//   * inMemoryAuthentication 可添加内存中的用户，并可给用户指定角色权限
//   * @param auth
//   * @throws Exception
//   */
//  @Autowired
//  public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
//    auth
//            .userDetailsService(customUserService())
//            .passwordEncoder(new BCryptPasswordEncoder());
////    auth
////            .inMemoryAuthentication()
////            .passwordEncoder(new BCryptPasswordEncoder())
////            .withUser("aaa啦").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN")
////            .and()
////            .withUser("bbb吧").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
//  }
//}
