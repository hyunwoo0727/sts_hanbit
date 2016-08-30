package com.hanbit.web.bank;

import java.util.Map;

public interface AccountDAO {
	public int openAccount(String id);
	public AccountMemberVO findByPk(int accNo);
	public int deposit(AccountMemberVO acmVO);
	public int withdraw(AccountMemberVO acmVO);
	public int closeAccount(int accNo);
	public int updateAccount(AccountMemberVO acmVO);
	public Map<Integer, AccountMemberVO> selectAll();
}