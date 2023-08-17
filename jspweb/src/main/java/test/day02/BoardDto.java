package test.day02;

public class BoardDto {
	
	private String title;
	private String content;

	public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	public BoardDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardDto [title=" + title + ", content=" + content + "]";
	}
	
	
}
