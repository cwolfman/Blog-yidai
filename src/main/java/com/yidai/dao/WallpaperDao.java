package com.yidai.dao;

import com.yidai.pojo.Wallpaper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @InterfaceName WallpaperDao
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/9/2 0:47
 * @Description TODO
 */

@Mapper
@Repository
public interface WallpaperDao {

    int saveWallpaper(Wallpaper wallpaper);

    Wallpaper getWallpaper(Long id);

    Wallpaper getWallpaperByName(String name);

    List<Wallpaper> getAllWallpaper();

    List<Wallpaper> getBlogWallpaper();

    int updateWallpaper(Wallpaper wallpaper);

    int deleteWallpaper(Long id);
}