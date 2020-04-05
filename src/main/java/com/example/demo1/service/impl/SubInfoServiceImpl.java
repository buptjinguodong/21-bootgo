package com.example.demo1.service.impl;

import com.example.demo1.model.SubInfo;
import com.example.demo1.repository.SubInfoRepository;
import com.example.demo1.service.SubInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/5/6 2:41 PM
 */
@Service
public class SubInfoServiceImpl implements SubInfoService {

  @Autowired
  private SubInfoRepository subInfoRepository;

  @Override
  public SubInfo save(SubInfo subInfo) {
    return subInfoRepository.save(subInfo);
  }

  @Override
  public SubInfo findById(String id) {
    return subInfoRepository.findById(id).get();
  }

  @Override
  public List<SubInfo> findAll() {
    return subInfoRepository.findAll();
  }

  @Override
  public void deleteById(String id) {
    subInfoRepository.deleteById(id);
  }
}
