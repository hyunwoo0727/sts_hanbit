package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :SubjectBean.java
 * @story  :
*/
@Component
@Data
public class SubjectDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String id,subjName;
	@Getter @Setter private int subjSeq;
}