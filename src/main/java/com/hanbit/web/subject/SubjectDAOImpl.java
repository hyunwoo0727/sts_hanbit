package com.hanbit.web.subject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hanbit.web.member.MemberDAOImpl;
import com.hanbit.web.util.Constants;
import com.hanbit.web.util.DatabaseFactory;
import com.hanbit.web.util.Vendor;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :SubjectDAO.java
 * @story  :
*/

public class SubjectDAOImpl implements SubjectDAO {
	private static SubjectDAOImpl instance = new SubjectDAOImpl();
	private static final String NAMESPACE = "mapper.subject.";
	private SqlSessionFactory sqlSessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(SubjectDAOImpl.class);
	
	private SubjectDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("SubjectDAOImpl session build fail");
			e.printStackTrace();
		}
	}
	public static SubjectDAOImpl getInstance() {
		if(instance==null){
			instance = new SubjectDAOImpl();
		}
		return instance;
	}
	@Override
	public int insert(SubjectVO subVO) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.insert(NAMESPACE+"insert", subVO);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public int findById(String id) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.selectOne(NAMESPACE+"findById", id);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public SubjectVO findByPk(int subSeq) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.selectOne(NAMESPACE+"findByPk", subSeq);
		}finally {
			sqlsession.close();
		}
	}
	
	
	
}
