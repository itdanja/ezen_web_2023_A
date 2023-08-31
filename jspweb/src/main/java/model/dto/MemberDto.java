package model.dto;

public class MemberDto {
	// 1. 필드 
		// 1-1 DB 있는 필드
	private int mno; 
    private String mid; 
    private String mpwd; 
    private String memail ;
    private String  mimg ;
    	// 1-2 DB 없는 필드 
    private String loginDatetime; // 로그인 시간
    
    // -- * 로그인 객체를 만들 생성자 [ 패스워드 제외 ] : 오버로딩 하기위해 매개변수 타입 순서 변경 
	public MemberDto( String loginDatetime , int mno, String mid, String memail, String mimg ) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mimg = mimg;
		this.loginDatetime = loginDatetime;
	}

	// 2. 생성자 
    public MemberDto() { }
    
	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}

    // -- * 회원가입 용 생성자
	public MemberDto(String mid, String mpwd, String memail, String mimg) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}

	// 3. 
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
    public String getLoginDatetime() {
		return loginDatetime;
	}
	public void setLoginDatetime(String loginDatetime) {
		this.loginDatetime = loginDatetime;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail + ", mimg=" + mimg
				+ ", loginDatetime=" + loginDatetime + "]";
	}
	
	
	
}
