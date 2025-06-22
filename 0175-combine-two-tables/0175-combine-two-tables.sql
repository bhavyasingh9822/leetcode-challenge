# Write your MySQL query statement below
SELECT  p.firstName,p.lastName,s.city,s.state
FROM Person p
LEFT jOIN Address s
ON p.personID = s.personID;