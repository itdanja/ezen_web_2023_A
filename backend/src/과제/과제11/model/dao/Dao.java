package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao { // 각종Dao 클래스를 대표하는 부모클래스 
	// 1.필드
	// [ import java.sql ] 
	public Connection conn;			// DB연동 객체
	public PreparedStatement ps; 	// 연동된 DB에서 SQL조작( SQL매개변수대입, SQL실행/취소 ) 하는 객체 
	public ResultSet rs;			// SQL 조작 결과(검색결과)를 가져오는 객체 
	// 2.생성자 : 객체 생성시 초기화 담당
		// 기본생성자에 DB연동 코드 작성 *DAO객체생성시 바로 DB연동 
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web"
							, "root", "1234");
		}catch (Exception e) {System.out.println("경고] DB연동성공실패 : "+e);}
	}
}











