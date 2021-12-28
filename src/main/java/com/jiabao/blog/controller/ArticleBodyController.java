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

import com.jiabao.blog.entity.ArticleBodyEntity;
import com.jiabao.blog.service.ArticleBodyService;
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
@RequestMapping("blog/articlebody")
public class ArticleBodyController {
    @Autowired
    private ArticleBodyService articleBodyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("blog:articlebody:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = articleBodyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("blog:articlebody:info")
    public R info(@PathVariable("id") Long id){
		ArticleBodyEntity articleBody = articleBodyService.getById(id);

        return R.ok().put("articleBody", articleBody);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("blog:articlebody:save")
    public R save(@RequestBody ArticleBodyEntity articleBody){
		articleBodyService.save(articleBody);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("blog:articlebody:update")
    public R update(@RequestBody ArticleBodyEntity articleBody){
		articleBodyService.updateById(articleBody);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("blog:articlebody:delete")
    public R delete(@RequestBody Long[] ids){
		articleBodyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
