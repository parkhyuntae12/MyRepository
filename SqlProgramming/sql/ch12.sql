--행 순번 붙이기
select rownum, bno, btitle --rownum은 정렬되기전의 결과에만 적용된다(order by 이후에 rownum을 붙이게 하려면 서브쿼리를 써야한다)
from board
order by bno;

select rownum, bno, btitle
from (select bno,btitle from board order by bno);

select rownum, bno, btitle
from (select bno,btitle from board order by bno desc);

--최근 삽입된 행 5개를 가져와라
select rownum, bno, btitle --순번이 매겨질때마다 조건을 검사한다(rownum과 where의 관계), 순번이 다 매겨지고 조건검사를 하지 않는다 where 조건이 false가 나올때까지 순번을 매긴다
from (select bno,btitle from board order by bno desc)
where rownum<=5;

select rownum, bno, btitle
from (select bno,btitle from board order by bno desc)
where rownum>5000;--rownum이 생기지도 않았는데 ~이상은 검색이 되지않는다

--행의 순번이 11번~20번까지를 가져와라
select rn, bno,btitle
from(
select rownum as rn, bno, btitle
from (select bno,btitle from board order by bno desc)
where rownum<=20
)
where rn>=11;

--1페이지에 10개씩 구성하고, n번째 페이지를 가져와라
select rn, bno,btitle
from(
select rownum as rn, bno, btitle
from (select bno,btitle from board order by bno desc)
where rownum<=n*10
)
where rn>=((n-1)*10+1);
