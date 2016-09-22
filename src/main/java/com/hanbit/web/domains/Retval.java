package com.hanbit.web.domains;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class Retval {
	@Getter @Setter private int count;
	@Getter @Setter private String message,flag,temp;
}
