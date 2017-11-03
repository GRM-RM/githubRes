package com.news.grm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyException implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String msg = e.getMessage();
        if (httpServletResponse.isCommitted()) {
            return null;
        }
        //如果是ajax请求就返回json数据
        if (isAjax(httpServletRequest)) {
            Map<String, String> result = new HashMap<String, String>();
            result.put("ex", msg);
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            return new ModelAndView(view, "result", result);
        } else {//不是ajax就返回错误页面
            httpServletRequest.setAttribute("ex", msg);
            return new ModelAndView("error");
        }
    }


    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || request.getParameter("ajax") != null;
    }

}
