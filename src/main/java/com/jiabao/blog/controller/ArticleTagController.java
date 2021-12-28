package com.jiabao.blog.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiabao.blog.entity.ArticleTagEntity;
import com.jiabao.blog.service.ArticleTagService;
import com.jiabao.blog.utils.PageUtils;
import com.jiabao.blog.utils.R;



/**
 * 
 *
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
@RestController
@RequestMapping("blog/articletag")
public class ArticleTagController {
    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("blog:articletag:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = articleTagService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{articleId}")
    @RequiresPermissions("blog:articletag:info")
    public R info(@PathVariable("articleId") Integer articleId){
		ArticleTagEntity articleTag = articleTagService.getById(articleId);

        return R.ok().put("articleTag", articleTag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("blog:articletag:save")
    public R save(@RequestBody ArticleTagEntity articleTag){
		articleTagService.save(articleTag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("blog:articletag:update")
    public R update(@RequestBody ArticleTagEntity articleTag){
		articleTagService.updateById(articleTag);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("blog:articletag:delete")
    public R delete(@RequestBody Integer[] articleIds){
		articleTagService.removeByIds(Arrays.asList(articleIds));

        return R.ok();
    }

}
