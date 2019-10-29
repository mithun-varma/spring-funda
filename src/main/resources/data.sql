/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  phanic
 * Created: 25 May, 2019
 */


DROP TABLE IF EXISTS billionaires;
  
CREATE TABLE billionaires (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');

-- INSERT INTO country (name) VALUES ('India');
-- INSERT INTO country (name) VALUES ('Brazil');
-- INSERT INTO country (name) VALUES ('USA');
-- INSERT INTO country (name) VALUES ('Italy');

INSERT INTO `person` (name) VALUES ('Santosh');
INSERT INTO `person` (name) VALUES ('Kumar');
INSERT INTO `person` (name) VALUES ('Walking');
INSERT INTO `person` (name) VALUES ('Techie');

-- INSERT INTO `employee` (id,name,company,salary) VALUES (1,'Santosh','HII','1000');
-- INSERT INTO `employee` (id,name,company,salary) VALUES (2,'Kumar','HII','2000');


--JDBC AUTHENTICATION
INSERT INTO `users` (username, password, enabled) values ('admin', '{noop}ace2three', true);
INSERT INTO `users` (username, password, enabled) values ('mith', '{noop}ace2three', true);

INSERT INTO AUTHORITIES (username, authority) values ('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES (username, authority) values ('mith', 'ROLE_USER');



