# Write your MySQL query statement below

#NOT MINE

Select SalesPerson.name
from Orders o join Company c on(o.com_id=c.com_id and c.name='RED')
right join SalesPerson on SalesPerson.sales_id=o.sales_id
where o.sales_id is null;