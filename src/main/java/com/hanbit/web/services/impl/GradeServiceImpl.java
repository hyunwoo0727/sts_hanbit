package com.hanbit.web.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.domains.MajorDTO;
import com.hanbit.web.services.GradeService;
@Service
public class GradeServiceImpl implements GradeService{
	private static GradeServiceImpl instance = GradeServiceImpl.getInstance();
	private Map<Integer, GradeDTO> map;
	
	private GradeServiceImpl() {
		this.map = this.map();
	}
	public static GradeServiceImpl getInstance() {
		if(instance==null){
			instance = new GradeServiceImpl();
		}
		return instance;
	}
	@Override
	public String insert(GradeDTO grade) {
		// TODO Auto-generated method stub
	//	grade.setGrade(getGrade(grade));
//		return gDao.insert(grade)!=0?"입력 완료":"입력 실패";
		return null;
	}
	@Override
	public String delete(String seq) {
		// TODO Auto-generated method stub
		//return gDao.delete(seq)!=0?"삭제 성공":"삭제 실패 시퀀스를 확인바랍니다";
		return null;
	}
	@Override
	public List<GradeDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return map.size();
	}
	public static String getGrade(GradeDTO bean){
		String grade = "";
	/*	switch ((bean.getJava()+bean.getSql()+bean.getHtml()+bean.getJavascript())/4/10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}*/
		return grade;
	}
	public String numberCheck(String[] scores){
		int i=0;
		for (; i < scores.length-2; i++) {
			if(Integer.parseInt(scores[i])<0 ||  Integer.parseInt(scores[i]) > 100){
				return "0에서 100사이 점수만 입력 가능";
			}
		}
		GradeDTO gdBean = new GradeDTO();
		return this.insert(gdBean);
		
	}
	@Override
	public GradeDTO findBySeq(int seq) {
	//	return gDao.findByPk(seq);
		return null;
	}
	@Override
	public List<GradeDTO> findBy(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String update(String sData) {
		HashMap<String, Object> tempMap = new HashMap<String,Object>();
		String[] arData = sData.split(",");
		tempMap.put("subject", arData[0]);
		tempMap.put("score", Integer.parseInt(arData[1]));
		tempMap.put("seq", Integer.parseInt(arData[2]));
		//return gDao.update(tempMap)!=0 ? "수정 완료" : "수정 실패";
		return null;	}
	@Override
	public Map<Integer, GradeDTO> map() {
	//	return gDao.selectAll();
		return null;
	}

}
