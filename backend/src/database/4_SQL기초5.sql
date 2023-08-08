# 확대축소 : ctrl + 마우스휠
# 한줄주석
-- 한줄주석 
/* 여러줄 주석 */

/*
	데이터베이스 : 데이터[자료] , 베이스[모임]
		- 종류
			1. 계층형 데이터 베이스 : 트리형태
            2. 네트워크형 데이터 베이스 : 양방향 형태
            3. *관계형 데이터 베이스 : 행/열 구성된 테이블[표] 형태
            4. NoSQL 데이터 베이스 : Key-value 형태
			
		- 용어
				DBA[ 데이터베이스 관리자 ]
					- 개발자 
                DBMS[ 데이터베이스 관리 시스템]
					- MYSQL , ORACLE , MARIADB , SQLSERVER -각 회사별 소프트웨어
                    - 표준 SQL [ 구조화된 질의 언어 ]
                DB [ 데이터베이스 ]
					- 실제 데이터 저장된 곳 = DB SERVER 
                    - 메모리[ 16진수/기계어 ] : 개발자 직접적으로 관리 힘듬...
                    
		- 관계
            DBA		----------> 	DB		[ X ]
			개발자					기계어 
            
            DBA		---------->		DBMS	---------> DB		[ O ]
            개발자 					관리시스템 			기계어
									MYSQL
                                    ORACLE
                    표 만들어줘					기계어
                    create
					SQL언어 학습
            이클립스	----------> 	JVM		---------> 메모리		[ O ]
			개발자					번역					
					출력해줘						기계어
                    print()
                    자바언어 학습
                    
		- SQL : DB 조작/관리/제어 할때 사용되는 언어/문법 (대소문자 구분X)
			-1. DDL [ 데이터베이스 정의어 ]
				- 1. create 	: 데이터베이스 , 테이블(표) 생성
					- create database db명;
                    - create table table명( 필드명 속성명 , 필드명 속성명 , 필드명 속성명 );
                    
                - 2. drop 		: 데이터베이스 , 테이블(표) 삭제 
					- drop database db명;
                    - drop database if exists db명;
                    - drop table table명;
                    
                - 3. alter 		: 테이블(표) 속성 수정 
                - 4. truncate  	: 테이블(표)내 데이터 초기화/삭제
                - 5. rename 	: 테이블(표) 의 이름 변경 
                - 6. show		:
					- show databases;					: 데이터베이스 전체 목록보기 
                    - show variables like 'datadir';	: 데이터베이스 저장소 로컬 경로 확인 
				- 7. use
					- use db명	: 데이터베이스 사용 선택
                    
            -2. DML [ 데이버베이스 조작어 ]
				- 1. insert 	: 테이블(표)에 레코드(행) 삽입 
                	# 1. insert into 테이블명 values( 값1 , 값2 , 값3 );					# 모든 필드에 값 삽입 할때
					# 2. insert into 테이블명( 필드명1, 필드명2 ) values( 값1 , 값2 ) 		# 특정 필드에 값 삽입 할때.
                    
                - 2. select 	: 테이블(표)에 레코드(행) 검색 
					select * from 테이블명				: 모든 레코드 검색 [ *모든필드 표시 ]
					select 필드명 , 필드명 from 테이블명			: 모든 레코드 검색 [ 특정필드 표시 ]
					select * from 테이블명 where 조건절 			: 조건에 충족[true]하는 레코드 검색  [ *모든필드 표시 ]
					select 필드명 , 필드명 from 테이블명 where 조건절 	: 조건에 충족[true]하는 레코드 검색 [ 특정필드 표시 ]
                    
                - 3. update 	: 테이블(표)에 레코드(행) 수정 
					update 테이블명 set 필드명 = 수정할값;			: 모든 레코드의 특정 필드의 값 수정 
					update 테이블명 set 필드명 = 수정할값 where 조건절 ;	: 조건에 충족[true]하는 레코드만 특정 필드의 값 수정 
                    
                - 4. delete 	: 테이블(표)에 레코드(행) 삭제 
					delete from 테이블명;				: 모든 레코드 삭제
					delete from 테이블명 where 조건절;			: 조건에 충족[true]하는 레코드만 삭제 

            -3. DCL [ 데이터베이스 제어어 ]
				- 1. grant		: 사용자 권한 부여 
                - 2. revoke		: 사용자 권한 취소 
            -4. TCL [ 트랜잭션 제어어 ]
				- 1. commit		: !! 트랜잭션[명령어 단위] 완료
                - 2. rollback	: 트랜잭션[명령어 단위] 취소
                
                
		- 테이블 용어   /  테이블 [ 표 ]
                속성		colum	  열				필드
				 |		  |       |              |
				학번		학생명	전화번호			주소 
                1010	김현수	010-4444-3333	안산 	- 가로 = 행 = row = 레코드 = 1번레코드
                1011	강호동	010-3333-3333	수원 	- 2번 레코드 
                
			1. colum=열=필드=속성 : 테이블[표]의 열 
				학번필드 , 학생명필드 , 전화번호필드 주소필드
                
			2. row = 행 = 레코드	: 테이블[표]의 행 
				1번레코드 , 2번레코드 , 3번레코드
			
            3. 행/열 로 구성된 테이블(표)를 다른 테이블(표)와 연결/관계 = 관계형 데이터베이스 
            
		- 데이터 필드 타입 [ mysql기준 *DBMS 조금씩 다름 ] 
			(숫자) : 바이트 단위 
            1.정수
				tinyint		[1] 		: -128~127  
                smallint	[2] 		: +-3만정도  
                mediumint	[3]			: +-8백만정도  
                int			[4] 		: +-21억정도
                bigint		[8] 		: +-21억 이상
			2.실수 
				float		[4] 		: 소수점 7자리  
                double		[8]			: 소수점 15자리 
			3.문자
				char(문자길이)				: [ 글자수 최소1~최대255 ] 고정길이			char(3) -> 'ab'	-> 3바이트  	[ *저장할 데이터의 글자수가 정확히 정해져 있는경우 ]
                varchar(문자길이)			: [ 글자수 최소1~최대65535 ] 가변길이			varchar(3) -> 'ab' -> 2바이트 [ *저장할 데이터의 글자수가 정확하지 않을때 ]
            5.대용량 문자 
				text 					: 최소1~최대65535 ]
                mediumtext				: 최소1 ~ 최대 16000000 ]
                longtext 	[4G]		: 긴글 텍스트 
			4.날짜
				date					: (날짜) YYYY-MM-DD
                time 					: (시간) HH:MM:SS
                datetime				: (날짜시간)YYYY-MM-DD HH:MM:SS
			6.논리
				boolean		[1]			: 0 or 1  = tinyint
                
		- 제약조건 
			1. pk	: primary key( pk필드명 )
				- 기본키[식별키] : 식별가능한 필드 , 중복X , nullX , 공백X , 테이블1당 1개 이상 권장
					- 예) 학번 , 사번 , 주민등록번호 , ISBN , 상호코드 등등 
                    - 다른테이블의 필드에서 해당 PK필드를 참조 당한다.  
                    - not null + unique = primary key
                    
            2. fk 	: foreign key( fk필드명 ) references pk테이블명(pk필드명) [ 선택 옵션 ]
				- 외래키[참조키] : 다른테이블의 PK필드를 참조하는 필드 , 중복o , null o 
					- 예) 점수테이블(접수자) , 출결(출근한사번) , 각종서류(주민등록) , 대여(ISBN) , 재고관리(상호코드)
                    - 다른테이블의 PK필드을 참조하는 FK필드
            
            3. auto_increment	: 	insert(삽입) 할때 해당 필드를 생략하면 자동번호 부여 [ 자동으로 1씩 증가 ]
				* auto_increment 사용할려면 무조건 pk필드 이면서 만 가능 
                
			4. not null			: 	insert(삽입) 할때 해당 필드의 공백 방지 
            5. unique			: 	insert(삽입) 할때 해당 필드의 값 중복 방지 
            6. default			:	insert(삽입) 할때 해당 필드의 값 생략하면 자동으로 대입되는 기본값 
				default 숫자	
                default now()
                default '문자열'
			
        - SQL 함수 
			1. now()	: 현재날짜/시간 반환해주는 함수 
            

                    
/* ------------ 데이터베이스 만들기 -------------- */
#예1 : 데이터베이스( 여러개의 테이블(표) 들이 저장 할 수 있는 공간 - 폴더와 비슷한 형태 ) 생성
create database sqldb1;
	# create 	: 생성한다. 
    # database 	: 데이터베이스.
    # sqldb1 	: 이름정의 [ 아무거나 , 대소문자 구분X , 키워드X ]
    # ;			: 명령어 끝마침.
		# 명령어 실행 : 해당 명령어 줄에 커서 위치한 상태에서  ctrl+엔터  
		# navigator 새로고침
