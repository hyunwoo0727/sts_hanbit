package com.hanbit.web.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.controllers.MemberController;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	private static MemberServiceImpl instance = MemberServiceImpl.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private Map<String,MemberDTO> map;
	@Autowired
	private SqlSession sqlSession;
	
	private MemberServiceImpl() {
		//accService=AccountServiceImp.getInstance();
	}
	public static MemberServiceImpl getInstance() {
		if(instance==null){
			instance = new MemberServiceImpl();
		}
		return instance;
	}
	
	
	@Override
	public MemberDTO login(MemberDTO inMem) {
		logger.info("===LOGIN=== ID : {}",inMem.getMemId());
		MemberDTO memDto = this.findByPK(inMem.getMemId());
		if(memDto!=null && memDto.getPw().equals(inMem.getPw())){	
			logger.info("=========LOGIN SUCCESS=========");
			return memDto;
		}
		logger.info("=========LOGIN FAIL=========");
		return null;
	}
	@Override
	public Map<String, MemberDTO> map() {
//		return mDao.selectMap();
		return null;
	}
/*	@Override
	public int regist(MemberDTO mVO) {
		if(mDao.findByPK(mVO.getId())==null){
			return mDao.insert(mVO);
		}
		return 0;
	}
	@Override
	public int update(MemberDTO mVO) {
		int result = mDao.updatePw(mVO);
		if(result==1){
			this.map.replace(mVO.getId(), mDao.findByPK(mVO.getId()));
		}
		return 0;
	}
	@Override
	public int delete(MemberDTO mVO) {
		int result = 0;
		MemberDTO temp = (MemberDTO) map.get(mVO.getMemId());
		if(temp.getPw().equals(mVO.getPw())){
	//		result = mDao.deleteMember(mVO.getId());
		}
		return result;
	}*/
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public MemberDTO findByPK(String pk) {
		logger.info("===FIND BY PK=== ID : {}",pk);
		return sqlSession.getMapper(MemberMapper.class).findByPK(pk);
	}
	@Override
	public List<MemberDTO> findBy(String word) {
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		List<MemberDTO> findList = new ArrayList<MemberDTO>();
		while(it.hasNext()){
			MemberDTO tempBean = (MemberDTO) map.get(it.next());
			if(tempBean.getName().contains(word)){
				findList.add(tempBean);
			}
		}
		return findList;
	}
	@Override
	public List<MemberDTO> list() {
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		List<MemberDTO> findList = new ArrayList<MemberDTO>();
		while(it.hasNext()){
			findList.add((MemberDTO) this.map.get(it.next()));
		}
		return findList;
	}
}
