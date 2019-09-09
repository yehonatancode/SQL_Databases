CREATE VIEW avg_grades_view AS
   SELECT students.firstName, AVG(grade) AS average
   FROM grades 
   INNER JOIN students ON grades.studentId = students.id
   GROUP BY studentId;

SELECT  * FROM avg_grades_view

UPDATE avg_grades_view SET average=75 WHERE firstName LIKE 'Johnny';
