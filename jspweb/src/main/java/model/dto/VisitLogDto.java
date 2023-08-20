package model.dto;

public class VisitLogDto {

	private int vno;
	private String vwriter;
	private String vpwd;
	private String vcontent;
	private String vdate;

	public VisitLogDto() {
		// TODO Auto-generated constructor stub
	}

	public VisitLogDto(int vno, String vwriter, String vpwd, String vcontent, String vdate) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
		this.vdate = vdate;
	}

	public VisitLogDto(String vwriter, String vpwd, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
	}

	public int getVno() {
		return vno;
	}

	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getVwriter() {
		return vwriter;
	}

	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}

	public String getVpwd() {
		return vpwd;
	}

	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}

	public String getVdate() {
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	@Override
	public String toString() {
		return "VisitLogDto [vno=" + vno + ", vwriter=" + vwriter + ", vpwd=" + vpwd + ", vcontent=" + vcontent
				+ ", vdate=" + vdate + "]";
	}
	
	
	
}
