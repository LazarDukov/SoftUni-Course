USE `table_relations`;

CREATE TABLE `manufacturers` (
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`established_on` DATE
);

CREATE TABLE `models` (
`model_id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
`manufacturer_id` INT,
CONSTRAINT `fk_models_to_manufacturers`
FOREIGN KEY (`manufacturer_id`)
REFERENCES `manufacturers` (`manufacturer_id`)
);

ALTER TABLE `models` AUTO_INCREMENT = 101;

INSERT INTO `manufacturers` (`name`,`established_on`)
VALUE ("BMW", '1916-03-01'),
("Tesla", '2003-01-01'),
("Lada", '1966-05-01');

INSERT INTO `models` (`name`, `manufacturer_id`)
VALUE ("X1", 1),
("i6", 1),
("ModelS", 2),
("ModelX",2),
("Model3",2),
("Nova", 3);

ALTER TABLE `models`;
UPDATE `models` SET `name` = 'Model S' WHERE (`model_id` = '103');
UPDATE `models` SET `name` = 'Model X' WHERE (`model_id` = '104');
UPDATE `models` SET `name` = 'Model 3' WHERE (`model_id` = '105');

