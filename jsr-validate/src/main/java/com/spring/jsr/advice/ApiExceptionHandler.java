package com.spring.jsr.advice;

import com.spring.jsr.record.Rest;
import com.spring.jsr.record.RestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @desc: 统一异常处理
 * @author: xingle
 * @date: 2022/6/15
 */
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BindException.class)
    public Rest<?> handle(HttpServletRequest request, BindException e) {
        logger(request, e);
        List<ObjectError> allErrors = e.getAllErrors();
        ObjectError objectError = allErrors.get(0);
        return RestBody.failure(700, objectError.getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Rest<?> handle(HttpServletRequest request, MethodArgumentNotValidException e) {
        logger(request, e);
        List<ObjectError> allErrors = e.getAllErrors();
        ObjectError objectError = allErrors.get(0);
        return RestBody.failure(700, objectError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public Rest<?> handle(HttpServletRequest request, Exception e) {
        logger(request, e);
        return RestBody.failure(700, e.getMessage());
    }


    private void logger(HttpServletRequest request, Exception e) {
        String contentType = request.getHeader("Content-Type");
        log.error("统一异常处理 uri: {} content-type: {} exception: {}", request.getRequestURI(), contentType, e.toString());
    }
}
