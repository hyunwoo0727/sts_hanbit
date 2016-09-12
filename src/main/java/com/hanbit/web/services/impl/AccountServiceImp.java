/**
 * 
 */
package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.AccountDTO;
import com.hanbit.web.services.AccountService;
@Service
public class AccountServiceImp implements AccountService{
	private Map<Integer,AccountDTO> map;
	private static AccountServiceImp instance =  AccountServiceImp.getInstance();
	
	private AccountServiceImp() {
	//	this.map = this.map();
	}
	public static AccountServiceImp getInstance() {
		if(instance==null){
			instance = new AccountServiceImp();
		}
		return instance;
	}
	@Override
	public String openAccount(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AccountDTO findByAccountNo(String accNo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deposit(AccountDTO accBean) {
		if(accBean.getMoney() < 100){
			return "적어도 100원 이상 입금 가능합니다";
		}
		int result = 0;
		return result==0?"입금 오류":"입금후 잔액 : "+result;
	}
	@Override
	public List<AccountDTO> list() {
		return null;
	}
	@Override
	public String withdraw(AccountDTO withBean) {
		if(map.get(withBean.getAccountNo()).getMoney() < withBean.getMoney()){
			return "잔액이 부족합니다";
		}
		return null;
	}
	@Override
	public List<AccountDTO> findBy(String name) {
		
		return null;
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public String closeAccount(String accNo) {
		return null;
	}
	@Override
	public String updateAccount(AccountDTO uptBean) {
		return null;
	}
	@Override
	public Map<Integer,AccountDTO> map() {
		return null;
	}
}
