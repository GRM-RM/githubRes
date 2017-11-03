package com.news.grm.controller;

import com.github.pagehelper.PageInfo;
import com.news.grm.pojo.GrmCategory;
import com.news.grm.pojo.GrmNews;
import com.news.grm.pojo.GrmNewsUtil;
import com.news.grm.service.GrmCategoryService;
import com.news.grm.service.GrmNewsService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/grmNews")
public class GrmNewsController {

    @Autowired
    private GrmNewsService grmNewsService;
    @Autowired
    private GrmCategoryService grmCategoryService;

    @RequestMapping("findById")
    public ModelAndView findById(Integer id) {
        GrmNews grmNews = grmNewsService.findById(id);
        return new ModelAndView("grmnews/info","grmNews",grmNews);
    }

    @RequestMapping("/findGrmNews.html")
    public ModelAndView findNews(GrmNewsUtil grmNewsUtil, @RequestParam(required = false, defaultValue = "1") Integer pageIndex) {

        List<GrmCategory> categoryList = grmCategoryService.findAll();
        PageInfo<GrmNews> page = grmNewsService.findGrmNews(grmNewsUtil, pageIndex);

        ModelAndView view = new ModelAndView();
        view.addObject("categoryList", categoryList);
        view.addObject("page", page);
        view.setViewName("grmnews/list");
        return view;
    }


    @RequestMapping("/addGrmNews.html")
    public ModelAndView add() {
        List<GrmCategory> list = grmCategoryService.findAll();
        return new ModelAndView("grmnews/add", "list", list);
    }

    @RequestMapping("/do_addNews.html")
    public String addNews(GrmNews grmNews) {
        grmNewsService.addGrmNews(grmNews);
        return "redirect:/grmNews/findGrmNews.html";
    }

    @RequestMapping("/upload.html")
    @ResponseBody
    public String fileUpload2(@RequestParam("file") MultipartFile file) {
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = System.currentTimeMillis() + extName;
        try {
            //将上传的文件存在E:/upload/下
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("d:/temp/",
                    fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //上传成功返回原来页面
        return "{\"error\":0,\"url\":\"" + "http://localhost:8080/upload/" + fileName + "\"}";
    }
}
