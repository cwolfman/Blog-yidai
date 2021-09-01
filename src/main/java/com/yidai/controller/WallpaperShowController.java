package com.yidai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yidai.pojo.Blog;
import com.yidai.pojo.Type;
import com.yidai.pojo.Wallpaper;
import com.yidai.service.BlogService;
import com.yidai.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName WallpaperShowController
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/9/2 1:19
 * @Description TODO
 */
@Controller
public class WallpaperShowController {

    @Autowired
    private WallpaperService wallpaperService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/wallpapers/{id}")
    public String types(@PathVariable Long id, @RequestParam(required = false, defaultValue = "1", value = "pagenum") int pagenum,
                        Model model) {
        //开启分页
        PageHelper.startPage(pagenum, 100);
        List<Wallpaper> wallpapers = wallpaperService.getBlogWallpaper();

        if (id == null) {
            return "error";
        } else if (id == -1) {
            // -1从导航点过来的
            id = wallpapers.get(0).getId();
        }

        List<Blog> blogs = blogService.getByWallpaperId(id);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("wallpapers", wallpapers);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeWallpaperId", id);

        return "wallpapers";
    }
}
