package com.jiabao.blog.vo;

import com.jiabao.blog.entity.CommentEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: JiabaoLi
 * @Email: 905001136@qq.com
 * @CreatedDate: 2021/12/25
 */

@Data
@ToString
public class ArticleDetailVo implements Serializable {
    private static final long serialVersionUID = -1225688096433135414L;

    private String title;
    private Long bodyId;
    private String authorName;
    private Date createDate;
    private Integer commentCounts;
    private Integer viewCounts;
    private String categoryName;
    private List<String> tags;
    private String articleImg;
    private String content;
    private List<CommentEntity> comments;

}
