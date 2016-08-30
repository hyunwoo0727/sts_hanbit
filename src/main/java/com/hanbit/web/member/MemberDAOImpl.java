package com.hanbit.web.member;

import java.io.IOException;
import java.io.InputStream;
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

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :MemberDao.java
 * @story  :
*/
@Repository
public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl instance = MemberDAOImpl.getInstance();
	private static final String NAMESPACE = "mapper.member.";
	private SqlSessionFactory sqlSessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private MemberDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("MemberDAOImpl session build fail");
			e.printStackTrace();
		}
		
	}
	public static MemberDAOImpl getInstance() {
		if(instance==null){
			instance = new MemberDAOImpl();
		}
		return instance;
	}
	@Override
	public int insert(MemberVO memVO){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.insert("insert",memVO);
		}finally {
			session.close();
		}
	}
	@Override
	public int updatePw(MemberVO memVO){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.update("updatePw",memVO);
		}finally {
			session.close();
		}
	}
	@Override
	public int deleteMember(String id){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.delete("deleteMember",id);
		}finally {
			session.close();
		}
	}
	@Override
	public MemberVO findByPK(String pk){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findByPK",pk);
		}finally {
			session.close();
		}
	} // id
	@Override
	public Map<String, MemberVO> selectMap() {
		SqlSession session = sqlSessionFactory.openSession();
		List<MemberVO> tempList = session.selectList(NAMESPACE+"selectAll","");
		Iterator<MemberVO> it = tempList.iterator();
		Map<String, MemberVO> tempMap = new HashMap<String, MemberVO>();
		while (it.hasNext()) {
			MemberVO memVO = (MemberVO) it.next();
			tempMap.put(memVO.getId(), memVO);
		}
		return tempMap;
	}
}
