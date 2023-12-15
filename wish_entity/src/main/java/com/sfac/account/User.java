package com.sfac.account;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sfac.common.AbstractEntity;

/**
 * Description: User
 * @author JiangHu
 * @date 2022-03-25 14:16:25
 */
@Entity
@Table(name = "account_user")
@TableName(value = "account_user")
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	/* ==== 网站相关 ==== */
	@Column(unique = true)
	private String userName;
	private String password;
	private String image;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
