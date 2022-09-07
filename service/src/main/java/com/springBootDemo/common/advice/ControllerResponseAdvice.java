package com.springBootDemo.common.advice;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.springBootDemo.common.ExceptionDto;
import com.springBootDemo.common.annotation.IgnoreResponseAdvice;
import com.springBootDemo.common.exception.PublicException;
import com.springBootDemo.dto.CommonRespDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Locale;
import java.util.Set;


/**
 * @author symoon
 * @version 1.0
 * @date 2022/9/7 下午2:59
 */
@ControllerAdvice(basePackages = "com.springBootDemo.framework.controller")
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {
    Logger logger = LoggerFactory.getLogger(ControllerResponseAdvice.class);
    @Resource
    private ResourceBundleMessageSource messageSource;

    public ControllerResponseAdvice() {
    }

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class) && !methodParameter.getMethod().getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class) && !methodParameter.getMethod().getDeclaringClass().getName().equals("org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping$OperationHandler");
    }

    public CommonRespDto beforeBodyWrite(Object origin, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        CommonRespDto commonRespDto = new CommonRespDto();
        if (origin instanceof ExceptionDto) {
            ExceptionDto exceptionDto = (ExceptionDto) origin;
            commonRespDto.setStatus(exceptionDto.getStatus());
            commonRespDto.setCode(Integer.parseInt(exceptionDto.getStatus()));
            commonRespDto.setErrorCode(exceptionDto.getErrorCode());
            commonRespDto.setMsg(exceptionDto.getErrorMsg());
            commonRespDto.setErrorMsg(exceptionDto.getErrorMsg());
            commonRespDto.setData(exceptionDto.getData());

        } else if (origin instanceof IllegalArgumentException) {
            IllegalArgumentException argumentException = (IllegalArgumentException) origin;
            commonRespDto.setErrorCode("ARGUMENT_NOT_VALID");
            commonRespDto.setMsg(argumentException.getMessage());
            commonRespDto.setErrorMsg(argumentException.getMessage());
        } else {
            if (origin instanceof CommonRespDto) {
                return (CommonRespDto) origin;
            }
            commonRespDto.setCode(200);
            commonRespDto.setStatus("0");
            commonRespDto.setData(origin);
        }

        return commonRespDto;
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public ExceptionDto fixResponseDto(Exception e) {
        String exceptionMsg = ExceptionUtil.stacktraceToString(e);
        if (e instanceof PublicException) {
            PublicException ue = (PublicException) e;
            if ("TOKEN_INVALID".equals(ue.getCode())) {
                exceptionMsg = this.messageSource.getMessage(ue.getCode(), ue.getArgs(), Locale.getDefault());
            }
        }

        this.logger.error("fixResponseDto,message:{}", exceptionMsg);
        ExceptionDto exceptionDto = new ExceptionDto();
        if (e instanceof PublicException) {
            PublicException ue = (PublicException) e;
            if (StrUtil.isNotBlank(ue.getStatus())) {
                exceptionDto.setCode(Integer.parseInt(ue.getStatus()));
                exceptionDto.setStatus(ue.getStatus());
            }

            exceptionDto.setErrorCode(ue.getCode());
            exceptionDto.setMsg(this.messageSource.getMessage(ue.getCode(), ue.getArgs(), Locale.getDefault()));
            exceptionDto.setErrorMsg(this.messageSource.getMessage(ue.getCode(), ue.getArgs(), Locale.getDefault()));
            exceptionDto.setData(ue.getData());
        } else if (e instanceof IllegalArgumentException) {
            exceptionDto.setErrorCode("ARGUMENT_NOT_VALID");
            exceptionDto.setMsg(e.getMessage());
            exceptionDto.setErrorMsg(e.getMessage());
        } else if (e instanceof HttpMessageNotReadableException) {
            exceptionDto.setErrorCode("params.format.err");
            exceptionDto.setMsg(this.messageSource.getMessage(exceptionDto.getErrorCode(), (Object[]) null, Locale.getDefault()));
            exceptionDto.setErrorMsg(this.messageSource.getMessage(exceptionDto.getErrorCode(), (Object[]) null, Locale.getDefault()));
        } else if (!(e instanceof MissingServletRequestParameterException) && !(e instanceof MissingRequestHeaderException)) {
            exceptionDto.setErrorCode("UFIN_DEFAULT_EXCEPTION");
            exceptionDto.setMsg(this.messageSource.getMessage(exceptionDto.getErrorCode(), (Object[]) null, Locale.getDefault()));
            exceptionDto.setErrorMsg(this.messageSource.getMessage(exceptionDto.getErrorCode(), (Object[]) null, Locale.getDefault()));
        } else {
            exceptionDto.setErrorCode("REQUEST_PARAMETER_ILLEGAL");
            exceptionDto.setMsg(this.messageSource.getMessage(exceptionDto.getErrorCode(), (Object[]) null, Locale.getDefault()));
            exceptionDto.setErrorMsg(this.messageSource.getMessage(exceptionDto.getErrorCode(), (Object[]) null, Locale.getDefault()));
        }

        return exceptionDto;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public ExceptionDto handleServiceException(ConstraintViolationException e) {
        this.logger.error("全局异常--> ConstraintViolationException", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = (ConstraintViolation) violations.iterator().next();
        String message = violation.getMessage();
        String propertyPath = violation.getPropertyPath().toString();
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorCode(message);
        exceptionDto.setMsg(this.getMessageSource(message, propertyPath.split("\\.")[1]));
        exceptionDto.setErrorMsg(this.getMessageSource(message, propertyPath.split("\\.")[1]));
        return exceptionDto;
    }

    @ResponseBody
    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleBodyValidException(BindException exception) {
        this.logger.warn("参数绑定失败", exception.getMessage());
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorCode("params.format.err");
        exceptionDto.setMsg(((FieldError) fieldErrors.get(0)).getDefaultMessage());
        exceptionDto.setErrorMsg(((FieldError) fieldErrors.get(0)).getDefaultMessage());
        return exceptionDto;
    }

    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    public ExceptionDto handleError(MethodArgumentNotValidException e) {
        this.logger.warn(":::Catch Exception Handler::: MethodArgumentNotValidException: {}", e.getMessage());
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorCode("ARGUMENT_NOT_VALID");
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        exceptionDto.setMsg(message);
        exceptionDto.setErrorMsg(message);
        return exceptionDto;
    }

    private String getMessageSource(String errorCode, String args) {
        return this.messageSource.getMessage(errorCode, new Object[]{args}, Locale.getDefault());
    }
}
