//package com.example.demo1.security;
//
//import com.example.demo1.error.BusinessException;
//import com.example.demo1.model.AyUser;
//import com.example.demo1.model.AyUserRoleRel;
//import com.example.demo1.service.AyRoleService;
//import com.example.demo1.service.AyUserRoleRelService;
//import com.example.demo1.service.AyUserService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author jinguodong
// * @date 2019/4/26 4:37 PM
// */
//public class CustomUserService implements UserDetailsService {
//  private Logger logger = LogManager.getLogger(this.getClass());
//  @Resource
//  private AyUserService ayUserService;
//  @Resource
//  private AyUserRoleRelService ayUserRoleRelService;
//  @Resource
//  private AyRoleService ayRoleService;
//
//  @Override
//  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//    logger.info("收到登录用户名：" + s);
//    List<AyUser> ayUserList = ayUserService.findByName(s);
//
//    AyUser ayUser = null;
//    if(ayUserList == null || ayUserList.size()<=0) {
//      throw new BusinessException("#loadUserByUsername 用户不存在");
//    }
//    ayUser = ayUserList.get(0);
//    ayUser.setPassword(new BCryptPasswordEncoder().encode(ayUser.getPassword()));
//    // 获取用户角色
//    List<AyUserRoleRel> ayUserRoleRelList = ayUserRoleRelService.findByUserId(ayUser.getId());
//    List<GrantedAuthority> authorityList = new ArrayList<>();
//    if(ayUserRoleRelList != null && ayUserRoleRelList.size() > 0) {
//      for(AyUserRoleRel rel:ayUserRoleRelList) {
//        // 获取用户关联角色名称
//        String roleName = ayRoleService.find(rel.getRoleId()).getName();
//        authorityList.add(new SimpleGrantedAuthority((roleName)));
//      }
//    }
//    return new User(ayUser.getName(), ayUser.getPassword(), authorityList);
//  }
//}
