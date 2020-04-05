package com.example.demo1.service;

import com.example.demo1.model.MovieInfo;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/5/6 4:17 PM
 */
public interface MovieInfoService {
  // 新增 | 修改
  MovieInfo save(MovieInfo subInfo);
  // 查看
  MovieInfo findById(String id);
  // 查看全部
  List<MovieInfo> findAll();
  // 删除
  void deleteById(String id);
}
