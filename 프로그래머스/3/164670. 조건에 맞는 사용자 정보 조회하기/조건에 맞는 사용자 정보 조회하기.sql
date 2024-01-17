select u.user_id, u.nickname, 
concat(city, ' ', street_address1, ' ', street_address2) as '전체주소',
concat(substr(tlno, 1, 3), '-', substr(tlno, 4, 4), '-', substr(tlno, 8)) as '전화번호'
from used_goods_board as b
join used_goods_user as u
on b.writer_id = u.user_id
group by u.user_id
having count(*) >= 3
order by u.user_id desc