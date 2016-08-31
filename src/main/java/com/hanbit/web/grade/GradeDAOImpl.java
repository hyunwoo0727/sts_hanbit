package com.hanbit.web.grade;

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
 * @file   :GradeDao.java
 * @story  :
*/
@Repository
public class GradeDAOImpl implements GradeDAO {

	private static final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);
	private static GradeDAOImpl instance = GradeDAOImpl.getInstance();
	private static final String NAMESPACE = "mapper.grade.";
	private SqlSessionFactory sqlSessionFactory;
	
	private GradeDAOImpl() {
		try {
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			logger.info("GradeDAOImple session build fail");
			e.printStackTrace();
		}
	}
	public static GradeDAOImpl getInstance(){
		if(instance==null){
			instance = new GradeDAOImpl();
		}
		return instance;
	}
	@Override
	public int insert(GradeVO gradeVO) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.insert(NAMESPACE+"insert", gradeVO);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public int delete(String seq) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.delete(NAMESPACE+"delete", seq);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public GradeVO findByPk(int seq) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.selectOne(NAMESPACE+"findByPk", seq);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public int update(HashMap<String, Object> uptMap) {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try{
			return sqlsession.update(NAMESPACE+"update", uptMap);
		}finally {
			sqlsession.close();
		}
	}
	@Override
	public Map<Integer, GradeVO> selectAll() {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		List<GradeVO> tempList = sqlsession.selectList(NAMESPACE+"selectAll");
		Iterator<GradeVO> it = tempList.iterator();
		Map<Integer, GradeVO> tempMap = new HashMap<Integer,GradeVO>();
		while (it.hasNext()) {
			GradeVO gradeVO = (GradeVO) it.next();
			tempMap.put(gradeVO.getSeq(), gradeVO);
		}
		return tempMap;
	}
}
