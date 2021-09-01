package com.yidai.service;

import com.yidai.pojo.Comment;

import java.util.List;

/**
 * @author: 一呆
 * @date: 2021/8/31 11:48
 * @description:
 */
public interface CommentService {

    List<Comment> getCommentByBlogId(Long blogId);

    int saveComment(Comment comment);
}
