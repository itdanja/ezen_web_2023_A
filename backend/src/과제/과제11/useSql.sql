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
    #foreign key( mno ) references member( mno ) on delete restrict 	# (생략시기본값)회원탈퇴[PK레코드삭제] 할때 FK의 레코드가 존재하면 탈퇴 불가능 
    #foreign key( mno ) references member( mno ) on delete set null  	# 회원탈퇴[PK레코드삭제] 되면 FK의 값을 NULL 수정 
    #foreign key( mno ) references member( mno ) on delete no action 	# 아무런 변화 없는상태.
);
select * from board;
select * from board order by bdate desc;

# 테이블 합치기
# 1. select * from 테이블명1 , 테이블명2 	[ 레코드수 X 레코드수 ]
select * from member , board;
# 2. 테이블 합치는데 기준!!! [ PK --- FK 연관 ]
	# member pk = mno	/	board fk = mno
    # 1. 조건 조인 [ pk필드와 fk필드가 일치하면 검색 ] * 일반 조건들과 가독성 떨어짐 [ 조인을 위한 조건인지 식별 힘듬 ]
select * from member , board where member.mno = board.mno;
	# 테이블명 이 길어지면 sql문도 길어져서 그래서 *별칭!!! : 하나의 쿼리문 다수의 테이블이 존재할때. 식별용
	select * from member m , board b where m.mno = b.mno;
	# 2. 자연 조인 [ 자동으로 두 테이블간 pk필드와 fk필드를 식별해서 조인 ]	* pk 다수일때 힘듬 
select * from member natural join board;
	select * from member m natural join board b;
    # * 내가 보고 싶은것만 필드 골라서 출력 
    # b.* : board 테이블 모든 필드 
    # m.mid : member 테이블의 mid 필드
select b.* , m.* from member m natural join board b;
select b.* , m.mid from member m natural join board b;
select b.* , m.mid from member m natural join board b order by b.bdate desc;
    
    