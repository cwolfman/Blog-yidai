package com.yidai.dao;

import com.yidai.pojo.Blog;
import com.yidai.pojo.BlogAndTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogDao {

    /**
     * @description: 后台展示博客
     */
    Blog getBlog(Long id);

    /**
     * @Param:
     * @return:
     * @author: 一呆
     * @date: 2021/8/31 11:24
     * @description: 博客详情
     */
    Blog getDetailedBlog(@Param("id") Long id);

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
     * @description: 后台根据标题、分类、推荐搜索博客
     */
    List<Blog> searchAllBlog(Blog blog);

    /**
     * @description: 查询所有年份，返回一个集合
     */
    List<String> findGroupYear();

    /**
     * @description: 按年份查询博客
     */
    List<Blog> findByYear(@Param("year") String year);

    int saveBlog(Blog blog);

    int saveBlogAndTag(BlogAndTag blogAndTag);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    int saveViews(@Param("views") int views, @Param("id") Long id);  //浏览量+1
}
