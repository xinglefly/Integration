package com.spring.jsr.record;

/**
 * @desc: The interface Rest
 * @author: xingle
 * @date: 2022/6/15
 */
public interface Rest<T> {

    /**
     * 状态码
     * @param httpStatus the http status
     */
    void setHttpStatus(int httpStatus);

    /**
     * 数据载体
     * @param data
     */
    void setData(T data);

    /**
     * 体系信息
     * @param msg
     */
    void setMsg(String msg);

    /**
     * 标识
     * @param identifier
     */
    void setIdentifier(String identifier);
}
