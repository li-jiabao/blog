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
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String account;
	/**
	 * 
	 */
	private Boolean admin;
	/**
	 * 
	 */
	private String avatar;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private Boolean deleted;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private Date lastLogin;
	/**
	 * 
	 */
	private String mobilePhoneNumber;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String salt;
	/**
	 * 
	 */
	private String status;

}
