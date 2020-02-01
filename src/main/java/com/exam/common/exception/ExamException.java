package com.exam.common.exception;

import com.exam.common.enums.ExceptionEnum;
import lombok.Getter;

@Getter
public class ExamException extends RuntimeException {
    private int status;

    public ExamException(ExceptionEnum em){
        super(em.getMessage());
        this.status = em.getStatus();
    }

    public ExamException(ExceptionEnum em,Throwable cause){
        super(em.getMessage(),cause);
        this.status = em.getStatus();
    }

    public ExamException(int status,String messgae){
        super(messgae);
        this.status = status;
    }
}
