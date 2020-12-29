package com.nehru.mongoDbExample;

public class BadRequestException extends RuntimeException {

    BadRequestException(String s) {
        super(s);
    }
}
