package com.example.demo1.service.impl;

import com.example.demo1.model.OrderInfo;
import com.example.demo1.repository.OrderInfoRepository;
import com.example.demo1.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

  @Autowired
  private OrderInfoRepository orderInfoRepository;

  // 新增 | 修改
  public OrderInfo save(OrderInfo orderInfo) {
    return orderInfoRepository.save(orderInfo);
  }

  // 查看
  public OrderInfo findById(String id) {
    return orderInfoRepository.findById(id).get();
  }

  // 查看全部
  public List<OrderInfo> findAll() {
    return orderInfoRepository.findAll();
  }

  // 删除
  public void deleteById(String id) {
    orderInfoRepository.deleteById(id);
  }
}
