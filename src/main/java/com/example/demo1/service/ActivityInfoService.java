package com.example.demo1.service;

import com.example.demo1.model.ActivityInfo;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
public interface ActivityInfoService {

  // 新增 | 修改
  ActivityInfo save(ActivityInfo ActivityInfo);

  // 查看
  ActivityInfo findById(String id);

  // 查看全部
  List<ActivityInfo> findAll();

  // 删除
  void deleteById(String id);

}
