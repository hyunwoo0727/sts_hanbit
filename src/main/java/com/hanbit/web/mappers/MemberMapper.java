package com.hanbit.web.mappers;


import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;

@Repository
public interface MemberMapper {
	/*public int insert(MemberDTO mBean);
	public int updatePw(MemberDTO mBean);
	public int deleteMember(String id);*/
	public MemberDTO findOne(Command command);
/*	public Map<String, MemberDTO> selectMap();*/
}
