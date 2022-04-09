package health.back.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import health.back.a.dto.LikeBbsDto;
import health.back.a.dto.ReadCountBbsDto;
import health.back.a.dto.WorkBbsDto;
import health.back.a.dto.WorkBbsParam;
import health.back.a.service.WorkBbsService;

@RestController
public class WorkBbsController {
	
	@Autowired
	WorkBbsService sv;
	
	// 게시판 전체리스트 불러오기
	@RequestMapping(value = "/getBbsList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<WorkBbsDto> getBbsList(){
		System.out.println("게시판 리스트 불러오기 " + new Date());
		
		// 클라이언트로 보내줄 데이터 확인
		List<WorkBbsDto> list = sv.getBbsList();
		System.out.println(list);
		
		return list;
	}
	
	// 게시판 글 작성_Web
	@RequestMapping(value = "/writebbs", method = {RequestMethod.GET, RequestMethod.POST})
	public String writebbs(WorkBbsDto dto) {
		// 클라이언트에서 받은 데이터 확인
		System.out.println("받은데이터 : " + dto);
		
		boolean b = sv.writeBbs(dto);
		if(b) {
			// 게시글 작성 성공
			return "success";
		}
		// 게시글 작성 실패
		return "fail";
	}
	
	// 게시판 글 작성_App
	@RequestMapping(value = "/writebbs_M", method = {RequestMethod.GET, RequestMethod.POST})
	public String writebbs_M(@RequestBody WorkBbsDto dto) {
		// 클라이언트에서 받은 데이터 확인
		System.out.println("받은데이터 : " + dto);
		
		boolean b = sv.writeBbs(dto);
		if(b) {
			// 게시글 작성 성공
			return "success";
		}
		// 게시글 작성 실패
		return "fail";
	}
	
	// 선택한 게시글 불러오기_Web
	@RequestMapping(value = "/bbsDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public WorkBbsDto bbsDetail(ReadCountBbsDto dto) {
		// 클라이언트에서 받은 seq번호 확인
		System.out.println("받은 seq번호(조회수 테스트) : " + dto.getBbs_seq());
		System.out.println("받은 ID값(조회수 테스트) : " + dto.getUser_id());
		
		// 게시글 seq번호
		int seq = dto.getBbs_seq();
		// 로그인 유저 id
		String id = dto.getUser_id();
		
		WorkBbsDto bbs = sv.bbsDetail(seq);
		
		boolean b = sv.checkReadCount(dto);
		System.out.println("현재 b의값 : " + b);

		// 디테일 누를때마다 조회수 1씩 증가
		if(!bbs.getId().equals(id)) { // 게시글 id와 로그인유저 id가 다를경우
			if(b) {
				System.out.println("게시물 반복한적 있음");
			}else { // 해당 게시물 첫 조회시 실행
				System.out.println("조회수증가 실행");
				// 조회수 테이블에 유저정보 및 게시글seq번호 저장
				boolean r = sv.readCountInfo(dto);
				
				if(r) { // 조회수 테이블에 저장 성공시
					System.out.println("조회수 테이블 저장 성공 및 조회수 1증가 실행(최종)");
					sv.readcount(seq);
				}else {
					System.out.println("모종의 이유로 조회수테이블 저장 실패");
				}
			}
		}
		
		// 클라이언트로 보내줄 데이터 확인
		bbs = sv.bbsDetail(seq);
		System.out.println("클라이언트로 보낼 게시글 데이터 : " + bbs);
		
		return bbs;
	}
		
	// 선택한 게시글 불러오기_App
	@RequestMapping(value = "/bbsDetail_M", method = {RequestMethod.GET, RequestMethod.POST})
	public WorkBbsDto bbsDetail_M(@RequestBody ReadCountBbsDto dto) {
		// 클라이언트에서 받은 seq번호 확인
		System.out.println("받은 seq번호(조회수 테스트) : " + dto.getBbs_seq());
		System.out.println("받은 ID값(조회수 테스트) : " + dto.getUser_id());
		
		// 게시글 seq번호
		int seq = dto.getBbs_seq();
		// 로그인 유저 id
		String id = dto.getUser_id();
		
		WorkBbsDto bbs = sv.bbsDetail(seq);
		
		boolean b = sv.checkReadCount(dto);
		System.out.println("현재 b의값 : " + b);

		// 디테일 누를때마다 조회수 1씩 증가
		if(!bbs.getId().equals(id)) { // 게시글 id와 로그인유저 id가 다를경우
			if(b) {
				System.out.println("게시물 반복한적 있음");
			}else { // 해당 게시물 첫 조회시 실행
				System.out.println("조회수증가 실행");
				// 조회수 테이블에 유저정보 및 게시글seq번호 저장
				boolean r = sv.readCountInfo(dto);
				
				if(r) { // 조회수 테이블에 저장 성공시
					System.out.println("조회수 테이블 저장 성공 및 조회수 1증가 실행(최종)");
					sv.readcount(seq);
				}else {
					System.out.println("모종의 이유로 조회수테이블 저장 실패");
				}
			}
		}
		
		// 클라이언트로 보내줄 데이터 확인
		bbs = sv.bbsDetail(seq);
		System.out.println("클라이언트로 보낼 게시글 데이터 : " + bbs);
		
		return bbs;
	}
	
	// 게시글 좋아요 기능
	@RequestMapping(value = "/likeCount", method = {RequestMethod.GET, RequestMethod.POST})
	public void likeCount(int seq) {
		// 클라이언트에서 받은 seq번호 확인
		System.out.println("받은 seq번호(게시글 좋아요) : " + seq);
		
		sv.likeCount(seq);
	}
	
