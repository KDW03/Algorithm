-- 코드를 입력하세요
SELECT *
FROM CAR_RENTAL_COMPANY_CAR
where OPTIONS LIKE "%네비게이션%"
order by CAR_ID DESC