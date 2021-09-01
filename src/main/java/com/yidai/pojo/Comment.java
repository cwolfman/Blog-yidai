package com.yidai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @ClassName Comment
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/8/31 11:11
 * @Description TODO
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("Comment")
public class Comment {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    /**
     * @description: 是否为管理员评论
     */
    private boolean adminComment;

    /**
     * @description: 头像
     */
    private String avatar;
    private Date createTime;

    private Long blogId;
    /**
     * @description: 父评论id
     */
    private Long parentCommentId;
    private String parentNickname;

    //回复评论
    //private List<Comment> replyComments = new ArrayList<>();

    /**
     * @description: 父评论
     */
    private Comment parentComment;

    /**
     * @description: 多对一
     */
    private Blog blog;

}
