package com.example.demo1.service.impl;

import com.example.demo1.model.AyUserAttachmentRel;
import com.example.demo1.repository.AyUserAttachmentRelRepository;
import com.example.demo1.service.AyUserAttachmentRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jinguodong
 * @date 2019/4/25 6:03 PM
 */
@Service
public class AyUserAttachmentRelServiceImpl implements AyUserAttachmentRelService {

  @Autowired
  private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;

  @Override
  public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {
    return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
  }
}
