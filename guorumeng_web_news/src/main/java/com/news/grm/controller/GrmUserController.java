package com.news.grm.controller;

import com.news.grm.pojo.GrmUser;
import com.news.grm.service.GrmUserService;
import com.news.grm.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/grmUser")
public class GrmUserController {

    @Autowired
    private GrmUserService grmUserService;

    @RequestMapping("/logout.html")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.jsp";
    }

    @RequestMapping("/do_login.html")
    public ModelAndView login(String username, String password, HttpSession session) {
        GrmUser grmUser = grmUserService.findByUsername(username);

        if (grmUser != null && grmUser.getPassword().equals(password)) {
            session.setAttribute(Constants.SESSION_USER, grmUser);
            return new ModelAndView("index");
        } else {
            return new ModelAndView("grmuser/login", "msg", "用户名或密码错误");
        }
    }

    @RequestMapping("/do_register.html")
    public ModelAndView register(String username, String password, String repassword, HttpSession session) {
        if (username == null || "".equals(username.trim())) {
            throw new RuntimeException("用户名不能为空");
        }
        if (password != null && repassword != null && repassword.equals(password)) {
            GrmUser grmUser = new GrmUser();
            grmUser.setUsername(username);
            grmUser.setPassword(password);
            grmUserService.addGrmUser(grmUser);
            return new ModelAndView("grmuser/login");
        } else {
            throw new RuntimeException("两次输入的密码不同");
        }
    }

    @RequestMapping("findByUsername.html")
    @ResponseBody
    public Map<String, Object> findByUsername(String username) {
        if (username == null || "".equals(username.trim())) {
            throw new RuntimeException("用户名不能为空");
        }
        Map<String, Object> map = new HashMap<String, Object>();

        GrmUser grmUser = grmUserService.findByUsername(username);
        if (grmUser != null) {
            map.put("status", true);
            map.put("result", "用户名已经被占用");
        } else {
            map.put("status", false);
            map.put("result", "用户名可以使用");
        }
        return map;
    }
}
