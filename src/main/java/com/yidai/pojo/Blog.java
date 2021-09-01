package com.yidai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Blog
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/8/31 11:02
 * @Description TODO
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("Blog")
public class Blog {

    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;
    /**
     * @description: 这个属性用来在mybatis中进行连接查询的
     */
    private Long typeId;
    private Long userId;
    /**
     * @description: 获取多个标签的id
     */
    private String tagIds;
    private String description;
    /**
     * @description: 多对一
     */
    private Type type;
    private User user;
    /**
     * @description: 多对多
     */
    private List<Tag> tags = new ArrayList<>();
    /**
     * @description: 一对多
     */
    private List<Comment> comments = new ArrayList<>();

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    /**
     * @description: 将tags集合转换为tagIds字符串形式：“1,2,3”,用于编辑博客时显示博客的tag
     */
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }
}