package cn.jcera.fileservice.core.exception;

public enum ExceptionEnum {
    SUCCESS(200),
    ARGUMENTS_INVALID(412),
    RESOURCE_NOT_FOUND(404),
    UNAUTHORIZED(401),
    BUSINESS_ERROR(400),
    SERVER_ERROR(500);

    private ExceptionEnum(int code){
        this.code=code;
    }

    // 成员变量
    private int code;

    public   int getCode(){
        return  this.code;
    }

}
