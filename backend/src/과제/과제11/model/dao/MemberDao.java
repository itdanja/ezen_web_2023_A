package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao {
	
	// 0. 싱글톤 객체
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() { return memberDao; }
	private MemberDao() {}
	
	// 3.infoCheck
	public boolean infoCheck ( int type , String info ) {
		try {
			String sql = "";
			if( type == 1 ) {  sql = "select * from member where mid = ?"; }
			else if( type == 2 ) {   sql = "select * from member where mphone = ?"; }
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , info );
			rs = ps.executeQuery();
			if( rs.next() ) {  return true; }
		}catch (Exception e) { System.out.println(e); }
		return false; // 로그인 실패 
	}
	// 2. 회원가입SQL 
	public boolean signupSQL( MemberDto dto ) {
		try {
			// 1. 연동된DB객체 에서 SQL조작 도구(PreparedStatement)꺼내기  [ 연동객체명.prepareStatement("조작할SQL")
			ps = conn.prepareStatement( "insert into member(mid,mpw,mname,mphone)values(?,?,?,?)" );
			// 2. sql안에 있는 ?매개변수에 값 대입 [ ps.set타입( ?순서번호 , 값 ) ]
			ps.setString(1, dto.getMid() );
			ps.setString(2, dto.getMpw() );
			ps.setString(3, dto.getMname() );
			ps.setString(4, dto.getMphone() );
			// 3. sql 실행 					[ ps.ps.executeUpdate() : SQL 실행 ]
			ps.executeUpdate();
			// 4. 리턴 [ 회원가입성공 =true / 회원가입실패 = false ] 
			return true;
		}catch (Exception e) {System.out.println(e);}
		// 4. 리턴 [ 회원가입성공 =true / 회원가입실패 = false ] 
		return false;
 	}
	// 3. 로그인SQL
	public int loginSQL( String id , String pw ) {
		try {
			// 1단계 : SQL 작성한다. [ 추천 : MYSQL 워크벤치에서 임의의값으로 테스트하고 ]
			String sql = "select * from member where mid = ? and mpw = ?";
			// 2단계 : SQL 조작할수 있는 객체 필요함으로 PreparedStatement 반환받기
			ps = conn.prepareStatement(sql);
			// 3단계 : SQL 조작 [ SQL안에 있는 매개변수[?]에 값 대입 ]
			ps.setString( 1 , id );
			ps.setString( 2 , pw );
			// 4단계 : SQL 실행해서 그 결과객체 를 rs객체에 대입 	[ * ps는 결과를 조작할수 없다. ]
				// [ insert/update/delete : ps.executeUpdate(); / select :ps.executeQuery(); ]
			rs = ps.executeQuery();
			// 5단계 : SQL 실행 결과 조작 	[ rs.next() : 결과중에서 다음 레코드객체 호출 ]
				// 만약에 검색결과의 레코드 3개 가정 [   rs = null -> 레코드1객체 -> 레코드2객체 -> 레코드3객체 ]
				//									  .next()	 .next()	 .next()
			if( rs.next() ) { // 로그인SQL 결과레코드는 1개 또는 0개 이므로 if 사용해서 .next() 1번 호출 해서
										// next() 다음레코드가 존재하면 true / false
				return rs.getInt(1); // 로그인 성공 
			}
			
		}catch (Exception e) { System.out.println(e); }
		return 0; // 로그인 실패 
	}
	// 3. 로그인SQL
	public String findIdSQL( String name , String phone ) {
		try {
			String sql = "select * from member where mname = ? and mphone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , name );
			ps.setString( 2 , phone );
			rs = ps.executeQuery();
			if( rs.next() ) {  return rs.getString( 2 ); }
		}catch (Exception e) { System.out.println(e); }
		return null; // 로그인 실패 
	}
	// 3. 로그인SQL
	public String findPwSQL( String id , String phone ) {
		try {
			String sql = "select * from member where mid = ? and mphone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , id );
			ps.setString( 2 , phone );
			rs = ps.executeQuery();
			if( rs.next() ) {  return rs.getString( 3 ); }
		}catch (Exception e) { System.out.println(e); }
		return null; // 로그인 실패 
	}
	
	//
	public MemberDto myInfoSQL( int mno ) {
		
		try {
			String sql = "select * from member where mno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , mno );
			rs = ps.executeQuery();
			if( rs.next() ) {  
				MemberDto memberDto = new MemberDto( 
						rs.getInt(1) ,
						rs.getString(2),
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5) );
				return memberDto;
			}
		}catch (Exception e) { System.out.println(e); }
		return null; // 로그인 실패 
		
	}
	
	public boolean myInfoUpdateSQL(  String newPw , int mno ) {
		
		try {
			String sql = "update member set mpw = ? where mno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , newPw );
			ps.setInt( 2 , mno );
			
			ps.executeUpdate(); return true;
			
		}catch (Exception e) { System.out.println(e); }
		return false; // 로그인 실패 
		
	}
	
	public boolean myInfoDeleteSQL( int mno ) {
		
		try {
			String sql = "delete from member where mno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , mno );
			
			ps.executeUpdate(); return true;
		
		}catch (Exception e) { System.out.println(e); }
		return false; // 로그인 실패 
		
	}
	
}

/*

// 2. 회원가입SQL 
	public void signupSQL( MemberDto dto ) {
		System.out.println("--- signupSQL 다오 도착 ");
		System.out.println( dto );
		// 1. 회원가입 필요한 SQL을 문자열에 작성(여기는 SQL공간 아니라서)해서 저장  
			// 테이블에 레코드 삽입 : insert into 테이블명( 필드명 , 필드명 , 필드명 ) values( 매개변수1 , 매개변수2 , 매개변수3 );
		String sql = "insert into member( mid , mpw , mname , mphone ) values( ? , ? , ? , ? )";
		
		try { // Connection , PreparedStatement , ResultSet 예외 처리 필수 !!! 
			
			// 2. 위에서 작성한 SQL를 DB연동객체에 대입 [ conn.prepareStatement( sql ) ]
			// 3. 대입된 SQL 조작하기 위해 반환된 PreparedStatement를 ps 대입 
			ps = conn.prepareStatement( sql ); // db연동객체.prepareStatement( 조작할SQL문자열 )
			// conn , ps 필드는 Dao 부모클래스에게 물려받음 
			
			// 4. SQL에서 작성한 매개변수(?) 에 대해 값 대입 	[ .setString( ?순서번호 , 값 ) ]
			ps.setString( 1 , dto.getMid() );
			ps.setString( 2 , dto.getMpw() );
			ps.setString( 3 , dto.getMname() );
			ps.setString( 4 , dto.getMphone() );
			// 5. SQL 실행 								[ ps.ps.executeUpdate();  : SQL 실행 ] 
			ps.executeUpdate();	
			
		}catch ( Exception e) { System.out.println("경고] 회원가입실패 사유 : "+e); }
	}

 
 
 */









