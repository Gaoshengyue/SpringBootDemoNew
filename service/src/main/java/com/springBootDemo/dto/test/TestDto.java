package com.springBootDemo.dto.test;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

/**
 * @author symoon
 * @version 1.0
 * @date 2023/1/9 下午3:44
 */

@Data
public class TestDto implements Serializable {

    private List<String> result;

}
