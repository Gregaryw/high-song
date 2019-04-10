package com.high.exception;

import com.high.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * @Author: HarlanW
 * @Date: 2019/4/2
 * @Version: 1.0
 */
@RestControllerAdvice
public class GlobalException {
    private static Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result defaultExceptionHandler(HttpServletRequest req, Exception e){
        logger.error("全局参数出现异常{}",e);
        return Result.error();
    }
}
