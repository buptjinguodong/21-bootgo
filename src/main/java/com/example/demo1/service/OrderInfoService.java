package com.example.demo1.service;

import com.example.demo1.model.OrderInfo;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
public interface OrderInfoService {

  // 新增 | 修改
  OrderInfo save(OrderInfo orderInfo);

  // 查看
  OrderInfo findById(String id);

  // 查看全部
  List<OrderInfo> findAll();

  // 删除
  void deleteById(String id);

}
