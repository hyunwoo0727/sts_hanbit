package com.hanbit.web.mappers;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;

@Repository
public interface MemberMapper {
	/*public int insert(MemberDTO mBean);
	public int updatePw(MemberDTO mBean);
	public int deleteMember(String id);*/
	public MemberDTO findOne(Command command);
	public MemberDTO findOne2(Map<String, Object> params);
	public int existId(String id);
	public int insert(MemberDTO memDto);
	public int deleteStudent(String memId);
	public int updateStudent(MemberDTO memDto);
/*	public Map<String, MemberDTO> selectMap();*/
}
