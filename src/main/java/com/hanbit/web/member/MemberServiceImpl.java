package com.hanbit.web.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImp;
import com.hanbit.web.subject.SubjectVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	private Map<String,MemberVO> map;
	private MemberDAOImpl mDao;
	private SubjectDAOImpl sdao = SubjectDAOImpl.getInstance();
	
	AccountService accService;
	
	private static MemberServiceImpl instance = MemberServiceImpl.getInstance();
	
	private MemberServiceImpl() {
		mDao = MemberDAOImpl.getInstance();
		accService=AccountServiceImp.getInstance();
	}
	public static MemberServiceImpl getInstance() {
		if(instance==null){
			instance = new MemberServiceImpl();
		}
		return instance;
	}
	@Override
	public SubjectMemberVO login(MemberVO mVO) {
		SubjectMemberVO sm = null;
		if(this.checkLogin(mVO)){	
			this.map();
			accService.map();
			sm = new SubjectMemberVO();
			SubjectVO sb = sdao.findByPk(1005);
			MemberVO mb = map.get(mVO.getId());
			sm = this.makeSM(mb, sb);
		}
		return sm;
	}
	@Override
	public Map<String, MemberVO> map() {
		this.map = new HashMap<String,MemberVO>(); 
		map = mDao.selectMap();
		System.out.println(map.size()+"ㅋㅋㅋ");
		return map;
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
		return map.values().size();
	}
	@Override
	public MemberVO findById(String id) {
		
		return mDao.findByPK(id);
	}
	@Override
	public List<MemberVO> findBy(String word) {
		List<MemberVO> findList = new ArrayList<MemberVO>();
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		while(it.hasNext()){
			MemberVO tempBean = (MemberVO) map.get(it.next());
			if(tempBean.getName().contains(word)){
				findList.add(tempBean);
			}
		}
		return findList;
	}
	@Override
	public ArrayList<MemberVO> list() {
		ArrayList<MemberVO> allList = new ArrayList<MemberVO>();
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		while(it.hasNext()){
			allList.add((MemberVO) this.map.get(it.next()));
		}
		return allList;
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
		SubjectMemberVO sm = new SubjectMemberVO();
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
		SubjectVO sb = sdao.findByPk(sdao.findById(id));
		return this.makeSM(mb, sb);
	}
}
