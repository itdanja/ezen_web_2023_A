package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.mpointDto;

@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PointController() {  super();  }
    
	// 9.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. UUID 만들어서 포인트내역 식별자로 사용 
		String mpno  = UUID.randomUUID().toString() ; // 포인트내역 식별번호 구성 [ UUID ] 
			// UUID.randomUUID() : (s) UUID 고유성을 보장하는 ID[식별자] 만들기 위한 표준규약
			System.out.println( mpno );
			
		// 2. 로그인된[세션에저장된] 회원정보에서 회원번호만 출력 
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno() ;
		
		// 3. 포인트 수량 / 지급내역 는 JS에서 요청 받음 
		long mpamount  = Long.parseLong( request.getParameter("mpamount") );
		String mpcomment = request.getParameter("mpcomment");
		
		// ----- Dto
		mpointDto mpointDto = new mpointDto(mpno, mno, mpamount, mpcomment, null);
		// ----- DAO
		boolean result = MemberDao.getInstance().setPoint( mpointDto );
		// ----- 응답
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(result);
	}
	
    // 10. 11.   -- 하나의 함수에서 2개이상의 기능 처리 type 분류 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 서로 다른 함수/기능 를 실행 하기 위한 분류 
		int type = Integer.parseInt( request.getParameter("type") );
		
		// - 공통 
		int mno  = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno() ;
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		// 2. 분류 
		if( type == 1  ) { // 1: 현재 포인트 출력 
			long result =  MemberDao.getInstance().getPoint( mno );
			json  = mapper.writeValueAsString(result);
			
		}else if( type == 2  ) { // 2 : 포인트내역 전체 출력 
			List< mpointDto > result =  MemberDao.getInstance().getPointList( mno );
			json  = mapper.writeValueAsString(result);
		}
		
		// 3.응답
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(json);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}














