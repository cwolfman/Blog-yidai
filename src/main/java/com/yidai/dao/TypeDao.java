package com.yidai.dao;

import com.yidai.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDao {

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
