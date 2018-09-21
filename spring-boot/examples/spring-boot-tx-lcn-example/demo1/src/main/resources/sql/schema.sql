CREATE TABLE `product` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO product VALUES('1','iphone x',100);