package com.example.demo1.controller;

import com.example.demo1.error.BusinessException;
import com.example.demo1.model.AyUser;
import com.example.demo1.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jinguodong
 * @date 2019/4/22 4:02 PM
 */
@Controller
@RequestMapping("/ayUser")
public class AyUserController {

  @Resource
  private AyUserService ayUserService;

  @RequestMapping("/test")
  public String test(Model model) {
    // 查询数据库所有用户
    List<AyUser> ayUsers = ayUserService.findAll();
    model.addAttribute("users", ayUsers);
    return "ayUser";
  }

  @RequestMapping("/findAll")
  public String findAll(Model model) {
    // 查询数据库所有用户
    List<AyUser> ayUsers = ayUserService.findAll();
    model.addAttribute("users", ayUsers);
    if (true) {
      throw new BusinessException("业务异常！！");
    }
    return "ayUser";
  }

  @RequestMapping("/findByNameAndPasswordRetry")
  public String findByNameAndPasswordRetry(Model model) {
    // 查询数据库所有用户
    AyUser ayUser = ayUserService.findByNameAndPasswordRetry("aaa", "123456");
    model.addAttribute("user", ayUser);
    return "success";
  }
}
