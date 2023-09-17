package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.dto.ProductDto;

public class ProductDao extends Dao {

	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return productDao; }
	
	
	// 1. 제품 등록 
	public boolean register( ProductDto dto ) {
		
		// 1-1 [제품 등록] 
		try {
			
			String sql = "insert into product( pcno , pname , pcontent , pprice , plat , plng , mno  ) "
					+ "	values( ? , ? , ? , ? , ? , ? , ?  );";
			// * sql insert 후 자동생성[auto_increment]된 pk번호를 반환하는 방법 
				// conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ) 	: 생성된 식별키를 반환
				// ps.getGeneratedKeys() 											: 식별키 반환하는 함수.
			ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ); 
			
			ps.setInt( 1 , dto.getPcno()  );		ps.setString( 2 , dto.getPname() );
			ps.setString( 3 , dto.getPcontent() );	ps.setInt( 4 , dto.getPprice() );
			ps.setString( 5 , dto.getPlat() );		ps.setString( 6 , dto.getPlng() );
			ps.setInt( 7 , dto.getMno() );
			
			int count = ps.executeUpdate();	// 제품 등록 
			
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk->pno] 반환해서 resultset[ps]에 대입
			if( rs.next() ) {	// resultset  null ---next()--> 결과레코드1 --next()--> 결과레코드2 
							// 반환된 결과레코드로 1번 이동 [ 하나의 제품 식별키 필요 ]
				if( count == 1 ) { // 만약에 제품등록 1개 등록했으면 
					// 1-2 제품 등록후 생성된 제품pk를 가지고 [이미지 등록] 
						// 1. dto 에 저장된 이미지 개수만큼 insert 실행 
					for( String img : dto.getImgList().values() ) {
						sql = "insert into productimg( pimg , pno ) values( ? , ? )";
						ps = conn.prepareStatement(sql);
						ps.setString( 1 , img  );
						ps.setInt( 2 , rs.getInt( 1 ) ); // ??????????? 위에서 insert 된 제품번호 ????
						ps.executeUpdate();
					} 
					return true; // 제품등록과 이미지 등록 성공 했을때. 
				}
			}
			
		}catch (Exception e) { System.out.println( e ); } return false;
	}
	
	
	public ArrayList<ProductDto> findByAll(){
		ArrayList<ProductDto> list = new ArrayList<>();
		try {
			String sql  ="select * from product order by pdate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { 	list.add( findByPno(rs.getInt("pno")) ); }
			return list;
		}catch (Exception e) {System.out.println(e);	}
		return null;
	}
	
	// 
	public Map<Integer, String > getProductImg( int pno ){
		try {
			Map<Integer, String > imglist = new HashMap<>();
			String sql = "select * from productimg where pno="+rs.getInt("pno");
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) { imglist.put( resultSet.getInt("pimgno"), resultSet.getString("pimg") ); }
			return imglist;
		}catch (Exception e) {System.out.println(e);} return null;
	}
	
	public ProductDto findByPno( int pno ){
		try {
			String sql = "select * from product p natural join pcategory pc natural join member m where p.pno = ? ";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt( 1 , pno);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) { 
				ProductDto productDto = new ProductDto(
						resultSet.getInt("pcno") , 
						resultSet.getString("pcname"), 
						resultSet.getInt("pno"), 
						resultSet.getString("pname"),
						resultSet.getString("pcontent"), 
						resultSet.getInt("pprice"),
						resultSet.getInt("pstate"), 
						resultSet.getString("pdate"),
						resultSet.getString("plat"),
						resultSet.getString("plng"),
						resultSet.getInt("mno"),
						getProductImg( rs.getInt("pno") ), 
						resultSet.getString("mid")
						);
				return productDto;
			}
		}catch (Exception e) {System.out.println(e);} return null;
	}
	
	public ArrayList<ProductDto> findByTop( int count ){
		ArrayList<ProductDto> list = new ArrayList<>();
		try {
			String sql  ="select * from product order by pdate desc limit "+count;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { 	list.add( findByPno(rs.getInt("pno")) ); }
			return list;
		}catch (Exception e) {System.out.println(e);	}
		return null;
	}
	
	public ArrayList<ProductDto> findByLatLng( String 동 , String 서 , String 남 , String 북 ){
		ArrayList<ProductDto> list = new ArrayList<>();
		try {
			String sql ="SELECT * FROM product where ? >= plng and ? <= plng and ? <= plat and ? >= plat order by pdate desc ";
			ps = conn.prepareStatement(sql);
			ps.setString( 1 , 동 );	ps.setString( 2 , 서 );	ps.setString( 3 , 남 );	ps.setString( 4 , 북 );
			rs = ps.executeQuery();
			while( rs.next() ) { 	list.add( findByPno(rs.getInt("pno")) ); }
			return list;
		}catch (Exception e) {System.out.println(e);	}
		return null;
	}
	

	
	// 4. 제품 수정 
	
	// 5. 제품 삭제 
	
}


/*
 * 						// 	Map<Integer, String>			: map객체명.keySet() : map객체내 모든 키 호출 
						//	Map<Integer, String>			: map객체명.values() : map객체내 모든 값 호출 
				
						// ------ get( 인덱스 ) 	: LIST컬렉션은 인덱스 사용 
						// ------ get( 키 ) 		: SET컬렉션 MAP컬렉션은 인덱스가 없으므로 키 값으로 호출 
						// ------ 
				
 * 
 * 
 * 
 */










