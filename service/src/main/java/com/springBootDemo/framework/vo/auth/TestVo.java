package com.springBootDemo.framework.vo.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author symoon
 * @version 1.0
 * @date 2023/1/9 下午3:49
 */

@ApiModel(value = "TestVo", description = "测试")
@Data
public class TestVo implements Serializable {

    @JsonProperty("data")
    @NotNull(message = "不能为空")
    @ApiModelProperty(value = "来源类型", name = "data")
    private String data;
}
