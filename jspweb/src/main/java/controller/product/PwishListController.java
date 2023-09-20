package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ProductDao;
import model.dto.MemberDto;
import model.dto.ProductDto;

/**
 * Servlet implementation class PwishListController
 */
@WebServlet("/PwishListController")
public class PwishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public PwishListController() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 찜하기로 등록할 제품번호 ajax에게 요청 
		int pno = Integer.parseInt( request.getParameter("pno") );
		// 2. 찜하기를 등록한 회원번호 ajax에게 요청x [ 서블릿은 로그인한 회원 정보를 알고있다.->서블릿 세션 ]
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno() ;
		// 3. Dao 에게
		boolean result = ProductDao.getInstance().setWish(mno, pno);
		// 4.
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(result);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if( type.equals("findByWish") ) {
			int pno = Integer.parseInt( request.getParameter("pno" ) );
			int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno() ;
			boolean result = ProductDao.getInstance().getWish(mno, pno);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(result);
		}else if(  type.equals("findByAll") ) {
			int mno = ( (MemberDto)request.getSession().getAttribute("loginDto") ).getMno() ;
			List<ProductDto> result = ProductDao.getInstance().getWishProdutList(mno);
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArray = objectMapper.writeValueAsString( result );
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print( jsonArray );
		}
	}



	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}






