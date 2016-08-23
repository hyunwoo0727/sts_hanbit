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
	public String deposit(AccountMemberBean accBean);
	public AccountMemberBean findByAccountNo(String accNo);
	public String withdraw(AccountMemberBean withBean);
	public int count();
	public String closeAccount(String accNo);
	public String updateAccount(AccountMemberBean uptBean);
	
}
