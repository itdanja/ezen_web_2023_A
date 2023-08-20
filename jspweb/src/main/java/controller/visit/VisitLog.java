package controller.visit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.Dao;
import model.dao.VisitLogDao;
import model.dto.VisitLogDto;

/**
 * Servlet implementation class VisitLog
 */
@WebServlet("/VisitLog")
public class VisitLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 
		
		// 2. 
		ArrayList<VisitLogDto> result = VisitLogDao.getInstance().vprint();
			System.out.println( result );
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString( result );
		
		// 3. 
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print( jsonArray );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 
		String vwriter = request.getParameter("vwriter");
		String vpwd = request.getParameter("vpwd");
		String vcontent = request.getParameter("vcontent");
		// 2. 
		VisitLogDto visitLogDto = new VisitLogDto(vwriter, vpwd, vcontent);
			System.out.println("visitLogDto : "+ visitLogDto);
		// 3. 
		boolean result = VisitLogDao.getInstance().vwrite(visitLogDto);
		// 4 . 
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print( result );
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
		int vno = Integer.parseInt( request.getParameter("vno") );
		String vpwd =  request.getParameter("vpwd") ;
		String vcontent =  request.getParameter("vcontent") ;
			System.out.println( "vno : " + vno);
			System.out.println( "vpwd" + vpwd);
			System.out.println( "vcontent : " + vcontent);
		// 2. 
		int result = VisitLogDao.getInstance().vupdate(vno, vpwd, vcontent);
		// 3. 
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print( result );
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
		int vno = Integer.parseInt( request.getParameter("vno") );
		String vpwd =  request.getParameter("vpwd") ;
			System.out.println( "vno : " + vno);
			System.out.println( "vpwd : " + vpwd);
		// 2. 
		int result = VisitLogDao.getInstance().vdelete(vno, vpwd);
		// 3. 
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print( result );
	}

}
























