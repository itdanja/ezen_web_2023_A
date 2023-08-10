package 과제.과제11.model.dao;

import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.view.LoginPage;

public class BoardDao extends Dao {
	
	// 0.싱글톤 
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() { return boardDao; }
	private BoardDao() {}
	
	// 9. boardWrite : 게시물쓰기 페이지 
	public boolean boardWrite( BoardDto boardDto ) {
		
		try {
			// 1. SQL 작성한다.
			String sql ="insert into board( btitle,bcontent,mno) values(?,?,?)";
			// 2. 작성한 SQL 조작할 인터페이스PS 객체 반환한다. 
			ps = conn.prepareStatement(sql);
			// 3. SQL에 매개변수 대입 (조작)
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent() );
			ps.setInt(3, boardDto.getMno() );
			// 4. SQL 실행 / 실행 후 저장된 레코드 개수 반환 
			int row = ps.executeUpdate();
			// 5. 만액에 저장된 레코드수가 1개이면 성공 
			if( row == 1 ) return true;
		}catch (Exception e) {System.out.println(e);}
		return false; // 실패
	}
	// 10. boardPrint : 모든 게시물 출력 [ 반환타입 : 
	// public BoardDto[] boardPrint() {
	public ArrayList<BoardDto> boardPrint() {
		ArrayList<BoardDto> list = new ArrayList<>(); // 여러개 BoardDto 를 저장할 리스트객체 선언 
		try {
			//String sql = "select * from board order by bdate desc";// 1. 최신순[desc내림차순]으로 모든 레코드 호출 
			String sql = "select b.* , m.mid from member m natural join board b order by b.bdate desc";
			ps = conn.prepareStatement(sql); // 2.
			// 3. SQL에 ?(매개변수) 없으므로 set~~ 생략 
			rs = ps.executeQuery(); // 4. 검색결과의 레코드를 여러개 조작하기 위해 resultSet 객체 반환 
			// 5. 여러개 레코드 조회 [ rs.next() : 다음 레코드 이동(존재하면true/존재하지않으면false) ]
			while( rs.next() ) { // 마지막 레코드까지 하나씩 레코드 이동 ( 다음레코드가 존재하지 않을때까지 반복 ) 
				// [ 레코드 개수만큼 반복 ]
				// 레코드 1개 마다 1개의 DTO 변환 
				BoardDto dto = new BoardDto(
						rs.getInt(1) , rs.getString(2) , rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7) );
				// 변환된 Dto 를 리스트객체에 담기 
				list.add(dto);
			}
		}catch (Exception e) { }
		return list ;
	}
	
	
	
	// 11. boardView : 개별 게시물 출력 
	public void boardView() {}
	// 12. boardUpdate : 게시물 수정 
	public void boardUpdate() {}
	// 13. boardDelete : 게시물 삭제
	public void boardDelete() {}

	
}

/*
 	테이블
 		레코드/행/가로	-> DTO 1개
 		레코드/행/가로	-> DTO 1개	여러개 DTO 하나의 객체로 담기 => 리스트 혹은 배열 
 		레코드/행/가로	-> DTO 1개
 		
		1	안녕하세요.	안녕		2023-08-10 11:01:58	0	7	-> boardDTO	
		2	제목에 띄어	하하하	2023-08-10 11:02:53	0	7	-> boardDTO		ArrayList<boardDTO> vs BoardDto[]
		3	테스트1		테스트2	2023-08-10 11:09:11	0	7	-> boardDTO
		
		
	예)
		로그인한 회원정보1개 조회 = DTO.
		관리자가 모든회원정보 여러개 조회 = ArrayList<DTO>
	
		개별 게시물 1개 출력 = DTO 
		모든 게시물 여러개 출력 = ArrayList<DTO>
		
		
		----
				System.out.println( rs );
				System.out.println();
				// 필드순서에 따른 필드 값 호출 : rs.get타입(필드순서번호)
				System.out.print( rs.getString(1) +"\t" ); // bno
				System.out.print( rs.getString(2) +"\t"); // btitle
				System.out.print( rs.getString(3) +"\t"); // bcontent
				System.out.print( rs.getString(4) +"\t"); // bdate 
				System.out.print( rs.getString(5) +"\t"); // bview 
				System.out.print( rs.getString(6) +"\t"); // mno
				System.out.println();
				
  
 */

















