package com.yidai.dao;

import com.yidai.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {

    /**
     * @description: 根据创建时间倒序来排
     */
    List<Comment> findByBlogIdAndParentCommentNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);

    /**
     * @description: 查询父级对象
     */
    Comment findByParentCommentId(@Param("parentCommentId") Long parentcommentid);

    /**
     * @description: 添加一个评论
     */
    int saveComment(Comment comment);
}
