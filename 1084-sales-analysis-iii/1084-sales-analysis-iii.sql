# Write your MySQL query statement below
Select product_id, product_name
from sales
join product
using (product_id)
group by product_id
having min(sale_date) >='2019-01-01' and max(sale_date)<='2019-03-31';