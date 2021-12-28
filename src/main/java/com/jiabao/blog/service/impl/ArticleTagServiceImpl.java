package com.jiabao.blog.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiabao.blog.utils.PageUtils;
import com.jiabao.blog.utils.Query;

import com.jiabao.blog.dao.ArticleTagDao;
import com.jiabao.blog.entity.ArticleTagEntity;
import com.jiabao.blog.service.ArticleTagService;

/**
 *
 *
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTagEntity> implements ArticleTagService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ArticleTagEntity> page = this.page(
                new Query<ArticleTagEntity>().getPage(params),
                new QueryWrapper<ArticleTagEntity>()
        );

        return new PageUtils(page);
    }

}