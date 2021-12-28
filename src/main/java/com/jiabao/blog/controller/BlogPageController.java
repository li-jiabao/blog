package com.jiabao.blog.controller;

import com.jiabao.blog.entity.ArticleBodyEntity;
import com.jiabao.blog.entity.UserEntity;
import com.jiabao.blog.service.*;
import com.jiabao.blog.utils.PageUtils;
import com.jiabao.blog.vo.ArticleDetailVo;
import com.jiabao.blog.vo.CategoryVo;
import com.jiabao.blog.vo.TagVo;
import com.jiabao.blog.vo.YearMonthArchiveVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: JiabaoLi
 * @Email: 905001136@qq.com
 * @CreatedDate: 2021/12/27
 */
@Slf4j
@Controller
public class BlogPageController {
    @Autowired
    UserService userService;

    @Autowired
    TagService tagService;

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleBodyService bodyService;

    @Autowired
    private CategoryService categoryService;

    /********************************************
     *
     *  归档界面的Controller
     *
     ********************************************/

    @RequestMapping("/archive")
    public String archive(Model model) {
        List<YearMonthArchiveVo> archives = articleService.getArticleArchiveInfo();
        log.info("获取到的归档数据{}",archives);
        model.addAttribute("archives",archives);
        return "archive";
    }


    /********************************************
     *
     *  博客界面的Controller
     *
     ********************************************/


    @RequestMapping("/blog")
    public String bolg(Model model) {
        PageUtils page = articleService.queryPage(new HashMap<>());
        model.addAttribute("page",page);
        return "blog";
    }

    @RequestMapping("/blog/{bodyId}.html")
    public String articleDetail(@PathVariable("bodyId") Long bodyId, Model model) {
        // 创建一个业务层方法来获取文章的所有信息并封装称一个vo对象进行数据传输
        ArticleDetailVo detailVo = articleService.getArticleAllInfo(bodyId);
        model.addAttribute("article",detailVo);
        return "blog-single";
    }

    /********************************************
     *
     *  分类界面的Controller
     *
     ********************************************/

    @RequestMapping("/category")
    public String getCategory(Model model) {
        List<CategoryVo> categories = categoryService.getAllCategoryInfo();
        model.addAttribute("categories",categories);
        return "category";
    }


    /********************************************
     *
     *  编辑器界面的Controller
     *
     ********************************************/

    @RequestMapping("/editor/{articleBodyId}.html")
    public String editArticle(@PathVariable("articleBodyId") Long articleBodyId, Model model) {
        model.addAttribute("articleBody",articleBodyId);
        return "editor";
    }

    /********************************************
     *
     *  文章标签界面的Controller
     *
     ********************************************/

    @RequestMapping("/tag")
    public String getTag(Model model) {
        List<TagVo> tags = tagService.getAllTag();
        model.addAttribute("tags",tags);
        return "tag";
    }

    /********************************************
     *
     *  编辑器界面的Controller
     *
     ********************************************/

    @RequestMapping("/about/{authorId}.html")
    public String about(@PathVariable("authorId") Long authorId,Model model) {
        UserEntity userEntity = userService.getById(authorId);
        model.addAttribute("author",userEntity);
        return "about";
    }
}
