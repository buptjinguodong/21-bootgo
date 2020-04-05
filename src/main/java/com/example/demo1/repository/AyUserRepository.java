package com.example.demo1.repository;

import com.example.demo1.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * 描述：用户Rep
 * 依赖：
 *  1. 在AyUser实体类下添加@Entity 注解
 *  2. 在AyUser的主键下添加@Id 注解
 * @author jinguodong
 * @date 2019/04/22
 */
public interface AyUserRepository extends JpaRepository<AyUser, String> {

  // 自定义查询方法

  /**
   *
   * @param name
   * @return
   * 相当于：select u from ay_user u where u.name = ?1
   */
  List<AyUser> findByName(String name);

  /**
   * select u from ay_user u where u.name like ?1
   */
  List<AyUser> findByNameLike(String name);

  /**
   * select u from ay_user u where id in(?,?,?)
   */
  List<AyUser> findByIdIn(Collection<String> ids);

}
