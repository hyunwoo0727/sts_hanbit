package com.hanbit.web.util;



import java.util.Comparator;

import com.hanbit.web.bank.AccountMemberVO;



/**
 * @date   :2016. 7. 8.
 * @author :HyunWoo Lee
 * @file   :NameAccSort.java
 * @story  :
*/

public class NameAscSort implements Comparator<AccountMemberVO> {
	
	@Override
	public int compare(AccountMemberVO first, AccountMemberVO second) {
		// TODO Auto-generated method stub
		return first.getName().compareTo(second.getName());
	}
	
}
