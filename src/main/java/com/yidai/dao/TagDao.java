package com.yidai.dao;

import com.yidai.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 一呆
 * @date: 2021/8/31 23:19
 * @description:
 */
@Mapper
@Repository
public interface TagDao {

    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    /**
     * @description: 首页展示博客标签
     */
    List<Tag> getBlogTag();

    int updateTag(Tag tag);

    int deleteTag(Long id);
}
