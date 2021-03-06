CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tcc_transaction_user` (
  `TRANSACTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DOMAIN` varchar(100) DEFAULT NULL,
  `GLOBAL_TX_ID` varbinary(32) NOT NULL,
  `BRANCH_QUALIFIER` varbinary(32) NOT NULL,
  `CONTENT` varbinary(8000) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `TRANSACTION_TYPE` int(11) DEFAULT NULL,
  `RETRIED_COUNT` int(11) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `LAST_UPDATE_TIME` datetime DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  PRIMARY KEY (`TRANSACTION_ID`),
  UNIQUE KEY `UX_TX_BQ` (`GLOBAL_TX_ID`,`BRANCH_QUALIFIER`)
) ENGINE=InnoDB AUTO_INCREMENT=590 DEFAULT CHARSET=utf8

