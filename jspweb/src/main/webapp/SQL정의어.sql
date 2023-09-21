drop database if exists jspweb;
create database jspweb;
use jspweb;

drop table if exists visitlog;
create table visitlog(
	vno			int auto_increment , 		-- 식별번호( 방문록번호 ) , 자동번호 부여 
    vwriter 	varchar(30) not null , 		-- (방문록작성자명) , 공백불가능 
    vpwd 		varchar(10) not null , 		-- (방문록비밀번호) , 공백불가능 
    vcontent	text not null , 			-- (방문록 내용 ) 
    vdate		datetime default now() , 	-- (방문록 작성일/시간 ) , 생략시 자동날짜/시간 등록 
    primary key( vno )
);
drop table if exists member;
create table member(
	mno int auto_increment ,				-- 식별번호( 회원번호 ) , 자동번호 부여 
    mid varchar(50) not null unique ,		-- ( 회원아이디 ) , 공백불가능 , 중복불가능  
    mpwd varchar(20) not null , 			-- ( 회원비밀번호 ) , 공백불가능  
    memail varchar(50) not null unique ,	-- ( 회원이메일 )  , 공백불가능  
    mimg longtext ,							-- ( 회원 프로필의 이미지사진 이름 ) , 공백가능 
    primary key( mno )
);

# 게시판 카테고리 
drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment , 		
    bcname varchar(30) not null ,
    primary key( bcno )
);
# 샘플 [ 공지사항 , 자유게시판  , 노하우 ] 
insert into bcategory value ( 1 , '공지사항');
insert into bcategory value ( 2 , '자유게시판');
insert into bcategory value ( 3 , '노하우');

# 게시판 
drop table if exists board;
create table board(
	bno			int auto_increment , 
    btitle		varchar(30) not null , 
    bcontent 	longtext , 
	bfile		longtext , 
    bdate		datetime default now() ,
    bview		int default 0 ,
    mno			int , 
    bcno		int ,
    primary key( bno ) ,
    foreign key( mno ) references member(mno) 
    		on delete cascade ,  -- 회원탈퇴시 게시물도 같이 삭제 [ 제약조건 ]
    foreign key( bcno ) references bcategory( bcno ) 
    		on delete cascade 
    		on update cascade  	-- 카테고리 삭제시 게시물도 삭제 , 카테고리번호 변경시 fk도 같이 변경   [ 제약조건 ]
);
# ------------- 제품 --------------------------- # 
	# pk[상위] 테이블 먼저 생성 
# 1. 제품 카테고리 
drop table if exists pcategory;
create table pcategory( pcno int auto_increment , pcname varchar(100) not null , primary key(pcno)  );
	# 샘플 
	insert pcategory(pcname) values( '노트북' ); insert pcategory(pcname) values( '태블릿' ); insert pcategory(pcname) values( '냉장고' );
# 2. 제품 
drop table if exists product;
create table product(
	pno			int auto_increment ,  
    pname		varchar(100)  not null , 
    pcontent	longtext , 
    pprice		int unsigned default 0 not null ,	-- signed(기본값:음수사용 +-21억) / unsigned(음수사용X-음수만큼의메모리를 양수로 사용 0~42억정도 ) : 음수 사용여부 
    pstate		tinyint default 0 not null , -- [ 0 : 판매중(기본값) , 1:거래중 , 2:판매대기 3:판매완료 ]
    pdate 		datetime default now() not null , 
    plat		varchar(30) not null, 
    plng		varchar(30) not null, 	
    pcno		int ,
    mno			int ,
    primary key( pno ) , 
    foreign key( pcno ) references pcategory(pcno) on delete set null on update cascade , 
    foreign key( mno ) references member(mno) on delete cascade on update cascade
);
# 3. 제품 이미지 
drop table if exists productimg;
create table productimg(  
	pimgno int auto_increment , 
    pimg longtext , 
    pno int ,
    primary key ( pimgno ) , 
    foreign key( pno ) references product( pno ) on delete cascade on update cascade
);

# 4. 제품 찜하기
# - 1. 찜하기 테이블 [ pk 없는 경우 ]
drop table if exists pwishlist;
create table pwishlist(
	mno int not null,
    pno int  ,
    foreign key(mno) references member(mno) on delete cascade on update cascade ,	-- 회원이 탈퇴하면 찜하기 목록 같이 삭제 
    foreign key(pno) references product(pno) on delete set null on update cascade  	-- 제품이 삭제되면 찜하기 목록에서 없는 제품으로 표시하기 위한 null 대입 
);
/*
# - 2. 찜하기 테이블 [ pk 있는 경우 ]

drop table if exists pwishlist;
create table pwishlist(
	pwno int auto_increment ,
	mno int not null,
    pno int  ,
    primary key (pwno) ,
    foreign key(mno) references member(mno) on delete cascade on update cascade ,	-- 회원이 탈퇴하면 찜하기 목록 같이 삭제 
    foreign key(pno) references product(pno) on delete set null on update cascade  -- 제품이 삭제되면 찜하기 목록에서 없는 제품으로 표시하기 위한 null 대입 
);
# - 3. 찜하기 테이블 [ auto_increment 사용했을때 최대치 대한 고민.. ]
drop table if exists pwishlist;
create table pwishlist(
	pwno bigint unsigned auto_increment ,	# bigint[long]		unsigned[양수] vs signed[양수/음수]
	mno int not null,
    pno int  ,
    primary key (pwno) ,
    foreign key(mno) references member(mno) on delete cascade on update cascade ,	-- 회원이 탈퇴하면 찜하기 목록 같이 삭제 
    foreign key(pno) references product(pno) on delete set null on update cascade  -- 제품이 삭제되면 찜하기 목록에서 없는 제품으로 표시하기 위한 null 대입 
);
# - 3. 찜하기 테이블 [ auto_increment 없을때 ]
drop table if exists pwishlist;
create table pwishlist(
	pwno longtext , -- 직접 식별키 생성 [ 1. UUID 2. 커스텀생성 (데이터조합) ]
	mno int not null,
    pno int  ,
    primary key (pwno) ,
    foreign key(mno) references member(mno) on delete cascade on update cascade ,	-- 회원이 탈퇴하면 찜하기 목록 같이 삭제 
    foreign key(pno) references product(pno) on delete set null on update cascade  -- 제품이 삭제되면 찜하기 목록에서 없는 제품으로 표시하기 위한 null 대입 
);

*/

# 포인트내역 테이블 
drop table if exists mponint;
create table mpoint( 
	mpno varchar(40),						-- 포인트내역 식별번호 [ UUID ]
	mno int ,								-- 지급대상 [ 회원번호 fk ]
    mpamount bigint signed default 0 , 		-- 대락 +-21억이상[ signed 기본값/생략시 , unsigned ]
	mpcomment varchar(100) , 				-- 지급내역 
    mpdate datetime default now() , 		-- 지급날짜 
    primary key( mpno ) , 
    foreign key( mno ) references member(mno) on delete set null on update cascade 
);





















