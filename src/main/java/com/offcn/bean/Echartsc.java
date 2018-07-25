package com.offcn.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Echartsc implements Serializable {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
