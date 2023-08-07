package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() { return memberController; }
	private MemberController() {}
	
	private int loginMno = 0; 
	
	
	
	public int getLoginMno() {
		return loginMno;
	}
	public void setLoginMno(int loginMno) {
		this.loginMno = loginMno;
	}
	// 2. 회원가입 처리
	public int signupLogic( String id , String pw , String name , String phone ) {
		System.out.println("--- signupLogic컨트롤 도착 ");
		System.out.println( id + pw + name + phone );
		// 유효성검사 했다치고 
			// 1. 아이디중복체크
			if( MemberDao.getInstance().infoCheck( 1 , id ) ) return 3;
			// 2. 이메일중복체크 
			if( MemberDao.getInstance().infoCheck( 2 , phone )) return 4;
			
		// 1. 객체화 : 5개 매개변수 들이 이동 할때마다 매개변수의 코드 길어지니까.. 패키지화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			// 1. 회원가입시 회원번호는 자동[auto_increment]이므로 필요 없으므로 기본값 0
		// 2. Dao 에게 전달 하고 SQL 결과 받기 
		boolean result = MemberDao.getInstance().signupSQL( dto );
		// 3. 결과를 view 에게 전달
		if( result ) return 1;
		else return 0;
	}
	// 3. 로그인 처리
	public boolean loginLogic( String id , String pw) {
		// 유효성검사 했다치고 
		// 1. 매개 변수가 2개라서 객체화 해고 되고 안해도 되고 [선택]
		// 2. Dao 에게 전달
		int result = MemberDao.getInstance().loginSQL( id , pw );
		// 
		if( result != 0 ) { this.loginMno = result; return true;  }
		return false;
	}	
	
	// 3. 아이디찾기 화면
	public String findIdLogic( String name , String phone ) {
		String result = MemberDao.getInstance().findIdSQL( name , phone );
		return result;
	}
	// 3. 비밀번호찾기 화면
	public String findPwLogic(String id , String phone) {
		String result = MemberDao.getInstance().findPwSQL( id , phone );
		return result;
	}
	// 4. 로그아웃
	public void logOut() { this.loginMno = 0; }
	
	//
	public MemberDto myInfoLogic() {
		return MemberDao.getInstance().myInfoSQL(loginMno);
	}
	
	public boolean myInfoUpdateLogic( String newPw ) {
		return MemberDao.getInstance().myInfoUpdateSQL( newPw , loginMno );
	}
	
	public boolean myInfoDeleteLogic(  ) {
		
		boolean result =  MemberDao.getInstance().myInfoDeleteSQL( loginMno );
		
		logOut();
		
		return result;
		
	}
	
	
	
}










































