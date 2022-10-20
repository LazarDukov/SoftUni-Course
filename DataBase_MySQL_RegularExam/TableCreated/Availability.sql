USE `restaurant_db`;

SELECT 
o.`table_id`,
t.`capacity`,
COUNT(c.`id`) AS `count_clients`,
CASE 
WHEN t.`capacity` > COUNT(c.`id`) THEN "Free seats"
WHEN t.`capacity` = COUNT(c.`id`) THEN "Full"
ELSE "Extra seats"
END
AS `availability`

FROM `orders` AS o
JOIN `tables` AS t 
ON o.`table_id` = t.`id`

JOIN `orders_clients` AS oc 
ON o.`id` = oc.`order_id`

JOIN `clients` AS c 
ON c.`id` = oc.`client_id`

WHERE t.`floor` = 1
GROUP BY `table_id`
ORDER BY `table_id` DESC;