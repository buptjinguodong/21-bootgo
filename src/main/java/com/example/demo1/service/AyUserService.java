package com.example.demo1.service;

import com.example.demo1.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 描述：用户服务接口
 * @author jinguodong
 * @date 2019-04-22
 */
public interface AyUserService {
  AyUser findById(String id);
  List<AyUser> findAll();
  // 异步查询
  Future<List<AyUser>> findAsynAll();

  AyUser save(AyUser ayUser);
  void delete (String id);
  // 分页
  Page<AyUser> findAll(Pageable pageable);

  // 自定义方法
  List<AyUser> findByName(String name);
  List<AyUser> findByNameLike(String name);
  List<AyUser> findByIdIn(Collection<String> ids);

  AyUser findByNameAndPasswordRetry(String name, String password);

}
