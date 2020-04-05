package com.example.demo1.service;

import com.example.demo1.model.UserInfo;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
public interface UserInfoService {

  // 新增 | 修改
  UserInfo save(UserInfo userInfo);

  // 查看
  UserInfo findById(String id);

  // 查看全部
  List<UserInfo> findAll();

  // 删除
  void deleteById(String id);

}
