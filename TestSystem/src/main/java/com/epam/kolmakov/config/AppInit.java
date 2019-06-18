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
    //todo: сделать сообщение о сохранении теста у тьютора
    //todo: сделать статистику
    //todo: сделать отдельный модуль генерации пароля тьютора


    //todo: ВАЖНАЯ ЧАСТЬ
    //todo: сделать обзор тестов у тьютора
}
