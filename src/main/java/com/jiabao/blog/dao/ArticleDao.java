package com.jiabao.blog.dao;

import com.jiabao.blog.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiabao.blog.vo.ArticleVo;
import com.jiabao.blog.vo.YearMonthArchiveVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {
	/**
	 * 获取文章信息
	 * @param articleId 文章id
	 * @return 文章信息vo
	 */
	public List<ArticleVo> getArticleVoByIds(@Param("articleIds") List<Long> articleId);

	/**
	 * 按照年月对文章进行归档
	 * @return 归档信息
	 */
	public List<YearMonthArchiveVo> getArchiveByYearMonth();

	/**
	 * 获取当前分类ID下的所有文章数据
	 * @param categoryId 分类ID
	 * @return 当前分类ID下所有相关的文章
	 */
	public List<ArticleVo> getArticlesVoByCategoryId(@Param("categoryId") Long categoryId);
}
