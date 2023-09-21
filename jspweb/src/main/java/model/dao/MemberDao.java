package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.dto.MemberDto;
import model.dto.mpointDto;

public class MemberDao extends Dao {
	// 0. 싱글톤
	private static MemberDao memberDao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return memberDao; }
	
	// 1. 회원가입
	public boolean signup( MemberDto dto ) {
		try {
			String sql = "insert into member( mid , mpwd , memail , mimg ) values( ? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , dto.getMid() );
			ps.setString( 2 , dto.getMpwd() );
			ps.setString( 3 , dto.getMemail() );
			ps.setString( 4 , dto.getMimg() );
			int row = ps.executeUpdate();
			if( row == 1 )return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 로그인 
	public boolean login( String mid , String mpwd ) {
		try {
			String sql ="select * from member where mid =  ? and mpwd = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , mid ); ps.setString( 2 , mpwd );
			rs = ps.executeQuery();
			if( rs.next() ) return true;
		}catch (Exception e) { System.out.println(e);}
		return false;
	}
	// 3. 아이디찾기
	
	// 4. 비밀번호찾기 
	
	// 5. 내정보 호출 
	public MemberDto info( String mid ) {
		try {
			String sql ="select mno , mid , memail , mimg from member where mid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , mid );
			rs = ps.executeQuery();
			if( rs.next() ) {
				MemberDto memberDto = new MemberDto( 
						LocalDateTime.now().toString() , 
						// LocalDateTime.now().toString() : 현재 날짜/시간 문자열 반환 함수 
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
				return memberDto;
			}
		}catch (Exception e) { System.out.println(e ); }
		return null;
	}
	
	// 6. 아이디/이메일 중복검사 [ 인수 : 검사할아이디 / 반환 : true(중복있어) , false(중복없어) 
		// - type(mid,memail) : 필드명 / data(입력받은mid,memail) : 필드에서 찾을 값 
	public boolean findIdOrEmail( String type , String data ) {
		try {
			String sql = "select * from member where "+type+" = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , data );
			rs = ps.executeQuery();
			// [ while : 결과 레코드 여러개 검사 vs if : 결과 레코드 한개 검사 ]
			if( rs.next() ) return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 7. 회원수정
	public boolean mupdate( int mno , String mimg ) {
		try {
			String sql = "update member set mimg = ? where mno = ?";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , mimg ); ps.setInt( 2 , mno);
			int count = ps.executeUpdate();
			if( count == 1 ) return true ;
		}catch (Exception e) {System.out.println(e);	}
		return false;
	}
	
	// 8. 회원탈퇴 [ 삭제할회원번호 , 검증할패스워드 ]
	public boolean mdelete( int mno , String mpwd ) {
		try {
			String sql ="delete from member where mno = ? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , mno); ps.setString(2, mpwd);
			int count = ps.executeUpdate();
			if( count == 1 ) return true; // 삭제성공 => 회원탈퇴
		}catch (Exception e) {System.out.println(e);}
		return false; // 회원번호 또는 입력받은 패스워드 일치하지 않거나
	}
	
	// 9. 포인트 사용[증감/차감] 에 대한 함수 [ 인수: mpno식별번호 , mno회원번호 , mpamount포인트수 , mpcomment지급내역 vs mpointDto ]
	public boolean setPoint( mpointDto dto ) {
		try {
			String sql = "insert into mpoint(mpno,mno,mpamount,mpcomment)values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , dto.getMpno() ); 			ps.setInt( 2 , dto.getMno() );
			ps.setLong( 3 , dto.getMpamount() );		ps.setString( 4 , dto.getMpcomment() );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch (Exception e) { e.getStackTrace();		} return false;
	} 
	// 10. 내 포인트 수 확인 함수 [ 로그인한 사람의 현재 포인트 합계 ] [ 인수: mno회원번호 ]
	public long getPoint( int mno ) {
		try {		// sum( 필드명 )  : 총합계를 계산할 필드명 인수로 대입
			String sql = "select sum( mpamount ) from mpoint where mno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , mno );
			rs = ps.executeQuery();
			if( rs.next() ) { return rs.getInt( 1 ); } 
		}catch (Exception e) { e.getStackTrace();		} return 0;
	}
	// 11. 내 포인트 사용 내역 전체 출력하는 함수  [ 인수: mno회원번호 ]
	public List< mpointDto > getPointList(  int mno  ){
		List< mpointDto > list = new ArrayList<>();
		try {
			String sql = "select * from mpoint where mno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , mno );
			rs = ps.executeQuery();
			while( rs.next() ) { 
				mpointDto dto = new mpointDto( rs.getString(1), rs.getInt(2), 
						rs.getLong(3), rs.getString(4), rs.getString(5) );
				list.add( dto );
			}  
		}catch (Exception e) { e.getStackTrace();		} return list;
	}
}
/*

		JDBC : JAVA 와 DB 간의 연동 라이브러리 [ mysql-connector-j-8.1.0.jar ]
				1. Connection	
				2. PreparedStatement
				3. ResultSet		
				- DriverManager.getConnection(연동할 DB주소)
				
				
				1. 연동 :  new MemberDao();싱글톤생성
					-------------------------------------
							스트림[ 데이터 다니는 통로 ] 					DB서버
	JAVA					DriverManager.getConnection					localhost:3306
					-------------------------------------
					
				2. 연동 결과 [ 싱글톤이 사라기전까지는 연동중 ]
					-------------------------------------
	JAVA						Connection conn						DB서버
					-------------------------------------
					
				3. 연동 결과 [ SQL 대입해서 PreparedStatement   ]
					-------------------------------------
	JAVA						prepareStatement(SQl)				DB서버
					-------------------------------------	
					
				4. SQL 조작/준비 [ SQL 대입해서 PreparedStatement   ]
					-------------------------------------
	JAVA	ps														DB서버
					-------------------------------------	
			SQL 가공
			set( 1 , ~~ );		
			
				5. SQL 실행 [ SQL 대입해서 PreparedStatement   ]
					-------------------------------------
	JAVA	ps			ps.executeQuery();	ResultSet						DB서버
						ps.executeUpdate();	int
					-------------------------------------	
	
	
				5. SQL 실행에 SQL결과값/ 레코드 반환 [ SQL 대입해서 PreparedStatement   ]
					-------------------------------------
	JAVA	ResultSet	ResultSet[ 질의한 결과의 여러개레코드 ]										DB서버
						int[ update 레코드 개수 반환 ]
					-------------------------------------	
		
		ResultSet 
			null --- rs.next()---> 찾은1행 레코드 ----rs.next()--> 찾은2행 레코드 ---rs.next()---> 찾은3행 레코드
									로그인														
									제품1개														여러개 출력 
									아이디찾기
									비밀번호찾기 
			if( rs.next() ) 
			while( rs.next() )
			
		
	
 */




































