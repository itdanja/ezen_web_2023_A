package 과제.과제11.model.dao;

import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.MemberDto;

public class BoardDao extends Dao {
	
	// 0. 싱글톤 객체
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() { return boardDao; }
	private BoardDao() {}
	
	// 9. boardWrite : 게시물쓰기 페이지 
	public boolean boardWrite( BoardDto boardDto ) {
		
		try {
			String sql = "insert into board( btitle , bcontent , mno )values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent() );
			ps.setInt( 3 , boardDto.getMno() );
			int row = ps.executeUpdate();
			if( row == 1 )return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 10. boardPrint : 모든 게시물 출력 
	public ArrayList<BoardDto> boardPrint() {
		
		ArrayList<BoardDto> list = new ArrayList<>();
		
		try {
			String sql = "select * from board b natural join member m";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				
				BoardDto boardDto = new BoardDto( 
						rs.getInt(2), rs.getString(3), rs.getString(4), 
						 rs.getString(5),  rs.getInt(6),  rs.getInt(1), rs.getString(7));
				
				list.add(boardDto);
				
			}
		}catch (Exception e) {System.out.println(e);}
		
		return list;
	}
	
	
	// 11. boardView : 개별 게시물 출력 
	public void boardView() { }
	// 12. boardUpdate : 게시물 수정 
	public void boardUpdate() {}
	// 13. boardDelete : 게시물 삭제
	public void boardDelete() {}
	
	
}
























