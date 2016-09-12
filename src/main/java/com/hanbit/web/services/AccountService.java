/**
 * 
 */
package com.hanbit.web.services;

import com.hanbit.web.domains.AccountDTO;
import com.hanbit.web.util.CommonService;

/**
 * @date   : 2016. 6. 20.
 * @author : HyunWoo Lee
 * @file   : AccountService.java 
 * @story  : 
*/
public interface AccountService extends CommonService {

	public String openAccount(String id);
	public String deposit(AccountDTO accBean);
	public AccountDTO findByAccountNo(String accNo);
	public String withdraw(AccountDTO withBean);
	public int count();
	public String closeAccount(String accNo);
	public String updateAccount(AccountDTO uptBean);
	
}
