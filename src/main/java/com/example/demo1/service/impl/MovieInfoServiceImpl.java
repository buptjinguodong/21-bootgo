package com.example.demo1.service.impl;

import com.example.demo1.model.MovieInfo;
import com.example.demo1.repository.MovieInfoRepository;
import com.example.demo1.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinguodong
 * @date 2019/5/6 4:18 PM
 */
@Service
public class MovieInfoServiceImpl implements MovieInfoService {

  @Autowired
  private MovieInfoRepository movieInfoRepository;

  @Override
  public MovieInfo save(MovieInfo subInfo) {
    return movieInfoRepository.save(subInfo);
  }

  @Override
  public MovieInfo findById(String id) {
    return movieInfoRepository.findById(id).get();
  }

  @Override
  public List<MovieInfo> findAll() {
    return movieInfoRepository.findAll();
  }

  @Override
  public void deleteById(String id) {
    movieInfoRepository.deleteById(id);
  }
}
