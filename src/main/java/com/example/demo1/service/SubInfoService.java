package com.example.demo1.service;

import com.example.demo1.model.SubInfo;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/5/6 2:39 PM
 */
public interface SubInfoService {
  // 新增 | 修改
  SubInfo save(SubInfo subInfo);
  // 查看
  SubInfo findById(String id);
  // 查看全部
  List<SubInfo> findAll();
  // 删除
  void deleteById(String id);
}
