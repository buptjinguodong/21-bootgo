package com.example.demo1.repository;

import com.example.demo1.model.MovieInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jinguodong
 * @date 2019/5/6 4:14 PM
 */
public interface MovieInfoRepository extends MongoRepository<MovieInfo, String> {
}
