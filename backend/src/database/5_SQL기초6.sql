/* ------------------------------------------------------------------ */
drop database if exists sqldb6web;
create database sqldb6web;
use sqldb6web;
# 1. 회원테이블
drop table if exists member;
create table member(				# 아이돌 그룹
	mid char(8) not null ,			# 식별키 		최대 8자리
    mname varchar(10) not null ,	# 그룹명		최대 10자리
    mnumber int not null ,			# 인원수		정수 +-21억정도
    maddr char(2) not null , 		# 지역		최대 2자리
    mphone1 char(3) ,				# 지역번호	최대 2자리 
    mphone2 char(8) ,				# 전화번호 	최대 8자리
    mheight smallint ,				# 평균키 		정수 +-3만정도
	mdebut date ,					# 데뷔일 		yyyy-mm-dd 
    primary key ( mid )				# 제약조건 
);
# 2. 구매테이블
drop table if exists buy;
create table buy(
	bnum int auto_increment , 			# 구매번호	정수 	자동번호 부여 
    mid char(8),						# 구매자		FK 
    bpname char(6) not null ,			# 제품명		최대 6자리 
    bgname char(4) , 					# 분류명 		최대	4자리
    bprice int not null ,				# 가격 		정수 
    bamout smallint not null ,			# 구매수량	정수 
    primary key(bnum) ,					# 제약조건 
    foreign key ( mid ) references member(mid) # 제약조건 
);

# 샘플데이터 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# SELECT 문
# 1. 테이블 전체 레코드 검색 [ * 모든 필드 표시 ]
select * from member;
select * from buy;
# 2. 테이블 전체 레코드 검색 [ 특정 필드 표시 ( ,구분 )  ]
select mid from member;
select mid , mname from member;
# 3. 필드 별칭 [ 필드명 as 별칭 vs 필드명 별칭  	:	별칭 (별칭은 검색결과 에 표시할 필드명의 별명) ]	
select mid as 그룹식별명 from member;
select mid 그룹식별명 from member;
select mid 그룹식별명 from member m ;
# 4. 조건절 [ where 조건절 ]
select * from member where mname = '블랙핑크';					# 1.필드의 값[문자이면 ' ']이 일치한 레코드 검색
select * from member where mnumber = 4;							# 2.필드의 값[숫자이면 ]이 일치한 레코드 검색  
select * from member where mheight <= 162;						# 3.필드의 값이 이하 이면 레코드 검색
select * from member where mheight >= 165 and mheight <=170;	# 4.필드의 값이 이상 이면서 이하 이면 레코드 검색
	select * from member where mheight between 165 and 170;		# 동일 
select * from member where mheight >= 165 or mnumber > 6; 		# 5.필드의 값이 이상 이거나 초과 이면 레코드 검색 
select * from member where maddr ='경기' or maddr = '전남' or maddr ='경남';
	select * from member where maddr in( '경기','전남','경남');
    select * from member where not maddr in( '경기','전남','경남');
select * from member where mname = '에이핑크';
select * from member where not mname = '에이핑크';					# 6-1. '에이핑크' 가 아니면 
select * from member where mname != '에이핑크';					# 6-2. '에이핑크' 가 아닌 
select * from member where mname like '에이%';					# 7. '에이' 로 시작하는 문자 
select * from member where mname like '%핑크'; 					# 8. '핑크' 로 끝나는 문자
select * from member where mname like '에이_';					# 9. '에이' 로 시작하는 세글자
select * from member where mname like '_핑크';					# 10. '핑크' 로 끝나는 세글자 
select * from member where mname like '%우%';					# 11 '우' 가 포함된 문자 
select * from member where mname like '_우_';					# 12 '우' 가 두번째에 위치한 세글자 
select mname 그룹명 , mnumber 멤버수 , 
	mnumber+10 , mnumber-10 , mnumber * 10 , mnumber/10 , mnumber div 3 , mnumber mod 3 ,
    mnumber * mheight
from member;													# 13 산술연산자. 
select * from member where mphone1 = '';						# 공백 검색 
select * from member where mphone1 = ' ';						# 띄어쓰기 하나 들어간 데이터 검색
select * from member where mphone1 = null;						# 불가능!!   
select * from member where mphone1 is null;						# null 검색
select * from member where mphone1 is not null;					# null 아닌 검색 
 
