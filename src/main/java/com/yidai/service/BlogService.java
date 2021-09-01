package com.yidai.service;

import com.yidai.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author: 一呆
 * @date: 2021/8/31 11:48
 * @description:
 */
public interface BlogService {

    /**
     * @description: 后台展示博客
     */
    Blog getBlog(Long id);

    /**
     * @description: 前端展示博客
     */
    Blog getDetailedBlog(Long id);

    List<Blog> getAllBlog();

    /**
     * @description: 根据类型id获取博客
     */
    List<Blog> getByTypeId(Long typeId);

    /**
     * @description: 根据标签id获取博客
     */
    List<Blog> getByTagId(Long tagId);

    /**
     * @description: 主页博客展示
     */
    List<Blog> getIndexBlog();

    /**
     * @description: 推荐博客展示
     */
    List<Blog> getAllRecommendBlog();

    /**
     * @description: 全局搜索博客
     */
    List<Blog> getSearchBlog(String query);

    /**
     * @description: 归档博客
     */
    Map<String, List<Blog>> archiveBlog();

    /**
     * @description: 查询博客条数
     */
    int countBlog();

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    int saveViews(int views, Long id);

    /**
     * @description: 后台根据标题、分类、推荐搜索博客
     */
    List<Blog> searchAllBlog(Blog blog);

}
