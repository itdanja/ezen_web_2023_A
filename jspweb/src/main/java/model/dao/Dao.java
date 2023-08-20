package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	private Connection conn;			// DB연동 객체
	private PreparedStatement ps; 		// 연동된 DB에서 SQL조작( SQL매개변수대입, SQL실행/취소 ) 하는 객체 
	private ResultSet rs;				// SQL 조작 결과(검색결과)를 가져오는 객체 

	protected Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb0"
							, "root", "1234");
		}catch (Exception e) {System.out.println("경고] DB연동성공실패 : "+e);}
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public PreparedStatement getPs() {
		return ps;
	}
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
	
}
