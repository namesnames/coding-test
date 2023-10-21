-- 코드를 입력하세요
SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT (B.PUBLISHED_DATE, '%Y-%m-%d') from BOOK B 
join AUTHOR A
where B.CATEGORY = '경제' and B.AUTHOR_ID = A.AUTHOR_ID
order by B.PUBLISHED_DATE