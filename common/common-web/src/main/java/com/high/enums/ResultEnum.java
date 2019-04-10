package com.high.enums;

/**
 * @Author: HarlanW
 * @Date: 2019/4/2 0002
 * @Version: 1.0
 */
public enum ResultEnum {
    /**
     *
     */
    SUCCESS("0","成功"),
    ERROR("1","失败"),
    FAIL("-1","未知错误");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
