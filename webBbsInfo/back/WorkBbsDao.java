package health.back.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import health.back.a.dto.LikeBbsDto;
import health.back.a.dto.ReadCountBbsDto;
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
	
	// 동일 게시글 조회수 여부 확인
	public int checkReadCount(ReadCountBbsDto dto);
	
	// 게시판 글 조회수
	public void readcount(int seq);
	public int readCountInfo(ReadCountBbsDto dto);
	
	// 동일 게시글 좋아요 여부 확인
	public int checkLikeCount(LikeBbsDto dto);
	
	// 게시판 글 좋아요
	public void likeCount(int seq);
	public int likeInfo(LikeBbsDto dto);
	
	// 게시판 글 좋아요 취소
	public void likeCountCancel(int seq);
	public int likeCancel(LikeBbsDto dto);
	
	// 게시판 검색기능
	public List<WorkBbsDto> getBbsListSearch(WorkBbsParam param);
	
	// 게시판 페이징 기능
	public List<WorkBbsDto> getBbsListSearchPage(WorkBbsParam param);
	
	// 게시판 글 총 갯수
	public int getBbsCount(WorkBbsParam param);
}
