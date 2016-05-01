DROP DATABASE IF EXISTS workflow;
CREATE DATABASE workflow;

CREATE TABLE `workflow`.`organization` (
  `org_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` varchar(600) NOT NULL,
  `admin_email` varchar(45) NOT NULL UNIQUE,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`org_id`));

CREATE TABLE `workflow`.`role`(
`role_id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
PRIMARY KEY (`role_id`));

CREATE TABLE `workflow`.`department`(
`dept_id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
`org_id` INT,
PRIMARY KEY (`dept_id`),
constraint fk1 FOREIGN KEY(org_id) references `workflow`.`organization`(org_id));


CREATE TABLE `workflow`.`user` (
  `email_id` VARCHAR(45) NOT NULL UNIQUE,
  `org_id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `address` VARCHAR(600) NOT NULL,
  `dept_id` INT,
  `role_id` INT,
PRIMARY KEY(`email_id`,`org_id`),
constraint fk2 FOREIGN KEY (org_id) references `workflow`.`organization`(org_id),
constraint fk3 FOREIGN KEY (role_id) references `workflow`.`role`(role_id),
constraint fk4 FOREIGN KEY (dept_id) references `workflow`.`department`(dept_id));

CREATE TABLE `workflow`.`level_master` (
  `level_id` INT NOT NULL AUTO_INCREMENT,
  `desc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`level_id`));
  
CREATE TABLE `workflow`.`layer_master` (
  `layer_id` INT NOT NULL AUTO_INCREMENT,
  `desc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`layer_id`));
  
CREATE TABLE `workflow`.`status_master` (
  `status_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` varchar(6000),
PRIMARY KEY(`status_id`));

CREATE TABLE `workflow`.`request_type_master` (
  `request_type_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
PRIMARY KEY(`request_type_id`));

CREATE TABLE `workflow`.`workflow_master` (
  `workflow_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR (600) NOT NULL,
  `request_type_id` INT,
PRIMARY KEY(`workflow_id`),
constraint fk5 FOREIGN KEY (request_type_id) references `workflow`.`request_type_master`(request_type_id));

CREATE TABLE `workflow`.`workflowtbl` (
  `workflow_id` INT NOT NULL AUTO_INCREMENT,
  `level_id` INT NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `org_id` INT NOT NULL,
  `layer_id` INT NOT NULL,
  `description` VARCHAR (600) NOT NULL,
  `request_type_id` INT,
PRIMARY KEY(`workflow_id`),
constraint fk6 FOREIGN KEY (level_id) references `workflow`.`level_master`(level_id),
constraint fk7 FOREIGN KEY (email_id,org_id) references `workflow`.`user`(email_id,org_id),
constraint fk8 FOREIGN KEY (layer_id) references `workflow`.`layer_master`(layer_id));

CREATE TABLE `workflow`.`workflowinstance` (
  `workflow_instance_id` INT NOT NULL AUTO_INCREMENT,
  `workflow_id` INT NOT NULL,
  `level_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  `layer_id` INT NOT NULL,
PRIMARY KEY(`workflow_instance_id`),
constraint fk9 FOREIGN KEY (level_id) references `workflow`.`level_master`(level_id),
constraint fk10 FOREIGN KEY (status_id) references `workflow`.`status_master`(status_id),
constraint fk11 FOREIGN KEY (layer_id) references `workflow`.`layer_master`(layer_id),
constraint fk12 FOREIGN KEY (workflow_id) references `workflow`.`workflow_master`(workflow_id));

CREATE TABLE `workflow`.`phonetbl` (
  `email_id` varchar(45) NOT NULL,
  `org_id` INT NOT NULL,
  `phone` varchar(10) NOT NULL,
  constraint fk13 FOREIGN KEY (email_id,org_id) references `workflow`.`user`(email_id,org_id));
  
USE workflow;  
INSERT INTO organization ( name, address, admin_email, password ) VALUES ('Microsoft','Seattle','micro@micro.com','admin');  
INSERT INTO department ( name, org_id ) VALUES ('Software','1');
INSERT INTO role ( name) VALUES ('depart_admin');
INSERT INTO role ( name) VALUES ('user');
INSERT INTO user ( email_id, org_id, password, address, dept_id, role_id ) VALUES ('bill@apple.com','1','admin','101 E San','1','1');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('bill@apple.com','1','0123456789');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('bill@apple.com','1','1234567890');
INSERT INTO user ( email_id, org_id, password, address, dept_id, role_id ) VALUES ('parth@microsoft.com','1','admin','111 E San','1','2');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('parth@microsoft.com','1','0123456789');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('parth@microsoft.com','1','1234567890');