package com.example.demo1.repository;

import com.example.demo1.model.AyUserAttachmentRel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jinguodong
 * @date 2019/4/25 6:01 PM
 */
public interface AyUserAttachmentRelRepository extends MongoRepository<AyUserAttachmentRel, String> {
}
