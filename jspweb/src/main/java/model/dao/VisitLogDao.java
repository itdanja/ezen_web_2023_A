package model.dao;

import java.util.ArrayList;

import model.dto.VisitLogDto;

public class VisitLogDao extends Dao {
	private static VisitLogDao visitLogDao = new VisitLogDao();
	public static VisitLogDao getInstance() { return visitLogDao; }
	private VisitLogDao() {}
	
	// 1. 등록 
	public boolean vwrite( VisitLogDto visitLogDto ) {
		
		String sql = "insert into visitlog( vwriter , vpwd , vcontent )values(?,?,?)";
		try {
		
			setPs( getConn().prepareStatement(sql) );
			getPs().setString( 1 , visitLogDto.getVwriter() );
			getPs().setString( 2 , visitLogDto.getVpwd() );
			getPs().setString( 3 , visitLogDto.getVcontent() );
			
			int row = getPs().executeUpdate();
			if( row == 1 ) { return true; }
	
		}
		catch (Exception e) {System.out.println(e);}
		finally { try { getPs().close(); getRs().close(); }catch (Exception e) {} }
		return false;
	}
	
	// 2. 
	public ArrayList<VisitLogDto> vprint(){
		
		ArrayList<VisitLogDto> list = new ArrayList<>();
		String sql ="select * from visitlog order by vno desc";
		try {
			setPs( getConn().prepareStatement(sql) );
			setRs(  getPs().executeQuery() );
			
			while( getRs().next() ) {
				VisitLogDto visitLogDto  = new VisitLogDto( 
						getRs().getInt(1) , 
						getRs().getString(2) , 
						getRs().getString(3) , 
						getRs().getString(4) , 
						getRs().getString(5) );
				list.add(visitLogDto);
			}
		}
		catch (Exception e) {System.out.println(e);}
		finally { try { getPs().close(); getRs().close(); }catch (Exception e) {} }
		return list;
	}
	
	// 3. 
	public int vupdate( int vno , String vpwd , String vcontent ) { 
		
		String sql ="update visitlog set vcontent = ? where vno =? and vpwd = ?";
		
		try {
			setPs( getConn().prepareStatement(sql) );
			getPs().setInt( 2 , vno );
			getPs().setString( 3 , vpwd );
			getPs().setString( 1 , vcontent );
			int row = getPs().executeUpdate();
			if( row == 1 ) { return 1; }
			else { return 2;}
		}
		catch (Exception e) { System.out.println(e);}
		finally { try { getPs().close(); getRs().close(); }catch (Exception e) {} }
		
		return 0;}
	// 4 .
	public int vdelete( int vno , String vpwd ) { 
		String sql ="delete from visitlog where vno =? and vpwd = ?";
		try {
			setPs( getConn().prepareStatement(sql) );
			getPs().setInt( 1 , vno );
			getPs().setString( 2 , vpwd );
			int row = getPs().executeUpdate();
			if( row == 1 ) { return 1; }
			else { return 2;}
		}
		catch (Exception e) { System.out.println(e);}
		finally { try { getPs().close(); getRs().close(); }catch (Exception e) {} }
		return 0;}
	
}




















