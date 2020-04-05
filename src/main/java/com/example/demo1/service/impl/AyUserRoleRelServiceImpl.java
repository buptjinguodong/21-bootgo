package com.example.demo1.service.impl;

import com.example.demo1.model.AyUserRoleRel;
import com.example.demo1.repository.AyUserRoleRelRepository;
import com.example.demo1.service.AyUserRoleRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jinguodong
 * @date 2019/4/26 4:34 PM
 */
@Service
public class AyUserRoleRelServiceImpl implements AyUserRoleRelService {

  @Resource
  private AyUserRoleRelRepository ayUserRoleRelRepository;

  @Override
  public List<AyUserRoleRel> findByUserId(String userId) {
    List<AyUserRoleRel> ayUserRoleRels = ayUserRoleRelRepository.findByUserId(userId);
    return ayUserRoleRels;
  }

  @Override
  public AyUserRoleRel save(AyUserRoleRel ayUserRoleRel) {
    return this.ayUserRoleRelRepository.save(ayUserRoleRel);
  }
}
