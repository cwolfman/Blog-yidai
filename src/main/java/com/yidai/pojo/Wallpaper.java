package com.yidai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Wallpaper
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/9/2 0:45
 * @Description TODO
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("Wallpaper")
public class Wallpaper {

    private Long id;
    private String name;
    private List<Blog> blogs = new ArrayList<>();

}
