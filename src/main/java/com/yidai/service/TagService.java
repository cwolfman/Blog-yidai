package com.yidai.service;

import com.yidai.pojo.Tag;

import java.util.List;

/**
 * @author: 一呆
 * @date: 2021/8/31 11:48
 * @description:
 */
public interface TagService {

    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    /**
     * @description: 首页展示博客标签
     */
    List<Tag> getBlogTag();

    /**
     * @description: 从字符串中获取tag集合
     */
    List<Tag> getTagByString(String text);

    int updateTag(Tag tag);

    int deleteTag(Long id);
}
