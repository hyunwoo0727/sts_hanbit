package com.hanbit.web.grade;

import java.util.HashMap;
import java.util.Map;

public interface GradeDAO {
	public int insert(GradeVO gradeVO);
	public int delete(String seq);
	public GradeVO findByPk(int seq);
	public int update(HashMap<String, Object> uptMap);
	public Map<Integer, GradeVO> selectAll(); 
}
