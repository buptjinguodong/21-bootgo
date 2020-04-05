package com.example.demo1.repository;

import com.example.demo1.model.AyUser;
import com.example.demo1.model.AyUserRoleRel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/4/26 4:19 PM
 */
public interface AyUserRoleRelRepository extends MongoRepository<AyUserRoleRel, String> {
  List<AyUserRoleRel> findByUserId(@Param("userId") String userId);
}