	// 게시글 좋아요 기능 웹 테스트
		@RequestMapping(value = "/likeCount_W", method = {RequestMethod.GET, RequestMethod.POST})
		public String likeCount_W(LikeBbsDto dto) {
			// 클라이언트에서 받은 정보 확인
			System.out.println("받은 정보(게시글 좋아요) : " + dto);
			
			boolean b = sv.checkLikeCount(dto);
			System.out.println("현재 b의 값 : " + b);
			
			if(b) { // 해당 게시판 좋아요 기록 있을때
				System.out.println("좋아요 누른적이 있습니다");
				return "notCount";
			}else { // 해당 게시판 좋아요 기록 없을때
				sv.likeInfo(dto);
				sv.likeCount(dto.getBbs_no());
				System.out.println("좋아요를 눌렀습니다");
				return "count";
			}
			
		}
	
	// 게시글 좋아요 취소기능
	@RequestMapping(value = "/likeCountCancel", method = {RequestMethod.GET, RequestMethod.POST})
	public void likeCountCancel(int seq) {
		// 클라이언트에서 받은 seq번호 확인
		System.out.println("받은 seq번호(좋아요 취소) : " + seq);
		
		sv.likeCountCancel(seq);
	}
	
	// 게시글 좋아요 취소기능 웹 테스트
		@RequestMapping(value = "/likeCountCancel_W", method = {RequestMethod.GET, RequestMethod.POST})
		public String likeCountCancel_W(LikeBbsDto dto) {
			// 클라이언트에서 받은 정보 확인
			System.out.println("받은정보 (좋아요 취소) : " + dto);
			
			// 좋아요테이블 게시판 및 유저정보 삭제
			boolean b = sv.likeCancel(dto);
			
			if(b) {
				// 게시판 좋아요 1감소
				sv.likeCountCancel(dto.getBbs_no());
				return "complete";
			}else {
				return "fail";
			}
		}
	
	// 게시판 글 수정_Web
	@RequestMapping(value = "/updateBbs", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateBbs(WorkBbsDto dto) {
		// 클라이언트에서 받은 수정된 게시글 데이터
		System.out.println("수정된 게시글 정보 : " + dto);
		
		boolean b = sv.updateBbs(dto);
		if(b) {
			// 수정 완료
			return "success";
		}
		// 수정 실패
		return "fail";
	}
	
	// 게시판 글 수정_App
	@RequestMapping(value = "/updateBbs_M", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateBbs_M(@RequestBody WorkBbsDto dto) {
		// 클라이언트에서 받은 수정된 게시글 데이터
		System.out.println("수정된 게시글 정보 : " + dto);
		
		boolean b = sv.updateBbs(dto);
		if(b) {
			// 수정 완료
			return "success";
		}
		// 수정 실패
		return "fail";
	}
	
	// 게시판 글 삭제
	@RequestMapping(value = "/deleteBbs", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBbs(int seq) {
		// 클라이언트에서 받은 게시글 seq
		System.out.println("삭제될 게시글 seq : " + seq);
		
		boolean b = sv.deleteBbs(seq);
		if(b) {
			// 삭제 성공
			return "success";
		}
		//삭제 실패
		return "fail";
	}
	
	// 게시판 검색기능_Web
	@RequestMapping(value = "/getBbsListSearch", method = {RequestMethod.GET, RequestMethod.POST})
	public List<WorkBbsDto> getBbsListSearch(WorkBbsParam param) {
		// 클라이언트에서 받은 게시글 검색옵션
		System.out.println("게시글 검색옵션 : " + param);
		
		// 클라이언트로 보내줄 데이터 확인
		List<WorkBbsDto> list = sv.getBbsListSearch(param);
		System.out.println("클라이언트로 보낼 데이터 : " + list);
		
		return list;
	}
	
	// 게시판 검색기능_App
	@RequestMapping(value = "/getBbsListSearch_M", method = {RequestMethod.GET, RequestMethod.POST})
	public List<WorkBbsDto> getBbsListSearch_M(@RequestBody WorkBbsParam param) {
		// 클라이언트에서 받은 게시글 검색옵션
		System.out.println("게시글 검색옵션 : " + param);
		
		// 클라이언트로 보내줄 데이터 확인
		List<WorkBbsDto> list = sv.getBbsListSearch(param);
		System.out.println("클라이언트로 보낼 데이터 : " + list);
		
		return list;
	}
	
	// 게시판 페이징 기능_Web(only)
	@RequestMapping(value = "/getBbsListSearchPage", method = {RequestMethod.GET, RequestMethod.POST})
	public List<WorkBbsDto> getBbsListSearchPage(WorkBbsParam param) {
		// 클라이언트에서 받은 게시글 검색옵션
		System.out.println("게시글 검색옵션 : " + param);
		
		// 페이지 설정
		int sn = param.getPage();	// 0 1 2 3 ~
		int start = sn * 10 + 1;	// 1	11
		int end = (sn + 1) * 10;	// 10	20
		
		param.setStart(start);
		param.setEnd(end);
		
		// 클라이언트로 보낼 데이터 확인
		List<WorkBbsDto> list = sv.getBbsListSearchPage(param);
		System.out.println("클라이언트로 보낼 데이터 : " + list);
		
		return list;
	}
	
	// 게시판 글 총 갯수_Web(only)
	@RequestMapping(value = "/getBbsCount", method = {RequestMethod.GET, RequestMethod.POST} )
	public int getBbsCount(WorkBbsParam param) {
		// 클라이언트에서 받은 게시글 검색옵션
		System.out.println("게시글 검색옵션 : " + param);
		
		// 클라이언트로 보내줄 게시글 총 갯수 확인
		int count = sv.getBbsCount(param);
		System.out.println("게시글 총 수" + count);
		
		return count;
	}
}






















