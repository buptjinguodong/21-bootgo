package com.example.demo1.model;

import javax.persistence.Id;

/**
 * @author jinguodong
 * @date 2019/5/6 4:15 PM
 */
public class MovieInfo {
  @Id
  private String id;
  private String iRank;
  private String movieName;
  private String boxOffice;
  private String sumBoxOffice;
  private String movieDay;
  private String boxPer;
  private String time;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getiRank() {
    return iRank;
  }

  public void setiRank(String iRank) {
    this.iRank = iRank;
  }

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public String getBoxOffice() {
    return boxOffice;
  }

  public void setBoxOffice(String boxOffice) {
    this.boxOffice = boxOffice;
  }

  public String getSumBoxOffice() {
    return sumBoxOffice;
  }

  public void setSumBoxOffice(String sumBoxOffice) {
    this.sumBoxOffice = sumBoxOffice;
  }

  public String getMovieDay() {
    return movieDay;
  }

  public void setMovieDay(String movieDay) {
    this.movieDay = movieDay;
  }

  public String getBoxPer() {
    return boxPer;
  }

  public void setBoxPer(String boxPer) {
    this.boxPer = boxPer;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}
