package com.yidai.service;

import com.yidai.pojo.User;

/**
 * @author: 一呆
 * @date: 2021/8/31 11:47
 * @description:
 */
public interface UserService {

    public User checkUser(String username, String password);
}
