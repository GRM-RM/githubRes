package com.news.grm.dao;


import com.news.grm.pojo.GrmUser;

public interface GrmUserDao {

    void addGrmUser(GrmUser grmUser);

    GrmUser findByUsername(String username);
}
