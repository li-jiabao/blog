package com.jiabao.blog.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: JiabaoLi
 * @Email: 905001136@qq.com
 * @CreatedDate: 2021/12/27
 */

@Data
@ToString
public class YearMonthArchiveVo {
    private String yearMonth;
    private String articleIds;
    private List<ArticleVo> articles;
}
