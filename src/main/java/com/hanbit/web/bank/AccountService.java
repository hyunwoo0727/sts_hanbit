/**
 * 
 */
package com.hanbit.web.bank;

import com.hanbit.web.util.CommonService;

/**
 * @date   : 2016. 6. 20.
 * @author : HyunWoo Lee
 * @file   : AccountService.java 
 * @story  : 
*/
public interface AccountService extends CommonService {

	public String openAccount(String id);
	public String deposit(AccountMemberVO accBean);
	public AccountMemberVO findByAccountNo(String accNo);
	public String withdraw(AccountMemberVO withBean);
	public int count();
	public String closeAccount(String accNo);
	public String updateAccount(AccountMemberVO uptBean);
	
}
