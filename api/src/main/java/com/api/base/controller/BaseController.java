package com.api.base.controller;

import com.common.utils.exception.SelfDefinedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.charset.Charset;

/**
 * @ClassName:  BaseController
 * @Description: controller基类
 * @author: Jivoin
 * @date: 2015-11-18 18:50:15
 */
public class BaseController {

    /**
     *
     * @Title: exceptionHandler
     * @Description: 异常，及验证信息处理
     * @return
     * @return: ResponseEntity<String>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        BindingResult bindingResult;
        String errorMesssage = null;
        if(exception instanceof MethodArgumentNotValidException){
            bindingResult =((MethodArgumentNotValidException) exception).getBindingResult();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMesssage += fieldError.getDefaultMessage() + ", ";
            }
        }else if (exception instanceof SelfDefinedException){
            errorMesssage = exception.getMessage();
        }else{
            errorMesssage = "操作失败";
        }
        if(StringUtils.isBlank(errorMesssage)){
            errorMesssage = exception.getMessage();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        responseHeaders.setContentType(mediaType);
        //返回信息及http状态码
        return new ResponseEntity<>(errorMesssage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
