package com.jiabao.blog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author JiabaoLi
 * @email 905001136@qq.com
 * @date 2021-12-25 21:56:09
 */
@Data
@TableName("article")
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer commentCounts;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private String summary;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private Integer viewCounts;
	/**
	 * 
	 */
	private Integer weight;
	/**
	 * 
	 */
	private Long authorId;
	/**
	 * 
	 */
	private Long bodyId;
	/**
	 * 
	 */
	private Integer categoryId;

	private String authorName;

	private String articleImg;

}
