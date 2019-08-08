package com.epam.kolmakov.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Throwable.class)
    public ModelAndView returnErrorPage(Throwable throwable){
        throwable.printStackTrace();
        WebConfig.LOGGER.error(throwable);
        return new ModelAndView("error");
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView returnError(Exception ex){
        ex.printStackTrace();
        WebConfig.LOGGER.error(ex);
        return new ModelAndView("error");
    }
}
