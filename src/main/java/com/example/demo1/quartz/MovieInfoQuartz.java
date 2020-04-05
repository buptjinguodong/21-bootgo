package com.example.demo1.quartz;

import com.alibaba.fastjson.JSON;
import com.example.demo1.model.MovieInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jinguodong
 * @date 2019/5/6 4:23 PM
 */
@Component
@Configurable // 加了此注释的类相当于XML配置文件，可以被SpringBoot扫描初始化
@EnableScheduling // 开启对计划任务的支持，然后在要执行计划任务的方案上注解@Scheduled，生命这是一个计划任务。
public class MovieInfoQuartz {
  private Logger logger = LogManager.getLogger(this.getClass());

  // 注解为定时任务，在Cron 表达式里写执行的时机
//  @Scheduled(cron = "0/5 * * * * ?")
  public void fetchMovieInfoByCron() {
    logger.info("------[fetchMovieInfoByCron]定时器运行了！！！");

    String aimUrl = "https://api.shenjian.io/?appid=f4dc5fbbbfc85a08209e6ccf90e73117";
    RestTemplate restTemplate = new RestTemplate();
    Object obj = restTemplate.getForObject(aimUrl, Object.class);
    Map<String, Object> mapRes = (Map)obj;
    logger.info("error_code： " + mapRes.get("error_code"));
    logger.info("reason： " + mapRes.get("reason"));
    logger.info("InnerMovieInfoRes: " + JSON.toJSONString(mapRes));

    Object objData = mapRes.get("data");
    List<Object> objectList = (List<Object>) objData;
    List<MovieInfo> movieInfoList = new ArrayList<>();
    for(Object objDataInner: objectList) {
      Map<String, String> mapDataInner = (Map) objDataInner;
      logger.info("mapDataInner: " + JSON.toJSONString(mapDataInner));

//      MovieInfo movieInfo = new MovieInfo();
//      movieInfo.setiRank(mapDataInner.get("Irank"));
//      movieInfo.setMovieName(mapDataInner.get("MovieName"));

    }


    logger.info("======[fetchMovieInfoByCron]定时器运行了 完了！！！");
  }
}
