package com.nehru.mongoDbExample.repository;

import com.nehru.mongoDbExample.dto.ReqData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReqDataRepository extends MongoRepository<ReqData<?>, Integer> {

}
