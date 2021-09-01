package com.yidai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * @ClassName BlogAndTag
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/8/31 11:13
 * @Description TODO
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("BlogAndTag")
public class BlogAndTag {

    private Long tagId;

    private Long blogId;

}
