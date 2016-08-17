package com.hanbit.web.global;

import java.util.Comparator;

import com.hanbit.web.bank.AccountMemberBean;


/**
 * @date   :2016. 7. 8.
 * @author :HyunWoo Lee
 * @file   :NameAccSort.java
 * @story  :
*/

public class AccountNoAscSort2 implements Comparator<AccountMemberBean> {

	@Override
	public int compare(AccountMemberBean first, AccountMemberBean second) {
		// TODO Auto-generated method stub
		int a = 0;
		if(first.getAccountNo() > second.getAccountNo()){
			a = 1;
		}else{
			if(first.getAccountNo()<second.getAccountNo()){
				a = -1;
			}else{
				a = 0;
			}
		}
//		return String.valueOf(first.getAccountNo()).compareTo(String.valueOf(second.getAccountNo()));
		return a;
	}
	
}
