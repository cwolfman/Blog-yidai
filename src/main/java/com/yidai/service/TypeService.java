package com.yidai.service;

import com.yidai.pojo.Type;

import java.util.List;

/**
 * @author: 一呆
 * @date: 2021/8/31 11:48
 * @description:
 */
public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    List<Type> getAllType();

    /**
     * @description: 首页右侧展示type对应的博客数量
     */
    List<Type> getBlogType();

    int updateType(Type type);

    int deleteType(Long id);
}
