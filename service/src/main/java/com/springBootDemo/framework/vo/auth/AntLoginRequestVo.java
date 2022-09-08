package com.springBootDemo.framework.vo.auth;

/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/8 上午10:29
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.annotation.RegEx;
import javax.validation.constraints.*;
import java.io.Serializable;

@ApiModel(value = "AntLoginRequestVo", description = "前端登录结构体")
@Data
public class AntLoginRequestVo implements Serializable {

    @JsonProperty("username")

    @ApiModelProperty(value = "用户名", name = "username")
    private String username;


    @JsonProperty("password")
//    @NotNull(message = "密码8-16位，由数字，大写字母，小写字母，特殊字符如`~!@#$%^&*()-_=+|[{}];:'\",<.>/?空格，至少3种组成")
    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    @JsonProperty("mobile")
//    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$")
    @NotNull(message = "请正确输入用户名")
    @ApiModelProperty(value = "联系人手机号", name = "mobile")
    private String mobile;

    @JsonProperty("captcha")
    @Size(max = 6)
    @ApiModelProperty(value = "验证码", name = "captcha")
    private String captcha;

    @JsonProperty("identity")
    @NotNull(message = "登录用户类型")
    @ApiModelProperty(value = "登录用户类型", name = "identity")
    private String identity;

}
