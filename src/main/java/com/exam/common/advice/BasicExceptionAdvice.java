package com.exam.common.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BasicExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e){
        if (e instanceof AccessDeniedException){
            return "redirect:/403";
        }
        return "redirect:/500";
    }
}
