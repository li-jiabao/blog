package com.jiabao.blog.service.impl;

import com.jiabao.blog.dao.ArticleTagDao;
import com.jiabao.blog.entity.TagEntity;
import com.jiabao.blog.service.*;
import com.jiabao.blog.vo.ArticleDetailVo;
import com.jiabao.blog.vo.ArticleVo;
import com.jiabao.blog.vo.YearMonthArchiveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiabao.blog.utils.PageUtils;
import com.jiabao.blog.utils.Query;

import com.jiabao.blog.dao.ArticleDao;
import com.jiabao.blog.entity.ArticleEntity;

/**
 *
 *
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {

    @Autowired
    ArticleBodyService bodyService;

    @Autowired
    ArticleTagDao articleTagDao;

    @Autowired
    TagService tagService;

    @Autowired
    CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ArticleEntity> page = this.page(
                new Query<ArticleEntity>().getPage(params),
                new QueryWrapper<ArticleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public ArticleDetailVo getArticleAllInfo(Long articleId) {
        // 创建一个文章详情vo类
        ArticleDetailVo detailVo = new ArticleDetailVo();
        // 查询文章表找到文章相关的标签、分类和评论数据或者相关的ID
        // 再利用当前查到的ID信息继续去查询数据库
        ArticleEntity articleEntity = this.baseMapper.selectById(articleId);
        // 通过文章实体类可以获取到很多有用的信息，可以讲这些信息直接封装到vo类中
        detailVo.setBodyId(articleEntity.getBodyId());
        detailVo.setArticleImg(articleEntity.getArticleImg());
        detailVo.setAuthorName(articleEntity.getAuthorName());
        detailVo.setCreateDate(articleEntity.getCreateDate());
        detailVo.setCommentCounts(articleEntity.getCommentCounts());
        detailVo.setTitle(articleEntity.getTitle());
        detailVo.setViewCounts(articleEntity.getViewCounts());
        // 查询文章的标签信息，需要先查标签和文章的关系数据表，再利用查询到标签ID查询标签表
        List<Long> tagIds = articleTagDao.getTagsByArticleId(articleId);
        List<String> tags = tagIds.stream().map(tagId -> {
            TagEntity tag = tagService.getById(tagId);
            return tag.getTagname();
        }).collect(Collectors.toList());
        detailVo.setTags(tags);
        // 查询文章的分类信息
        detailVo.setCategoryName(categoryService.getById(articleEntity.getCategoryId()).getCategoryName());
        // 查询文章的内容
        detailVo.setContent(bodyService.getById(articleEntity.getBodyId()).getContentHtml());
        // TODO 查询评论表获取所有改文章相关的评论数据

        // TODO 由于该过程有许多的步骤不是互相影响的，可以讲这些步骤编排为异步任务，加快查询的速度

        return detailVo;
    }

    @Override
    public List<YearMonthArchiveVo> getArticleArchiveInfo() {
        ArticleDao articleDao = this.baseMapper;
        List<YearMonthArchiveVo> yearMonth = articleDao.getArchiveByYearMonth();
        yearMonth.forEach(item-> {
            String[] split = item.getArticleIds().split(",");
            List<Long> longs = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            List<ArticleVo> articleVos = articleDao.getArticleVoByIds(longs);
            item.setArticles(articleVos);
        });
        return yearMonth;
    }

}