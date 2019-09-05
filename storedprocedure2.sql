CREATE PROCEDURE `student_avg_2'(IN stId INT, OUT avg_g REAL, OUT max_g INT)
BEGIN
SELECT AVG(grade) into avg_g FROM grades WHERE studentId = stId;
SELECT MAX(grade) into max_g FROM grades WHERE StudentId = stId;
END

CALL student_avg_2(222, @avg_grade, @max_grade);
SELECT @avg_grade, @max_grade;
