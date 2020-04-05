package com.example.demo1;

import com.example.demo1.client.Client;
import com.example.demo1.utils.XMLHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;

/**
 * @author jinguodong
 * @date 2019/11/21 12:19 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UcTests {

  private String username;
  private String password;
  private String email;

  @Before
  public void setup() {
    this.username = "aaaa2";
    this.password = "aaaa2";
    this.email = "aaaa2@ccb.com";
  }

  @Test
  public void testLogin(){

    Client e = new Client();
    String result = e.uc_user_login(this.username, this.password);

    LinkedList<String> rs = XMLHelper.uc_unserialize(result);
    if(rs.size()>0){
      int $uid = Integer.parseInt(rs.get(0));
      String $username = rs.get(1);
      String $password = rs.get(2);
      String $email = rs.get(3);
      if($uid > 0) {
        System.out.println("登录成功");
        System.out.println($username);
        System.out.println($password);
        System.out.println($email);

        String $ucsynlogin = e.uc_user_synlogin($uid);
        System.out.println("登录成功"+$ucsynlogin);

        //本地登陆代码
        //TODO ... ....
      } else if($uid == -1) {
        System.out.println("用户不存在,或者被删除");
      } else if($uid == -2) {
        System.out.println("密码错");
      } else {
        System.out.println("未定义");
      }
    }else{
      System.out.println("Login failed");
      System.out.println(result);
    }
  }

  @Test
  public void testLogout(){

    Client uc = new Client();

    //setcookie('Example_auth', '', -86400);
//		生成同步退出的代码
    String $ucsynlogout = uc.uc_user_synlogout();
    System.out.println("退出成功"+$ucsynlogout);


  }

  @Test
  public void testRegister(){

    Client uc = new Client();

    //setcookie('Example_auth', '', -86400);
//		生成同步退出的代码
    String $returns = uc.uc_user_register(this.username, this.password, this.email );
    int $uid = Integer.parseInt($returns);
    if($uid <= 0) {
      if($uid == -1) {
        System.out.print("用户名不合法");
      } else if($uid == -2) {
        System.out.print("包含要允许注册的词语");
      } else if($uid == -3) {
        System.out.print("用户名已经存在");
      } else if($uid == -4) {
        System.out.print("Email 格式有误");
      } else if($uid == -5) {
        System.out.print("Email 不允许注册");
      } else if($uid == -6) {
        System.out.print("该 Email 已经被注册");
      } else {
        System.out.print("未定义");
      }
    } else {
      System.out.println("OK:"+$returns);
    }


  }
  
  @Test
  public void testOneFlow() {
//    testRegister();
    testLogin();
//    testLogout();
  }
}
