package com.news.grm.service;

import com.news.grm.pojo.GrmUser;

public interface GrmUserService {

    void addGrmUser(GrmUser grmUser);

    GrmUser findByUsername(String username);
}
