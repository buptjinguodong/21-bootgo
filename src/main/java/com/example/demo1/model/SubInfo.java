package com.example.demo1.model;

import javax.persistence.Id;

/**
 * @author jinguodong
 * @date 2019/5/6 2:33 PM
 */
public class SubInfo {
  @Id
  private String id;
  private String nickname;
  private String departure;
  private String destination;
  private String flight;

  public String getFlight() {
    return flight;
  }

  public void setFlight(String flight) {
    this.flight = flight;
  }

  /**
   * 单程：01
   * 往返：02
   */
  private String departCd;
  private String price;
  private String email;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getDeparture() {
    return departure;
  }

  public void setDeparture(String departure) {
    this.departure = departure;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getDepartCd() {
    return departCd;
  }

  public void setDepartCd(String departCd) {
    this.departCd = departCd;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
