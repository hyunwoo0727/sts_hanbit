/**
 * 
 */
package com.hanbit.web.member;

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
public class MemberVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id, pw, name, gender, regDate, ssn, profileImg, email, birth,phone;

	public MemberVO() {
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}

	public String getRegDate() {
		return regDate;
	}

	public String getSsn() {
		return ssn;
	}


	public String getName() {
		return name;
	}
	
	public void setSsn(String ssn) {
		int sCode = Integer.parseInt(ssn.split("-")[1]);
		this.gender = (sCode + 10) % 2 == 0 ? "여" : "남";
		int nowYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis())));
		int ageYear = Integer.parseInt(ssn.substring(0, 2));
		switch (sCode) {
		case 1:	case 2:	case 5:	case 6:
	//		this.age = nowYear - (1900 + ageYear) + 1;
			break;
		case 9:	case 0:
		//	this.age = nowYear - (1800 + ageYear) + 1;
			break;
		default:
			//this.age = nowYear - (2000 + ageYear) + 1;
			break;
		}
		this.birth = ssn.split("-")[0];
		this.ssn = ssn;
	}
	
	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegDate() {
		this.regDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", regDate=" + regDate
				+ ", ssn=" + ssn + ", profileImg=" + profileImg + ", email=" + email + ", birth=" + birth + ", phone="
				+ phone + "]";
	}
	
	
}
