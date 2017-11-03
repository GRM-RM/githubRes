package com.news.grm.service;

import com.news.grm.pojo.GrmCategory;

import java.util.List;

public interface GrmCategoryService {

    List<GrmCategory> findAll();

    void addGrmCategory(GrmCategory grmCategory);

    void updateByName(String name);
}
