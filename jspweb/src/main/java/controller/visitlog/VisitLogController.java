package controller.visitlog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.VisitDto;

@WebServlet("/VisitLogController") // 해당 서블릿(자바)/컨트롤러 클래스를 호출하는 HTTP 매핑주소
public class VisitLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisitLogController() {   super(); }

    // 1. 저장 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX의 data속성에 있는 객체 정보(속성명이용) 를 요청 하기 
		//request.getParameter("객체의속성명");
		String vwriter = request.getParameter("vwriter");	System.out.println( "vwriter : " + vwriter);
		String vpwd = request.getParameter("vpwd");			System.out.println( "vpwd : " + vpwd);
		String vcontent = request.getParameter("vcontent");	System.out.println( "vcontent : " + vcontent);
		// 2. 객체화 
		VisitDto  visitDto = new VisitDto(vwriter, vpwd, vcontent);	System.out.println("visitDto : " + visitDto);
		// 3. DAO 객체 전달후 결과 응답받고 
		
		// 4. 결과를 AJAX에게 응답한다. 
	}
	
	// 2. 호출 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// 3. 수정 
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
