package com.nehru.mongoDbExample.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ResData<T> {
    @Id
    int id;


    List<T> tList;

    public ResData(List<T> tList) {
        this.tList = tList;
    }


    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }


}
