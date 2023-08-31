package model.dao;

import java.time.LocalDateTime;

import model.dto.MemberDto;

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
	
	// 8. 회원탈퇴
	
	
	
}
















