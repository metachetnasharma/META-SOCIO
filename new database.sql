create database meta_socio;

use meta_socio;

CREATE TABLE `user_table` (
 
 `user_id` int(11) NOT NULL Auto_increment,
 `name` varchar(50) DEFAULT NULL,
 `email_id` varchar(50) DEFAULT NULL unique,
 `image_url` varchar(100) DEFAULT NULL,
 `role` varchar(50) DEFAULT NULL,
 `department` varchar(30) DEFAULT NULL,
 `project_name` varchar(50) DEFAULT NULL,
 `created_at` datetime NOT NULL,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 `created_by` varchar(45) DEFAULT NULL,
 `updated_by` varchar(45) DEFAULT NULL,
 `phone_No` varchar(45) DEFAULT NULL,

 `isdelete` int(1) DEFAULT '0',
 PRIMARY KEY (`user_id`)
);
drop table user_table;

DELIMITER ;;
CREATE TRIGGER userTrigger BEFORE INSERT ON user_table FOR EACH ROW
BEGIN

   SET NEW.created_by = NEW.name;
   SET NEW.updated_by = NEW.name;
   
END;;
DELIMITER ;


select * from user_table;



CREATE TABLE `friends` (
`ID` int(11) Auto_increment Unique,
`friend_one` INT(11) ,
`friend_two` INT(11) ,

PRIMARY KEY (`friend_one`,`friend_two`),
FOREIGN KEY (friend_one) REFERENCES user_table(user_id),
FOREIGN KEY (friend_two) REFERENCES user_table(user_id),
`created_at` datetime NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `isdelete` int(1) DEFAULT '0'
  );

drop table friends;
select * from meta_socio.friends where friend_one!=2 and friend_two!=41;


create table post_management
(
post_id integer Auto_increment primary key ,
user_id integer,
post_details varchar(100),
group_id integer,
date_posted datetime,
likes integer,
FOREIGN KEY (user_id) REFERENCES user_table(user_id),
created_at datetime NOT NULL,
updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
created_by varchar(45) DEFAULT NULL,
updated_by varchar(45) DEFAULT NULL,
isdelete int(1) DEFAULT '0'
);




create table groups
(
group_id integer primary key,
user_id integer,
post_id integer,
FOREIGN KEY (user_id) REFERENCES user_table(user_id),
FOREIGN KEY (post_id) REFERENCES Post_management(post_id),
created_at datetime NOT NULL,
updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
created_by varchar(45) DEFAULT NULL,
updated_by varchar(45) DEFAULT NULL,
isdelete int(1) DEFAULT '0'
);
Select name, user_id FROM user_table where user_table.user_id=user_id;



select * from groups; 





create table comment_management
(
comment_id integer primary key,
post_id integer,
user_id integer,
comments varchar(100),
date_commented datetime,
FOREIGN KEY (user_id) REFERENCES user_table(user_id),
FOREIGN KEY (post_id) REFERENCES post_management(post_id),
created_at datetime NOT NULL,
updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
created_by varchar(45) DEFAULT NULL,
updated_by varchar(45) DEFAULT NULL,
isdelete int(1) DEFAULT '0'
);





CREATE TABLE group_member (
`group_id` INT(11) ,
`user_id` INT(11) ,
`status` ENUM('0','1','2') DEFAULT '0',
FOREIGN KEY (group_id) REFERENCES groups(group_id),
FOREIGN KEY (user_id) REFERENCES user_table(user_id),
`created_at` datetime NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `isdelete` int(1) DEFAULT '0');



