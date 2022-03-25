package health.back.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import health.back.a.dao.WorkBbsDao;
import health.back.a.dto.WorkBbsDto;
import health.back.a.dto.WorkBbsParam;

@Service
@Transactional
public class WorkBbsService {
	
	@Autowired
	WorkBbsDao dao;

	// 게시판 전체리스트 불러오기
	public List<WorkBbsDto> getBbsList(){
		return dao.getBbsList();
	}
	
	// 게시판 글 작성
	public boolean writeBbs(WorkBbsDto dto) {
		int n = dao.writeBbs(dto);
		return n>0?true:false;
	}
	
	// 선택한 게시글 불러오기(detail)
	public WorkBbsDto bbsDetail(int seq) {
		return dao.bbsDetail(seq);
	}
	
	// 게시판 글 수정
	public boolean updateBbs(WorkBbsDto dto) {
		int n = dao.updateBbs(dto);		
		return n>0?true:false;
	}
	
	// 게시판 글 삭제
	public boolean deleteBbs(int seq) {
		int n = dao.deleteBbs(seq);
		return n>0?true:false;
	}
	
	// 게시판 글 조회수
	public void readcount(int seq) {
		dao.readcount(seq);
	}
	
	// 게시판 검색기능
	public List<WorkBbsDto> getBbsListSearch(WorkBbsParam param) {
		return dao.getBbsListSearch(param);
	}
	
	// 게시판 페이징 기능
	public List<WorkBbsDto> getBbsListSearchPage(WorkBbsParam param) {
		return dao.getBbsListSearchPage(param);
	}
	
	// 게시판 글 총 갯수
	public int getBbsCount(WorkBbsParam param) {
		return dao.getBbsCount(param);
	}
}








