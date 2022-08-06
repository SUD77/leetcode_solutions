# Write your MySQL query statement below

Select x.id
from weather as x, weather as y
where x.temperature > y.temperature and datediff(x.recordDate, y.recordDate)=1;
