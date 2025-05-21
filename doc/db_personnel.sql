/*
  Staff-Information-Management fresh dump
  Generated : 2025-05-21 (Asia/Shanghai, UTC+8)
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

/* =========================================================
   1.  Announcement
========================================================= */
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
                                `id`          CHAR(19)     NOT NULL COMMENT 'id',
                                `title`       VARCHAR(20)  DEFAULT NULL COMMENT '公告标题',
                                `content`     VARCHAR(5000)DEFAULT NULL COMMENT '公告内容',
                                `time`        DATETIME     DEFAULT NULL COMMENT '发布时间',
                                `is_deleted`  INT          DEFAULT 0,
                                `gmt_create`  DATETIME     DEFAULT NULL,
                                `gmt_modified`DATETIME     DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='公告表';

/* ——— 目前无公告示例数据 ——— */


/* =========================================================
   2.  Attendance
========================================================= */
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
                              `id`            CHAR(19) NOT NULL,
                              `name`          VARCHAR(20) DEFAULT NULL,
                              `status`        CHAR(1)     DEFAULT '0',
                              `time`          DATETIME    DEFAULT NULL COMMENT '考勤日期',
                              `audit`         CHAR(1)     DEFAULT '0',
                              `department_id` CHAR(19)    DEFAULT NULL,
                              `clerk_id`      CHAR(19)    DEFAULT NULL,
                              `is_deleted`    INT         DEFAULT 0,
                              `gmt_create`    DATETIME    DEFAULT NULL,
                              `gmt_modified`  DATETIME    DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='考勤表';

INSERT INTO `attendance`
(`id`,`name`,`status`,`time`,`audit`,`department_id`,`clerk_id`,
 `is_deleted`,`gmt_create`,`gmt_modified`) VALUES
                                               ('1638782305318051842',NULL,'1','2025-05-20 09:02:00','1',
                                                '1340584045776916482','1638778252236267521',0,
                                                '2025-05-21 12:05:00','2025-05-21 12:35:00'),
                                               ('1638782560528867330',NULL,'4','2025-05-20 09:02:00','0',
                                                '1340584967022235649','1638779582375895042',0,
                                                '2025-05-21 12:10:00','2025-05-21 12:40:00');


