package com.itheima.dao;

import com.itheima.domain.Order2;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Select("select * from userinfo where username=#{username} AND pwd=#{pwd} ")
    @Results(id="userMap",value={
            @Result(id=false,column="id",property="id"),
            @Result(column="power",property="power"),
            @Result(column="username",property="username"),
            @Result(column="pwd",property="pwd")
    })
    User login(User user);

    @Update("update userinfo set username=#{username},pwd=#{pwd},email=#{email},address=#{address},postcode=#{postcode} where id=#{id}")
    int updatePer(User user);

    @Insert("insert into userinfo(username,pwd,email,address,postcode,power)values(#{username},#{pwd},#{email},#{address},#{postcode},#{power})")
    int insertUser(User user);
}
