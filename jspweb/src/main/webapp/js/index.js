

findByTop(10);
function findByTop( count ){
	
	$.ajax({
		url : "/jspweb/ProductInfoController" , 
		method: "get" , 
		data : { type : "fintByTop" , count : count },
		success : productList => { 
			
			console.log(productList);
			
			let productBox = document.querySelector('.productBox')
			
			let html = ``;
			
			
			productList.forEach( (p)=>{
				
				let firstImg = p.imgList[Object.keys(p.imgList)[0]];
				
				html += `<div class="col">
						    <div class="card">
						      <img src="/jspweb/product/img/${ firstImg }" class="card-img-top" alt="...">
						      <div class="card-body">
						        <h5 class="card-title">${ p.pname}</h5>
						        <p class="card-text"> 
						        	<div>${ p.pcontent }</div> 
						        	<div>${ p.pprice }</div> 
					        	</p>
						      </div>
						    </div>
						  </div>`
			});
			productBox.innerHTML = html;
		 },
		 error : e => { console.log(e);} 
	})
}

//fintByAll(  );
function fintByAll(  ){
	
	$.ajax({
		url : "/jspweb/ProductInfoController" , 
		method: "get" , 
		data : { type : "fintByAll"  },
		success : productList => { 
			
			console.log(productList);
		
		 },
		 error : e => { console.log(e);} 
	})
	
}

//fintByPno( 1  );
function fintByPno( pno ){
	
	$.ajax({
		url : "/jspweb/ProductInfoController" , 
		method: "get" , 
		data : { type : "fintByPno"  , pno : pno },
		success : product => { 
			
			console.log(product);
		
		 },
		 error : e => { console.log(e);} 
	})
	
}

//fintByLatLng( 1  );
function fintByLatLng( pno ){
	
	$.ajax({
		url : "/jspweb/ProductInfoController" , 
		method: "get" , 
		data : { type : "fintByLatLng"  , pno : pno },
		success : productList => { 
			console.log(productList);
		 },
		 error : e => { console.log(e);} 
	})
}




/*

*/