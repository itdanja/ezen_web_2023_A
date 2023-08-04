package 과제.과제11.controller;

public class MemberController {
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() { return memberController; }
	private MemberController() {}
	
	// 2. 회원가입 처리
	public void signupLogic() {
		System.out.println("--- signupLogic컨트롤 도착 ");
	}
	// 3. 로그인 처리
	public void loginLogic() {
		System.out.println("--- loginLogic컨트롤 도착 ");
	}
	
}