create database sqldb2;
create database sqldb3;
create database sqldb4;
create database sqldb5;
#예2 : 데이터베이스 목록 보기 
show databases;
#예3 : 데이터베이스가 저장된 로컬[pc] 경로 확인 
show variables like 'datadir';
#예4 : 데이터베이스 삭제 
drop database sqldb1;
	# drop : 삭제한다. 
    # database : 데이터베이스 
    # sqldb1 : DB명 
drop database sqldb2;
drop database sqldb3;
drop database sqldb4;
drop database sqldb5;

#예5 : 만약에 데이터베이스 존재했을때 삭제 [ *만약에 데이터베이스 없을때 삭제명령어 사용하면 오류발생!! ]
drop database if exists sqldb1;
	# if exists : 만약에 존재하면 

#예6 : 여러개의 데이터베이스중 사용할 데이터베이스 선택!!
use sqldb1; 
use sqldb2;

#활용1 : 데이터베이스 새롭게 생성하세요.
# 1. 데이터베이스 존재하면 삭제처리
drop database if exists test1;
# 2. 데이터베이스 생성 
create database test1;
# 3. 데이터베이스 사용준비
use test1;

/* ------------ 테이블(표) 만들기 -------------- */
# 테이블(표)는 데이터베이스 안에 저장 [ * 무슨 데이터베이스에서 테이블(표) 생성할껀지... use DB명; ]
#예1 : 테이블 생성
use sqldb1;	# 테이블을 생성할 데이터베이스 선택 
create table member( 아이디 text , 비밀번호 text );
	# create 	: 생성한다.
    # table		: 테이블
	# member	: 이름정의 [ 아무거나 , 대소문자 구분X , 키워드X ]
    # ( );		: 테이블 속성/열/필드 정의 구역 
		# ( 필드명 타입 , 필드명 타입 , 필드명 타입 , 필드명 타입 )	: 테이블(표) 제목/속성/열/필드 정의 
