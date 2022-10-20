USE `restaurant_db`;
INSERT INTO `products` (`name`, `type`, `price`) (
SELECT 
CONCAT(waiters.`last_name`, " ", 'specialty'),
"Cocktail",
CEIL(waiters.`salary` * 0.01)
FROM `waiters` AS waiters
WHERE waiters.`id` > 6
);