-- 1.1 문장과 절
select*from emp;
--1.2 특정 데이터만 보기
select empno, emname from emp;
--1.3 산술 연산자 
select ename, sal, sal*12 from emp;
--1.4 NULL 연산시 주의할 점
select ename,sal,comm,sal*12+comm from emp;
--1.5 컬럼이름에 별칭 지정하기 
select ename as 이름,sal as 월급,comm 보너스,sal*12+nvl(comm,0) as 연봉 from emp;
--1.6 Concatenation 연산자(문자열 결합 ||)
select (empno ||'-'|| ename) as 이름 from emp;
select ename ||'의 직급은'|| job||'입니다' as 직급 from emp;
--1.7 DISTINCT 키워드(중복제거)
--사원이 있는 부서번호는?
select distinct deptno from emp;

-------------------------------------------------------------------------------

--조건절 작성
select ename from emp where deptno=20;
--2.1 비교연산자
select ename from emp where deptno!=20;
select ename from emp where deptno<>20;
select ename from emp where sal>=500;
--2.1.1 문자 데이터 조회
select * from emp where enmae='이문세';
--2.1.2 날짜 데이터 조회
--2005년 1월 1일 이전에 입사한 사원의 정보
select * from emp where hiredate <'2005-01-01';--문자열을 비교하는게 아니라 날짜(date)로 변환해서 비교한다
select * from emp where hiredate <to_date('2005-01-01','YYYY/MM/DD');
--2.2 논리 연산자
--2.2.1 AND 연산자
--10번 부서에 소속된 사원 중에서 직급이 과장인 사원의 정보
select * from emp where deptno=10 and job='과장';
--월급이 400 이상, 500이하인 사원의 정보
select * from emp where 400<=sal and sal<=500;
--2.2.2 OR 연산자
--10번 부서에 소속된 사원 또는 직급이 과장인 사원의 정보
select * from emp where deptno=10 or job='과장';
--2.2.3 NOT 연산자
--10번 부서가 아닌 사원의 정보
select * from emp where deptno!=10;
select * from emp where deptno<>10;
select * from emp where not deptno=10;
--2.3 BETWEEN AND 연산자
--월급이 400 이상, 500이하인 사원의 정보
select * from emp where 400<=sal and sal<=500;--연산자 3개사용
--월급이 400 이상, 500이하인 사원의 정보
select * from emp where sal between 400 and 500;--연산자 1개사용(between and)
select * from emp where ename between '바'and '자';
--2.4 IN 연산자
--보너스가 80이거나, 100이거나, 200인 사원의 정보
select * from emp where comm=80 or comm=100 or comm=200;
select * from emp where comm IN(80,100,200);--comm의 값이 80,100,200중 하나인경우, 문자도 가능하다 ,갯수의 제한이 없다
--2.5 LIKE 연산자와 와일드 카드
--2.5.1 와일드카드(%) 사용하기
--성이 이씨인 사원의 정보
select * from emp where ename between '이' and '익';
select * from emp where ename like '이%';-- %는 LIKE 연산자에서만 쓸수 있다(~와 같은)
--이름중에 '성'이 포함된 사원의 정보
select * from emp where ename like '%성%';
--2.5.1 와일드카드(_) 사용하기
--이름중에 두번째 글자가 '성'인 사원의 정보
select * from emp where ename like '_성%';--_가 첫글자
--이름중에 '성'이 포함되지 않는 사원의 정보
select * from emp where ename not like '%성%';-- not은 조건전체의 부정할때 많이 쓴다
--2.6 NULL을 위한 연산자
--보너스가 없는(null)인 사원의 정보
select * from emp where comm=null;--x
select * from emp where comm is null;
select * from emp where comm is not null;--보너스가 있을때  
--제일처음 resultset을 얻으면 커서는 before first에 위치 before first 다음줄에 데이터가있는데 커서를 데이터가있는곳으로 내리려면 next()를쓴다(데이터가 있으면 true 없으면 false 리턴) 
--마지막줄엔 after last
--3.2 오름차순 정렬을 위한 ASC
select * from emp order by sal;
select * from emp order by sal asc;
--3.2 내림차순 정렬을 위한 DESC
select * from emp order by sal desc;
select * from emp order by hiredate desc;--최근입사자부터
--입사날 내림차순 순서(1차정렬)->이름 올림차순(2차정렬)
select * from emp order by hiredate desc, ename asc;

--30번부서에서 월급이 400이상인 사원의 번호,이름,연봉(내림차순)을 가져오시오
select empno,ename, (sal*12+nvl(comm,0)) as yearsal from emp
where sal>400 and deptno=30
order by yearsal desc;