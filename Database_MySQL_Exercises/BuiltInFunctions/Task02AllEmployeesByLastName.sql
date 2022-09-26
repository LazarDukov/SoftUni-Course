USE `soft_uni`;

SELECT `first_name`, `last_name`
FROM `employees`
WHERE LOCATE("ei", `last_name`);
