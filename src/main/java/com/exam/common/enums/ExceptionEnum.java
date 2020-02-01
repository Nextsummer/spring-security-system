package com.exam.common.enums;

import lombok.Getter;

@Getter
public enum  ExceptionEnum {
    SERVER_ERROR(500,"服务器错误"),
    ;

    private int status;
    private String message;

    ExceptionEnum(int status,String message){
        this.status = status;
        this.message = message;
    }
}
