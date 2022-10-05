USE `manytomany`;
USE `manytomany`;


CREATE TABLE `students` (
`student_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

INSERT INTO `students` (`name`)
VALUE ("Mila"),
("Toni"),
("Ron");

CREATE TABLE `exams` (
`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);
ALTER TABLE `exams` AUTO_INCREMENT = 101;
INSERT INTO `exams` (`name`)
VALUE ("Spring MVC"),
("Neo4j"),
("Oracle 11g");



CREATE TABLE `students_exams`(
`student_id` INT NOT NULL,
`exam_id` INT NOT NULL,

CONSTRAINT `pk`
PRIMARY KEY (`student_id`, `exam_id`),

CONSTRAINT `fk_to_student`
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`),

CONSTRAINT `fk_to_exams`
FOREIGN KEY (`exam_id`)
REFERENCES `exams`(`exam_id`)
);

INSERT INTO `students_exams` (`student_id`, `exam_id`)
VALUE (1,101),
(1,102),
(2,101),
(3,103),
(2,102),
(2,103);