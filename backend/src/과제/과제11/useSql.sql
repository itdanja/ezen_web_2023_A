# JDBC와 연결할 DB 선언 
drop database if exists sqldb4web;
create database sqldb4web;

# 회원번호[자동] 아이디 비밀번호 이름 전화번호를 저장하는 member 테이블 생성 
use sqldb4web;
drop table if exists member;
create table member(
	mno int not null unique auto_increment ,	-- 자동부여[무조건PK만가능] 
    mid varchar(30) not null unique,
    mpw varchar(30)  not null ,		-- 중복허용 
    mname varchar(30) not null ,	-- 중복허용 
    mphone varchar(13) not null unique ,
    primary key(mno) 
);

# 게시판 테이블 
use sqldb4web;
drop table if exists board;
create table board(
	bno			int	auto_increment , 	#정수 , 자동번호 부여  
    btitle		varchar(50) not null , 	#문자50 , 공백불가 
    bcontent	longtext , 				#긴글[4G]
    bdate		datetime default now(),	#날짜/시간 , 기본값을 레코드삽입기준 자동 
    bview		int default 0 ,			#정수 , 기본값을 0 
    mno			int ,					#작성자의 회원번호[ 작성자의 식별번호 ]
    primary key( bno )	,				#제약조건 [ PK ]
	foreign key( mno ) references member( mno ) on delete cascade  		# 회원탈퇴[PK레코드삭제] 되면 FK의 레코드 같이 삭제 
);