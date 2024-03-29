CREATE DATABASE `self-referencing`;
USE `self-referencing`;

CREATE TABLE `teachers` (
`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
`manager_id` INT
);
ALTER TABLE `teachers` AUTO_INCREMENT = 101;

INSERT INTO `teachers` (`name`, `manager_id`)
VALUE ("John", NULL),
("Maya", 106),
("Silvia", 106),
("Ted", 105),
("Mark", 101),
("Greta", 101);

ALTER TABLE `teachers`
ADD CONSTRAINT `fk`
FOREIGN KEY (`manager_id`)
REFERENCES `teachers`(`teacher_id`);
