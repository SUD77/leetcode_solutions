# Write your MySQL query statement below
Select * from Cinema where id%2!=0 && description!='boring' ORDER BY rating DESC;