DROP DATABASE IF EXISTS workflow;
CREATE DATABASE workflow;

CREATE TABLE `workflow`.`organization` (
  `org_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` varchar(600) NOT NULL,
  `admin_email` varchar(45) NOT NULL UNIQUE,
  `password` varchar(100) NOT NULL,
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
  `password` VARCHAR(100) NOT NULL,
  `address` VARCHAR(600) NOT NULL,
  `dept_id` INT,
  `role_id` INT,
PRIMARY KEY(`email_id`,`org_id`),
constraint fk2 FOREIGN KEY (org_id) references `workflow`.`organization`(org_id),
constraint fk3 FOREIGN KEY (role_id) references `workflow`.`role`(role_id),
constraint fk4 FOREIGN KEY (dept_id) references `workflow`.`department`(dept_id));

CREATE TABLE `workflow`.`level` (
  `level_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL UNIQUE,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`level_id`));
  
CREATE TABLE `workflow`.`layer` (
  `layer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL UNIQUE,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`layer_id`));
  
CREATE TABLE `workflow`.`status` (
  `status_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` varchar(6000),
PRIMARY KEY(`status_id`));

CREATE TABLE `workflow`.`request_type` (
  `request_type_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `org_id` INT NOT NULL,
UNIQUE(email_id, org_id, name),
constraint fk5 FOREIGN KEY (email_id,org_id) references `workflow`.`user`(email_id,org_id), 
PRIMARY KEY(`request_type_id`));

CREATE TABLE `workflow`.`workflow_master` (
  `workflow_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR (600) NOT NULL,
  `request_type_id` INT,
  `email_id` VARCHAR(45) NOT NULL,
  `org_id` INT NOT NULL,
  `dept_id` INT NOT NULL,
PRIMARY KEY(`workflow_id`),
constraint fk15 FOREIGN KEY (email_id,org_id) references `workflow`.`user`(email_id,org_id),
constraint fk16 FOREIGN KEY (dept_id) references `workflow`.`department`(dept_id),
constraint fk6 FOREIGN KEY (request_type_id) references `workflow`.`request_type`(request_type_id));

CREATE TABLE `workflow`.`workflowtbl` (
  `workflow_id` INT NOT NULL,
  `level_id` INT NOT NULL,
  `layer_id` INT NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `org_id` INT NOT NULL,
  `description` VARCHAR (600) NOT NULL,
constraint fk17 FOREIGN KEY (workflow_id) references `workflow`.`workflow_master`(workflow_id),
constraint fk7 FOREIGN KEY (level_id) references `workflow`.`level`(level_id),
constraint fk8 FOREIGN KEY (email_id,org_id) references `workflow`.`user`(email_id,org_id),
constraint fk9 FOREIGN KEY (layer_id) references `workflow`.`layer`(layer_id));

