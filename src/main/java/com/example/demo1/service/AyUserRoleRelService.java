package com.example.demo1.service;

import com.example.demo1.model.AyUserRoleRel;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/4/26 4:27 PM
 */
public interface AyUserRoleRelService {
  List<AyUserRoleRel> findByUserId(String userId);
  AyUserRoleRel save(AyUserRoleRel ayUserRoleRel);
}
