package com.yidai.service.impl;

import com.yidai.dao.WallpaperDao;
import com.yidai.pojo.Wallpaper;
import com.yidai.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName WallpaperServiceImpl
 * @Author 一呆
 * @Version 1.0.0
 * @Date 2021/9/2 1:11
 * @Description TODO
 */
@Service
public class WallpaperServiceImpl implements WallpaperService {

    @Autowired
    private WallpaperDao wallpaperDao;

    @Override
    @Transactional
    public int saveWallpaper(Wallpaper wallpaper) {
        return wallpaperDao.saveWallpaper(wallpaper);
    }

    @Override
    @Transactional
    public Wallpaper getWallpaper(Long id) {
        return wallpaperDao.getWallpaper(id);
    }

    @Override
    @Transactional
    public Wallpaper getWallpaperByName(String name) {
        return wallpaperDao.getWallpaperByName(name);
    }

    @Override
    @Transactional
    public List<Wallpaper> getAllWallpaper() {
        return wallpaperDao.getAllWallpaper();
    }

    @Override
    @Transactional
    public List<Wallpaper> getBlogWallpaper() {
        return wallpaperDao.getBlogWallpaper();
    }

    @Override
    @Transactional
    public int updateWallpaper(Wallpaper wallpaper) {
        return wallpaperDao.updateWallpaper(wallpaper);
    }

    @Override
    @Transactional
    public int deleteWallpaper(Long id) {
        return wallpaperDao.deleteWallpaper(id);
    }
}
