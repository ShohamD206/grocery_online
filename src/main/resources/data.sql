INSERT INTO `user` (`name`,`email`,`password`,`mobile_num`,`role_id`,`address_id`,`created_at`,`created_by`)
    VALUES ('Shoham Dar','shohamD.206@gmail.com','0000','0545700670',1,CURDATE(),'ADMIN');

INSERT INTO `user` (`name`,`email`,`password`,`mobile_num`,`role_id`,`address_id`,`created_at`,`created_by`)
    VALUES ('Naor Cohen','shohamD.206@gmail.com','1111','0544433264',1,CURDATE(),'ADMIN');



INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
    VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
    VALUES ('GUEST',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
    VALUES ('USER',CURDATE(),'DBA');