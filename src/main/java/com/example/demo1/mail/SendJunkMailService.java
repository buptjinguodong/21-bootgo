package com.example.demo1.mail;

import com.example.demo1.model.AyUser;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/4/24 4:03 PM
 */
public interface SendJunkMailService {
  boolean sendJunkMail(List<AyUser> ayUserList);
}
