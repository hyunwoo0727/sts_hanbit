package com.hanbit.web.util;

import com.hanbit.web.bank.AccountMemberVO;
import com.hanbit.web.bank.AccountServiceImp;
import com.hanbit.web.grade.GradeDAOImpl;
import com.hanbit.web.grade.GradeServiceImpl;
import com.hanbit.web.grade.GradeVO;
import com.hanbit.web.member.MemberServiceImpl;
import com.hanbit.web.member.MemberVO;
import com.hanbit.web.subject.SubjectServiceImpl;

/**
 * @date   :2016. 7. 19.
 * @author :HyunWoo Lee
 * @file   :Test.java
 * @story  :
*/

public class Test {
	public static void main(String[] args) {
	//	AccountMemberVO acmVO = AccountServiceImp.getInstance().findByAccountNo("1000003");
		//GradeVO gVO = GradeDAOImpl.getInstance().findByPk(1005);
		System.out.println(SubjectServiceImpl.getInstance().findByPk(1005).getId());
	}
}
