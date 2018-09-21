CREATE TABLE `record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;