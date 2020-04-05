package com.example.demo1.dao;

import com.example.demo1.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jinguodong
 * @date 2019/4/24 4:21 PM
 */
@Mapper // MyBatis根据接口定义与Mapper文件中的SQL语句动态创建接口实现
public interface AyUserDao {
  // @Param 注解参数，在Mapper.xml配置文件中，可以采用 #{} 的方式对@Param 注解括号内的参数进行引用
  AyUser findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
