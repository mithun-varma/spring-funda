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

-- INSERT INTO `person` (name) VALUES ('Santosh');
-- INSERT INTO `person` (name) VALUES ('Kumar');
-- INSERT INTO `person` (name) VALUES ('Walking');
-- INSERT INTO `person` (name) VALUES ('Techie');


INSERT INTO person (ID,NAME, LOCATION, BIRTH_DATE ) 
VALUES(10,'Ranga', 'Hyderabad',sysdate());
INSERT INTO person (ID,NAME, LOCATION, BIRTH_DATE ) 
VALUES(11,'James', 'New York',sysdate());
INSERT INTO person (ID,NAME, LOCATION, BIRTH_DATE ) 
VALUES(12,'Pieter', 'Amsterdam',sysdate());

-- INSERT INTO `employee` (id,name,company,salary) VALUES (1,'Santosh','HII','1000');
-- INSERT INTO `employee` (id,name,company,salary) VALUES (2,'Kumar','HII','2000');


--JDBC AUTHENTICATION
INSERT INTO `users` (username, password, enabled) values ('admin', '{noop}ace2three', true);
INSERT INTO `users` (username, password, enabled) values ('mith', '{noop}ace2three', true);

INSERT INTO AUTHORITIES (username, authority) values ('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES (username, authority) values ('mith', 'ROLE_USER');


-- insert into course(id, name, created_date, last_updated_date) 
-- values(10001,'JPA in 50 Steps', sysdate(), sysdate());
-- insert into course(id, name, created_date, last_updated_date) 
-- values(10002,'Spring in 50 Steps', sysdate(), sysdate());
-- insert into course(id, name, created_date, last_updated_date) 
-- values(10003,'Spring Boot in 100 Steps', sysdate(), sysdate());
-- 
-- insert into passport(id,number)
-- values(40001,'E123456');
-- insert into passport(id,number)
-- values(40002,'N123457');
-- insert into passport(id,number)
-- values(40003,'L123890');
-- 
-- insert into student(id,name,passport_id)
-- values(20001,'Ranga',40001);
-- insert into student(id,name,passport_id)
-- values(20002,'Adam',40002);
-- insert into student(id,name,passport_id)
-- values(20003,'Jane',40003);
-- 
-- insert into review(id,rating,description,course_id)
-- values(50001,'5', 'Great Course',10001);
-- insert into review(id,rating,description,course_id)
-- values(50002,'4', 'Wonderful Course',10001);
-- insert into review(id,rating,description,course_id)
-- values(50003,'5', 'Awesome Course',10003);

-- insert into student_course(student_id,course_id)
-- values(20001,10001);
-- insert into student_course(student_id,course_id)
-- values(20002,10001);
-- insert into student_course(student_id,course_id)
-- values(20003,10001);
-- insert into student_course(student_id,course_id)
-- values(20001,10003);