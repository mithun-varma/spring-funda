/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  phanic
 * Created: 10 Oct, 2019
 */

-- DROP TABLE IF EXISTS `person`;
-- CREATE TABLE `person` (
--   `id` bigint(20) NOT NULL AUTO_INCREMENT,
--   `name` varchar(50) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- );

DROP TABLE IF EXISTS billionaires;
  
CREATE TABLE billionaires (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);


DROP TABLE IF EXISTS `person`;
create table person
(
   id integer not null AUTO_INCREMENT,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);


DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `created_at` timestamp,
  `updated_at` timestamp,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `guide`;
CREATE TABLE `guide` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `version` INT DEFAULT 0,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enroll_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `guide_id` varchar(50) DEFAULT NULL,
   FOREIGN KEY (guide_id) references guide,
   PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `users`;
create table `users`(
    `username` varchar(50) not null,
    `password` varchar(50) not null,
    `enabled` boolean not null,
     PRIMARY KEY (`username`)
);

DROP TABLE IF EXISTS `AUTHORITIES`;
CREATE TABLE `AUTHORITIES` (
  `username` varchar(20) NOT NULL, 
  `authority` varchar(50) DEFAULT NULL,
   FOREIGN KEY (username) references users(username)
-- constraint fk_authorities_users foreign key(username) references users(username)
);
