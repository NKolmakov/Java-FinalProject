package com.epam.kolmakov.interceptiors;

import com.epam.kolmakov.db.models.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        if(user != null && user.isAuthorized()){
            return true;
        }
        response.sendRedirect("/authorization");
        return false;
    }
}
