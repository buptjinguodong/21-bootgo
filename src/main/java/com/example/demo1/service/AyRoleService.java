package com.example.demo1.service;

import com.example.demo1.model.AyRole;

/**
 * @author jinguodong
 * @date 2019/4/26 4:27 PM
 */
public interface AyRoleService {
  AyRole find(String id);
  AyRole save(AyRole ayRole);
}
