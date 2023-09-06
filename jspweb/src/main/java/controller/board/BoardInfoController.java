package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;
import model.dto.PageDto;
import service.FileService;

/**
 * Servlet implementation class BoardInfoController
 */
@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    // type : 1. 전체조회 , 2.개별조회 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 
		String type = request.getParameter("type");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";

		if( type.equals("1") ) { // 전체 조회 로직 
			
			// ----------------------- 7. 검색처리 ----------------------- // 
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			
			// ----------------------- 1. 카테고리 ---------------------- //
			int bcno = Integer.parseInt( request.getParameter("bcno") );
			// ----------------------- 2. 출력할 게시물수/하나의 페이지의 최대 게시물수 ---------//
			int listsize = Integer.parseInt( request.getParameter("listsize") );
			// ----------------------- 3. 페이징 처리 하기 ---------------- //
			int page = Integer.parseInt( request.getParameter("page") );
				// 1. 페이지별 레코드의 시작번호
			int startrow = ( page-1 )*listsize; // 페이지번호*최대게시물수
				// 1*10 => 10->0 // 2*10 => 20 -> 10 // 3*10 => 30->20
			// ----------------------- 4. 마지막 페이지번호 ---------------- // 
				// 1. 마지막페이지번호/총페이지수 = 전체게시물수 / 페이지별최대게시물수( listsize )
				// 2. 전체 게시물수
			int totalsize = BoardDao.getInstance().getTotalSize( 
											bcno , key , keyword );
				// 3. 마지막페이지번호/총페이지수
			int totalpage = totalsize%listsize == 0 ? // 만약에 나머지가 없으면 
							totalsize/listsize : 	  // 몫 
							totalsize/listsize+1 ;	  // 몫 + 1( 나머지 페이지 수를 표시할 페이지1개 추가 )
					// 게시물수 : 10 , 페이지별 2개씩 출력  => 총페이지수 5페이지[몫]
					// 게시물수 : 20 , 페이지별 3개씩 출력  => 총페이지수 6페이지[몫] + 1 ( 나머지[2] ) => 7페이지
			
			// ----------------------- 5. 페이지번호버튼 시작번호 , 마지막번호 ----------------- */ 
				// 5개씩 	:	1~5페이지( 1 , 5 ) 6~10페이지( 6 , 10 ) 11~15페이지(11,15)
				// 10개씩	:	1~10페이지 ( 1 , 10 ) 11~20페이지( 11,20) 21~30(21,30)
				// 15개씩:	1~15페이지 ( 1 , 15 )	 16~30페이지( 16,30) 31~45(31,45)
				/*
				 	페이지		시작		마지막		시작계산식 [int btnsize = 5;]
				 	1페이지		1		5			page/btnsize 	=> 0
				 	2			1		5			(page/btnsize)*btnsize => 0
				  	3			1		5			(page/btnsize)*btnsize +1  => 1
				  	4			1		5			page/btnsize	
				  	5			1		5			(page/btnsize)*btnsize +1  => 6	 / (page-1/btnsize)*btnsize +1  => 1	
				  	6			6		10				
				  	7			6		10
				  	8			6		10
				  	9			6		10
				  	10			6		10
				  	11			11		15
				  	~~~~~~~~~~~~~~~~~~~~~~~
				  	21			21		25
				  
				 */
				// 1. 페이지버튼 번호의 최대개수 
			int btnsize = 5;
				// 2. 페이지버튼 번호의 시작번호 
			int startbtn = ( (page-1) / btnsize ) * btnsize + 1 ;	
				// 3. 페이지버튼 번호의 마지막번호 
			int endbtn = startbtn+(btnsize-1);
					// * 단 마지막번호는 총페이지수 보다 커질수 없음 [
					// 만약에 마지막번호가 총 페이지수보다 크거나 같으면 총페이지 수로 제한두기 
			if( endbtn >= totalpage ) endbtn = totalpage;
			
			// ----------------------- 6. pageDto 구성  ---------------- // 
		
			ArrayList<BoardDto> result = BoardDao.getInstance().getList(  
							bcno , listsize , startrow , key , keyword );
			
			PageDto pageDto = new PageDto( page, listsize, startrow, totalsize, totalpage, startbtn , endbtn ,  result );
			
			json = objectMapper.writeValueAsString( pageDto );
			

		}else if( type.equals("2") ) {// 개별 조회 로직 
			//1.매개변수 요청 
			int bno = Integer.parseInt( request.getParameter("bno") ) ;
			//2. DAO 처리 
			BoardDto result = BoardDao.getInstance().getBoard( bno );
			
				// 3. 만약에 ( 로그인 혹은 비로그인 )요청한한사람과 게시물작성한사람과 동일하면 
			Object object = request.getSession().getAttribute("loginDto");
			if( object == null ) { // 비로그인 
				result.setIshost(false); // 남이 쓴 글 
			}else { // 로그인 
				MemberDto login = (MemberDto)object;
				if( login.getMno() == result.getMno() ) { result.setIshost(true); } 	// 내가 쓴 글 
				else { result.setIshost(false);  } 	// 남이 쓴 글 
			}
			json = objectMapper.writeValueAsString( result );
		}
		
		// 공통 로직 // 1. 전체조회 , 개별조회 하던 응답 로직 공통
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( json );
		
	}
	// 2. 쓰기 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 첨부파일 업로드 [ cos.jar -> MultipartRequest 클래스  ]
		MultipartRequest multi = new MultipartRequest(
				request,			// 요청방식 
				request.getServletContext().getRealPath("/board/upload"),	//저장경로				// 저장경로 
				1024*1024*1024, // 업로드허용용량[바이트] 1GB 
				"UTF-8",		// 인코딩타입 
				new DefaultFileRenamePolicy() // 만약에 업로드파일명이 서버내 존재하면(중복) 자동으로 파일명뒤에 숫자 붙이기
				);
		// * 업로드가 잘 되었는지 확인하기 위한 업로드 서버경로 확인 
		System.out.println( request.getServletContext().getRealPath("/board/upload") );
		
		// 1. (입력받은 매개변수) 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile"); // 첨부파일명은 getFilesystemName
			// - 작성자(mno) 는 입력x / mno는 세션에 저장 되어있는 상태 
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno();
		int bcno = Integer.parseInt( multi.getParameter("bcno") );
		// 2. 유효성검사/객체화 
		BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno);	System.out.println( boardDto );
		// 3. Dao 처리 
		boolean result = BoardDao.getInstance().bwrite(boardDto);
		// 4. (Dao 결과) 응답 
		response.setContentType("application/json; charset=UTF-8"); 
		response.getWriter().print(result);
	}
	// 3. 수정 
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 수정할 첨부파일 업로드 
		MultipartRequest multi = new MultipartRequest(
				request,request.getServletContext().getRealPath("/board/upload"), 
				1024 * 1024 *1024 ,  "UTF-8" , new DefaultFileRenamePolicy() );
		
		// 2. 수정할 데이터 내용 요청 
		int bcno = Integer.parseInt( multi.getParameter("bcno") );
		String btitle = multi.getParameter("btitle") ;
		String bcontent = multi.getParameter("bcontent") ;
		String bfile = multi.getFilesystemName("bfile") ; // 파일명 호출 !![ getFilesystemName ]
		
		// 2* 수정할 게시물 식별키 
		int bno = Integer.parseInt( multi.getParameter("bno") );
		BoardDto updateDto = 
				new BoardDto(bno, btitle, bcontent, bfile, bcno); System.out.println("수정dto : " + updateDto );
		
		// * 만약에 수정할 첨부파일이 없으면 기존 첨부파일 그대로 사용
		if( updateDto.getBfile() == null ) {
			// 기존첨부파일 호출해서 수정dto에 저장하기.
			updateDto.setBfile( 
					BoardDao.getInstance().getBoard(bno).getBfile() 
					) ;
		}else { // 만약에 수정할 첨부파일 있으면 기존 첨부파일은 서버업로드폴더에서 삭제 
			
			String filename = BoardDao.getInstance().getBoard(bno).getBfile();
			filename = request.getServletContext().getRealPath("/board/upload")+"/"+filename;
			FileService.fileDelete(filename);
		}
		
		// 3. DAO
		boolean result = BoardDao.getInstance().onUpdate( updateDto );
		
		// 4. 응답 
		response.setContentType("application/json; charset=UTF-8"); 
		response.getWriter().print(result);
	}
	
	// 4. 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 
		int bno = Integer.parseInt( request.getParameter("bno") );
		
			// - 레코드 삭제 전 에 파일이름 꺼내두기 [ 레코드 삭제후 파일이름 호출이 불가능 하니까 ]
			String filename = BoardDao.getInstance().getBoard(bno).getBfile();
			
		// 2. DAO
		boolean result = BoardDao.getInstance().ondelete(bno);
			// 게시물 삭제시 삭제된 게시물의 업로드파일도 같이 삭제 
			if( result ) { // 만약에 게시물 삭제 성공이면 
				filename = request.getServletContext().getRealPath("/board/upload")+"/"+filename;
				FileService.fileDelete(filename);
			}
		// 3. 응답 
		response.setContentType("application/json; charset=UTF-8"); 
		response.getWriter().print(result);
	}
	
}





























