package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ManageUserMapper {
    @Select("select * from userinfo where power=0")
    @Results(id="manageMap",value={
            @Result(id=false,column="id",property = "id"),
            @Result(column = "username",property="username"),
            @Result(column = "pwd",property="pwd"),
            @Result(column = "email",property="email"),
            @Result(column = "address",property = "address"),
            @Result(column = "level",property = "level"),
            @Result(column = "power",property = "power")
    })
    List<User> FindUser();




}
