CREATE database grocery_online;

USE grocery_online;

CREATE TABLE IF NOT EXISTS `inquiry` (
    `inquiry_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) NOT NULL,
    `mobile_num` varchar(10) NOT NULL,
    `email` varchar(100) NOT NULL,
    `subject` varchar(100) NOT NULL,
    `message` varchar(500) NOT NULL,
    `status` varchar(10) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `roles` (
    `role_id` int NOT NULL AUTO_INCREMENT,
    `role_name` varchar(50) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS `address` (
    `address_id` int NOT NULL AUTO_INCREMENT,
    `address1` varchar(200) NOT NULL,
    `address2` varchar(200) DEFAULT NULL,
    `city` varchar(50) NOT NULL,
    `state` varchar(50) NOT NULL,
    `zip_code` int NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`address_id`)
);

CREATE TABLE IF NOT EXISTS `user` (
    `user_id` int AUTO_INCREMENT NOT NULL,
    `name` varchar(50) NOT NULL,
    `email` varchar(50) NOT NULL,
    `password` varchar(12) NOT NULL,
    `mobile_num` varchar(10) NOT NULL,
    `role_id` int NOT NULL,
    `address_id` int NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE IF NOT EXISTS `order` (
    `order_number` int AUTO_INCREMENT NOT NULL,
    `user_id` int,
    `user_name` varchar(50) NOT NULL,
    `to_street` varchar(50) NOT NULL,
    `to_city` varchar(50) NOT NULL,
    `to-state` varchar(50) NOT NULL,
    `to-zip` varchar(10) NOT NULL,
    `ship_date` TIMESTAMP NOT NULL,
    `product_id` int NOT NULL,
    PRIMARY KEY (`order_number`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`)
);

CREATE TABLE IF NOT EXISTS `product` (
    `product_id` int AUTO_INCREMENT NOT NULL,
    `quantity` int NOT NULL,
    `product_type` varchar(50) NOT NULL,
    PRIMARY KEY (`product_id`)
);