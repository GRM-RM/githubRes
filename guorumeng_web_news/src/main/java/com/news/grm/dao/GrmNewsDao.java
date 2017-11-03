package com.news.grm.dao;

import com.news.grm.pojo.GrmNews;
import com.news.grm.pojo.GrmNewsUtil;

import java.util.List;

public interface GrmNewsDao {
    List<GrmNews> findGrmNews(GrmNewsUtil grmNewsUtil);

    void addGrmNews(GrmNews grmNews);

    GrmNews findById(Integer id);

    void updateByName(String name);
}
