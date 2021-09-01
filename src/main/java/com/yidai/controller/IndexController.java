package com.yidai.controller;

import com.yidai.pojo.Blog;
import com.yidai.pojo.Tag;
import com.yidai.pojo.Type;
import com.yidai.service.BlogService;
import com.yidai.service.TagService;
import com.yidai.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String toIndex(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum, Model model) {

        PageHelper.startPage(pageNum, 8);
        List<Blog> allBlog = blogService.getIndexBlog();
        //获取博客的类型(联表查询)
        List<Type> allType = typeService.getBlogType();
        //获取博客的标签(联表查询)
        List<Tag> allTag = tagService.getBlogTag();
        //获取推荐博客
        List<Blog> recommendBlog = blogService.getAllRecommendBlog();

        //得到分页结果对象
        PageInfo pageInfo = new PageInfo(allBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendBlogs", recommendBlog);
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam(required = false, defaultValue = "1", value = "pagenum") int pagenum,
                         @RequestParam String query, Model model) {

        PageHelper.startPage(pagenum, 5);
        List<Blog> searchBlog = blogService.getSearchBlog(query);
        PageInfo pageInfo = new PageInfo(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String toLogin(@PathVariable Long id, Model model) {
        Blog blog = blogService.getDetailedBlog(id);

        int view = blog.getViews();
        blogService.saveViews(++view, id);

        model.addAttribute("blog", blog);
        return "blog";
    }
}
