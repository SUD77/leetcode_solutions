# Write your MySQL query statement below

Select DISTINCT(author_id) AS id from Views a where a.author_id=a.viewer_id ORDER BY author_id ASC;
