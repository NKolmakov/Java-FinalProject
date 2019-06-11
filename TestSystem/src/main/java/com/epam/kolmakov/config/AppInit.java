package com.epam.kolmakov.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                WebConfig.class,
               // SecurityConfig.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    protected Filter[] getServletFilters() {
        return new Filter[]{
                new CharacterEncodingFilter("UTF-8")
        };
    }

    //TODO: локализация ошибки
    //TODO: сделать хэширование паролей на входе
    //TODO: сообщение о неправильной регистрации выводить как импорт страницы регистрации плюс сверху локализированная надпись об ошибке
    //TODO: пример
    // <jsp:include page="_menu.jsp" />
    //    <h1>Message : ${message}</h1>
    //todo: сделать страницы сообщений об ошибке
}
