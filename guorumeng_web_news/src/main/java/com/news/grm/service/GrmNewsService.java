package com.news.grm.service;

import com.github.pagehelper.PageInfo;
import com.news.grm.pojo.GrmNews;
import com.news.grm.pojo.GrmNewsUtil;

public interface GrmNewsService {
    void addGrmNews(GrmNews grmNews);

    PageInfo<GrmNews> findGrmNews(GrmNewsUtil grmNewsUtil, Integer pageIndex);

    GrmNews findById(Integer id);

    void updateByName(String name);
}
