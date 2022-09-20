CREATE TABLE `users` (
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users` (username, password)
VALUES ("lazar", "lazar123"),
		("ivan", "ivan123"),
        ("gosho", "gosho123"),
        ("mihaela", "mihaela123"),
        ("petko", "petko123");
