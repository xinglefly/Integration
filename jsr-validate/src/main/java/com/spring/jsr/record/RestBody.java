package com.spring.jsr.record;

import lombok.Data;

import java.io.Serializable;

/**
 * @desc:
 * @author: xingle
 * @date: 2022/6/15
 */
@Data
public class RestBody<T> implements Rest<T>, Serializable {

    private int code = 200;
    private String msg = "";
    private String identifier = "";
    private T data;


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

    public static <T> Rest<T> build(int code, T data, String msg) {
        Rest<T> restBody = new RestBody<>();
        restBody.setCode(code);
        restBody.setData(data);
        restBody.setMsg(msg);
        return restBody;
    }

    public static Rest<?> failure(int code,String msg) {
        Rest<?> restBody = new RestBody<>();
        restBody.setCode(code);
        restBody.setMsg(msg);
        return restBody;
    }

    public static Rest<?> failure(String msg) {
        Rest<?> restBody = new RestBody<>();
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
