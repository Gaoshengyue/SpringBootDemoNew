package com.springBootDemo.dto;
import lombok.Data;

import java.io.Serializable;

/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/7 下午2:57
 */

@Data
public class CommonRespDto<T> implements Serializable {
    private Integer code = 200;
    private String status = "0";
    private String errorCode;
    private String msg;
    private String errorMsg;
    private T data;

}