#예2 : 테이블 확인 
select * from member;
#예3 : 테이블 삭제 
drop table member;

# 활용2 : 문제
/*
	문제1 : 
		1. 웹개발 하는데 DB저장소 'sqldb1web' 이름으로 DB 생성
		2. 해당 db에 member 테이블 생성 
			id( 문자열 최대 20 )	
            password( 문자열 최대 10 )
*/
# 1. 만약에 생성할 이름의 DB명이 존재하면 삭제..
drop database if exists sqldb1web;
# 2. DB 생성 
create database sqldb1web;
# 3. DB 사용 선택 
use sqldb1web;
# 4. 만약에 생성할 이름의 테이블명이 존재하면 삭제.. 
drop table if exists member;
# 5. 테이블생성	( 필드명 타입 , 필드명 타입 ) 
create table member( id varchar(20) , password varchar(20) );
# 6. 테이블생성 여부 확인
select * from member;
/*
	문제2 : 
		1. 웹개발 하는데 DB저장소 'sqldb1web2' 이름으로 DB 생성
		2. 해당 db에 board 테이블 생성 
				게시물번호 	( 필드명 :no  		타입 : 최대 21억정도 )
				게시물제목		( 필드명 :title 		타입 : 문자열 최대 100 )	
				게시물내용 	( 필드명 :content 	타입 : 문자열 최대 6만5천 이상 )
				게시물조회수	( 필드명 :view 		타입 : 최대 21억정도 )
				게시물작성일 	( 필드명 :date 		타입 : 날짜/시간 )
*/
# 1. 데이터베이스 생성 
drop database if exists sqldb1web2;
create database sqldb1web2;
# 2. 테이블 생성 
use sqldb1web2;
drop table if exists board;
create table board( no int , title varchar(100) , content longtext , view int , date datetime );
select * from board;
/*
	문제3 : 
		1. 웹개발 하는데 DB저장소 'sqldb2web1' 이름으로 DB 생성
		2. 해당 db에 memberboard 테이블 생성
				회원번호		( 필드명 : mno		타입 : 최대 21억정도 )
                회원아이디		( 필드명 : mid		타입 : 문자열 최대 20 )
                회원비밀번호 	( 필드명 : mpw		타입 : 문자열 최대 20 )
				게시물번호 	( 필드명 : bno  		타입 : 최대 21억정도 )
				게시물제목		( 필드명 : btitle 	타입 : 문자열 최대 100 )	
				게시물내용 	( 필드명 : bcontent 	타입 : 문자열 최대 6만5천 이상 )
				게시물조회수	( 필드명 : bview 		타입 : 최대 21억정도 )
				게시물작성일 	( 필드명 : bdate 		타입 : 날짜/시간 )
*/
# 1. 데이터베이스 생성 
drop database if exists sqldb2web1; # 만약에 동일한 db명이 존재했을때 생성불가능 하기 때문에 만약에 존재하면 삭제
create database sqldb2web1; 		# 실행 : [명령어]; 마다 컨트롤+엔터 
# 2. 테이블 생성 
use sqldb2web1;
drop table if exists memberboard;
create table memberboard(
		mno int , 				#		회원번호		( 필드명 : mno		타입 : 최대 21억정도 )
        mid varchar(20)	, 		#       회원아이디		( 필드명 : mid		타입 : 문자열 최대 20 )
        mpw varchar(20) , 		#       회원비밀번호 	( 필드명 : mpw		타입 : 문자열 최대 20 )
		bno int ,				#		게시물번호 	( 필드명 : bno  		타입 : 최대 21억정도 )
		btitle varchar(100) , 	#		게시물제목		( 필드명 : btitle 	타입 : 문자열 최대 100 )	
		bcontent longtext , 	# 		게시물내용 	( 필드명 : bcontent 	타입 : 문자열 최대 6만5천 이상 )
		bview int , 			#		게시물조회수	( 필드명 : bview 		타입 : 최대 21억정도 )
		bdate datetime 			#		게시물작성일 	( 필드명 : bdate 		타입 : 날짜/시간 )
);
select * from memberboard;

