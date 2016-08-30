/**
 * 
 */
package com.hanbit.web.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class AccountServiceImp implements AccountService{
	private AccountDAOImpl aDao; 
	private Map<Integer,AccountMemberVO> map;
	private static AccountServiceImp instance =  AccountServiceImp.getInstance();
	
	private AccountServiceImp() {
		this.aDao = AccountDAOImpl.getInstance();
		this.map = this.map();
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
		return aDao.openAccount(id)!=0 ? "개설 완료" : "개설 실패";
	}
	@Override
	public AccountMemberVO findByAccountNo(String accNo) {
		// TODO Auto-generated method stub
		return aDao.findByPk(Integer.parseInt(accNo));
	}
	@Override
	public String deposit(AccountMemberVO accBean) {
		if(accBean.getMoney() < 100){
			return "적어도 100원 이상 입금 가능합니다";
		}
		int result = aDao.deposit(accBean);
		return result==0?"입금 오류":"입금후 잔액 : "+result;
	}
	@Override
	public List<AccountMemberVO> list() {
		return (List<AccountMemberVO>) this.map.values();
	}
	@Override
	public String withdraw(AccountMemberVO withBean) {
		if(map.get(withBean.getAccountNo()).getMoney() < withBean.getMoney()){
			return "잔액이 부족합니다";
		}
		int money = aDao.withdraw(withBean);
		return money==0?"출금 오류":"출금 후 잔액 : " + money;
	}
	@Override
	public List<AccountMemberVO> findBy(String name) {
		List<AccountMemberVO> tempList = new ArrayList<AccountMemberVO>();
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			AccountMemberVO acmVO = map.get(it.next());
			if(acmVO.getName().contains(name)){
				tempList.add(acmVO);
			}
		}
		return tempList;
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public String closeAccount(String accNo) {
		return aDao.closeAccount(Integer.parseInt(accNo))!=0?"삭제 성공":"삭제 실패";
	}
	@Override
	public String updateAccount(AccountMemberVO uptBean) {
		// TODO Auto-generated method stub
		return aDao.updateAccount(uptBean)!=0?"변경 완료":"변경 실패";
	}
	@Override
	public Map<Integer,AccountMemberVO> map() {
		return aDao.selectAll();
	}
}