CREATE TABLE `workflow`.`workflowinstance` (
  `workflow_instance_id` INT NOT NULL,
  `workflow_id` INT NOT NULL,
  `level_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  `layer_id` INT NOT NULL,
  `description` VARCHAR (600) NOT NULL,
constraint fk10 FOREIGN KEY (level_id) references `workflow`.`level`(level_id),
constraint fk11 FOREIGN KEY (status_id) references `workflow`.`status`(status_id),
constraint fk12 FOREIGN KEY (layer_id) references `workflow`.`layer`(layer_id),
constraint fk13 FOREIGN KEY (workflow_id) references `workflow`.`workflow_master`(workflow_id));

CREATE TABLE `workflow`.`phonetbl` (
  `email_id` varchar(45) NOT NULL,
  `org_id` INT NOT NULL,
  `phone` varchar(10) NOT NULL,
  constraint fk14 FOREIGN KEY (email_id,org_id) references `workflow`.`user`(email_id,org_id));
  
USE workflow;  
INSERT INTO organization ( name, address, admin_email, password ) VALUES ('Microsoft','Seattle','micro@micro.com','21232f297a57a5a743894a0e4a801fc3');  
INSERT INTO department ( name, org_id ) VALUES ('Software','1');
INSERT INTO department ( name, org_id ) VALUES ('Hardware','1');
INSERT INTO role ( name) VALUES ('depart_admin');
INSERT INTO role ( name) VALUES ('user');
INSERT INTO user ( email_id, org_id, password, address, dept_id, role_id ) VALUES ('bill@microsoft.com','1','21232f297a57a5a743894a0e4a801fc3','101 E San','1','1');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('bill@microsoft.com','1','0123456789');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('bill@microsoft.com','1','1234567890');
INSERT INTO user ( email_id, org_id, password, address, dept_id, role_id ) VALUES ('parth@microsoft.com','1','21232f297a57a5a743894a0e4a801fc3','111 E San','1','2');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('parth@microsoft.com','1','0123456789');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('parth@microsoft.com','1','1234567890');
INSERT INTO user ( email_id, org_id, password, address, dept_id, role_id ) VALUES ('chinu@microsoft.com','1','21232f297a57a5a743894a0e4a801fc3','111 E San','1','2');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('chinu@microsoft.com','1','0123456789');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('chinu@microsoft.com','1','1234567890');
INSERT INTO user ( email_id, org_id, password, address, dept_id, role_id ) VALUES ('dharmik@microsoft.com','1','21232f297a57a5a743894a0e4a801fc3','111 E San','1','2');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('dharmik@microsoft.com','1','0123456789');
INSERT INTO phonetbl ( email_id, org_id, phone) VALUES ('dharmik@microsoft.com','1','1234567890');
INSERT INTO request_type ( name, email_id, org_id ) VALUES ('code review','bill@microsoft.com','1');
INSERT INTO level ( name, description ) VALUES ('Level 0','Requester');
INSERT INTO level ( name, description ) VALUES ('Level 1','First level worker');
INSERT INTO level ( name, description ) VALUES ('Level 2','Second level worker');
INSERT INTO level ( name, description ) VALUES ('Level 3','Third level worker');
INSERT INTO layer ( name, description ) VALUES ('Layer 0','First Worker');
INSERT INTO layer ( name, description ) VALUES ('Layer 1','First alternate Worker');
INSERT INTO layer ( name, description ) VALUES ('Layer 2','Second alternate Worker');
INSERT INTO status ( name, description ) VALUES ('Requested','Request is in requested state.');
INSERT INTO status ( name, description ) VALUES ('Assigned','Request is in assigned state.');
INSERT INTO status ( name, description ) VALUES ('Unassigned','Request is in unassigned state.');
INSERT INTO status ( name, description ) VALUES ('Pending','Request is in pending state.');
INSERT INTO status ( name, description ) VALUES ('Approve','Request is in approved state.');
INSERT INTO status ( name, description ) VALUES ('Reject','Request is in rejected state.');
INSERT INTO workflow_master ( description, request_type_id, email_id, org_id, dept_id ) VALUES ('Code review request for Bill','1','bill@microsoft.com','1','1');
INSERT INTO workflowtbl ( workflow_id, level_id, email_id, org_id, layer_id, description ) VALUES ('1','1','bill@microsoft.com','1','1','Code review request for Bill');
INSERT INTO workflowtbl ( workflow_id, level_id, email_id, org_id, layer_id, description ) VALUES ('1','2','chinu@microsoft.com','1','1','level 1 for code review workflow');
INSERT INTO workflowtbl ( workflow_id, level_id, email_id, org_id, layer_id, description ) VALUES ('1','2','parth@microsoft.com','1','2','layer 1 for code review workflow for level 1');
INSERT INTO workflowtbl ( workflow_id, level_id, email_id, org_id, layer_id, description ) VALUES ('1','3','dharmik@microsoft.com','1','1','level 2 for code review workflow');
INSERT INTO workflowinstance ( workflow_instance_id, workflow_id, level_id, layer_id, status_id, description ) VALUES ('1','1','1','1','1','Request initiated !');
INSERT INTO workflowinstance ( workflow_instance_id, workflow_id, level_id, layer_id, status_id, description ) VALUES ('1','1','2','1','2','Assigned!  level 1 for code review workflow');
INSERT INTO workflowinstance ( workflow_instance_id, workflow_id, level_id, layer_id, status_id, description ) VALUES ('1','1','2','2','2','Assigned!  layer 1 for code review workflow for level 1');