/* =========================================================
   3.  Clerk
========================================================= */
DROP TABLE IF EXISTS `clerk`;
CREATE TABLE `clerk` (
                         `id`            CHAR(19)  NOT NULL,
                         `name`          VARCHAR(20) DEFAULT NULL,
                         `sex`           CHAR(1)     DEFAULT NULL,
                         `phone_number`  CHAR(11)    DEFAULT NULL,
                         `photo`         VARCHAR(255)DEFAULT NULL,
                         `id_card`       CHAR(18)    DEFAULT NULL,
                         `address`       VARCHAR(50) DEFAULT NULL,
                         `position`      VARCHAR(25) DEFAULT NULL,
                         `department_id` CHAR(19)    DEFAULT NULL,
                         `user_id`       CHAR(19)    DEFAULT NULL,
                         `is_deleted`    INT         DEFAULT 0,
                         `gmt_create`    DATETIME    DEFAULT NULL,
                         `gmt_modified`  DATETIME    DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='职员表';

INSERT INTO `clerk`
(`id`,`name`,`sex`,`phone_number`,`photo`,`id_card`,`address`,`position`,
 `department_id`,`user_id`,`is_deleted`,`gmt_create`,`gmt_modified`) VALUES
                                                                         ('1638778252236267521','赵睿','1','13912345678',
                                                                          '/files/063cae42f8d74b43b46bcde8ec28c5e4file.png',
                                                                          '110101199001011234','北京市','主管',
                                                                          '1340584045776916482','1638778252097855489',0,
                                                                          '2025-05-21 09:15:12','2025-05-21 10:25:45'),

                                                                         ('1638779582375895042','孙倩','0','15898765432',
                                                                          '/files/44f2d988c637407bb94f70ae12061c95file.png',
                                                                          '310101199203052345','上海市','普通职员',
                                                                          '1340584967022235649','1638779582187151361',0,
                                                                          '2025-05-21 09:30:25','2025-05-21 10:40:15'),

                                                                         ('1638779765465653250','郑涛','1','14711223344',
                                                                          '/files/f3983b8376fe40d9b5b8ac1c8b830b7bfile.png',
                                                                          '500101198811303456','重庆市','总经理',
                                                                          '1340585021044871170','1638779765335629826',0,
                                                                          '2025-05-21 09:45:38','2025-05-21 10:55:22'),

                                                                         ('1638780386969231362','吕佳','0','18922334455',
                                                                          '/files/cc8550c3b13c4a15a13da36222ff7ac2file.png',
                                                                          '460101199506152567','海口市','普通职工',
                                                                          '1340603278481043457','1638780386969231361',0,
                                                                          '2025-05-21 10:00:51','2025-05-21 11:10:30'),

                                                                         ('1638781944314306561','韩梅','0','15966778899',
                                                                          '/files/67879d35362341fa9abfbaef3078c2ccfile.png',
                                                                          '150101199407213678','乌兰察布市','普通职工',
                                                                          '1340585021044871170','1638781944117174273',0,
                                                                          '2025-05-21 10:15:04','2025-05-21 11:25:18');


/* =========================================================
   4.  Clerk-Through
========================================================= */
DROP TABLE IF EXISTS `clerk_through`;
CREATE TABLE `clerk_through` (
                                 `id`            CHAR(19)  NOT NULL,
                                 `clerk_id`      CHAR(19)  NOT NULL,
                                 `position`      VARCHAR(25) DEFAULT NULL,
                                 `department_id` CHAR(19)    DEFAULT NULL,
                                 `is_deleted`    INT         DEFAULT 0,
                                 `gmt_create`    DATETIME    DEFAULT NULL,
                                 `gmt_modified`  DATETIME    DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='员工经历表';

INSERT INTO `clerk_through`
(`id`,`clerk_id`,`position`,`department_id`,`is_deleted`,
 `gmt_create`,`gmt_modified`) VALUES
                                  ('1638778252299182081','1638778252236267521','主管','1340584045776916482',0,
                                   '2025-05-21 09:15:12','2025-05-21 10:25:45'),
                                  ('1638779582375895044','1638779582375895042','普通职员','1340584967022235649',0,
                                   '2025-05-21 09:30:25','2025-05-21 10:40:15'),
                                  ('1638779765465653252','1638779765465653250','总经理','1340585021044871170',0,
                                   '2025-05-21 09:45:38','2025-05-21 10:55:22'),
                                  ('1638780386969231364','1638780386969231362','普通职工','1340603278481043457',0,
                                   '2025-05-21 10:00:51','2025-05-21 11:10:30'),
                                  ('1638781944314306563','1638781944314306561','普通职工','1340585021044871170',0,
                                   '2025-05-21 10:15:04','2025-05-21 11:25:18');


/* =========================================================
   5.  Contract
========================================================= */
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
                            `id`            CHAR(19)  NOT NULL,
                            `name`          VARCHAR(20) DEFAULT NULL,
                            `time`          DATETIME    DEFAULT NULL,
                            `clerk_id`      CHAR(19)    DEFAULT NULL,
                            `is_deleted`    INT         DEFAULT 0,
                            `gmt_create`    DATETIME    DEFAULT NULL,
                            `gmt_modified`  DATETIME    DEFAULT NULL,
                            `timeout`       DATETIME    DEFAULT NULL,
                            `url`           VARCHAR(255)DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='合同表';

INSERT INTO `contract`
(`id`,`name`,`time`,`clerk_id`,`is_deleted`,
 `gmt_create`,`gmt_modified`,`timeout`,`url`) VALUES
    ('1639122704003883009','赵睿劳动合同','2025-04-15 10:30:00',
     '1638778252236267521',0,
     '2025-05-21 14:10:00','2025-05-21 14:25:00',
     '2027-04-15 08:00:00',
     '/files/e4846f83b274452996e1c1fef4e050cefile.png');


/* =========================================================
   6.  Department
========================================================= */
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
                              `id`           CHAR(19)  NOT NULL,
                              `name`         VARCHAR(20) DEFAULT NULL,
                              `note`         VARCHAR(50) DEFAULT NULL,
                              `is_deleted`   INT         DEFAULT 0,
                              `gmt_create`   DATETIME    DEFAULT NULL,
                              `gmt_modified` DATETIME    DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='部门表';

INSERT INTO `department`
(`id`,`name`,`note`,`is_deleted`,`gmt_create`,`gmt_modified`) VALUES
                                                                  ('1340584045776916482','人事部门',NULL,0,'2025-05-21 08:05:10','2025-05-21 08:35:10'),
                                                                  ('1340584967022235649','运营部门',NULL,0,'2025-05-21 08:07:20','2025-05-21 08:37:20'),
                                                                  ('1340585021044871170','市场部', NULL,0,'2025-05-21 08:09:30','2025-05-21 08:39:30'),
                                                                  ('1340603143789359106','后勤部', NULL,1,'2025-05-21 08:11:40','2025-05-21 08:41:40'),
                                                                  ('1340603278481043457','后勤部', NULL,0,'2025-05-21 08:13:50','2025-05-21 08:43:50');


/* =========================================================
   7.  Rewards-Punishments
========================================================= */
DROP TABLE IF EXISTS `rewards_punishments`;
CREATE TABLE `rewards_punishments` (
                                       `id`            CHAR(19)    NOT NULL,
                                       `type`          CHAR(1)      DEFAULT NULL,
                                       `time`          DATETIME     DEFAULT NULL,
                                       `reason`        VARCHAR(50)  DEFAULT NULL,
                                       `amount`        DECIMAL(19,4)DEFAULT NULL,
                                       `note`          VARCHAR(100) DEFAULT NULL,
                                       `clerk_id`      CHAR(19)     DEFAULT NULL,
                                       `is_deleted`    INT          DEFAULT 0,
                                       `gmt_create`    DATETIME     DEFAULT NULL,
                                       `gmt_modified`  DATETIME     DEFAULT NULL,
                                       `department_id` CHAR(19)     DEFAULT NULL,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='奖惩表';

/* ——— 暂无奖惩示例数据 ——— */


/* =========================================================
   8.  Role
========================================================= */
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id`           CHAR(19)  NOT NULL,
                        `userid`       CHAR(19)  DEFAULT NULL,
                        `name`         VARCHAR(20)DEFAULT NULL,
                        `is_deleted`   INT        DEFAULT 0,
                        `gmt_create`   DATETIME   DEFAULT NULL,
                        `gmt_modified` DATETIME   DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='权限表';

INSERT INTO `role`
(`id`,`userid`,`name`,`is_deleted`,`gmt_create`,`gmt_modified`) VALUES
                                                                    ('1','1','管理员',0,'2025-05-21 08:45:00','2025-05-21 09:05:00'),
                                                                    ('1638778252236267522','1638778252097855489','职员',0,'2025-05-21 10:35:00','2025-05-21 10:55:00'),
                                                                    ('1638779582375895043','1638779582187151361','职员',0,'2025-05-21 10:37:00','2025-05-21 10:57:00'),
                                                                    ('1638779765465653251','1638779765335629826','职员',0,'2025-05-21 10:39:00','2025-05-21 10:59:00'),
                                                                    ('1638780386969231363','1638780386969231361','职员',0,'2025-05-21 10:41:00','2025-05-21 11:01:00'),
                                                                    ('1638781944314306562','1638781944117174273','职员',0,'2025-05-21 10:43:00','2025-05-21 11:03:00'),
                                                                    ('1638782217577406465','1638778252097855489','人事经理',0,'2025-05-21 11:05:00','2025-05-21 11:25:00');


/* =========================================================
   9.  User
========================================================= */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id`           CHAR(19)   NOT NULL,
                        `username`     VARCHAR(20)DEFAULT NULL,
                        `password`     VARCHAR(200)DEFAULT NULL,
                        `name`         VARCHAR(20)DEFAULT NULL,
                        `introduction` VARCHAR(255)DEFAULT NULL,
                        `avatar`       VARCHAR(255)DEFAULT NULL,
                        `is_deleted`   INT         DEFAULT 0,
                        `gmt_create`   DATETIME    DEFAULT NULL,
                        `gmt_modified` DATETIME    DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='用户表';

INSERT INTO `user`
(`id`,`username`,`password`,`name`,`introduction`,`avatar`,`is_deleted`,
 `gmt_create`,`gmt_modified`) VALUES
                                  ('1','admin','e10adc3949ba59abbe56e057f20f883e','超级管理员','公司老板',
                                   '/files/5131184693674b5c8ad9e938babf6cd4file.png',0,
                                   '2025-05-21 08:40:00','2025-05-21 08:50:00'),

                                  ('1638778252097855489','13912345678','e10adc3949ba59abbe56e057f20f883e','赵睿',NULL,
                                   '/files/28a5961efa5148ecb9a616c615c98d76file.png',0,
                                   '2025-05-21 09:15:12','2025-05-21 09:45:12'),

                                  ('1638779582187151361','15898765432','e10adc3949ba59abbe56e057f20f883e','孙倩',NULL,
                                   '/files/5131184693674b5c8ad9e938babf6cd4file.png',0,
                                   '2025-05-21 09:30:25','2025-05-21 10:00:25'),

                                  ('1638779765335629826','14711223344','e10adc3949ba59abbe56e057f20f883e','郑涛',NULL,
                                   '/files/5131184693674b5c8ad9e938babf6cd4file.png',0,
                                   '2025-05-21 09:45:38','2025-05-21 10:15:38'),

                                  ('1638780386969231361','18922334455','e10adc3949ba59abbe56e057f20f883e','吕佳',NULL,
                                   '/files/5131184693674b5c8ad9e938babf6cd4file.png',0,
                                   '2025-05-21 10:00:51','2025-05-21 10:30:51'),

                                  ('1638781944117174273','15966778899','e10adc3949ba59abbe56e057f20f883e','韩梅',NULL,
                                   '/files/5131184693674b5c8ad9e938babf6cd4file.png',0,
                                   '2025-05-21 10:15:04','2025-05-21 10:45:04');

SET FOREIGN_KEY_CHECKS = 1;
