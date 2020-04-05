package com.example.demo1.service.impl;

import com.example.demo1.error.BusinessException;
import com.example.demo1.model.AyUser;
import com.example.demo1.repository.AyUserRepository;
import com.example.demo1.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author jinguodong
 * @date 2019/4/22 12:10 PM
 */
@Transactional
@Service
public class AyUserServiceImpl implements AyUserService {

  private final Logger logger = LogManager.getLogger(this.getClass());

  @Resource
  private AyUserRepository ayUserRepository;

  @Override
  public AyUser findById(String id) {
    return ayUserRepository.findById(id).get();
  }

  @Override
  public List<AyUser> findAll() {
    logger.info("开始任务：" + this.getClass().getSimpleName() + ":"
            + new Exception().getStackTrace()[0].getMethodName());
    long start = System.currentTimeMillis();
    List<AyUser> userList = ayUserRepository.findAll();
    long end = System.currentTimeMillis();
    logger.info("完成任务，耗时：" + (end - start) + "毫秒");
    return userList;
  }

  @Override
  @Async
  public Future<List<AyUser>> findAsynAll() {
    try {
      logger.info("开始任务：" + this.getClass().getSimpleName() + ":"
              + new Exception().getStackTrace()[0].getMethodName());
      long start = System.currentTimeMillis();
      List<AyUser> userList = ayUserRepository.findAll();
      long end = System.currentTimeMillis();
      logger.info("完成任务，耗时：" + (end - start) + "毫秒");
      return new AsyncResult<>(userList);
    } catch (Exception e) {
      logger.error("method [findAll] error", e);
      return new AsyncResult<List<AyUser>>(null);
    }
  }

  @Override
  public AyUser save(AyUser ayUser) {
    AyUser saveUser = ayUserRepository.save(ayUser);
//    String error = null;
//    error.split("/");
    return saveUser;
  }

  @Override
  public void delete(String id) {
    ayUserRepository.deleteById(id);
  }

  @Override
  public Page<AyUser> findAll(Pageable pageable) {
    return ayUserRepository.findAll(pageable);
  }

  @Override
  public List<AyUser> findByName(String name) {
    return ayUserRepository.findByName(name);
  }

  @Override
  public List<AyUser> findByNameLike(String name) {
    return ayUserRepository.findByNameLike(name);
  }

  @Override
  public List<AyUser> findByIdIn(Collection<String> ids) {
    return ayUserRepository.findByIdIn(ids);
  }

  @Override
  @Retryable(value = {BusinessException.class}, maxAttempts = 3, backoff = @Backoff(delay = 5000, multiplier = 2))
  public AyUser findByNameAndPasswordRetry(String name, String password) {
    logger.info("[findByNameAndPasswordRetry()] 方法失败重试了！");
    if(true) {
      throw new BusinessException("\"[findByNameAndPasswordRetry()] 方法失败重试了！\"");
    }
    return null;
  }
}
