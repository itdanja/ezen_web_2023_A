package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class MemberInfoController
 */
@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 1. [C] (첨부파일 있을때 form )회원가입
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   	// ----------------------------------------------- 파일 업로드 : 서버폴더에 --------------------------------------------- //	
   		// 첨부파일 저장할 폴더의 절대경로
   		// 1. 개발자 pc 경로 업로드 [ 문제발생 : 개발자pc에 업로드하면 업로드파일을 서버로 빌드 ]
   		//String uploadpath ="C:\\Users\\504-t\\git\\ezen_web_2023_A\\jspweb\\src\\main\\webapp\\member\\img"; // 첨부파일 저장할 경로
   		// 2. 서버 pc 경로 업로드  [ 사용자는 바로 서버pc 업로드 ]
   		//String uploadpath ="C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\member\\img";
   		// 3. 서버 pc 경로 ( 상대경로 = 서버경로 찾아주는 함수 )
   			// 서버에 build(배포)된 파일/폴더 의 경로 찾기
   			// request.getServletContext().getRealPath("프로젝트명이하 경로");
   		String uploadpath = request.getServletContext().getRealPath("/member/img");
   			// RealPath : C:\\Users\\504-t\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\member\\img
   			// HttpPath : http://localhost/jspweb/member/img/
   		System.out.println( "member 폴더 img 폴더 실제(서버) 경로 : " + uploadpath ); 
   		// 첨부파일 전송 했을때.
   			// 1. 첨부파일 서버PC에 업로드( COS.jar 라이브러리 ) 
   				// MultipartRequest : 파일 업로드 클래스 
   			MultipartRequest multi = new MultipartRequest(
   					request , 		// 1. HttpServletRequest 요청방식 
   					uploadpath , 	// 2. 첨부파일을 저장할 폴더 경로 
   					1024*1024*10,	// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
   					"UTF-8" , 		// 4. 한글인코딩타입 
   					new DefaultFileRenamePolicy()	// 5. [파일명중복제거] 만약에 서버내 첨부파일의 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기 
   					);
   			
   		// ----------------------------------------------- DB처리 : 업로드된 파일명  --------------------------------------------- //	
   			// 2. form 안에 있는 각 데이터 호출 
   		// 일반input : multi.getParameter("form객체전송시input name");		
   		// 첨부파일input : multi.getFilesystemName( );
   		String mid =  multi.getParameter("mid");			System.out.println("mid : "  + mid);
   		String mpwd =  multi.getParameter("mpwd");		System.out.println("mpwd : "  + mpwd);
   		String memail =  multi.getParameter("memail");	System.out.println("memail : "  + memail);
   		//String mimg =  multi.getParameter("mimg");		System.out.println("mimg : "  + mimg);
   		String mimg =  multi.getFilesystemName("mimg");		System.out.println("mimg : "  + mimg);
   		
   		// *만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
   		if( mimg == null ) {mimg = "default.webp";}
   		
   		// 2. (선택) 객체화.
   		MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
   		// 2. (선택) 유효성검사.
   		
   		// 3. Dao 에게 전달하고 결과 받는다.
   		boolean result = MemberDao.getInstance().signup(memberDto);
   		
   		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [ response ]
   		response.setContentType("application/json;charset=UTF-8");
   		response.getWriter().print(result);
   		
   	}
   	/*
    // 1. [C] (첨부파일 없을때)회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. AJAX 통신받은 data객체의 '속성명' 요청한다. [ request ] 
		String mid =  request.getParameter("mid");			System.out.println("mid : "  + mid);
		String mpwd =  request.getParameter("mpwd");		System.out.println("mpwd : "  + mpwd);
		String memail =  request.getParameter("memail");	System.out.println("memail : "  + memail);
		String mimg =  request.getParameter("mimg");		System.out.println("mimg : "  + mimg);
		
		// 2. (선택) 객체화.
		MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
		// 2. (선택) 유효성검사.
		
		// 3. Dao 에게 전달하고 결과 받는다.
		boolean result = MemberDao.getInstance().signup(memberDto);
		
		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [ response ]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	*/
	
	// 2. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if( type.equals("info") ) {
			
			Object object = request.getSession().getAttribute("login");
			MemberDto memberDto = null;
			if( object != null ) {
				memberDto = (MemberDto)object;
			}
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString( memberDto );
			
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(json);
			
		}else if (type.equals("logout")) {
			request.getSession().setAttribute("login" , null);
		}
		
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getServletContext().getRealPath("/member/img");
		// 첨부파일 전송 했을때.
			// 1. 첨부파일 서버PC에 업로드( COS.jar 라이브러리 ) 
				// MultipartRequest : 파일 업로드 클래스 
			MultipartRequest multi = new MultipartRequest(
					request , 		// 1. HttpServletRequest 요청방식 
					uploadpath , 	// 2. 첨부파일을 저장할 폴더 경로 
					1024*1024*10,	// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
					"UTF-8" , 		// 4. 한글인코딩타입 
					new DefaultFileRenamePolicy()	// 5. [파일명중복제거] 만약에 서버내 첨부파일의 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기 
					);
			
		// ----------------------------------------------- DB처리 : 업로드된 파일명  --------------------------------------------- //	
			// 2. form 안에 있는 각 데이터 호출 
		// 일반input : multi.getParameter("form객체전송시input name");		
		// 첨부파일input : multi.getFilesystemName( );
		String mpwd =  multi.getParameter("mpwd");			System.out.println("mpwd : "  + mpwd);
		String newmpwd =  multi.getParameter("newmpwd");	System.out.println("newmpwd : "  + newmpwd);
		String mimg =  multi.getFilesystemName("mimg");		System.out.println("mimg : "  + mimg);
		
		// 2. (선택) 객체화.
		MemberDto memberDto = new MemberDto( null , mpwd, null, mimg);	
		System.out.println( memberDto );
		System.out.println( newmpwd );
		
		
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

/*
 	용량 단위
 		bit : 0 or 1 
 		byte: 01010101 -> 1byte
 		kb : 1024byte -> 1kb
 		mb : 1024kb -> 1mb
 */















