package com.student_assessment.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author Administrator
 *
 */
public class User implements Serializable {
	private String userName;// 用户名

	private Integer userTypeId;// 用户 类型Id

	private String passWord;// 用户密码
	@DateTimeFormat(pattern = "yyyy-MM-dd")

	private Date userAddDate;// 用户添加日期

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Date getUserAddDate() {
		return userAddDate;
	}

	public void setUserAddDate(Date userAddDate) {
		this.userAddDate = userAddDate;
	}
}
