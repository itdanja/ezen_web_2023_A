package java2.day25_제네릭2.Ex2;

public class Applicant <T> {

	// 필드 
	public T kind;
	
	// 생성자
	public Applicant( T kind ) {
		this.kind = kind;
	}
	
}
