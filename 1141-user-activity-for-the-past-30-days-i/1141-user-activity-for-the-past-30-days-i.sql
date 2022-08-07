# Write your MySQL query statement below

Select activity_date as day, Count(distinct user_id) as active_users
from Activity
where (activity_date > "2019-06-27" and activity_date <= "2019-07-27")
GROUP BY activity_date;