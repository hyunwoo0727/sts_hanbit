package com.hanbit.web.member;

import java.util.Map;

public interface MemberDAO {
	public int insert(MemberVO mBean);
	public int updatePw(MemberVO mBean);
	public int deleteMember(String id);
	public MemberVO findByPK(String pk);
	public Map<String, MemberVO> selectMap();
}
