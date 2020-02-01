package com.exam.common.advice;

import com.exam.common.exception.ExamException;
import com.exam.common.exception.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BasicExceptionAdvice {

    //捕获security异常
    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e){
        if (e instanceof AccessDeniedException){
            return "redirect:/403";
        }
        return "redirect:/500";
    }

    //统一异常处理
    @ExceptionHandler(ExamException.class)
    public ResponseEntity<ExceptionResult> handleLyException(ExamException e) {
        return ResponseEntity.status(e.getStatus()).body(new ExceptionResult(e));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
