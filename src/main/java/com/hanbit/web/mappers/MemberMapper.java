package com.hanbit.web.mappers;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.MemberDTO;

@Repository
public interface MemberMapper {
	/*public int insert(MemberDTO mBean);
	public int updatePw(MemberDTO mBean);
	public int deleteMember(String id);*/
	public MemberDTO findByPK(@Param("pk") String pk);
/*	public Map<String, MemberDTO> selectMap();*/
}
