package com.demo.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求路径
        String url = request.getRequestURI();
        if (url.indexOf("/login")>=0){
            return true;
        }
        HttpSession session = request.getSession();
        //如果用户是已登录状态，放行
        if (session.getAttribute("USER_SESSION")!=null){
            return true;
        }
        //其他情况都直接跳转到登录页面
        request.setAttribute("msg","您还没有登录，请先登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
