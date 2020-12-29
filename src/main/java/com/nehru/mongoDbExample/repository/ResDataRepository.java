package com.nehru.mongoDbExample.repository;

import com.nehru.mongoDbExample.dto.ResData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResDataRepository extends MongoRepository<ResData<?>, Integer> {

}
