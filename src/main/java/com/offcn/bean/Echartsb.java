package com.offcn.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Echartsb implements Serializable {

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
