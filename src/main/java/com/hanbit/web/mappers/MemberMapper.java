package com.hanbit.web.mappers;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;

@Repository
public interface MemberMapper {
	/*public int insert(MemberDTO mBean);
	public int updatePw(MemberDTO mBean);
	public int deleteMember(String id);*/
	public List<?> find(Map<String, Object> params);
	public List<MemberDTO> studentList(Map<String, Object> params);
	public int existId(String id);
	public int insert(MemberDTO memDto);
	public int deleteStudent(String memId);
	public int updateStudent(MemberDTO memDto);
	public Retval countStudent(Retval retval);
/*	public Map<String, MemberDTO> selectMap();*/
	public Retval searchCount(Retval retval);
}
