package com.high.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * user实体类
 * 
 * @author 
 *
 */
@Data
public class User {
	/**主键ID*/
	private String id; 
	/**部门ID*/
	private String deptId; 
	/**用户名*/
	private String username; 
	/**密码*/
	private String password; 
	/**手机号码*/
	private String phone; 
	/**电子邮箱*/
	private String email; 
	/**昵称*/
	private String nickName; 
	/**在线状态 0-下线 1-在线*/
	private Integer onlineStatus; 
	/**头像*/
	private String avatar; 
	/**状态 0-停用 1-正常 2-锁定 3-删除*/
	private Integer status; 
	/**微信openid*/
	private String wxOpenId; 
	/**QQ openid*/
	private String qqOpenId; 
	/**创建时间*/
	private LocalDateTime createTime;
	/**更新时间*/
	private LocalDateTime updateTime;
	
}
