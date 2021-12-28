package com.jiabao.blog.dao;

import com.jiabao.blog.entity.ArticleTagEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
@Mapper
public interface ArticleTagDao extends BaseMapper<ArticleTagEntity> {

    List<Long> getTagsByArticleId(Long articleId);
}
