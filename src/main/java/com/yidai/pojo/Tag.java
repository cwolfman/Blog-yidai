package com.yidai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Tag
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/8/31 11:10
 * @Description TODO
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("Tag")
public class Tag {

    private Long id;
    private String name;

    private List<Blog> blogs = new ArrayList<>();

}