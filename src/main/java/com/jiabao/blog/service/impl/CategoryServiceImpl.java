package com.jiabao.blog.service.impl;

import com.jiabao.blog.dao.ArticleDao;
import com.jiabao.blog.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiabao.blog.utils.PageUtils;
import com.jiabao.blog.utils.Query;

import com.jiabao.blog.dao.CategoryDao;
import com.jiabao.blog.entity.CategoryEntity;
import com.jiabao.blog.service.CategoryService;

/**
 *
 *
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryVo> getAllCategoryInfo() {
        CategoryDao categoryDao = this.baseMapper;
        List<CategoryVo> categoryVos = categoryDao.getAllCategories();
        categoryVos.forEach(item->{
            item.setArticles(articleDao.getArticlesVoByCategoryId(item.getCategoryId()));
        });
        return categoryVos;
    }

}