# Write your MySQL query statement below
Select email from person
group by email
having count(*)>1