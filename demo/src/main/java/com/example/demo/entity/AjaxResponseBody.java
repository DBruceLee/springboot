package com.example.demo.entity;

import java.util.List;

public class AjaxResponseBody {
    String msg;
    String encoder;
    List<User> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

    public String getEncoder() {
        return encoder;
    }

    public void setEncoder(String encoder) {
        this.encoder = encoder;
    }
}
