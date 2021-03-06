CREATE DATABASE `yidai_blog``yidai_blog`;

USE `yidai_blog`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog`
(
    `id`              BIGINT(20)                                              NOT NULL AUTO_INCREMENT,
    `title`           VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `content`         TEXT CHARACTER SET utf8 COLLATE utf8_general_ci         NULL,
    `first_picture`   VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `flag`            VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `views`           INT(11)                                                 NULL     DEFAULT NULL,
    `appreciation`    INT(11)                                                 NOT NULL DEFAULT 0,
    `share_statement` INT(11)                                                 NOT NULL DEFAULT 0,
    `commentabled`    INT(11)                                                 NOT NULL DEFAULT 0,
    `published`       INT(11)                                                 NOT NULL DEFAULT 0,
    `recommend`       INT(11)                                                 NOT NULL DEFAULT 0,
    `create_time`     DATETIME                                                NULL     DEFAULT NULL,
    `update_time`     DATETIME                                                NULL     DEFAULT NULL,
    `type_id`         BIGINT(20)                                              NULL     DEFAULT NULL,
    `user_id`         BIGINT(20)                                              NULL     DEFAULT NULL,
    `description`     TEXT CHARACTER SET utf8 COLLATE utf8_general_ci         NULL,
    `tag_ids`         VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 12
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- -----------------------------------------
DROP TABLE IF EXISTS `t_blog_tags`;

CREATE TABLE `t_blog_tags`
(
    `id`      INT(11)                                                 NOT NULL AUTO_INCREMENT,
    `tag_id`  BIGINT(20)                                              NULL DEFAULT NULL,
    `blog_id` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 78
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- -----------------------------------------
DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment`
(
    `id`                BIGINT(20)                                              NOT NULL AUTO_INCREMENT,
    `nickname`          VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `email`             VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `content`           VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `avatar`            VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `create_time`       DATETIME                                                NULL DEFAULT NULL,
    `blog_id`           BIGINT(20)                                              NULL DEFAULT NULL,
    `parent_comment_id` BIGINT(20)                                              NULL DEFAULT NULL,
    `admincomment`      INT(11)                                                 NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 9
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- -----------------------------------------
DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag`
(
    `id`   BIGINT(20)                                              NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 9
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- -----------------------------------------
DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type`
(
    `id`   BIGINT(20)                                              NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;


-- -----------------------------------------
DROP TABLE IF EXISTS `t_wallpaper`;

CREATE TABLE `t_wallpaper`
(
    `id` BIGINT(200) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 9
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- -----------------------------------------
DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user`
(
    `id`          BIGINT(20)                                              NOT NULL AUTO_INCREMENT,
    `nickname`    VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `username`    VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
    `password`    VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
    `email`       VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `avatar`      VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL,
    `type`        INT(10)                                                 NULL     DEFAULT NULL,
    `create_time` DATETIME                                                NULL     DEFAULT NULL,
    `update_time` DATETIME                                                NULL     DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;



SET FOREIGN_KEY_CHECKS = 1;