package com.news.grm.interceptor;

import com.news.grm.utils.Constants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("开始拦截");
        // 其他情况判断session中是否有key，有的话继续用户的操作
        if (request.getSession().getAttribute(Constants.SESSION_USER) != null) {
            return true;
        }
        // 最后的情况就是进入登录页面
        response.sendRedirect(request.getContextPath() + "/grmuser/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("视图解析前postHandle");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("处理异步请求");
    }

}
