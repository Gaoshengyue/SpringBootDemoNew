package com.springBootDemo.framework.dto.auth;

/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/8 上午10:24
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class LoginDto {

    @ApiModelProperty(value = "token")
    @JsonProperty("access_token")
    private String accessToken;


    @ApiModelProperty(value = "token_type")
    @JsonProperty("token_type")
    private String tokenType="bearer";


    @ApiModelProperty(value = "username")
    @JsonProperty("username")
    private String userName;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setUsername(String username) {
        this.userName = username;
    }
}
