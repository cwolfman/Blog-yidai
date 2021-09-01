package com.yidai.dao;

import com.yidai.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName UserDao
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/8/31 11:19
 * @Description TODO
 */

@Mapper
@Repository
public interface UserDao {

    User queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}