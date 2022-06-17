package com.spring.jsr.domain;

/**
 * @desc:
 * @author: xingle
 * @date: 2022/6/16
 */
public enum OrderStatus {
    CREATE(1), ELECTRCING(2), END(3);

    private final int value;

    private OrderStatus(int value) {
        this.value = value;
    }
}
