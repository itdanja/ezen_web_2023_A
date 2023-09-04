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
	
	// 2-2 게시물/레코드 수 구하기 
	public int gettotalsize(   String key , String keyword , int bcno ) {
		
		String sql = "";
		if( bcno == 0 ) {
			sql = " select count(*) from board b natural join member m ";
			 if( key.equals("") && keyword.equals("") ) { 
				 sql +=" ";
			 }else {
				 sql +=" where "+key+" like '%"+keyword+"%'";
			 }
		}else {
			sql = " select count(*) from board b natural join member m where bcno = "+bcno;
			 if( key.equals("") && keyword.equals("") ) { 
				 sql +=" ";
			 }else {
				 sql +=" and "+key+" like '%"+keyword+"%'";
			 }
		}
		
		try {
			ps =conn.prepareStatement(sql); rs = ps.executeQuery();
			if( rs.next() )return rs.getInt(1);
		}catch (Exception e) {System.err.println(e);} return 0;
	}
	
	// 2. 모든 글 출력
	public ArrayList<BoardDto> getList(  int startrow , int listsize , String key , String keyword , int bcno ){
		// * 게시물 레코드 정보의 DTO를 여러개 저장하는 리스트 선언
		ArrayList<BoardDto> list = new ArrayList<>();
		try {
			String sql = "";
			if( bcno == 0 ) {
				 sql = " select b.* , m.mid , m.mimg , bc.bcname from board b natural join bcategory bc natural join member m ";
				 if( key.equals("") && keyword.equals("") ) { 
					 sql +=" order by b.bdate desc limit ? , ? ";
				 }else {
					 sql +=" where "+key+" like '%"+keyword+"%' order by b.bdate desc limit ? , ? ";
				 }
				 
			}else {
				 sql = " select b.* , m.mid , m.mimg , bc.bcname from board b natural join bcategory bc natural join member m where b.bcno =  "+ bcno+" ";
				 if( key.equals("") && keyword.equals("") ) { 
					 sql +=" order by b.bdate desc limit ? , ? ";
				 }else {
					 sql +=" and "+key+" like '%"+keyword+"%' order by b.bdate desc limit ? , ? ";
				 }
			}
			
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , startrow ); ps.setInt( 2 , listsize);
			System.out.println( sql );
			System.out.println( ps );
			
			rs = ps.executeQuery();
			
			while( rs.next() ) { // 여러 레코드 조회 while
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
	public BoardDto getBoard( int bno ) {
		viewIncre( bno );
		try {
			String sql = " select b.* , m.mid , m.mimg , bc.bcname "
					+ "	from board b "
					+ "    natural join member m "
					+ "    natural join bcategory bc "
					+ "    where b.bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno); 
			rs = ps.executeQuery();
			if( rs.next()  ) { // 한개 레코드 조회 if
				
				BoardDto boardDto = new BoardDto(
						rs.getInt("bno"), 
						rs.getString("btitle"), rs.getString("bcontent"), 
						rs.getString("bfile"), rs.getString("bdate"), 
						rs.getInt("bview"), rs.getInt("mno"), 
						rs.getInt("bcno"), rs.getString("mid"), 
						rs.getString("bcname"), rs.getString("mimg") 
						);
				return boardDto;
			}
		}catch (Exception e) { System.out.println(e); }
		return null;
	}
	// 4. 게시물 수정 
	public boolean onUpdate( BoardDto dto ) {
		try {
			String sql = "update board "
					+ "	set btitle = ? , bcontent = ? , "
					+ " bcno = ?  , bfile = ? "
					+ "    where bno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , dto.getBtitle() );
			ps.setString( 2 , dto.getBcontent() );
			ps.setInt( 3 , dto.getBcno() );
			ps.setString( 4 , dto.getBfile() );
			ps.setInt( 5 , dto.getBno() );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	// 5. 게시물 삭제 
	public boolean ondelete( int bno ) {
		try {
			String sql ="delete from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 6. 조회수 증가 
	public boolean viewIncre( int bno ) {
		try {
			String sql = "update board set bview = bview+1 where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno );	
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	

		
	
}
































