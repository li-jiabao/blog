package com.jiabao.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiabao.blog.utils.PageUtils;
import com.jiabao.blog.entity.SysLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

