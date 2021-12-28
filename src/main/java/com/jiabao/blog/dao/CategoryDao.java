package com.jiabao.blog.dao;

import com.jiabao.blog.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiabao.blog.vo.CategoryVo;
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
public interface CategoryDao extends BaseMapper<CategoryEntity> {

    /**
     * 获取所有的分类以及分类名称
     * @return 包含了分类ID和分类名称的CategoryVo
     */
    List<CategoryVo> getAllCategories();
}
