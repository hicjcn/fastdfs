package cn.jcera.fileservice.controller;

import cn.jcera.fileservice.core.entity.ResultBean;
import cn.jcera.fileservice.util.FileDfsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class AppExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(FileDfsUtil.class);

    @ExceptionHandler(value = Exception.class)
    public ResultBean<Exception> exceptionHandler(Exception e){
        logger.error("未知异常", e);
        return new ResultBean<>(e);
    }
}