/*
	문제4 : 
		1. 웹개발 하는데 DB저장소 'sqldb2web1' 이름으로 DB 선택
		2. 해당 db에 memberboard 테이블을 중복을 최소화 할수 있도록 2개의 테이블로 분리하여 각각 생성 [ 필드과 타입은 문제3 동일 ]
*/

use sqldb2web1;
drop table if exists member;
create table member(
		mno int , 				#		회원번호		( 필드명 : mno		타입 : 최대 21억정도 )
        mid varchar(20)	, 		#       회원아이디		( 필드명 : mid		타입 : 문자열 최대 20 )
        mpw varchar(20)  		#       회원비밀번호 	( 필드명 : mpw		타입 : 문자열 최대 20 )
);
select * from member;

drop table if exists board;
create table board(
		bno int ,				#		게시물번호 	( 필드명 : bno  		타입 : 최대 21억정도 )
		btitle varchar(100) , 	#		게시물제목		( 필드명 : btitle 	타입 : 문자열 최대 100 )	
		bcontent longtext , 	# 		게시물내용 	( 필드명 : bcontent 	타입 : 문자열 최대 6만5천 이상 )
		bview int , 			#		게시물조회수	( 필드명 : bview 		타입 : 최대 21억정도 )
		bdate datetime 			#		게시물작성일 	( 필드명 : bdate 		타입 : 날짜/시간 )
);
select * from board;
# ----------------------------> 테이블 관계 상태 확인 : 메뉴 -> database -> reverse enginner

-- 예1 : 1:M 관계 / PK:FK 관계 
use sqldb2web1;
drop table if exists member2;
create table member2(
		mno_pk int , 				
        mid varchar(20)	, 		
        mpw varchar(20) ,
		primary key( mno_pk )	-- 현재 테이블에서 mno_pk 라는 필드를 식별키로 사용 설정
);
drop table if exists board2;
create table board2(
		bno int ,				
		btitle varchar(100) , 	
		bcontent longtext , 	
		bview int , 			
		bdate datetime ,
        mno_fk int ,  			-- 1. FK 필드 선언 
        foreign key( mno_fk ) references member2( mno_pk ) 	-- 2. 현재 테이블에서 mno_fk 라는 필드를 외래키로 사용 
			# foreign key( mno_fk ) 		: 'mno_fk' 라는 필드를 FK 필드로 설정 
            # references member2( mno_pk ) 	: FK필드를 member2 테이블의 mno_pk 필드와 참조.. [ 관계 ] 
);

