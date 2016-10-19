--Ch08: DML(Data Manipulation Language) -데이터 관련된 명령어
--         :저장(insert),수정(update),삭제(delete),조회(select)
--cf:   DDL(Data Denfinition Language) - 데이터베이스 객체(Object)와 관련된 명령어 테이블 생성, 인덱스 생성,(create,drop,alter)
--         :생성(create),삭제(drop),수정(alter)
--cf:   DCL(Data Controll Language) -권한 및 사용자와 관련된 명령어
--         :권한할당(grant),권한삭제(revoke),작업반영(commit),작업취소(rollback)

--Section01 테이블에 내용을 추가하는 INSERT문
insert into member(mid,mname,mage,mbirth) 
values('user3','사용자3',10,'2006.5.15');--테이블 특정 컬럼에 값을 넣겠다

insert into member(mid,mname)
values('user4','사용자4');

insert into member values('user5','사용자5',null,null);--컬럼이름이 삭제되면 memeber 다음에 컬럼이 있다고 오라클은 가정한다(대신에 컬럼의수와 입력값의 수가 같아야한다)

insert into board(bno,btitle,bcontent,bwriter,bhitcount,bdate)--삭제된 데이터가 있으면 그 공간은 남아있다(나중에 새 데이터를 입력하면 그공간을 채운다)
values(4,'제목4','내용4','user2',0,sysdate);

insert into board
values(5,'제목5','내용5','user3',0,sysdate);

insert into board(bno,btitle,bcontent,bwriter)
values(5,'제목6','내용6','user4');--insert into는 2가지 경우가 있는데 성공이되면 1을 리턴하고(무조건) 삽입이 안되면 예외발생

--Section02 테이블의 내용을 수정하는 UPDATE문(DML) alter는 테이블의 구조를 바꾸는것이고(테이블의 타입,이름 등등 DDL) 
update member set mage=10 where mid='user14'; --executeUpdate는 3가지 경우 1.1이상의 값(1개 이상의 행이 수정됨) 2.0(어떤 행도 수정되지 않았음) 3.예외(문법오류)
update member set mage=20,mbirth='2001.08.10' where mid='user5';
update member set mage=mage+1 where mid='user4';

--Section03 테이블의 내용을 삭제하는 DELETE문
delete member where mid='user5';
delete member where mage<=20; --delete도 3가지경우

--Section04 트랜잭션 관리
create table account(
 ano varchar(20) not null,
 abalance number(10) null
 );
insert into account(ano,abalance) values('111-111',1000000);
insert into account(ano,abalance) values('111-112',0);
commit;

--계좌이체:출금작업 + 입금작업--> 트랜잭션 작업 = All or Nothing
    --출금작업
    update account set abalance=abalance-10000 where ano='111-111';
    --입금작업
    update account set abalance=abalance+10000 where ano='111-113';
--출금은 성공했으나, 입금이 실패했기 때문에 전체를 실패처리해야함
rollback;-- rollback이 되면 출금이 없던것처럼 원상태로 돌아간다
--출금은 성공했고 입금도 성공했다면 전체를 영구반영 처리해야함

commit;






