package com.springBootDemo.framework.vo.auth;

/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/8 上午10:28
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springBootDemo.framework.vo.auth.AntLoginRequestVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "LoginVo", description = "登录")
@Data
public class LoginVo implements Serializable {

    @JsonProperty("sourceType")
    @NotNull(message = "不能为空")
    @ApiModelProperty(value = "来源类型", name = "sourceType")
    private String sourceType = "weixin";


//    @JsonProperty("wx_data")
//    @ApiModelProperty(value = "微信数据", name = "wx_data")
//    private String wxData = null;


    @JsonProperty("ant_data")
    @Valid
    @ApiModelProperty(value = "前端数据", name = "ant_data")
    private AntLoginRequestVo antData;


    @JsonProperty("scopes")
    @ApiModelProperty(value = "授权类型默认为auth_base", name = "scopes")
    private String scopes = "auth_base";


    @JsonProperty("timeout")
    @ApiModelProperty(value = "超时时间", name = "timeout")
    private int timeout = 300;



}