/*
	null vs 공백 vs 띄어쓰기 
		null : 참조 없다.
        공백 : 임의의공간 확보하기 위한 임의값[쓰레기값]
        띄어쓰기 : 문자 
	연산자 
		1. 산술연산자 : +더하기		-빼기	*곱하기	/나누기  div몫 	mod나머지 
        2. 비교연산자 : >초과	<미만	>=이상 <=이하 =같다 !=같지않다.
        3. 논리연산자 : and이면서 or이거나 not부정 
        4. 기타연산자 : 
			- 동일한 필드명의 여러개 연산을 나열할때. 
				- between 시작값 and 끝값 		: 시작값 부터 끝값 사이 이면 	= and 유사 
				- in( 값 , 값 , 값 )			: 여러 값 중 하나라도 포함하면 	= or 유사 
                
			- 패턴 비교 검색 
				필드명 like 패턴  
					% : 모든 문자수 대응 
                    _ : _개수만큼 문자수 대응 
			- null 연산
				필드명 is null			: 해당 필드의 데이터가 null 이면 
                필드명 is not null		: 해당 필드의 데이터가 null 이 아니면 
*/

# 5. 검색 결과의 레코드 정렬하기 [ order by 필드명 asc/desc ] 	
	# asc : 오름차순 , 작은수 -> 큰수 , 과거날짜 -> 최근날짜 
    # desc : 내림차순 , 큰수 -> 작은수 , 최근날짜 -> 과거날짜 
select * from member order by mdebut asc;		# 데뷔일 필드 기준으로 오름차순 
select * from member order by mdebut desc;		# 데뷔일 필드 기준으로 내림차순 
	# 정렬 기준 2개 이상 [ order by 필드명 정렬기준 , 필드명 정렬기준 ]
    # 첫번째 정렬후 동일한 키가 있을경우 동일한 키 중에서 데뷔날짜 오름차순 
select * from member order by mheight desc , mdebut asc;
/*										상위정렬의 동일데이터기준[ 동일한 학년끼리의 점수 정렬 ]
	학년 점수 	->> 학년 오름차순 		학년 점수	 	->> 점수 오름차순   		학년 점수
	1	90							1	90								1	90
	3	80							1	100								1	100
	2	95							2	95								2	95
    1	100							3	80								3	75	
    3	75							3	75								3	80
*/
# 6. 검색 레코드 수 제한 [ limit 레코드수  , limit 시작레코드번호 , 개수  ]
select * from member limit 2;						# 검색 결과의 레코드를 2개만 표시 
select * from member limit 0 , 3;					# 0(첫번째)레코드 부터 3개만 표시
select * from member order by mheight desc limit 3; # 키 상위 3명

# 7. 검색된 필드의 중복 제거 [ distinct ]
select maddr from member; 				# 모든 주소 검색 
select distinct maddr from member;		# 모든 주소에서 중복 제거 검색 

/*
  정리 
	
    
    select : 검색 
	select 필드명 from 테이블명 
	select * from 테이블명 
	1. where 조건절 
		select * from 테이블명 where 조건절 

	2. order by 필드명 정렬기준 
		select * from 테이블명 order by 필드명 정렬기준

	3. limit 레코드수
		select * from 테이블명 limit 레코드수
		select * from 테이블명 limit 시작레코드번호[0] , 레코드수 

	- 키워드 우선순위
		select * from 테이블명 where 조건절 order by 필드명 정렬기준 limit 레코드수

	4. 연산자
		1. as : 별칭
	 		select 필드명 as 별칭 from 테이블명  
			select 필드명 별칭 from 테이블명 별칭
 
		2. distinct : 필드 중복 제거 
			select distinct 필드명 from 테이블명 
 
		3. 산술
			+더하기 -빼기 *곱하기 /나누기 div몫 mod나머지 
		4. 비교
			=같다	!=같지않다.  >초과 <미만 >=이상 <=이하
		5. 논리
			and이면서 or이거나 not부정 
		6. 기타
			필드명 between 시작값 and 끝값 
			필드명 in( 값 , 값 , 값 )
			필드명 like '%값%'		% : 모든 문자 수 대응 
			필드명 like '_값_'		_ : _ 개수만큼 문자 수 대응 
			필드명 is null		
			필드명 is not null


*/
 










