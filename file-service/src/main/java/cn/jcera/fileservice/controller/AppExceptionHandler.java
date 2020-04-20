package cn.jcera.fileservice.controller;

import cn.jcera.fileservice.util.FileDfsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(FileDfsUtil.class);

    @ExceptionHandler(value =Exception.class)
    public String exceptionHandler(Exception e){
        logger.error("未知异常", e);
        return e.getMessage();
    }
}
