package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class MemberFindController
 */
@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MemberFindController() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 하나의 메소드의 여러개 ajax 통신할때. type전송( 숫자 1:아이디중복검사 2.이메일중복검사 vs 필드명  mid : 아이디중복검사 , memail : 이메일중복검사 )  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청한다.
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		// 2. 객체화/유효성검사
		// 3. DAO 요청 결과 
		boolean result = MemberDao.getInstance().findIdOrEmail( type , data);
		// 4. 결과 응답한다. 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	
	// 로그인 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 매개변수 요청 
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		// 2. (객체화/유효성검사)
		// 3. DAO 에게 전달후 결과 받기 
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		// 4. 결과를 응답한다.
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(result); 
	}
}


















