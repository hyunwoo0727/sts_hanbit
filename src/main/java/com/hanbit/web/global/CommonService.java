package com.hanbit.web.global;

import java.util.List;
import java.util.Map;

/**
 * @date   :2016. 7. 8.
 * @author :HyunWoo Lee
 * @file   :CommandService.java
 * @story  :
*/

public interface CommonService {
	public List<?> list();
	public List<?> findBy(String keyword);
	public int count();
	public Map<?,?> map();
}
