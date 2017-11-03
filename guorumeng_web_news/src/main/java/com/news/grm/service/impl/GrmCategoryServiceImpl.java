package com.news.grm.service.impl;

import com.news.grm.dao.GrmCategoryDao;
import com.news.grm.pojo.GrmCategory;
import com.news.grm.service.GrmCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrmCategoryServiceImpl implements GrmCategoryService {

    @Autowired
    private GrmCategoryDao grmCategoryDao;

    public List<GrmCategory> findAll() {
        return grmCategoryDao.findAll();
    }

    public void addGrmCategory(GrmCategory grmCategory) {
        grmCategoryDao.addGrmCategory(grmCategory);
    }

    public void updateByName(String name) {
        grmCategoryDao.updateByName(name);
    }
}
