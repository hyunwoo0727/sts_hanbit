/**
 * 
 */
package com.hanbit.web.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.util.CommonService;

/**
 * @date   : 2016. 6. 17.
 * @author : HyunWoo Lee
 * @file   : StudentService.java 
 * @story  : 
*/
@Repository
public interface MemberService{
/*	public int regist(MemberDTO mBean);
	public int update(MemberDTO mBean);
	public int delete(MemberDTO mBean);*/
	public String regist(MemberDTO memDto);
	public String deleteStudent(String memId);
	public String updateStudent(MemberDTO memDto);
	public List<MemberDTO> list(Command command);
	public List<MemberDTO> find(Command command);
	public MemberDTO findOne(Command command);
	public MemberDTO login(MemberDTO memDto);
	public int existId(String id);
	public Retval studentCnt();
	public Retval searchCnt(Command command);
}