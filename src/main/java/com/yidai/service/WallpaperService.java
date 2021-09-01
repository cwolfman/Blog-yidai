package com.yidai.service;

import com.yidai.pojo.Wallpaper;

import java.util.List;

/**
 * @InterfaceName WallpaperService
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/9/2 1:11
 * @Description TODO
 */
public interface WallpaperService {

    int saveWallpaper(Wallpaper wallpaper);

    Wallpaper getWallpaper(Long id);

    Wallpaper getWallpaperByName(String name);

    List<Wallpaper> getAllWallpaper();

    List<Wallpaper> getBlogWallpaper();

    int updateWallpaper(Wallpaper wallpaper);

    int deleteWallpaper(Long id);
}