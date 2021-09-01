package com.yidai.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yidai.pojo.Wallpaper;
import com.yidai.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @ClassName WallpaperController
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/9/2 1:18
 * @Description TODO
 */
@Controller
@RequestMapping("/admin")
public class WallpaperController {
    
    @Autowired
    WallpaperService wallpaperService;

    @GetMapping("/wallpapers")
    public String wallpapers(@RequestParam(required = false, defaultValue = "1", value = "pagenum") int pagenum, Model model) {
        PageHelper.startPage(pagenum, 5);
        List<Wallpaper> allWallpaper = wallpaperService.getAllWallpaper();
        //得到分页结果对象
        PageInfo<Wallpaper> pageInfo = new PageInfo<>(allWallpaper);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/wallpapers";
    }

    @GetMapping("/wallpapers/input")
    public String toAddWallpaper(Model model) {
        //返回一个Wallpaper对象给前端th:object
        model.addAttribute("wallpaper", new Wallpaper());
        return "admin/wallpapers-input";
    }

    @GetMapping("/wallpapers/{id}/input")
    public String toEditWallpaper(@PathVariable Long id, Model model) {
        model.addAttribute("wallpaper", wallpaperService.getWallpaper(id));
        return "admin/wallpapers-input";
    }

    /**
     * @Param:
     * @return:
     * @date: 2021/9/1 16:46
     * @description: 新增
     */
    @PostMapping("/wallpapers")
    public String addWallpaper(Wallpaper wallpaper, RedirectAttributes attributes) {
        Wallpaper t = wallpaperService.getWallpaperByName(wallpaper.getName());
        if (t != null) {
            attributes.addFlashAttribute("msg", "不能添加重复的分类");
            return "redirect:/admin/wallpapers/input";
        } else {
            attributes.addFlashAttribute("msg", "添加成功");
        }
        wallpaperService.saveWallpaper(wallpaper);
        //不能直接跳转到wallpapers页面，否则不会显示wallpaper数据(没经过wallpapers方法)
        return "redirect:/admin/wallpapers";
    }

    @PostMapping("/wallpapers/{id}")
    public String editWallpaper(@PathVariable Long id, Wallpaper wallpaper, RedirectAttributes attributes) {  //修改
        Wallpaper t = wallpaperService.getWallpaperByName(wallpaper.getName());
        if (t != null) {
            attributes.addFlashAttribute("msg", "不能添加重复的分类");
            return "redirect:/admin/wallpapers/input";
        } else {
            attributes.addFlashAttribute("msg", "修改成功");
        }
        wallpaperService.updateWallpaper(wallpaper);
        //不能直接跳转到wallpapers页面，否则不会显示Wallpaper数据(没经过wallpapers方法)
        return "redirect:/admin/wallpapers";
    }

    @GetMapping("/wallpapers/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        wallpaperService.deleteWallpaper(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/wallpapers";
    }
}
