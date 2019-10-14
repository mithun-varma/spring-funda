/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  phanic
 * Created: 10 Oct, 2019
 */

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `createdat` varchar(50) DEFAULT NULL,
  `updatedat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `guide` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `version` INT DEFAULT 0,
  PRIMARY KEY (`id`)
);

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enroll_id` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `guide_id` varchar(50) DEFAULT NULL,
   FOREIGN KEY (guide_id) references guide,
   PRIMARY KEY (`id`)
);