package com.jiabao.blog.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiabao.blog.utils.PageUtils;
import com.jiabao.blog.utils.Query;

import com.jiabao.blog.dao.ArticleBodyDao;
import com.jiabao.blog.entity.ArticleBodyEntity;
import com.jiabao.blog.service.ArticleBodyService;

/**
 *
 *
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
@Service("articleBodyService")
public class ArticleBodyServiceImpl extends ServiceImpl<ArticleBodyDao, ArticleBodyEntity> implements ArticleBodyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ArticleBodyEntity> page = this.page(
                new Query<ArticleBodyEntity>().getPage(params),
                new QueryWrapper<ArticleBodyEntity>()
        );

        return new PageUtils(page);
    }

}