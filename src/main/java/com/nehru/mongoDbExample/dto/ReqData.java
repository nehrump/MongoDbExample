package com.nehru.mongoDbExample.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ReqData<T> {
    @Id
    int id;

    boolean isString;

    boolean isInteger;
    List<T> tList;

    public boolean isString() {
        return isString;
    }

    public void setString(boolean string) {
        isString = string;
    }

    public boolean isInteger() {
        return isInteger;
    }

    public void setInteger(boolean integer) {
        isInteger = integer;
    }

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }


}
