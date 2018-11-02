CREATE TABLE `brand_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(100) DEFAULT NULL,
  `brand_model` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(20) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `licence_no` varchar(30) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `creation_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modification_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_email_unique_key` (`email`),
  UNIQUE KEY `user_licence_unique_key` (`licence_no`),
  UNIQUE KEY `user_mobile_number_unique_key` (`mobile_number`),
  KEY `user_name_index_key` (`name`),
  KEY `user_email_index_key` (`email`),
  KEY `idx_user_status` (`status`),
  KEY `user_mobile_number_index_key` (`mobile_number`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_unique_key` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

INSERT INTO `role` (`id`, `name`, `description`)
VALUES
	(1, 'ADMIN', 'Ecg247 admin'),
	(2, 'USER', 'End User'),
	(3, 'OWNER', 'Garage owner'),
	(4, 'PICKUP_USER', 'pick up boy');

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `creation_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modification_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `bike_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reg_no` varchar(100) DEFAULT NULL,
  `creation_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modification_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bike_reg_no_unique_key` (`reg_no`),
  KEY `bike_reg_no_index_key` (`reg_no`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


CREATE TABLE `garage_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_reg_no` varchar(100) DEFAULT NULL,
  `shop_name` varchar(100) DEFAULT NULL,
  `shop_add` varchar(100) DEFAULT NULL,
  `owner_id` int(11) NOT NULL,
  `creation_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modification_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `token_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(100) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


CREATE TABLE `service_request_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `garage_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `is_otp_verified` tinyint(1) NOT NULL DEFAULT '0',
  `payment_mode` varchar(100) DEFAULT NULL,
  `bike_model_no` varchar(100) DEFAULT NULL,
  `bike_mfg` varchar(100) DEFAULT NULL,
  `bike_reg_no` varchar(100) DEFAULT NULL,
  `pickup_user_id` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `is_pick_up` tinyint(1) NOT NULL DEFAULT '0',
  `is_drop` tinyint(1) NOT NULL DEFAULT '0',
  `pick_up_add` varchar(100) DEFAULT NULL,
  `drop_add` varchar(100) DEFAULT NULL,
  `pick_up_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `drop_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `requested_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `completed_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `creation_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modification_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;