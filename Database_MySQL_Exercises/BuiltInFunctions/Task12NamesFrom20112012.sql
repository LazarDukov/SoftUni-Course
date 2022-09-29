USE `diablo`;

SELECT `name`, date_format(`start`, "%Y-%m-%d") AS `name` FROM `games`
WHERE `start` REGEXP '^2011'
OR`start` REGEXP '^2012'
ORDER BY `start`, `name`
LIMIT 50;
