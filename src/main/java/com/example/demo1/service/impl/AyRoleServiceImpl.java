package com.example.demo1.service.impl;

import com.example.demo1.error.BusinessException;
import com.example.demo1.model.AyRole;
import com.example.demo1.repository.AyRoleRepository;
import com.example.demo1.service.AyRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author jinguodong
 * @date 2019/4/26 4:28 PM
 */
@Service
public class AyRoleServiceImpl implements AyRoleService {

  @Resource
  private AyRoleRepository ayRoleRepository;

  @Override
  public AyRole find(String id) {
    Optional<AyRole> ayRoleOptional = ayRoleRepository.findById(id);
    if(!ayRoleOptional.isPresent()) {
      throw new BusinessException("AyRoleServiceImpl#find@id[" + id + "] 角色不存在：");
    }
    return ayRoleOptional.get();
  }

  @Override
  public AyRole save(AyRole ayRole) {
    return this.ayRoleRepository.save(ayRole);
  }
}
