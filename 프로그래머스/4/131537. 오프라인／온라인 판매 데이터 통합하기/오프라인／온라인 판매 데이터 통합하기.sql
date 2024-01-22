select date_format(SALES_DATE, "%Y-%m-%d") as SALES_DATE, product_id, user_id, sales_amount
from online_sale
where SALES_DATE >= '2022-03-01' and SALES_DATE < '2022-04-01'
union all
select date_format(SALES_DATE, "%Y-%m-%d") as SALES_DATE, product_id, null as user_id
, sales_amount
from offline_sale
where SALES_DATE >= '2022-03-01' and SALES_DATE < '2022-04-01'
order by SALES_DATE, product_id, user_id;