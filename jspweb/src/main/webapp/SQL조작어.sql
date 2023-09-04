# ------------------------------------------------------------------------------------------ #
# 1. 저장 insert / 레코드 추가 
insert into visitlog( vwriter , vpwd , vcontent ) values( '김현수' , '1234' , '안녕하세요');
# insert into visitlog( vwriter , vpwd , vcontent ) values( ? , ? , ? );

# 2. 호출 select / 모든 레코드 검색 / 정렬(최신글부터 출력)
select * from visitlog order by vdate desc;

# 3. 수정 [ 삭제할 식별자 필수 ]
update visitlog set vcontent ='내용수정했다' where vno = 3; /* vno 3 이면 vcontent필드의 값을 수정 */
update visitlog set vcontent ='내용수정했다' where vno = 3 and vpwd = '123123'; /* vno 3 이면서 vpwd 1234 이면 vcontent필드의 값을 수정 */
#update visitlog set vcontent = ? where vno = ? and vpwd = ?;

# 4. 삭제 [ 삭제할 식별자 필수 ]
delete from visitlog;	/* 모든 레코드 삭제 */
delete from visitlog where vno = 3 ; /* vno 3 인  레코드 삭제 */
delete from visitlog where vno = 3 and vpwd = '123123'; /* vno 3 이면서 vpwd 123123 이면 레코드 삭제 */
# delete from visitlog where vno = ? and vpwd = ? ; 

# ------------------------------------------------------------------------------------------ #
select * from member;
# 1. 회원가입 
insert into member( mid , mpwd , memail , mimg ) values( '유재석' , 'a1234' , 'qwe@qwe.com', 'default.jpg' );
# insert into member( mid , mpwd , memail , mimg ) values( ? , ? , ? , ? );

# 2. 아이디중복검사. [ 특정 mid의 아이디로 검색했을때 존재하면 사용중인 아이디 O , 없으면 사용중인 아이디 X ] 
select * from member where mid = 'qweqwe';			/* 레코드 존재여부 판단 이므로 */
select mid from member where mid = 'qweqwe';		/* 레코드 존재여부 판단 이므로 */
# select * from member where mid = ?;
# select mid from member where mid = ?;

# 3. 로그인 [ 아이디와 비밀번호가 일치한 레코드 존재여부 ]
select * from member where mid = 'qweqwe' and mpwd ='qweqwe'; # 레코드가 검색되면 로그인성공 / 없으면 로그인 실패 
# select * from member where mid =  ? and mpwd = ? ;

# 4. 회원정보 호출 [ 아이디를 이용해서 패스워드 제외(안전성보장) 하고 모든 회원정보 호출 ]
select mno , mid , memail , mimg from member where mid = 'qweqwe';
# select mno , mid , memail , mimg from member where mid = ?;

# 5. 회원탈퇴 [ 누구(mno)를 탈퇴할껀지 , 검증(탈퇴할 회원의 패스워드) ] 
delete from member where mno = 1 and mpwd = 'qweqwe'; # 1번 회원의 패스워드가 'qweqwe'이면 레코드 삭제 
# delete from member where mno = ? and mpwd = ?;

# 6. 프로필 수정 [ 누구(mno)를 수정할껀지 , 수정할 내용(사진명) ]
update member set mimg = 'asdasd.jpg' where mno = 1; #1번 회원의 이미지명 변경
# update member set mimg = ? where mno = ?; 

# ------------------------------------------------------- # 
# 1. 글등록   # 1번 회원이 2번카테고리(자유게시판)에 제목,내용,첨부파일(없는상태) 등록
insert into board( btitle , bcontent , bfile , mno , bcno )values( '제목' ,'내용' , null , 1 , 2 );
#insert into board( btitle , bcontent , bfile , mno , bcno )values( ? ,? , ? ,? , ? );

# 2. 모든 글출력 [ 게시물번호 , 제목 , 파일 , 작성일 , 조회수 , 작성자아이디 , 카테고리명 ]
select * from board;
select bno , btitle , bfile , bdate , bview from board;
	# 게시물 테이블과 회원 테이블 조인[테이블 합치기 / pk - fk ] 
	# 게시물 테이블내 작성자번호와 회원테이블의 작성자번호와 같으면
select * from board b natural join member m;
select b.bno , b.btitle , b.bfile , b.bdate , b.bview  from board b natural join member m;
select b.bno , b.btitle , b.bfile , b.bdate , b.bview , m.mid from board b natural join member m;
	# 게시물 테이블 , 회원테이블 , 게시물카테고리테이블 
select * from board b natural join bcategory bc natural join member m; 
    # 게시물 테이블 모든 필드 , 회원테이블의 아이디/프로필 , 게시물카테고리테이블의 카테고리명 
select b.* , m.mid , m.mimg , bc.bcname 
	from board b 
		natural join bcategory bc 
		natural join member m 
	order by b.bdate desc; 
select * from member;
select * from board;

# 3. 개별 글 출력 [ 6번 게시물 조회 ] 
select * from board where bno = 6;
# select * from board where bno = ?;
# -- 게시물 모든 정보(board) + 작성자아이디(member) + 작성자프로필(member) + 카테고리이름(bcategory)
# --  board fk 필드를 이용한 fk필드와 연결된 pk필드의 다른 필드정보 호출
	# 1. board mno <---> member mno 
select b.* , m.mid , m.mimg from board b natural join member m;
	# 2. board bcno <---> bcategory bcno 
select b.* , m.mid , m.mimg , bc.bcname
	from board b 
    natural join member m
    natural join bcategory bc;
	# 3. 조건 
select b.* , m.mid , m.mimg , bc.bcname
	from board b 
    natural join member m
    natural join bcategory bc
    where b.bno = 6;
    # 자바 
select b.* , m.mid , m.mimg , bc.bcname
	from board b 
    natural join member m
    natural join bcategory bc
    where b.bno = ?;