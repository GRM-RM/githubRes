package com.news.grm.controller;

import com.news.grm.pojo.GrmCategory;
import com.news.grm.pojo.GrmNews;
import com.news.grm.service.GrmCategoryService;
import com.news.grm.service.GrmNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/grmCategory")
public class GrmCategoryController {

    @Autowired
    private GrmCategoryService grmCategoryService;

    @Autowired
    private GrmNewsService grmNewsService;

    @RequestMapping("/del.html")
    public String del(String name){
        grmCategoryService.updateByName(name);
        grmNewsService.updateByName(name);
        return "redirect:/index.jsp";
    }

    @RequestMapping("/addGrmCategory.html")
    public String addGrmCategory(GrmCategory grmCategory){
        grmCategoryService.addGrmCategory(grmCategory);
        return "forward:findAll.html";
    }

    @RequestMapping("/findAll.html")
    public ModelAndView findAll(){
        List<GrmCategory> list=grmCategoryService.findAll();
        return new ModelAndView("grmcategory/list","list",list);
    }
}
