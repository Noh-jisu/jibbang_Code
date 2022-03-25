package health.back.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import health.back.a.dto.WorkBbsDto;
import health.back.a.dto.WorkBbsParam;

@Mapper
@Repository
public interface WorkBbsDao {

	// 게시판 전체리스트 불러오기
	public List<WorkBbsDto> getBbsList();
	
	// 게시판 글 작성
	public int writeBbs(WorkBbsDto dto);
	
	// 선택한 게시글 불러오기(detail)
	public WorkBbsDto bbsDetail(int seq);
	
	// 게시판 글 수정
	public int updateBbs(WorkBbsDto dto);
	
	// 게시판 글 삭제
	public int deleteBbs(int seq);
	
	// 게시판 글 조회수
	public void readcount(int seq);
	
	// 게시판 검색기능
	public List<WorkBbsDto> getBbsListSearch(WorkBbsParam param);
	
	// 게시판 페이징 기능
	public List<WorkBbsDto> getBbsListSearchPage(WorkBbsParam param);
	
	// 게시판 글 총 갯수
	public int getBbsCount(WorkBbsParam param);
}
