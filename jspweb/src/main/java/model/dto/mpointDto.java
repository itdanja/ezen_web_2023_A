package model.dto;

public class mpointDto {
	
	private String mpno ;
	private int mno;								
	private long mpamount;		
	private String mpcomment;
	private String mpdate;
	
	public mpointDto() { }

	public mpointDto(String mpno, int mno, long mpamount, String mpcomment, String mpdate) {
		super();
		this.mpno = mpno;
		this.mno = mno;
		this.mpamount = mpamount;
		this.mpcomment = mpcomment;
		this.mpdate = mpdate;
	}

	public String getMpno() {
		return mpno;
	}

	public void setMpno(String mpno) {
		this.mpno = mpno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public long getMpamount() {
		return mpamount;
	}

	public void setMpamount(long mpamount) {
		this.mpamount = mpamount;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public String getMpdate() {
		return mpdate;
	}

	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}

	@Override
	public String toString() {
		return "mpointDto [mpno=" + mpno + ", mno=" + mno + ", mpamount=" + mpamount + ", mpcomment=" + mpcomment
				+ ", mpdate=" + mpdate + "]";
	}
	
}
