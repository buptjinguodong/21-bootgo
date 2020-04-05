//package com.example.demo1.security;
//
//import org.springframework.security.core.CredentialsContainer;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.Collection;
//
///**
// * @author jinguodong
// * @date 2019/4/26 4:44 PM
// */
//public class User implements UserDetails, CredentialsContainer {
//  private static final long serialVersionUID = 420L;
//  private String password;
//  private final String username;
//  Collection<? extends GrantedAuthority> authorities;
//
//  public void setPassword(String password) {
//    this.password = password;
//  }
//
//  public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//    this.username = username;
////    this.password = new BCryptPasswordEncoder().encode(password);
//    this.password = password;
//    this.authorities = authorities;
//  }
//
//  @Override
//  public void eraseCredentials() {
//
//  }
//
//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return this.authorities;
//  }
//
//  @Override
//  public String getPassword() {
//    return this.password;
//  }
//
//  @Override
//  public String getUsername() {
//    return this.username;
//  }
//
//  @Override
//  public boolean isAccountNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isAccountNonLocked() {
//    return true;
//  }
//
//  @Override
//  public boolean isCredentialsNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isEnabled() {
//    return true;
//  }
//}
