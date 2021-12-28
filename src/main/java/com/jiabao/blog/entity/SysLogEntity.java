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
@TableName("sys_log")
public class SysLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private String ip;
	/**
	 * 
	 */
	private String method;
	/**
	 * 
	 */
	private String module;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private String operation;
	/**
	 * 
	 */
	private String params;
	/**
	 * 
	 */
	private Long time;
	/**
	 * 
	 */
	private Long userid;

}
