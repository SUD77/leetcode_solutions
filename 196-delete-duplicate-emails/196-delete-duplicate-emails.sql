# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
Delete p from person p,person q
where p.id>q.id and q.email=p.email;