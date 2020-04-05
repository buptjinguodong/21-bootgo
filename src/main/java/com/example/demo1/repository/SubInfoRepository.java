package com.example.demo1.repository;

import com.example.demo1.model.SubInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author jinguodong
 * @date 2019/5/6 2:36 PM
 */
// 在服务器启动的时候，jpa的启动管理类会自动扫荡继承了JpaRepository的接口，然后添加到动态代理管理中，然后注入到spring的容器中。
public interface SubInfoRepository extends MongoRepository<SubInfo, String> {

}
