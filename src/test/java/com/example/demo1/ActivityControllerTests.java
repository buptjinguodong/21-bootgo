package com.example.demo1;

import com.alibaba.fastjson.JSON;
import com.example.demo1.controller.ActivityController;
import com.example.demo1.utils.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author jinguodong
 * @date 2019/6/16 11:23 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActivityControllerTests {

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void testUserController() throws Exception {
    // 测试UserController
    RequestBuilder request = null;

    /**
     * post a json to controller
     */
    Map<String, String> param = new HashMap<>();
    param.put("activityId", "1001001");
    param.put("userName", "1");
    param.put("userSex", "2");
    param.put("userAge", "3");
    param.put("userTelphone", "4");

    MvcResult mvcResult = mvc.perform(post("/activity/doDealOrder")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(JSON.toJSONString(param)))
            .andReturn();
    System.out.println(mvcResult.getResponse().getContentAsString());

  }

  @Test
  public void test4enquireOrder() throws Exception {
    // 测试UserController
    RequestBuilder request = null;

    /**
     * get to controller
     */

    MvcResult mvcResult = mvc.perform(get("/activity/enquireOrder"))
            .andReturn();
    System.out.println(JsonUtil.JsonFormart(mvcResult.getResponse().getContentAsString()));
  }
}
