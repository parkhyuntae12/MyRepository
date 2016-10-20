--Section01 시퀀스 생성
create sequence seq_1;
--다음 수 얻기
select seq_1.nextval from dual;
--현재 부여된 번호
select seq_1.currval from dual;

create sequence seq_2
  start with 101
  increment by 10
  maxvalue 1000
  nocycle 
  nocache;
  
select seq_2.nextval from dual;

drop sequence seq_1;
drop sequence seq_2;

--Section04 인덱스 개요 --조회속도를 빠르게 하기위해서 인덱스를 만들어서 사용한다  언제만들어야 되나?->where 조건문에서 특정 컬럼으로 검색할때( ex)content,id,no....)
set timing on;
select * from board where btitle='9333'; --table scan

create index idx_board_btitle on board(btitle); --중복이 허용되는 컬럼을 만들때 create index 
select * from board where btitle='9333ddd';
drop index idx_board_btitle;

select * from board where bno=9333;

create unique index seq_board_bno on board(bno);--중복이 허용되지 않는 컬럼을 만들때 create unique index(유니크제약이나 pk를 만들면 자동으로 만들어진다)
select * from board where bno=9333;
drop index seq_board_bno;