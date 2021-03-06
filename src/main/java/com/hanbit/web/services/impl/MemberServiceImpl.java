package com.hanbit.web.services.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Param;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.mappers.MemberMapper;
import com.hanbit.web.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	private static MemberServiceImpl instance = MemberServiceImpl.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private Command command;
	@Autowired
	private Retval retval;
	
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
		command.setKeyField("mem_id");
		command.setKeyword(inMem.getMemId());
		MemberDTO memDto = this.findOne(command);
		if(memDto!=null && memDto.getPw().equals(inMem.getPw())){
			logger.info("=========LOGIN SUCCESS=========");
			return memDto;
		}else{
			logger.info("=========LOGIN FAIL=========");
			return null;
		}
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
	public MemberDTO findOne(Command command) {
		logger.info("===FIND BY ONE === keyField : {}",command.getKeyField());
		logger.info("===FIND BY ONE === KEYWORD : {}",command.getKeyword());
		Map<String,Object> map = new HashMap<String,Object>();
		ResultSet rs = null;
		map.put("keyField", command.getKeyField());
		map.put("keyword", command.getKeyword());
		map.put("start", 1);
		map.put("end", 1);
		map.put("result", rs);
		sqlSession.getMapper(MemberMapper.class).find(map);
		@SuppressWarnings("unchecked")
		List<MemberDTO> list = (ArrayList<MemberDTO>)map.get("result");
		return list.size()==0?null:list.get(0);
	}
	@Override
	public List<MemberDTO> list(Command command) {
	/*	Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		List<MemberDTO> findList = new ArrayList<MemberDTO>();
		while(it.hasNext()){
			MemberDTO tempBean = (MemberDTO) map.get(it.next());
			if(tempBean.getName().contains(word)){
				findList.add(tempBean);
			}
		}
		return findList;*/
		logger.info("===LIST === START : {}",command.getStart());
		logger.info("===LIST === END: {}",command.getEnd());
		Map<String,Object> map = new HashMap<String,Object>();
		ResultSet rs = null;
		map.put("start", command.getStart());
		map.put("end", command.getEnd());
		map.put("result", rs);
		sqlSession.getMapper(MemberMapper.class).studentList(map);
		@SuppressWarnings("unchecked")
		List<MemberDTO> list = (ArrayList<MemberDTO>)map.get("result");
		return list;
	}
/*	@Override
	public List<MemberDTO> list() {
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		List<MemberDTO> findList = new ArrayList<MemberDTO>();
		while(it.hasNext()){
			findList.add((MemberDTO) this.map.get(it.next()));
		}
		return findList;
	}*/
	@Override
	public int existId(String id) {
		logger.info("===EXIST ID === ID : {}",id);
		return sqlSession.getMapper(MemberMapper.class).existId(id);
	}
	@Override
	public String regist(MemberDTO memDto) {
		logger.info("===REGIST MEMBER === ID : {}",memDto.getMemId());
		memDto.setGender(this.getGender(memDto.getSsn()));
		memDto.setRegDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())));
		memDto.setRole("STUDENT");
		memDto.setProfileImg("default.jpg");
		memDto.setMajorSeq(1011);
		return sqlSession.getMapper(MemberMapper.class).insert(memDto)==-1?"success":"fail";
	}
	@Override
	public String deleteStudent(String memId) {
		logger.info("===REGIST MEMBER === ID : {}",memId);
		return sqlSession.getMapper(MemberMapper.class).deleteStudent(memId)==-1?"SUCCESS":"FAIL";
	}
	@Override
	public String updateStudent(MemberDTO memDto) {
		logger.info("===UPDATE MEMBER === ID : {}",memDto.getMemId());
		return sqlSession.getMapper(MemberMapper.class).updateStudent(memDto)==-1?"SUCCESS":"FAIL";
	}
	public String getGender(String ssn){
		return (Integer.parseInt(ssn.split("-")[1])+10)%2==1?"MALE":"FEMALE";
	}
	@Override
	public Retval studentCnt() {
		logger.info("===STUDENT COUNT ===");
		sqlSession.getMapper(MemberMapper.class).countStudent(retval);
		return retval;
	}
	@Override
	public List<MemberDTO> find(Command command) {
		logger.info("===STUDENT FIND ===");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyword", command.getKeyword());
		map.put("keyField", command.getKeyField());
		map.put("start", command.getStart());
		map.put("end", command.getEnd());
		ResultSet rs = null;
		map.put("result", rs);
		sqlSession.getMapper(MemberMapper.class).find(map);
		return (List<MemberDTO>) map.get("result");
	}
	@Override
	public Retval searchCnt(Command command) {
		logger.info("===STUDENT COUNT ===");
		retval.setFlag(command.getKeyField());
		retval.setMessage(command.getKeyword());
		System.out.println(retval);
		sqlSession.getMapper(MemberMapper.class).searchCount(retval);
		return retval;
	}
}