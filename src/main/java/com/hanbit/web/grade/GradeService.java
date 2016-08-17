package com.hanbit.web.grade;

import com.hanbit.web.global.CommonService;



public interface GradeService extends CommonService{
	// 총 7가지 패턴 
	// exeU 
	//1.추가 2.수정 3.삭제 4.전체조회 5.학점을 포함한 시험내역 조회(SEQ) 6.시퀀스 조회(ID로)7.응시생수
	public String insert(GradeBean grade);
	public String delete(String seq);
	// exeQ
	public String numberCheck(String[] scores);
	public GradeBean findBySeq(String seq);
	public String update(String sData);
}
