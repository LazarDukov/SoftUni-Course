USE `movies`;

CREATE TABLE `directors` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(255) NOT NULL,
`notes` VARCHAR(255)
);

CREATE TABLE `genres` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(255) NOT NULL,
`notes` VARCHAR(255)
);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(255) NOT NULL,
`notes` VARCHAR(255)
);

CREATE TABLE `movies` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(255) NOT NULL,
`director_id` INT,
`copyright_year` DATE,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` INT,
`notes` VARCHAR(255)
);
USE `movies`;
INSERT INTO `directors` (`director_name`)
VALUES ("Gosho"),
		("Tosho"),
        ("Misho"),
        ("Tisho"),
        ("Lazar");
INSERT INTO `genres` (`genre_name`)
VALUES ("Slivcho"),
		("Mlivcho"),
        ("Sivcho"),
        ("Divcho"),
        ("Sikwsho");
INSERT INTO `categories` (`category_name`)
VALUES ("Dancho"),
		("Mancho"),
        ("Gancho"),
        ("Vancho"),
        ("Bancho");
INSERT INTO `movies` (`title`)
VALUES ("Banchev na more"),
		("Danchev is in the fitness"),
        ("Lazar is in the forest"),
        ("Marez is at the football pitch"),
        ("Misho e pich");
