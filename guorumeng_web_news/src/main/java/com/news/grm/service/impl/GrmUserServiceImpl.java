package com.news.grm.service.impl;

import com.news.grm.dao.GrmUserDao;
import com.news.grm.pojo.GrmUser;
import com.news.grm.service.GrmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrmUserServiceImpl implements GrmUserService {

    @Autowired
    private GrmUserDao grmUserDao;

    public void addGrmUser(GrmUser grmUser) {
        grmUserDao.addGrmUser(grmUser);
    }

    public GrmUser findByUsername(String username) {
        return grmUserDao.findByUsername(username);
    }
}
