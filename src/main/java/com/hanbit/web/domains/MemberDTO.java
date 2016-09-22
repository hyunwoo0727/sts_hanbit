/**
 * 
 */
package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @date : 2016. 6. 16.
 * @author : HyunWoo Lee
 * @file : Student.java
 * @story : 학생클라스
 */
@Component
@Data
public class MemberDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String memId,pw,name,gender,regDate,ssn,email,profileImg,role,phone,subjects;
	@Getter @Setter private int majorSeq;
}
