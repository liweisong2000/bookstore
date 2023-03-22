package com.itheima.service.impl;

import com.itheima.dao.FindUserMapper;
import com.itheima.domain.User;
import com.itheima.service.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserServiceImpl implements FindUserService {

    @Autowired
    private FindUserMapper findUserMapper;

    @Override
    public User FindUser(String username){
        return findUserMapper.FindUser(username);
    }

    @Override
    public int DeleteUser(String username){
        return findUserMapper.DeleteUser(username);
    }
}
