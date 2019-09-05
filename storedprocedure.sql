DELIMITER ;s
CREATE PROCEDURE student_avg
(IN stId INT)
BEGIN  
   SELECT AVG(grade) FROM grades WHERE studentId = stId;
END $$
DELIMITER ;

CALL student_avg(111);


DROP PROCEDURE student_avg
