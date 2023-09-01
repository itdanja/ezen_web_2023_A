package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao {
	
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() { return boardDao; }
	
	// 1. 글쓰기 
	public boolean bwrite( BoardDto boardDto ) {
		try {
			String sql = "insert into board( btitle , bcontent , bfile , mno , bcno )"
						+ " values( ? ,? , ? ,? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );	ps.setString( 2 , boardDto.getBcontent() ); 
			ps.setString( 3 , boardDto.getBfile() );	ps.setInt( 4 , boardDto.getMno() );	
			ps.setInt( 5 , boardDto.getBcno() );
			int count = ps.executeUpdate(); if( count == 1 )return true; 
		}catch (Exception e) {System.out.println(e);	}
		return false;
	}
	// 2. 모든 글 출력
	public ArrayList<BoardDto> getList( ){
		// * 게시물 레코드 정보의 DTO를 여러개 저장하는 리스트 선언
		ArrayList<BoardDto> list = new ArrayList<>();
		try {
			String sql = " select b.* , m.mid , m.mimg , bc.bcname "
					+ " from board b "
					+ "		natural join bcategory bc "
					+ "		natural join member m "
					+ " order by b.bdate desc ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto(
						rs.getInt("bno"), 
						rs.getString("btitle"), rs.getString("bcontent"), 
						rs.getString("bfile"), rs.getString("bdate"), 
						rs.getInt("bview"), rs.getInt("mno"), 
						rs.getInt("bcno"), rs.getString("mid"), 
						rs.getString("bcname"), rs.getString("mimg") 
						);
				list.add(boardDto);
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	} // f end 
	
	// 3. 개별 글 출력 
	
	// 4. 게시물 수정 
	
	// 5. 게시물 삭제 
	
	// 6. 조회수 증가 
}
















