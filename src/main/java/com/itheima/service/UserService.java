package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {
    User login(User user);

    int updatePer(User user);

    int insertUser(User user);
}
