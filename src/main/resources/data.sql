/* CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`account_id`)
);

CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  `active` BOOLEAN,
  PRIMARY KEY (`customer_id`)
);


CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `ACTIVE` BOOLEAN,
   `Role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
);

CREATE TABLE `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
);

CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `entry_date` datetime(6) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
);

CREATE TABLE `order_employees` (
  `order_order_id` int NOT NULL,
  `employees_employee_id` int NOT NULL,
  PRIMARY KEY (`order_order_id`,`employees_employee_id`)
);

CREATE TABLE `order_products` (
  `order_order_id` int NOT NULL,
  `products_product_id` int NOT NULL,
  PRIMARY KEY (`order_order_id`,`products_product_id`)
);

CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
);

CREATE TABLE `product_items` (
  `product_product_id` int NOT NULL,
  `items_item_id` int NOT NULL,
  PRIMARY KEY (`product_product_id`,`items_item_id`)
); */

INSERT INTO PUBLIC.EMPLOYEE (EMPLOYEE_ID,USERNAME, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NO, SSN,ACTIVE,ROLE) VALUES(1, 'employee1', 'employee1', 'employee1', 'employee1', 'employee1', '$2a$10$i6Rym4qyotX12Bwd.Nna5OLK67nsVZdxUeGtIuvM21/GLxxDWts6C', 'employee1',true,'EMPLOYEE');
INSERT INTO PUBLIC.EMPLOYEE (EMPLOYEE_ID,USERNAME, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, PHONE_NO, SSN,ACTIVE,ROLE) VALUES(2, 'employee2', 'employee2', 'employee2', 'employee2', 'employee2', '$2a$10$i6Rym4qyotX12Bwd.Nna5OLK67nsVZdxUeGtIuvM21/GLxxDWts6C', 'employee2',true,'ADMIN');

INSERT INTO PUBLIC.ACCOUNT (PASSWORD, USER_NAME, EMPLOYEE_ID) VALUES('$2a$10$i6Rym4qyotX12Bwd.Nna5OLK67nsVZdxUeGtIuvM21/GLxxDWts6C', 'randomness', 1);
INSERT INTO PUBLIC.ACCOUNT (PASSWORD, USER_NAME, EMPLOYEE_ID) VALUES('$2a$10$i6Rym4qyotX12Bwd.Nna5OLK67nsVZdxUeGtIuvM21/GLxxDWts6C', 'randomness', 2);
 INSERT INTO PUBLIC.CUSTOMER (ADDRESS, EMAIL, FIRST_NAME, LAST_NAME, USERNAME,PHONE_NUMBER,PASSWORD,ROLE,ACTIVE) VALUES('customer1', 'customer1', 'customer1', 'customer1', 'customer1','customer1','customer1','USER',true);
-- INSERT INTO PUBLIC.ITEM (NAME, "TYPE") VALUES('randomness', 'randomness');
-- INSERT INTO PUBLIC."order" (ENTRY_DATE, NOTES, ORDER_PRICE, ORDER_STATUS) VALUES('randomness', 'randomness', 0, 'randomness');
-- INSERT INTO PUBLIC."order_employees" ("order_order_id", EMPLOYEES_EMPLOYEE_ID) VALUES(0, 0);
-- INSERT INTO PUBLIC."order_products" ("order_order_id", PRODUCTS_PRODUCT_ID) VALUES(0, 0);
-- INSERT INTO PUBLIC.PRODUCT (PRICE, PRODUCT_NAME) VALUES(0, 'randomness');
-- INSERT INTO PUBLIC.PRODUCT_ITEMS (PRODUCT_PRODUCT_ID, ITEMS_ITEM_ID) VALUES(0, 0);
