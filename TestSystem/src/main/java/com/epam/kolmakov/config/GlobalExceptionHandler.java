package com.epam.kolmakov.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView returnErrorPage(HttpStatus httpStatus){
        WebConfig.LOGGER.error(httpStatus.getReasonPhrase());
        return new ModelAndView("error");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView returnNotFoundPage(HttpStatus status){
        WebConfig.LOGGER.error("Error: "+status.toString());
        return new ModelAndView("error");
    }


}
