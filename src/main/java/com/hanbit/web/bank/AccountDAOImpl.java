package com.hanbit.web.bank;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;


/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :BankDao.java
 * @story  :
*/
@Repository
public class AccountDAOImpl implements AccountDAO{
	private static AccountDAOImpl instance = AccountDAOImpl.getInstance();
	private static final String NAMESPACE = "mapper.account.";
	private SqlSessionFactory sqlSessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	
	private AccountDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("AccountDAOImpl session build fail");
			e.printStackTrace();
		}
	}
	public static AccountDAOImpl getInstance() {
		if(instance==null){
			instance = new AccountDAOImpl();
		}
		return instance;
	}
	@Override
	public int openAccount(String id) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.insert(NAMESPACE+"openAccount", id);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public AccountMemberVO findByPk(int accNo) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.selectOne(NAMESPACE+"findByPk", accNo);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public int deposit(AccountMemberVO acmVO) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.update(NAMESPACE+"deposit", acmVO);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public int withdraw(AccountMemberVO acmVO) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.update(NAMESPACE+"withdraw", acmVO);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public int closeAccount(int accNo) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.delete(NAMESPACE+"closeAccount", accNo);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public int updateAccount(AccountMemberVO acmVO) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.update(NAMESPACE+"updateAccount", acmVO);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public Map<Integer, AccountMemberVO> selectAll() {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		List<AccountMemberVO> tempList = sqlsession.selectList(NAMESPACE+"selectAll");
		Iterator<AccountMemberVO> it = tempList.iterator();
		Map<Integer, AccountMemberVO> tempMap = new HashMap<Integer,AccountMemberVO>();
		while (it.hasNext()) {
			AccountMemberVO acmVO = (AccountMemberVO) it.next();
			tempMap.put(acmVO.getAccountNo(), acmVO);
		}
		return tempMap;
	}
	
}
