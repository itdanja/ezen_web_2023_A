package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    // 1. [C] 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/img/member");
		System.out.println( uploadpath );
		
		// * 업로드 [ 유저파일 --> 서버폴더내 이동 ]
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				uploadpath , 					// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		
		// 그외 매개변수 요청 [ request --> multi / form 하위태그내 input 태그의 name 식별자  ]
		String mid = multi.getParameter("mid");	// 호출할 input의 name 
		String mpwd = multi.getParameter("mpwd");
		String memail = multi.getParameter("memail");
		String mimg = multi.getFilesystemName("mimg");	// 첨부파일된 파일명 호출[  .getFilesystemName 
		if( mimg == null )mimg="default.webp";
		
		// 2. (선택) 객체화.
		MemberDto memberDto = new MemberDto(mid, mpwd, memail, mimg);
		// 2. (선택) 유효성검사.
		
		// 3. Dao 에게 전달하고 결과 받는다.
		boolean result = MemberDao.getInstance().signup(memberDto);
		
		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [ response ]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
		
	}
	
	// 2. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
