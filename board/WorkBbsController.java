package health.back.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public WorkBbsDto bbsDetail(int seq) {
		// 클라이언트에서 받은 seq번호 확인
		System.out.println("받은 seq번호 : " + seq);
		
		// 디테일 누를때마다 조회수 1씩 증가
		sv.readcount(seq);
		
		// 클라이언트로 보내줄 데이터 확인
		WorkBbsDto dto = sv.bbsDetail(seq);
		System.out.println("클라이언트로 보낼 데이터 : " + dto);
		
		return dto;
	}
	
	// 선택한 게시글 불러오기_App
	@RequestMapping(value = "/bbsDetail_M", method = {RequestMethod.GET, RequestMethod.POST})
	public WorkBbsDto bbsDetail_M(@RequestBody int seq) {
		// 클라이언트에서 받은 seq번호 확인
		System.out.println("받은 seq번호 : " + seq);
		
		// 디테일 누를때마다 조회수 1씩 증가
		sv.readcount(seq);
		
		// 클라이언트로 보내줄 데이터 확인
		WorkBbsDto dto = sv.bbsDetail(seq);
		System.out.println("클라이언트로 보낼 데이터 : " + dto);
		
		return dto;
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
	
	// 게시판 글 삭제_Web
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
	
	// 게시판 글 삭제_App
	@RequestMapping(value = "/deleteBbs_M", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBbs_M(@RequestBody int seq) {
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






















