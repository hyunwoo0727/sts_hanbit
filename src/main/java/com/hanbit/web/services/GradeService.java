package com.hanbit.web.services;

import java.util.List;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.domains.MajorDTO;
import com.hanbit.web.util.CommonService;



public interface GradeService extends CommonService{
	// 총 7가지 패턴 
	// exeU 
	//1.추가 2.수정 3.삭제 4.전체조회 5.학점을 포함한 시험내역 조회(SEQ) 6.시퀀스 조회(ID로)7.응시생수
	public String insert(GradeDTO grade);
	public String delete(String seq);
	// exeQ
	public String numberCheck(String[] scores);
	public GradeDTO findBySeq(int seq);
	public String update(String sData);
}
