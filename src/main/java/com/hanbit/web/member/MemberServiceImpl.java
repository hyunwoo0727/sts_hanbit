package com.hanbit.web.member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.subject.SubjectVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	private MemberDAOImpl mDao;
	private SubjectDAOImpl sDao;
	@Autowired private AccountService accService;
	private static MemberServiceImpl instance = MemberServiceImpl.getInstance();
	private Map<String,MemberVO> map;
	@Autowired private SubjectMemberVO sm;
	private MemberServiceImpl() {
		mDao = MemberDAOImpl.getInstance();
		sDao = SubjectDAOImpl.getInstance();
		//accService=AccountServiceImp.getInstance();
	}
	public static MemberServiceImpl getInstance() {
		if(instance==null){
			instance = new MemberServiceImpl();
		}
		return instance;
	}
	@Override
	public SubjectMemberVO login(MemberVO mVO) {
		if(this.checkLogin(mVO)){	
			this.map = this.map();
		//	accService.map();
			SubjectVO sb = sDao.findByPk(sDao.findById(mVO.getId()));
			MemberVO mb = map.get(mVO.getId());
			return this.makeSM(mb, sb);
		}
		return null;
	}
	@Override
	public Map<String, MemberVO> map() {
		return mDao.selectMap();
	}
	@Override
	public int regist(MemberVO mVO) {
		if(mDao.findByPK(mVO.getId())==null){
			return mDao.insert(mVO);
		}
		return 0;
	}
	@Override
	public int update(MemberVO mVO) {
		int result = mDao.updatePw(mVO);
		if(result==1){
			this.map.replace(mVO.getId(), mDao.findByPK(mVO.getId()));
		}
		return result;
	}
	@Override
	public int delete(MemberVO mVO) {
		int result = 0;
		MemberVO temp = (MemberVO) map.get(mVO.getId());
		if(temp.getPw().equals(mVO.getPw())){
			result = mDao.deleteMember(mVO.getId());
		}
		return result;
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public MemberVO findById(String id) {
		
		return mDao.findByPK(id);
	}
	@Override
	public List<MemberVO> findBy(String word) {
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		List<MemberVO> findList = new ArrayList<MemberVO>();
		while(it.hasNext()){
			MemberVO tempBean = (MemberVO) map.get(it.next());
			if(tempBean.getName().contains(word)){
				findList.add(tempBean);
			}
		}
		return findList;
	}
	@Override
	public List<MemberVO> list() {
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		List<MemberVO> findList = new ArrayList<MemberVO>();
		while(it.hasNext()){
			findList.add((MemberVO) this.map.get(it.next()));
		}
		return findList;
	}
	public boolean checkLogin(MemberVO mVO) {
		boolean loginOk = false;
		MemberVO m = mDao.findByPK(mVO.getId());
		if(m!=null && m.getPw().equals(mVO.getPw())){
			loginOk = true;
		}
		return loginOk;
	}
	public SubjectMemberVO makeSM(MemberVO mb,SubjectVO sb){
		sm.setId(mb.getId());
		sm.setPw(mb.getPw());
		sm.setName(mb.getName());
		sm.setEmail(mb.getEmail());
		sm.setSsn(mb.getSsn());
		sm.setPhone(mb.getPhone());
		sm.setProfileImg(mb.getProfileImg());
		sm.setRegDate(mb.getRegDate());
		sm.setMajor(sb.getMajor());
		sm.setSubjects(sb.getSubjects());
		return sm;
	}
	@Override
	public SubjectMemberVO findSmById(String id) {
		MemberVO mb = mDao.findByPK(id);
		SubjectVO sb = sDao.findByPk(sDao.findById(id));
		return this.makeSM(mb, sb);
	}
}
