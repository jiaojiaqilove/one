package com.example.three.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
public class LoginHandlerinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功后，应该有用户的Session，同时外迁到下一页
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            request.setAttribute("msg","没有进入权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return  false;
        }else {
            return true;
        }
    }

}
