package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class BoardDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Getter @Setter private int artSeq;
	@Getter @Setter private String category,title,writeDate,regDate,content,memId,pw,name,gender,ssn,email,profileImg,role,phone;
}