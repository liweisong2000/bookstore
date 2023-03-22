package com.itheima.service;

import com.itheima.domain.User;

public interface FindUserService {
    User FindUser(String username);

    int DeleteUser(String username);
}
