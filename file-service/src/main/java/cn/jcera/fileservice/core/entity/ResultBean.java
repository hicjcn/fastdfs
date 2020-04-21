package cn.jcera.fileservice.core.entity;

import cn.jcera.fileservice.core.exception.ExceptionEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {
    /**
     * Code
     */
    private int code = ExceptionEnum.SUCCESS.getCode();
    /**
     * 编号
     */
    private String errStr = ExceptionEnum.SUCCESS.toString();

    /**
     * 消息内容

     */
    private String message = "success";

    /**
     数据内容
     */
    private  T data;

    public ResultBean(ExceptionEnum exceptionEnum, String message, T data) {
        this.code = exceptionEnum.getCode();
        this.errStr = exceptionEnum.toString();
        this.message = message;
        this.data = data;
    }

    public ResultBean(ExceptionEnum exceptionEnum, String message) {
        this.code = exceptionEnum.getCode();
        this.errStr = exceptionEnum.toString();
        this.message = message;
    }

    public  ResultBean(){}

    public  ResultBean(T data){
        this.data = data;
    }

    public ResultBean(Throwable e){
        this.code = ExceptionEnum.SERVER_ERROR.getCode();
        this.errStr = ExceptionEnum.SERVER_ERROR.toString();
        this.message = e.getMessage();
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(data);
    }
}
