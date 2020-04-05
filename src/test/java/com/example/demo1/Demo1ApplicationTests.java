package com.example.demo1;

import com.alibaba.fastjson.JSON;
import com.example.demo1.message.AyMoodProducer;
import com.example.demo1.model.*;
import com.example.demo1.repository.AyUserAttachmentRelRepository;
import com.example.demo1.repository.AyUserRepository;
import com.example.demo1.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

    private Logger log = LogManager.getLogger(Demo1ApplicationTests.class);

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void mySqlTest() {
      String sql = "select id,name,password from ay_user";
      List<AyUser> userList = (List<AyUser>) jdbcTemplate.query(sql, new RowMapper<AyUser>() {

        @Override
        public AyUser mapRow(ResultSet resultSet, int rowNum) throws SQLException {
          AyUser user = new AyUser();
          user.setId(resultSet.getString("id"));
          user.setName(resultSet.getString("name"));
          user.setPassword(resultSet.getString("password"));
          return user;
        }
      });

      log.info("查询成功");
      for(AyUser user:userList) {
        log.info("[id]:" + user.getId() + ";[name]:" + user.getName());
      }

    }

  @Resource
  private AyUserRepository ayUserRepository;

  @Test
  public void testRepository() throws JsonProcessingException {
    // 查找所有
    List<AyUser> userList = ayUserRepository.findAll();
    log.info("findAll():" + userList.size() + " Json: " + JSON.toJSONString(userList));

    // 通过name 查询数据
    List<AyUser> userList2 = ayUserRepository.findByName("aaa");
    log.info(" Json: " + JSON.toJSONString(userList2));

    // 通过 name模糊查询
    List<AyUser> userList3 = ayUserRepository.findByNameLike("%a%");
    log.info(" Json: " + JSON.toJSONString(userList3));

    // 通过id列表查询
    List<String> ids = new ArrayList<>();
    ids.add("1");
    ids.add("2");
    List<AyUser> userList4 = ayUserRepository.findByIdIn(ids);
    log.info(" Json: " + JSON.toJSONString(userList4));

    // 分页查询
    PageRequest pageRequest = new PageRequest(0, 10);
    Page<AyUser> userList5 = ayUserRepository.findAll(pageRequest);
    log.info(" Json: " + JSON.toJSONString(userList5));

    // 新增数据
    AyUser ayUser = new AyUser();
    ayUser.setId("11");
    ayUser.setName("jj");
    ayUser.setPassword("123456");
    ayUser = ayUserRepository.save(ayUser);
    log.info(" Json: " + JSON.toJSONString(ayUser));

    // 删除数据
    ayUserRepository.deleteById("11");
  }

  @Resource
  private AyUserService ayUserService;
  @Test
  public void test4Service() {
    AyUser ayUser = new AyUser();
    ayUser.setId("12");
    ayUser.setName("gg");
    ayUser.setPassword("123456");
    ayUser = ayUserService.save(ayUser);
    log.info(" Json: " + JSON.toJSONString(ayUser));
  }

  @Resource
  private RedisTemplate redisTemplate;

  @Test
  public void test4Redis() {
    redisTemplate.opsForValue().set("name", "ay");
    String name = (String) redisTemplate.opsForValue().get("name");
    log.info(name);
  }

  @Resource
  private AyMoodService ayMoodService;

  @Test
  public void test4AyMood() {
    AyMood ayMood = new AyMood();
    ayMood.setId("1");
    ayMood.setUserId("1");
    ayMood.setPraiseNum(0);
    ayMood.setContent("ljljkjadsf阿拉");
    ayMood.setPublishTime(new Date());
    AyMood ayMood1 = ayMoodService.save(ayMood);
    log.info("AyMood: " + JSON.toJSONString(ayMood1));
  }

  @Resource
  private AyMoodProducer ayMoodProducer;

  @Test
  public void testActiveMQ() {
    Destination destination = new ActiveMQQueue("ay.queue");
    ayMoodProducer.sendMessage(destination, "Hello MQ!!!");
  }

  @Test
  public void testActiveMQAsynSave() {
    AyMood ayMood = new AyMood();
    ayMood.setId("2");
    ayMood.setUserId("2");
    ayMood.setPraiseNum(0);
    ayMood.setContent("papaLa吗");
    ayMood.setPublishTime(new Date());
    String msg = ayMoodService.asynSave(ayMood);
    log.info("异步发表说说：" + msg);
  }

  @Test
  public void testAsync() {
    long startTime = System.currentTimeMillis(); // 当前时间毫秒数
    log.info("第1次查询用户！");
    List<AyUser> userList = ayUserService.findAll();
    log.info("第2次查询用户！");
    List<AyUser> userList2 = ayUserService.findAll();
    log.info("第3次查询用户！");
    List<AyUser> userList3 = ayUserService.findAll();
    long endTime = System.currentTimeMillis();
    log.info("总共消耗：" + (endTime - startTime) + "毫秒");
  }

  @Test
  public void testAsync2() throws InterruptedException {
    long startTime = System.currentTimeMillis(); // 当前时间毫秒数
    log.info("第1次查询用户！");
    Future<List<AyUser>> userList = ayUserService.findAsynAll();
    log.info("第2次查询用户！");
    Future<List<AyUser>> userList2= ayUserService.findAsynAll();
    log.info("第3次查询用户！");
    Future<List<AyUser>> userList3 = ayUserService.findAsynAll();

    while (true) {
      if(userList.isDone() && userList2.isDone() && userList3.isDone()) {
        break;
      } else {
        Thread.sleep(10);
      }
    }
    long endTime = System.currentTimeMillis();
    log.info("总共消耗：" + (endTime - startTime) + "毫秒");
  }

  @Resource
  private AyUserAttachmentRelService ayUserAttachmentRelService;
  @Resource
  private AyRoleService ayRoleService;
  @Resource
  private AyUserRoleRelService ayUserRoleRelService;

  @Test
  public void testMongo() {
    AyUserAttachmentRel ayUserAttachmentRel = new AyUserAttachmentRel();
    ayUserAttachmentRel.setId("1");
    ayUserAttachmentRel.setUserId("1");
    ayUserAttachmentRel.setFileName("个人简历啊.doc");
    ayUserAttachmentRel = ayUserAttachmentRelService.save(ayUserAttachmentRel);
    log.info("保存成功：" + JSON.toJSONString(ayUserAttachmentRel));

    AyRole ayRole = new AyRole();
    ayRole.setId("1");
    ayRole.setName("ADMIN");
    ayRoleService.save(ayRole);
    log.info("保存成功：" + JSON.toJSONString(ayRole));

    AyUserRoleRel ayUserRoleRel = new AyUserRoleRel();
    ayUserRoleRel.setRoleId("1");
    ayUserRoleRel.setUserId("1");
    ayUserRoleRelService.save(ayUserRoleRel);
    log.info("保存成功：" + JSON.toJSONString(ayUserRoleRel));
  }
}
