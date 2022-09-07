package com.springBootDemo.common;
/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/7 下午2:59
 */

import com.springBootDemo.common.Constants;

public class ExceptionDto {
    private Integer code = -1;
    private String status = Constants.FAILURE;
    private String errorCode;

    private String errorMsg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        if (data == null) {
            return new Object();
        }
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String msg;
    private Object data;
}