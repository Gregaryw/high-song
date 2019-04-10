package com.high.abs;

/**
 * @Author: HarlanW
 * @Date: 2019/4/3 0003
 * @Version: 1.0
 */
public abstract class AbstractResponse<T> {
    /**
     * 返回状态码
     */
    protected  String code;
    /**
     * 返回提示信息
     */
    protected  String message;
    /**
     * 返回数据
     */
    protected T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
