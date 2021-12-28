package com.jiabao.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiabao.blog.utils.PageUtils;
import com.jiabao.blog.entity.ArticleEntity;
import com.jiabao.blog.vo.ArticleDetailVo;
import com.jiabao.blog.vo.YearMonthArchiveVo;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
public interface ArticleService extends IService<ArticleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据文章ID获取文章相关的所有信息
     * @param articleId 需要获取详情的文章的ID
     * @return 返回和前端交互的文章所有信息的实体类
     */
    ArticleDetailVo getArticleAllInfo(Long articleId);

    List<YearMonthArchiveVo> getArticleArchiveInfo();
}

