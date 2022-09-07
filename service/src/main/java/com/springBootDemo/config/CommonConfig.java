package com.springBootDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/7 下午3:34
 */
@Configuration
public class CommonConfig {
    /**
     * @return
     * @Description 加载异常资源文件，名称定义为errMsg_zh.properties
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        Locale.setDefault(Locale.CHINESE);
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("ufinErrMsg", "errMsg", "ufinLogMsg");
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }
}