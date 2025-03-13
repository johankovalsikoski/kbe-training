CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(6) NOT NULL,
  `name` varchar(15) NOT NULL,
  `surname` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
);
