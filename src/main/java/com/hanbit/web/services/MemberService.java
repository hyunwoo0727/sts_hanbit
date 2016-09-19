/**
 * 
 */
package com.hanbit.web.services;

import org.springframework.stereotype.Repository;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.util.CommonService;

/**
 * @date   : 2016. 6. 17.
 * @author : HyunWoo Lee
 * @file   : StudentService.java 
 * @story  : 
*/
@Repository
public interface MemberService extends CommonService{
/*	public int regist(MemberDTO mBean);
	public int update(MemberDTO mBean);
	public int delete(MemberDTO mBean);*/
	public MemberDTO findOne(Command command);
	public MemberDTO login(MemberDTO mBean);
}
