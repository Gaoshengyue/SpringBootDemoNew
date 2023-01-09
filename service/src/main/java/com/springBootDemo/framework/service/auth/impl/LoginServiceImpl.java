package com.springBootDemo.framework.service.auth.impl;

import com.springBootDemo.framework.service.auth.AuthService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/8 上午10:34
 */
public class LoginServiceImpl implements AuthService {

    @Override
    public List<String> TestFunction(String testString) {

//        Map<String, Object> insuranceSumMap = MapUtil.newHashMap();
//        insuranceSumMap.put("name", "保险");
//        insuranceSumMap.put("value", franchiseeDistributionPieSqlDto.getInsuranceSum());

        List<String> testStringList = new ArrayList<String>();

        testStringList.add("fsfs");
        testStringList.add("312312");
        return testStringList;
    }
}
