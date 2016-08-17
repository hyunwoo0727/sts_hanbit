/**
 * 
 */
package com.hanbit.web.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountServiceImp implements AccountService{
	private AccountDAO dao = AccountDAO.getInstance();
	private Map<?,?> map;
	private static AccountServiceImp instance = new AccountServiceImp();
	
	private AccountServiceImp() {
		this.map = new HashMap<String,AccountMemberBean>(); 
	}
	public static AccountServiceImp getInstance() {
		return instance;
	}
	@Override
	public String openAccount(String id) {
		// TODO Auto-generated method stub
		return dao.openAccount(id)!=0 ? "개설 완료" : "개설 실패";
	}
	@Override
	public AccountMemberBean findByAccountNo(String accNo) {
		// TODO Auto-generated method stub
		return dao.findByAccountNo(accNo);
	}
	@Override
	public String deposit(AccountMemberBean accBean) {
		if(accBean.getMoney() < 100){
			return "적어도 100원 이상 입금 가능합니다";
		}
		int result = dao.deposit(accBean);
		return result==0?"입금 오류":"입금후 잔액 : "+result;
	}
	@Override
	public List<?> list() {
		List<AccountMemberBean> tempList = (List<AccountMemberBean>) dao.selectList(null);
		
		return tempList;
	}
	@Override
	public String withdraw(AccountMemberBean withBean) {
		if(dao.getMoney(withBean.getAccountNo()) < withBean.getMoney()){
			return "잔액이 부족합니다";
		}
		int money = dao.withdraw(withBean);
		return money==0?"출금 오류":"출금 후 잔액 : " + money;
	}
	@Override
	public List<?> findBy(String name) {
		return dao.selectList(name);
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}
	@Override
	public String closeAccount(String accNo) {
		return dao.closeAccount(Integer.parseInt(accNo))!=0?"삭제 성공":"삭제 실패";
	}
	@Override
	public String updateAccount(AccountMemberBean uptBean) {
		// TODO Auto-generated method stub
		return dao.updateAccount(uptBean)!=0?"변경 완료":"변경 실패";
	}
	@Override
	public Map<?,?> map() {
		this.map = new HashMap<String,AccountMemberBean>(); 
		map = dao.selectMap();
		return map;
	}
}
