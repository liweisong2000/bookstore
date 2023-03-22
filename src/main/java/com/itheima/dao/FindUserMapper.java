package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FindUserMapper {
    @Select("select * from userinfo where username=#{username}")
    @Results(id="FindUserMap",value={
            @Result(column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="pwd",property="pwd"),
            @Result(column = "email",property="email"),
            @Result(column = "address",property="address"),
            @Result(column = "postcode",property="postcode"),
            @Result(column="level",property = "level"),
            @Result(column="power",property = "power")
    })
    User FindUser(String username);

    @Delete("delete from userinfo where username=#{username}")
    int DeleteUser(String username);
}
