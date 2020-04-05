package com.example.demo1.repository;

import com.example.demo1.model.ActivityInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jinguodong
 * @date 2019/6/9 10:22 PM
 */
public interface ActivityInfoRepository extends MongoRepository<ActivityInfo, String> {
}
