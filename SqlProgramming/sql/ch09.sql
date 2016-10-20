--Section04 유일한 값만 허용하는 UNIQUE 제약조건
drop table member;
create table member(
  mid varchar(10) unique not null,--unique not null을 primary키로 대체할수 있다
  mname varchar(10) not null,
  mage number(3) null,
  email char(50) unique null,
  mbirth date null
);

insert into member values('user1','사용자1',25,'user1@sw.com',sysdate);--TESTER1.SYS_C0010928 (식별값) 제약조건에서 확인가능
insert into member values('user2','사용자1',25,'user2@sw.com',sysdate);
insert into member values('user3','사용자3',25,null,sysdate);
insert into member values('user4','사용자4',25,null,sysdate); --null은 unique에 포함되지 않는다(null은 값이 아니기때문에)


--Section06 데이터 구분을 위한 PRIMARY KEY 제약조건 
--UNIQUE + NOT NULL
--한테이블당 1개만 설정 가능
--행을 구별하는 식별값으로 사용
drop table member;
create table member(
  mid varchar(10) primary key,--unique not null을 primary키로 대체할수 있다(unique이면서 not null이다)
  mname varchar(10) not null,
  mage number(3) null,
  email char(50) unique null,
  mbirth date null
);

--Section07 참조 무결성을 위한 FOREIGN KEY 제약조건  *Key가 들어가면 unique하면서 not null이다
--외부 테이블의 PK 값만 입력할 수 있도록 함
 --FOREIGN KEY는 관계설정에서 나오는 키(테이블의 연결고리) 
drop table board;
create table board(
  bno number(10) primary key,
  btitle varchar(100) not null,
  bcontent varchar(4000) not null,
  bwriter varchar(10) references member(mid), --references:참조한다(외부의 값을 참조하겟다) 외부의값은 primary key가 와야한다
  bhitcount number(5) null, --null과 not null이 생략되면 디폴트로 null이 들어간다 primary key는 null/not null이 생략되도 not null이다
  bdate date null
);

insert into board values(1,'제목1','내용1','user1',0,sysdate);
insert into board values(2,'제목2','내용2','user1',0,sysdate);

--Section08 CHECK 제약조건 
drop table board;
drop table member;
create table member(
  mid varchar(10) primary key,--unique not null을 primary키로 대체할수 있다(unique이면서 not null이다)
  mname varchar(10) not null,
  mage number(3) check(mage>=0 and mage<150), --check 사용시 null을 안쓴다
  msex varchar(4) check(msex in('남자','여자')), 
  email char(50) unique null,
  mbirth date null
);

insert into member values('user1','사용자1',25,'남자','user1@sw.com',sysdate);
insert into member values('user2','사용자1',200,'여자','user1@sw.com',sysdate);
insert into member values('user3','사용자1',null,null,'user1@sw.com',sysdate);--check시에는 조건에 무조건 맞아야하고 null의 의미가 없다
insert into member values('user4','사용자1',30,'중성','user1@sw.com',sysdate);

--Section09 DEFAULT 제약조건
drop table board;
create table board(
  bno number(10) primary key,
  btitle varchar(100) not null,
  bcontent varchar(4000) not null,
  bwriter varchar(10) not null,
  bhitcount number(5) default 0,
  bkind varchar(15) default '자유',
  bdate date null
);

insert into board values(1,'제목1','내용1','user1',0,'자유',sysdate);
insert into board values(2,'제목2','내용2','user2',default,default,sysdate);
insert into board(bno,btitle,bcontent,bwriter) 
values(3,'제목3','내용3','user3');

--Section05 컬럼 레벨로 제약조건 설정
drop table board;
drop table member;
create table member(
  mid varchar(10) constraint pk_member_mid primary key, --constraint pk_member_mid 제약조건의 이름을 설정
  mage varchar(10) constraint ch_member_mage check(mage>=0 and mage<150)
);
create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwrite varchar(10) constraint fk_board_bwriter references member(mid) 
);
--Section10 테이블 레벨로 제약조건 설정(컬럼을 모두 만든후 설정)
create table member(
  ssn1 varchar(6) not null,
  ssn2 varchar(7) not null,
  mnage varchar(10) not null,
  constraint pk_member_ssn primary key(ssn1,ssn2), --(ssn1,ssn2):복합키
  constraint ch_member_mage check(mage>=0 and mage<150)
);
create table board(
  bno number(10),
  bwrite varchar(10),
  constraint pk_board_bno primary key(bno),
  constraint fk_board_bwriter foreign key(bwriter) references member(mid)
);

--Section11 제약조건 변경하기
--11.1 제약조건 추가하기
drop table member;
create table member(
  ssn1 varchar(6) not null,
  ssn2 varchar(7) not null,
  mnage varchar(10) not null
);
alter table member add constraint pk_member_ssn primary key(ssn1,ssn2);
alter table member add  constraint ch_member_mage check(mage>=0 and mage<150);

create table board(
  bno number(10),
  bwrite varchar(10)
);
alter table board add constraint pk_board_bno primary key(bno);
alter table board add constraint fk_board_bwriter foreign key(bwriter) references member(mid);

--11.3 제약조건 제거하기 
drop table board;
drop table member;
create table member(
  ssn1 varchar(6) not null,
  ssn2 varchar(7) not null,
  mage varchar(10) not null,
  constraint pk_member_ssn primary key(ssn1,ssn2), --(ssn1,ssn2):복합키
  constraint ch_member_mage check(mage>=0 and mage<150)
);

--primary key가 있는 제약조건을 지울때는 이름이 필요없지만 primary key가 없는 제약조건을 지울때는 이름(제약조건명)이 필요하다
alter table member drop primary key;
alter table member drop constraint ch_member_mage; --이름이 필요한 이유는 check는 테이블에서 여러개가 생길 수 있기때문에

--Section12 제약조건의 비활성화와 CASCADE
--제약기능이 들어가면 insert가 느려진다(대량의 데이터가 한번에 들어갈 경우)
--제약조건을 비활성화를 시켜줄 필요가있다,(제거나 나중에 조건을 걸어주는 방법도 있다)
drop table board;
drop table member;
create table member(
  mid varchar(10) constraint pk_member_mid primary key, --constraint pk_member_mid 제약조건의 이름을 설정
  mage varchar(10) constraint ch_member_mage check(mage>=0 and mage<150)
);
create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwriter varchar(10) constraint fk_board_bwriter references member(mid) 
);
--12.1 제약조건의 비활성화
alter table board disable primary key;
--12.2 제약조건의 활성화
alter table board enable primary key;
--12.3 CASCADE 
alter table member disable primary key cascade; 
alter table member enable primary key; 
alter table board enable constraint fk_board_bwriter; 
--cascade :계단식(계단식으로 내려가면서 영향을 끼친다) 멤버를 참조하고있는 모든테이블의 참조키마저 비활성화 시킨다
--12.4 ON DELETE CASCADE
insert into member values('user1',25);
insert into board values(1,'user1');
insert into board values(2,'user1');

delete from board where bwriter='user1';
delete from member where mid='user1';

drop table board;
drop table member;
create table member(
  mid varchar(10) constraint pk_member_mid primary key, --constraint pk_member_mid 제약조건의 이름을 설정
  mage varchar(10) constraint ch_member_mage check(mage>=0 and mage<150)
);
create table board(
  bno number(10) constraint pk_board_bno primary key,
  bwrite varchar(10) constraint fk_board_bwriter references member(mid) on delete cascade 
);

insert into member values('user1',25);
insert into board values(1,'user1');
insert into board values(2,'user1');

delete from member where mid='user1';