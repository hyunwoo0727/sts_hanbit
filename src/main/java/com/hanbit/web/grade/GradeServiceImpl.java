package com.hanbit.web.grade;

import java.util.List;
import java.util.Map;

public class GradeServiceImpl implements GradeService{
	GradeDAO dao = GradeDAO.getInstance();
	private static GradeServiceImpl instance = new GradeServiceImpl();
	
	private GradeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	@Override
	public String insert(GradeBean grade) {
		// TODO Auto-generated method stub
		grade.setGrade(getGrade(grade));
		return dao.insert(grade)!=0?"입력 완료":"입력 실패";
	}
	@Override
	public String delete(String seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq)!=0?"삭제 성공":"삭제 실패 시퀀스를 확인바랍니다";
	}
	@Override
	public List<GradeBean> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count("");
	}
	public static String getGrade(GradeBean bean){
		String grade = "";
		switch ((bean.getJava()+bean.getSql()+bean.getHtml()+bean.getJavascript())/4/10) {
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
		}
		return grade;
	}
	public String numberCheck(String[] scores){
		int i=0;
		for (; i < scores.length-2; i++) {
			if(Integer.parseInt(scores[i])<0 ||  Integer.parseInt(scores[i]) > 100){
				return "0에서 100사이 점수만 입력 가능";
			}
		}
		GradeBean gdBean = new GradeBean(scores[5], scores[4], scores[0], scores[1], scores[2], scores[3]);
		return this.insert(gdBean);
		
	}
	@Override
	public GradeBean findBySeq(String seq) {
		return dao.findBySeq(seq);
	}
	@Override
	public List<GradeBean> findBy(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	@Override
	public String update(String sData) {
		// TODO Auto-generated method stub
		return dao.update(sData.split(","))!=0 ? "수정 완료" : "수정 실패";
	}
	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
}
