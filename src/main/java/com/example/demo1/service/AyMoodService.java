package com.example.demo1.service;

import com.example.demo1.model.AyMood;

/**
 * @author jinguodong
 * @date 2019/4/25 11:47 AM
 */
public interface AyMoodService {
  AyMood save(AyMood ayMood);

  String asynSave(AyMood ayMood);
}