/*
	문제5 : 조건
		1) 키오스크 시스템 개발하는데 'sqldb2sys' 라는 이름으로 DB 생성 
        2) 해당 DB에 카테고리(category) 와 제품(product) 테이블 2개를  생성
        3) 	카테고리 : 카테고리번호(cno) , 카테고리명(cname)  
			제품 : 제품번호(pno) , 제품명(pname) , 제품가격(pprice) 
			- 필드 타입은 적절한 타입으로 선언 
		4) 두 테이블간 관계 
			- pk필드는 새로 생성하지 않고 pk설정만 하고 fk필드는 선언후 관계 설정한다.
*/
# 조건1)
drop database if exists sqldb2sys;
create database sqldb2sys;
# 조건2)	1. 테이블선언하고 필드명과 필드타입 선언 2.PK선정[테이블당 1개 권장] 3. 1:M 관계 경우에는  M쪽 테이블에 FK 필드 선언/설정 
	# 여러테이블 생성할때 : PK테이블 생성하고 FK테이블 생성		# 테이블 삭제할때 : FK테이블 삭제하고 PK테이블 삭제 	# 제약옵션 옵션 사용
use sqldb2sys;
drop table if exists category; 
create table category( 
	cno_pk tinyint , 		
    cname varchar(10) ,
    primary key( cno_pk )
);
drop table if exists product;
create table product( 
	pno_pk int , 
    pname varchar(30) , 
    pprice int  ,
    cno_fk tinyint , 		-- FK필드로 사용할 필드 선언 [ 연결할 PK필드명/타입 와 동일하게 선언 ] 
    primary key( pno_pk ) ,
    foreign key( cno_fk ) references category( cno_pk )
);

#--------------------------------------------------------------------------------------
drop database if exists sqldb3web;
create database sqldb3web;
use sqldb3web;
# ---------------- 예제 변경될때 실행
drop table if exists member1;
# create table member1( mno int , primary key(mno) );									# 예1)
#create table member1( mno int , mid varchar(10) , primary key(mno) );					# 예2)
#create table member1( mno int auto_increment , mid varchar(10) , primary key(mno) ); 	# 예3)
#create table member1( mno int auto_increment , mid varchar(10) not null , memail varchar(20) , primary key(mno) ); # 예4)
#create table member1( mno int auto_increment , mid varchar(10) not null unique , memail varchar(20) , primary key(mno) ); # 예5)
create table member1( 
	mno int auto_increment , 								-- 회원번호 [ pk , 자동번호 부여 ]
    mid varchar(10) not null unique , 						-- 회원아이디 [ 공백x , 중복x ]
    memail varchar(20) not null unique , 					-- 회원이메일 [ 공백x , 중복x ]
	mpoint int not null default 0,							-- 회원포인트 [ 공백x , 기본값 0	]					-- 회원가입시 고객이 입력하는 사항 x
    mdate datetime not null default now(),					-- 회원가입일 [ 공백x , 기본값 현재날짜/시간 ]			-- 회원가입시 고객이 입력하는 사항 x
    mreceive boolean not null default true ,				-- 회원이메일수신여부 [ 공백x , 기본값 true ]		 
    mimg varchar(1000) not null default '기본프로필.jpg' ,		-- 회원프로필사진 [ 공백x , 기본값 '기본프로필' ] 
    primary key(mno) 										-- pk설정 
); # 예6)

select * from member1;			# 반복!! : 확인할때 마다 실행 
# -------------------
# 예1) 테이블에 레코드/행 추가하기 . 	
	# 1. insert into 테이블명 values( 값1 , 값2 , 값3 );				# 모든 필드에 값 추가할때
    # 2. insert into 테이블명( 필드명1, 필드명2 ) values( 값1 , 값2 ) 		# 특정 필드에 값 추가할때.
insert into member1 values( 1 );	-- member1 테이블의 mno필드에 1 추가 

# 예2) 
insert into member1 values( 1 , '유재석' );	-- 직접 데이터 입력할경우 문자/날짜 입력시 ' ' 
insert into member1 values( 1 , '유재석' );	-- mno가 pk필드 이므로 중복방지해서 오류 발생 

# 예3) auto_increment : insert(삽입시) 해당 필드에 값 생략하면 자동번호가 삽입
insert into member1 values( 1 , '유재석' );		-- 가능
insert into member1 values( '유재석' );			-- 오류 : '유재석' 데이터를 어떤 필드에 넣을지 식별 불가능 
insert into member1( mid ) values( '유재석' );	-- 오류방안 : 특정 필드에만 데이터를 삽입할경우 테이블명( 필드명제시 );

# 예4) not null : 해당 필드에 값이 무조건 존재해야되는 경우에 사용 [ JS-JAVA-DB 안정성 보장 ]
#create table member1( mno int auto_increment , mid varchar(10) , memail varchar(20) , primary key(mno) );
insert into member1( mid , memail ) values( '유재석' , 'qwe@com' );
insert into member1( mid ) values( '강호동' );			-- 삽입시 필드 생략하면 생략된 필드는 null(비어있음뜻) 대입
#create table member1( mno int auto_increment , mid varchar(10) not null , memail varchar(20) , primary key(mno) ); # 예4)
insert into member1( memail) values( 'qwe@com');		-- 오류 : mid필드는 not null 제약조건을 사용했으므로 무조건 값 대입 

