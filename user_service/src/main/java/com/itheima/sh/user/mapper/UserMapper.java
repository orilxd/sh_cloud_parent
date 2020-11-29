package com.itheima.sh.user.mapper;

import com.itheima.sh.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from tb_user where username = #{username}")
    User findById(@Param("username") String username);
}
