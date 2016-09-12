/**
 * 
 */
package com.hanbit.web.domains;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @date : 2016. 6. 16.
 * @author : HyunWoo Lee
 * @file : Student.java
 * @story : 학생클라스
 */
@Component
public class MemberDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String memId,pw,name,gender,regDate,ssn,email,profileImg,role,phone;
	private int majorSeq;
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMajorSeq() {
		return majorSeq;
	}
	public void setMajorSeq(int majorSeq) {
		this.majorSeq = majorSeq;
	}
	@Override
	public String toString() {
		return "MemberDTO [memId=" + memId + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", regDate="
				+ regDate + ", ssn=" + ssn + ", email=" + email + ", profileImg=" + profileImg + ", role=" + role
				+ ", phone=" + phone + ", majorSeq=" + majorSeq + "]";
	}
	
	
}
