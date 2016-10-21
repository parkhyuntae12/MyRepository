--Section03 Equi Join(==Inner Join)
--조인대상이 되는 두 테이블에서 공통으로 존재하는 컬럼의 값이
--일치하는 행을 연결하여 결과를 생성하는 조인 방법
-------------------------------------------------------------------------------
--101번 사원의 부서 이름은?
select department_name 
from departments d, employees e
where employee_id=101 and d.department_id=e.department_id;

--ANSI Inner Join 문법
select department_name 
from departments d
inner join employees e
on d.department_id=e.department_id--연결조건
where employee_id=101;
-------------------------------------------------------------------------------
--Sales 부서가 있는 도시는?
select department_name, city
from departments d, locations l
where d.location_id=l.location_id
and department_name='Sales';
--ANSI Inner Join 문법
select department_name, city
from departments d
inner join locations l
on d.location_id=l.location_id
where department_name='Sales';
-------------------------------------------------------------------------------
--101번 사원의 부서번호와 부서이름은?
select e.department_id, department_name -- 두테이블 모두 존재하는 컬럼같은경우에는 앞에 테이블명을 적어줘야 한다(둘중 아무거나 써도 된다)
from employees e,departments d --from 뒤에 테이블명이 n개이면 where 연결조건문은 n-1개가 있어야 한다
where e.department_id=d.department_id
and employee_id=101;
-------------------------------------------------------------------------------
--101번 사원의 근무 도시는?
select city
from employees e,departments d ,locations l
where e.department_id=d.department_id 
  and d.location_id=l.location_id
  and employee_id=101;
-------------------------------------------------------------------------------
--101번 사원의 사번,first name, 부서번호, 부서이름,나라,도시는?
select employee_id, first_name, e.department_id, department_name, country_name, city
from employees e, departments d, locations l,countries c
where e.department_id=d.department_id 
  and d.location_id=l.location_id
  and l.country_id=c.country_id
  and employee_id=101;
--ANSI Inner Join 문법
select e.employee_id, e.first_name, d.department_id, d.department_name, c.country_name, l.city
from employees e
inner join departments d on e.department_id=d.department_id 
inner join locations l on  d.location_id=l.location_id
inner join countries c on l.country_id=c.country_id
where employee_id=101;
-------------------------------------------------------------------------------
--Section4 Self Join(=Inner join)
--101번 사원의 관리자 이름은?
select e2.first_name 
from employees e1, employees e2
where e1.manager_id=e2.employee_id
and e1.employee_id=101;

--5.3 ANSI Outer Join
  create table member(
    mid varchar(10) primary key,
    mname varchar(10) not null
  );
  create table board(
    bno number(5) primary key,
    btitle varchar(100) not null,
    bwriter varchar(10) references member(mid)
  );
  insert into member values('user1','사용자1');
  insert into member values('user2','사용자2');
  insert into member values('user3','사용자3');
  insert into member values('user4','사용자4');
  insert into member values('user5','사용자5');
  
  insert into board values(1,'제목1','user1');
  insert into board values(2,'제목2','user2');
  insert into board values(3,'제목3','user3');
  --게시물을 한번도 작성하지 않은 멤버의 mid는?
  select mid, mname, bno, btitle
  from member
  inner join board
  on member.mid=board.bwriter;
  
  select mid, mname, bno,btitle
  from member
  left outer join board
  on member.mid=board.bwriter
  where bno is null;
  
  select bno, btitle, mid, mname
  from board
  right outer join member
  on member.mid=board.bwriter
  where bno is null;
  
  --[참고 : 오라클에서만 사용]
  --left outer join
  select  mid, mname,bno, btitle
  from member,board
  where member.mid=board.bwriter(+);--(+)쪽이 붙는게 데이터가 없으면 null로 출력
  --right outer join
  select bno, btitle,mid,mname
  from board,member
  where board.bwriter(+)=member.mid;
    
  --left outer join
  select mid, mname, bno, btitle
  from member
  left outer join board
  on member.mid=board.bwriter;
  --left outer join
  select mid, mname, bno, btitle
  from member
  right outer join board
  on member.mid=board.bwriter;
  
  --full outer join
  select mid, mname, bno, btitle
  from member
  full outer join board
  on member.mid=board.bwriter;
  
  
  
  