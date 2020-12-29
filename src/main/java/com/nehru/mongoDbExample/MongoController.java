package com.nehru.mongoDbExample;

import com.nehru.mongoDbExample.dto.ReqData;
import com.nehru.mongoDbExample.dto.ResData;
import com.nehru.mongoDbExample.repository.ReqDataRepository;
import com.nehru.mongoDbExample.repository.ResDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class MongoController {

    @Autowired
    ReqDataRepository reqDataRepository;

    @Autowired
    ResDataRepository resDataRepository;

    @PostMapping("/Outgoing")
    public ResponseEntity<ResData<?>> getResponse(@RequestBody ReqData t) {
        reqDataRepository.save(t);
        if (t.isInteger() && !t.isString()) {

            List<Integer> tList = t.gettList();
            Optional<Integer> outputPresent = tList.stream().reduce((a, b) -> a > b ? a : b);
            outputPresent.orElseThrow(() -> new BadRequestException(""));
            ResData<Integer> resData = new ResData<>(Collections.singletonList(outputPresent.get()));
            resDataRepository.save(resData);
            return new ResponseEntity<>(resData, HttpStatus.OK);
        } else if (t.isString() && !t.isInteger()) {
            List<String> tList = t.gettList();
            Set<String> stringSet = new HashSet<>();
            List<String> outPutList = tList.stream().filter(s -> !stringSet.add(s)).collect(Collectors.toList());
            ResData<String> resData = new ResData<>(outPutList);
            resDataRepository.save(resData);
            return new ResponseEntity<>(resData, HttpStatus.OK);
        } else {
            throw new BadRequestException("Invalid request");
        }


    }

}
