package com.xh.demo.common;

/**
 * @author Xiong Hao
 */
public class CommonMessage<T> {

    private String regmsg;

    private String regcode;

    private T data;

    public CommonMessage() {
        this.regcode = CommonConstant.RETCODE_OK;
        this.regmsg = CommonConstant.RETCODE_OK_MSG;
    }

    public CommonMessage(String retcode, String retmsg) {
        this.regcode = retcode;
        this.regmsg = retmsg;
    }

    public CommonMessage(String retcode, String retmsg, T data) {
        this.regcode = retcode;
        this.regmsg = retmsg;
        this.data = data;
    }

    public String getRegmsg() {
        return regmsg;
    }

    public void setRegmsg(String regmsg) {
        this.regmsg = regmsg;
    }

    public String getRegcode() {
        return regcode;
    }

    public void setRegcode(String regcode) {
        this.regcode = regcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
