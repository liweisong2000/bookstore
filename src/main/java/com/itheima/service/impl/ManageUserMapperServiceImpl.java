package com.itheima.service.impl;

import com.itheima.dao.ManageUserMapper;
import com.itheima.domain.User;
import com.itheima.service.ManageUserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageUserMapperServiceImpl implements ManageUserMapperService {
    @Autowired
    private ManageUserMapper manageUserMapper;

    @Override
    public List<User> FindUser(){
        return manageUserMapper.FindUser();
    }
}
