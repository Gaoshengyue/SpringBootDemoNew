package com.springBootDemo.common.exception;

public class PublicException extends RuntimeException {
    private String status;
    private String code;
    private Object[] args;
    private Object data;

    public String getCode() {
        return this.code;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public String getStatus() {
        return this.status;
    }

    public Object getData() {
        return this.data;
    }

    public PublicException() {
    }

    public PublicException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public PublicException(String code, Object data, Throwable cause) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public PublicException(String code, Object[] args, Object data, Throwable cause) {
        super(cause);
        this.code = code;
        this.args = args;
        this.data = data;
    }

    public PublicException(String code) {
        this.code = code;
    }

    public PublicException(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public PublicException(String code, Object data, String status) {
        this.code = code;
        this.data = data;
        this.status = status;
    }

    public PublicException(String code, Object[] args) {
        this.code = code;
        this.args = args;
    }

    public PublicException(String code, Object[] args, Object data) {
        this.code = code;
        this.args = args;
        this.data = data;
    }

    public PublicException(String code, Object[] args, Object data, String status) {
        this.code = code;
        this.args = args;
        this.data = data;
        this.status = status;
    }
}
