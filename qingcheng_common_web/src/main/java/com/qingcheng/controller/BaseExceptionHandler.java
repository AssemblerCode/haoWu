package com.qingcheng.controller;

import com.qingcheng.entity.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultInfo error(Exception e){
        e.printStackTrace();
        System.out.println("发生异常!!!");
        return new ResultInfo("404",e.getMessage());
    }
}
