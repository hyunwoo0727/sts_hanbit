package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data	
public class MajorDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Getter @Setter private int majorSeq;
	@Getter @Setter private String title,id,pw,name,gender,regDate,ssn,email,profileImg,role,phone;	
}
