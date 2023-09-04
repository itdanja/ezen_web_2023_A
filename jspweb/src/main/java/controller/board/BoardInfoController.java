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
			
			ArrayList<BoardDto> result = BoardDao.getInstance().getList();
			json = objectMapper.writeValueAsString( result );

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
		
	}
	
	// 4. 삭제 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 
		int bno = Integer.parseInt( request.getParameter("bno") );
		// 2. DAO
		boolean result = BoardDao.getInstance().ondelete(bno);
		// 3. 응답 
		response.setContentType("application/json; charset=UTF-8"); 
		response.getWriter().print(result);
	}

}





























