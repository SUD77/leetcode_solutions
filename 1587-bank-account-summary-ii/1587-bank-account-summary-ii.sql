# Write your MySQL query statement below
Select 
    a.name,
    sum(b.amount) as balance
from 
    Users a
join
    transactions b
on
    a.account=b.account
group by 
    a.account
having
    balance>10000;