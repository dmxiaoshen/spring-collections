CREATE TABLE IF not EXISTS `t_user` (
  `id` varchar(32) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);