package com.jiabao.blog.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: JiabaoLi
 * @Email: 905001136@qq.com
 * @CreatedDate: 2021/12/25
 */
@Data
@ToString
public class ArticleVo {
    private Long articleId;
    private String title;
    private String summary;
    private Date createDate;
    private String authorName;
}
