package com.jiabao.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("article_body")
public class ArticleBodyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private String contentHtml;

}
