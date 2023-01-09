package com.springBootDemo.framework.controller.auth;

import com.springBootDemo.dto.test.TestDto;
import com.springBootDemo.framework.service.auth.AuthService;
import com.springBootDemo.framework.vo.auth.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/7 下午2:54
 */

@RestController
@AllArgsConstructor
@RequestMapping("/v1")
@Api(tags = "测试管理")
public class AuthController {

    private final static String test = "测试接口";
    @Resource
    private AuthService authService;


    @ApiOperation(value = test)
    @PostMapping("/test")
    public TestDto test(@Valid @RequestBody TestVo testVo) throws Exception {
        try {

            TestDto testDto = new TestDto();
            testDto.setResult(authService.TestFunction(testVo.getData()));
            return testDto;
        } catch (Exception e) {
            if (e instanceof Exception) {
                throw (Exception) e;
            } else{
                throw new Exception();
            }
        }
    }


}