# 예5 ) unique : 해당 필드에 값의 중복 방지 
create table member1( mno int auto_increment , mid varchar(10) not null unique , memail varchar(20) , primary key(mno) ); # 예5)
insert into member1( mid ) values( '유재석' );
insert into member1( mid ) values( '유재석' ) ;			-- 오류 : mid필드는 unique 제약조건을 사용했으므로 기존에 있는 값을 대입할수 가 없다. [ 중복방지 ]

# 예6 ) default : 해당 필드에 값 삽입시 생략할때 자동으로 들어가는 기본값 설정 
select * from member1;
insert into member1( mid , memail ) values( '유재석' , 'qwe@com');
insert into member1( mid , memail , mpoint ) values( '강호동' , 'asd@com' , 1000 );
insert into member1( mid , memail , mpoint , mdate ) values( '신동엽' , 'zxc@com' , 1000 , '2023-08-03 12:10:10' );
insert 
	into member1( mid , memail , mpoint , mdate , mreceive )
	values( '하하' , 'cvb@com' , 1000 , '2023-08-03 12:10:10' , false );
    
insert 
	into member1( mid , memail , mpoint , mdate , mreceive , mimg ) 
    values( '서장훈' , 'ert@com' , 0 , '2023-08-03 12:10:10' , false , '증명사진.jpg' );
    
insert into member1( mid , memail , mimg ) values( '김희철' , 'vbn@com' , '김희철증명사진.jpg' );

/*
	문제6 
		[조건1]
		1. 'sqldb3web2' 데이터베이스 생성한다.
		2. 'product' 테이블 생성합니다.
				[ 요구사항 ]
				제품번호		제품 식별용으로 정수형태로 저장하고 자동번호 부여 했으면 좋겠다.
				제품명		문자열 형태로 100글자 내외로 할것 같고 중복은 방지 해주세요.
				제품가격		정수로 저장하고 기본값은 0 으로 해주세요.
				제품등록일		날짜/시간 저장하고 제품등록할때 자동으로 날짜/시간 저장해주세요.				
			- 그리고 모든 필드에 null 값이 들어가지 않도록 해주세요.
		[조건2]
		1. 위에서 선언한 'product' 테이블에 제품 (레코드) 등록(insert) 
			[실행1] 제품명 : '콜라' , 1000  
			[실행2] 제품명 : '사이다'
            [실행3] 제품명 : '환타' , 1500 , '2023-08-03 17:10:30'
		
        [조건3]
		1. 위에서 선언한 'product' 테이블 과 관계가 있는 'category' 테이블 생성 
			[ 요구사항 ]
			1. 필드
				카테고리번호 		: 카테고리식별용으로 정수형태로 저장하고 자동번호 부여 했으면 좋겠다.
                카테고리명			: 문자열 형태로 20글자 내외로 할것 같고 중복X  , null X 해주세요.
            2. 관계 
				'product' 테이블 과 'category' 테이블 관계 연결 해주세요.
                
*/
# 1. DB 생성 
drop database if exists sqldb3web2;		create database sqldb3web2;		use sqldb3web2;
# 2. 테이블 생성 
drop table if exists product;
create table product( # 작성순서 :  1. 필드명 과 타입 선정 	# 2. 제약조건 [ pk -> 기타 등등 ]
	pno int auto_increment  , 				-- 제품번호 [ 정수타입 , pk필드(not null , unique) , 자동번호부여 ]
    pname varchar(100) unique not null , 	-- 제품명 [ 문자열(100) , 중복제거 ]
    pprice int default 0 not null , 		-- 제품가격 [ 정수타입 , 기본값 0 ]
    pdate datetime default now() not null ,	-- 제품등록일[ 날짜/시간타입 , 기본값 현재시간 ]
    primary key(pno) ,						-- 제품번호 필드를 pk필드 설정 
    # [조건3]
    cno int ,  -- 카테고리번호 
    foreign key( cno ) references category( cno )	-- category 테이블이 우선적으로 생성이 되어 있는 상태 이면 참조 가능 
);
#[실행1] 제품명 : '콜라' , 1000  
insert into product( pname, pprice ) values ( '콜라' ,1000 ); 			
# insert : 삽입하다. # into : ~~ 어디에 # ( ) : 값을 삽입할 필드명   # values	: 삽입할 값들    
#[실행2] 제품명 : '사이다'
insert into product( pname) values( '사이다');	
#[실행3] 제품명 : '환타' , 1500 , '2023-08-03 17:10:30'
insert into product( pname , pprice , pdate ) values( '환타' , 1500 , '2023-08-03 17:10:30');
select * from product; 

