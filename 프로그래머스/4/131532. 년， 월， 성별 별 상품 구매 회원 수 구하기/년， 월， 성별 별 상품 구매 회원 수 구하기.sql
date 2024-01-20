select year(SALES_DATE), month(SALES_DATE), gender, count(distinct o.user_id)
from user_info as u
join online_sale as o
on u.user_id = o.user_id
where gender is not null
group by year(SALES_DATE), month(SALES_DATE), gender
order by year(SALES_DATE), month(SALES_DATE), gender;