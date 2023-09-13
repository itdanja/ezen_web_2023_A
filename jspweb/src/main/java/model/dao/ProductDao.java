package model.dao;

public class ProductDao extends Dao {

	private static ProductDao productDao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return productDao; }
	
	
	// 1. 제품 등록 
	
	// 2. 제품 전체 출력 
	
	// 3. 제품 개별 조회 
	
	// 4. 제품 수정 
	
	// 5. 제품 삭제 
	
}
