package com.news.grm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.news.grm.dao.GrmNewsDao;
import com.news.grm.pojo.GrmNews;
import com.news.grm.pojo.GrmNewsUtil;
import com.news.grm.service.GrmNewsService;
import com.news.grm.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrmNewsServiceImpl implements GrmNewsService {

    @Autowired
    private GrmNewsDao grmNewsDao;

    public void addGrmNews(GrmNews grmNews) {
        grmNewsDao.addGrmNews(grmNews);
    }

    public PageInfo<GrmNews> findGrmNews(GrmNewsUtil grmNewsUtil, Integer pageIndex) {
        PageHelper.startPage(pageIndex, Constants.PAGESIZE,"created_date desc");
        List<GrmNews> list=grmNewsDao.findGrmNews(grmNewsUtil);
        PageInfo<GrmNews> page=new PageInfo<GrmNews>(list,Constants.NAVIGATEPAGES);
        return page;
    }

    public GrmNews findById(Integer id) {
        return grmNewsDao.findById(id);
    }

    public void updateByName(String name) {
        grmNewsDao.updateByName(name);
    }
}
