package com.demo.controller;

import com.demo.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

@Controller
public class MyExceptionHandler implements HandlerExceptionResolver {
    /*
    * @Param request 当前的 HTTP request
    * @Param respond 当前的 HTTP respond
    * @Param handler 正在执行的 Handler
    * @Param ex handler 执行时抛出的 exception
    * @return 返回一个ModelAndView
    * */

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //定义异常信息
        String msg;
        //如果是定义异常，将异常信息直接返回
        if (ex instanceof MyException){
            msg = ex.getMessage();
        } else {
            //如果是系统的异常，从堆栈中获取异常信息
            Writer out = new StringWriter();
            PrintWriter printWriter = new PrintWriter(out);
            ex.printStackTrace(printWriter);
            //系统真实异常信息，可以以邮件和短信等方式发给相关开发人员
            String systemMessage = out.toString();
            //向客户隐藏真实的异常信息，仅发生友好的提示信息
            msg = "网络异常！";
        }
        //返回错误页面，给用户好友页面显示错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("error.jsp");
        return modelAndView;
    }
}
