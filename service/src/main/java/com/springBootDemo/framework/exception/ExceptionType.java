package com.springBootDemo.framework.exception;


public enum ExceptionType {
    OK("200", "成功"),
    S3_OK("0", "成功"),
    FAILED("-1", "失败"),
    PARAM_IS_NULL("000002", "请求参数为空"),
    PARAM_ILLEGAL("000003", "请求参数非法"),
    JSON_PARSE_FAIL("000004", "JSON转换失败"),
    REPEATED_COMMIT("000005", "重复提交"),
    SQL_ERROR("000006", "数据库异常"),
    NOT_FOUND("000007", "无记录"),
    NETWORK_ERROR("000008", "网络异常"),
    ILLEGAL_REQUEST("000009", "非法请求"),
    LOGIN_TYPE_NOT_SUPPORTED("000010", "未支持登录类型"),
    OPENID_IS_NONE("000011", "openid为空"),
    WX_REQUEST_ERROR("000012", "第三方微信请求异常"),
    WX_DECODE_PHONENUMBER_ERROR("000013", "第三方微信手机号解码错误"),
    VF_FAIL("000014", "鉴权失败"),
    VF_SUCCESS("000015", "鉴权成功"),
    ERROR_TOKEN("000016", "token处理失败"),
    ERROR_TOKEN_EMPTY("000017", "token不能为空"),
    ANT_LOGIN_AUTHENTICATE_FAIL("000401", "鉴权失败"),
    UNKNOWN_ERROR("111111", "未知异常"),
    CAPTCHA_ERROR("000016", "验证码发送失败，验证码仍在有效期内"),
    CAPTCHA_FAILED("000017", "验证码错误，请重新输入"),
    GRADE_FAILED("000018", "未计算出查询结果");
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    private String code;


    ExceptionType(String status, String code) {
        this.code = code;
        this.status = status;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}