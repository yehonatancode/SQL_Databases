DELIMITER $$
CREATE TRIGGER new_grade_received 
AFTER INSERT ON grades 
FOR EACH ROW 
BEGIN 
    UPDATE students SET avg_grade = (SELECT AVG(grade) FROM grades WHERE studentId=NEW.studentId) where id = NEW.studentId;
END$$
DELIMITER ;

INSERT INTO grades(courseId, studentId, grade, passed) VALUES (60,70,81,1);
SELECT * FROM students;