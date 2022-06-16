package com.spring.jsr.record;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @desc:
 * @author: xingle
 * @date: 2022/6/15
 */
@Data
public class RestBody<T> implements Rest<T>, Serializable {

    private int httpStatus = 200;
    private T data;
    private String msg = "";
    private String identifier = "";


    public static Rest<?> ok() {
        return new RestBody<>();
    }

    public static Rest<?> ok(String msg) {
        Rest<?> restBody = new RestBody<>();
        restBody.setMsg(msg);
        return restBody;
    }

    public static <T> Rest<T> okData(T data) {
        Rest<T> restBody = new RestBody<>();
        restBody.setData(data);
        return restBody;
    }

    public static <T> Rest<T> okData(T data, String msg) {
        Rest<T> restBody = new RestBody<>();
        restBody.setData(data);
        restBody.setMsg(msg);
        return restBody;
    }

    public static <T> Rest<T> build(int httpStatus, T data, String msg) {
        Rest<T> restBody = new RestBody<>();
        restBody.setHttpStatus(httpStatus);
        restBody.setData(data);
        restBody.setMsg(msg);
        return restBody;
    }

    public static Rest<?> failure(int httpStatus,String msg) {
        Rest<?> restBody = new RestBody<>();
        restBody.setHttpStatus(httpStatus);
        restBody.setMsg(msg);
        return restBody;
    }

    public static Rest<?> failure(String msg, String identifier) {
        Rest<?> restBody = new RestBody<>();
        restBody.setMsg(msg);
        restBody.setIdentifier(identifier);
        return restBody;
    }

    public static <T> Rest<T> failure(T data, String msg, String identifier){
        Rest<T> restBody = new RestBody<>();
        restBody.setData(data);
        restBody.setMsg(msg);
        restBody.setIdentifier(identifier);
        return restBody;
    }


}
