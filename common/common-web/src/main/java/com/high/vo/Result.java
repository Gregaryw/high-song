package com.high.vo;

import com.high.abs.AbstractResponse;
import com.high.enums.ResultEnum;

import java.io.Serializable;

/**
 * 控制层返回结果实体
 * @Author: HarlanW
 * @Date: 2019/4/2
 * @Version: 1.0
 */
public class Result<T> extends AbstractResponse<T> implements Serializable {

    /**
     * 参构造方法
     */
    private Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
    }

    /**
     * 一个参数构造方法
     * @param code
     */
    private Result(String code) {
        this.code = code;
    }

    /**
     * 两个参数构造方法
     * @param code
     * @param message
     */
    private Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 三个参数构造方法
     * @param code
     * @param message
     * @param data
     */
    private Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 获取成功结果
     */
    public static <T> Result<T> success() {
       return BodyBuilder.getInstance(ResultEnum.SUCCESS,null);
    }
    /**
     * 获取成功结果
     */
    public static <T> Result<T> success(T data) {
        return BodyBuilder.getInstance(ResultEnum.SUCCESS,data);
    }

    /**
     * 获取失败结果
     */
    public static <T> Result<T> fail() {
       return BodyBuilder.getInstance(ResultEnum.FAIL,null);
    }

    /**
     * 获取自定义失败结果
     */
    public static <T> Result<T> fail(T data) {
        return BodyBuilder.getInstance(ResultEnum.FAIL,data);
    }

    /**
     *  获取错误结果
     */
    public static <T> Result<T> error() {
        Result result = new Result<>(ResultEnum.ERROR);
        return result;
    }

    /**
     * 返回自定义错误结果数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(T data){
        return BodyBuilder.getInstance(ResultEnum.ERROR,data);
    }

    /**
     * 对外提供构建Result对象
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static <T> Result<T> build(String code,String message,T data){
        return BodyBuilder.getInstance(code,message,data);
    }

    private static class BodyBuilder<T>{
        public static <T> Result<T> getInstance(String code,String message,T data){
           return new Result(code,message,data);
        }

        public static <T> Result<T> getInstance(ResultEnum resultEnum,T data){
            return getInstance(resultEnum.getCode(),resultEnum.getMsg(),data);
        }
    }

}
