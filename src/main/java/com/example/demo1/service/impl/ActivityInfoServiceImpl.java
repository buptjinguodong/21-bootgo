package com.example.demo1.service.impl;

import com.example.demo1.model.ActivityInfo;
import com.example.demo1.repository.ActivityInfoRepository;
import com.example.demo1.service.ActivityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/6/9 10:35 PM
 */
@Service
public class ActivityInfoServiceImpl implements ActivityInfoService {

  @Autowired
  private ActivityInfoRepository activityInfoRepository;

  // 新增 | 修改
  public ActivityInfo save(ActivityInfo activityInfo) {
    return activityInfoRepository.save(activityInfo);
  }

  // 查看
  public ActivityInfo findById(String id) {
    return activityInfoRepository.findById(id).get();
  }

  // 查看全部
  public List<ActivityInfo> findAll() {
    return activityInfoRepository.findAll();
  }

  // 删除
  public void deleteById(String id) {
    activityInfoRepository.deleteById(id);
  }
}
