package com.example.demo1.repository;

import com.example.demo1.model.AyRole;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jinguodong
 * @date 2019/4/26 4:18 PM
 */
public interface AyRoleRepository extends MongoRepository<AyRole, String> {
}
