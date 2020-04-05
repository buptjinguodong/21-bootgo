package com.example.demo1.service.impl;

import com.example.demo1.model.UserInfo;
import com.example.demo1.repository.UserInfoRepository;
import com.example.demo1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  private UserInfoRepository userInfoRepository;

  // 新增 | 修改
  public UserInfo save(UserInfo userInfo) {
    return userInfoRepository.save(userInfo);
  }

  // 查看
  public UserInfo findById(String id) {
    return userInfoRepository.findById(id).get();
  }

  // 查看全部
  public List<UserInfo> findAll() {
    return userInfoRepository.findAll();
  }

  // 删除
  public void deleteById(String id) {
    userInfoRepository.deleteById(id);
  }
}
