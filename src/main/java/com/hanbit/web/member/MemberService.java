/**
 * 
 */
package com.hanbit.web.member;

import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.util.CommonService;

/**
 * @date   : 2016. 6. 17.
 * @author : HyunWoo Lee
 * @file   : StudentService.java 
 * @story  : 
*/
public interface MemberService extends CommonService{
	public int regist(MemberVO mBean);
	public int update(MemberVO mBean);
	public int delete(MemberVO mBean);
	public MemberVO findById(String id);
	public SubjectMemberVO login(MemberVO mBean);
	public SubjectMemberVO findSmById(String id);
}