#[조건3] 'category' 테이블 생성 [ 상위테이블 생성 -> 하위테이블 생성  ]
drop table if exists category;
create table category(
	cno	int auto_increment , 
    cname varchar(20) unique not null ,
    primary key( cno )
);
#[실행1] 카테고리 등록 
insert into category( cname ) values( '에이드' );		# '에이드' 카테고리 등록 [ 자동번호 부여 = 1 ]
insert into category( cname ) values( '탄산' );		# '탄산' 카테고리 등록 [ 자동번호 부여 = 2 ]
# 1번카테고리[에이드] 에 제품 등록 
insert into product ( pname , pprice , cno ) values ( '사과에이드' , 3000 , 1 );
# 1번카테고리[에이드] 에 제품 등록 
insert into product ( pname , pprice , cno ) values ( '포도에이드' , 3500 , 1 );
# 2번카테고리[탄산] 에 제품 등록 
insert into product ( pname , pprice , cno ) values ( '제로콜라' , 4000 , 2 );
select * from product;

# --------------------------------------------------------------- #
# JDBC와 연결할 DB 선언 
drop database if exists sqldb4web;
create database sqldb4web;
# Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web" , "root","1234");

# member 테이블 
use sqldb4web;
drop table if exists member;
create table member(
	mno int not null unique auto_increment ,	-- 자동부여[무조건PK만가능] 
    mid varchar(30) not null unique,
    mpw varchar(30)  not null ,					-- 중복허용 
    mname varchar(30) not null ,				-- 중복허용 
    mphone varchar(13) not null unique ,
    primary key(mno) 
);

# 1. 회원가입 [ 테이블에 레코드 삽입(insert) ]
insert into member( mid , mpw , mname , mphone ) values ( 'ezen01' , '1234' , '이젠' ,'031-444-2222');
# 자바 문자열 변환 
insert into member( mid , mpw , mname , mphone ) values ( ? , ? , ? , ?);

# 2. 로그인 [ 테이블에 값 검색(select) ] 	필드:열/세로 	 레코드:행/가로		
	# -> 로그인 성공 했다-검색레코드존재o[true] / 안했다.-검색레코드존재x[false]
select mid from member;					-- mid 필드의 레코드만 검색 
select mid , mpw from member;			-- mid 와 mpw 필드의 레코드만 검색  
select mid , mpw , mname from member;	-- mid 와 mpw 와 mname 필드의 레코드만 검색  
select * from member;					-- *[모든필드 뜻] 모든필드의 레코드 검색 
# 1. 로그인할때 필요한 필드[아이디,패스워드] 검색 
select mid , mpw from member;										# select * from member;
# 2. 아이디와 패스워드가 일치한 레코드 검색 
	select mid , mpw from member where mid ='qwe';						# 만약에 mid필드에 'qwe'문자열이 있는 레코드 검색 
	select mid , mpw from member where mid ='ezen01';					# 만약에 mid필드에 'ezen01'문자열이 있는 레코드 검색 
# 만약에 mid필드가 'ezen01' 이면서 mpw필드가 '1234' 인 레코드 검색 
select mid , mpw from member where mid ='ezen01' and mpw ='1234';
select * from member where mid ='ezen01' and mpw ='1234';
# 자바 문자열 변환 
select * from member where mid = ? and mpw = ?;
 
/* 
	1. 테이블의 필드에 해당하는 레코드 검색 
		select 필드명 from 테이블명						: 해당 필드의 레코드 검색 
        select 필드명 , 필드명 , 필드명 from 테이블 		: 여러개 필드들의 레코드 검색 
        select * from 테이블명 						: 모든 필드[*] 의 레코드 검색 
	
    2. 필드에 조건 추가 							[ where 조건절 ]
		select 필드명 				from 테이블명 where 조건 
        select 필드명 , 필드명 , 필드명 	from 테이블명 where 조건  
        select * 					from 테이블명 where 조건 
        
*/
/* ------------------------------------------------------------------ */
drop database if exists sqldb5web;	
create database sqldb5web;
use sqldb5web;
drop table if exists table1;
create table table1( 데이터1 int , 데이터2 varchar(100) );
select * from table1;

