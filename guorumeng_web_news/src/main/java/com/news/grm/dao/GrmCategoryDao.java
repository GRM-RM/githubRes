package com.news.grm.dao;

import com.news.grm.pojo.GrmCategory;

import java.util.List;

public interface GrmCategoryDao {

    void updateByName(String name);

    List<GrmCategory> findAll();

    void addGrmCategory(GrmCategory grmCategory);
}
