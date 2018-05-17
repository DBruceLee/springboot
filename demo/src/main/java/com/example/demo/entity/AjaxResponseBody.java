package com.example.demo.entity;

import java.util.List;

public class AjaxResponseBody {
    String msg;
//    String mothod;
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

//    public String getMothod() {
//        return mothod;
//    }
//
//    public void setMothod(String mothod) {
//        this.mothod = mothod;
//    }
}
