package com.exam.common.exception;

import lombok.Getter;
import org.joda.time.DateTime;

@Getter
public class ExceptionResult {
    private int status;
    private String message;
    private String timestamp;

    public ExceptionResult(ExamException e) {
        this.status = e.getStatus();
        this.message = e.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }
}
