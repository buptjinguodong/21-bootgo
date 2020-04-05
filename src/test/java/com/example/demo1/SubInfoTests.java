package com.example.demo1;

import com.alibaba.fastjson.JSON;
import com.example.demo1.dao.AyUserDao;
import com.example.demo1.model.AyUser;
import com.example.demo1.model.MovieInfo;
import com.example.demo1.model.SubInfo;
import com.example.demo1.quartz.MovieInfoQuartz;
import com.example.demo1.service.MovieInfoService;
import com.example.demo1.service.SubInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/5/6 2:43 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubInfoTests {
  private Logger log = LogManager.getLogger(SubInfoTests.class);

  @Autowired
  private SubInfoService subInfoService;
  @Autowired
  private AyUserDao ayUserDao;

  @Test
  public void test4SubInfoService() {
    SubInfo subInfo = new SubInfo();
    subInfo.setId("2");
    subInfo.setDepartCd("02"); // 单程
    subInfo.setDeparture("北京"); // 出发地
    subInfo.setDestination("俄罗斯"); // 目的地
    subInfo.setEmail("buptjinguodong@126.com"); //订阅邮件
    subInfo.setPrice("500"); // 价格阈值
    subInfo.setFlight("SU1492");
    subInfoService.save(subInfo);
  }

  @Test
  public void test4SubInfoServiceFindAll() {

    List<SubInfo> subInfos = subInfoService.findAll();
    log.info("订阅信息：" + JSON.toJSONString(subInfos));
  }

  @Autowired
  private MovieInfoService movieInfoService;

  @Test
  public void test4MovieInfoServiceSave() {
    MovieInfo movieInfo = new MovieInfo();
    movieInfo.setId("1");
    movieInfo.setiRank("1");
    movieInfo.setMovieName("复仇者联盟4：终局之战");
    movieInfo.setBoxOffice("1234");
    movieInfo.setSumBoxOffice("12345");
    movieInfo.setMovieDay("12");
    movieInfo.setBoxPer("56");
    movieInfo.setTime("20190504");
    movieInfoService.save(movieInfo);
  }

  @Test
  public void test4MovieInfoQuartz() {
    MovieInfoQuartz movieInfoQuartz = new MovieInfoQuartz();
    movieInfoQuartz.fetchMovieInfoByCron();
  }

  @Test
  public void test4ayUserDao() {
    AyUser ayUser = new AyUser();
    ayUser.setName("user");
    ayUser.setPassword("pass");
    List<AyUser> ayUserList;
    ayUser = ayUserDao.findByNameAndPassword(ayUser.getName(), ayUser.getPassword());
    System.out.println(ayUser);

  }
}
