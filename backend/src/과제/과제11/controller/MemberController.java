package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() { return memberController; }
	private MemberController() {}
	
	// 2. 회원가입 처리
	public boolean signupLogic( String id , String pw , String name , String phone ) {
		System.out.println("--- signupLogic컨트롤 도착 ");
		System.out.println( id + pw + name + phone );
		// 유효성검사 했다치고 
		// 1. 객체화 : 5개 매개변수 들이 이동 할때마다 매개변수의 코드 길어지니까.. 패키지화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			// 1. 회원가입시 회원번호는 자동[auto_increment]이므로 필요 없으므로 기본값 0
		// 2. Dao 에게 전달 하고 SQL 결과 받기 
		boolean result = MemberDao.getInstance().signupSQL( dto );
		// 3. 결과를 view 에게 전달
		return result;
	}
	// 3. 로그인 처리
	public boolean loginLogic( String id , String pw) {
		// 유효성검사 했다치고 
		// 1. 매개 변수가 2개라서 객체화 해고 되고 안해도 되고 [선택]
		// 2. Dao 에게 전달
		boolean result = MemberDao.getInstance().loginSQL( id , pw );
		return result;
	}	
	
	// 4. 
	public String findById( String name , String phone) {
		// - 테스트. view 전달받은 매개변수 확인 
		System.out.println("findById value : " + name + phone );
		// Dao에게 매개변수 전달하고 찾은 아이디 반환 받기 
		String result =
				MemberDao.getInstance().findById(name, phone);
		return result; 
	}
	
	// 5.
	public String findByPw( String id , String phone ) {
		// - 테스트. view 전달받은 매개변수 확인 
		System.out.println("findByPw value : " + id + phone );
		// Dao에게 매개변수 전달하고 찾은 아이디 반환 받기 
		return MemberDao.getInstance().findByPw(id, phone);  // 실패 
	}
	
}


