#  CRUD : 
# 1. insert [ C : create ]	회원가입 , 글쓰기 , 제품등록 , 주문 , 대여 등등 
	# insert into 테이블명( 필드명 , 필드명 ) values( 값1 , 값2 )
insert into table1( 데이터1 , 데이터2 ) values( 1 , '유재석' );	# 데이터1 필드에 '1' 데이터2 필드에 '유재석' 레코드 삽입 
insert into table1( 데이터1 , 데이터2 ) values( 2 , '강호동' );

# 2. select [ R : read ]	로그인 , 아이디찾기 , 비밀번호찾기 , 글목록 , 글조회 , 제품조회 , 주문현황 , 검색 등등 
	# select 필드명 from 테이블명 
	# select 필드명 from 테이블명 where 조건절 
select * from table1;						# 모든 레코드 검색 [ 모든필드 표시 ]
select * from table1 where 데이터2 = '강호동';	# 데이터2 필드의 값이 '강호동'인 레코드 검색 [ 모든필드 표시 ]

# 3. update [ U : update ]
	# update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값 
    # update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값 where 조건절 
update table1 set 데이터1 = 3;						# 모든 레코드의 데이터1 필드의 값을 3으로 변경 
	# 메뉴 -> edit -> Preferences -> sql editor -> 하단 -> safe updates 해제	[ update , delete 사용시 ]
update table1 set 데이터1 = 2 where 데이터2 = '유재석';	# 데이터2 필드의 값이 '유재석'인 레코드의 데이터1 필드의 값을 2 로 변경 

# 4. delete [ D : delete ]
	# delete from 테이블명 
	# delete from 테이블명 where 조건절 
delete from table1;							# 모든 레코드를 삭제
delete from table1 where 데이터2 = '유재석';	# 데이터2 필드의 값이 '유재석'인 레코드 삭제 



/* ------------------------------------------------------------------ */
use sqldb4web;
/*1. 테이블의 모든 레코드 검색 */
select * from member;
/*2. 회원가입  : mno 자동부여 이므로 생략 */
insert into member( mid , mpw , mname , mphone ) values( 'ezen02' , '1234' , '이젠' , '010-443-1234' );
#insert into member( mid , mpw , mname , mphone ) values( ? , ? , ? , ? );
/*3. 로그인 : 입력한 값이 존재하는지 검색 */
select * from member where mid = 'ezen02' and mpw = '1234';	#로그인성공 : 레코드 1개이상 검색되면 
select * from member where mid = 'ezen02' and mpw = '12345'; #로그인실패 : 레코드 0개 검색
#select * from member where mid = ? and mpw = ?;
 
/*4. 아이디 / 전화번호 중복체크(유효성검사) : 입력한 값이 존재하는지 검색 */
select * from member where mid = 'ezen02';									# 조건에 맞는 충족한 레코드의 모든 필드 검색 
# select * from member where mid = ?;
select * from member where mphone = '010-443-1234';							# 조건에 맞는 충족한 레코드의 모든 필드 검색 
#select * from member where mphone = ?;
	
/*5. 아이디찾기 / 비밀번호찾기 : 입력한 값의 레코드 검색 */ 
select mid from member where mname = '이젠' and mphone = '010-443-1234';		# 조건에 맞는 충족한 레코드의 아이디 필드만 검색 
# select mid from member where mname = ? and mphone = ?;
select mpw from member where mid = 'ezen02' and mphone = '010-443-1234';	# 조건에 맞는 충족한 레코드의 비밀번호 필드망 검색 
#select mpw from member where mid = ? and mphone = ?;

/*6. 회원수정 : 비밀번호 수정  : pk식별 조건 [pk필드는 수정 하지 않음 -권장 ] ]*/
update member set mpw = '12345' where mno = 4;								# 4번 회원인 레코드의 비밀번호 수정 
#update member set mpw = ? where mno = ?;
	 
/*6. 회원수정 : 이름 , 전화번호 수정 : pk식별 조건[pk필드는 수정 하지 않음 -권장 ]  */
update member set mname ='ezen' , mphone = '010-1234-1234' where mno = 4;	# 4번 회원인 레코드의 이름 , 전화번호 수정 
#update member set mname =? , mphone = ? where mno = ?;

/*7. 회원탈퇴 : pk식별 조건 */ 
delete from member where mno = 4;		-- 4번 회원인 레코드 삭제 
#delete from member where mno = ?;
	




