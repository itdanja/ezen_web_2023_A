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
                - 2. select 	: 테이블(표)에 레코드(행) 검색 
					- select * from 테이블명	: 테이블내 모든 필드의 레코드(행) 검색 [ * : 와일드카드(모든) ]
                    
                - 3. update 	: 테이블(표)에 레코드(행) 수정 
                - 4. delete 	: 테이블(표)에 레코드(행) 삭제 
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
            
*/
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
        












