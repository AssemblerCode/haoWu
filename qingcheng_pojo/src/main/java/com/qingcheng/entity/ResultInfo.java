package com.qingcheng.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultInfo implements Serializable {
    private String errorCode;//状态码
    private String errorMsg;//消息
    private boolean success;//是否成功


    public ResultInfo(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ResultInfo() {
        success=true;
    }
}
