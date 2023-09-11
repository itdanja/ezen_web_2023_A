package model.dto;

public class MsgDto {
	
	private String frommid; // 보낸사람 
	private String msg; 	// 보낸내용
	
	public MsgDto() {
		// TODO Auto-generated constructor stub
	}

	public MsgDto(String frommid, String msg) {
		super();
		this.frommid = frommid;
		this.msg = msg;
	}

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MsgDto [frommid=" + frommid + ", msg=" + msg + "]";
	}
	
	
		
}
