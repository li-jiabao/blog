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
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId
	private Integer id;
	/**
	 * 系统给用户分配的随机id
	 */
	private String uid;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 用户邮箱
	 */
	private String email;
	/**
	 * 用户手机号
	 */
	private String phone;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * md5加密的盐值
	 */
	private String salt;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 用户生日
	 */
	private Date birth;
	/**
	 * 用户注册时间
	 */
	private Date createTime;
	/**
	 * 用户性别
	 */
	private String gender;

}
