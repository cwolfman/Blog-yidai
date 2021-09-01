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
 * @ClassName User
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/8/31 11:08
 * @Description TODO
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("User")
public class User {

    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;
    /**
     * @description: 一对多
     */
    private List<Blog> blogs = new ArrayList<>();

}
