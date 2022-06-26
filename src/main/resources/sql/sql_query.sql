-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cat_community
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cat_community
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cat_community` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cat_community` ;

-- -----------------------------------------------------
-- Table `cat_community`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cat_community`.`user` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `full_name` VARCHAR(100) NOT NULL,
  `location` VARCHAR(50) NOT NULL,
  `access_token` VARCHAR(45) NULL DEFAULT NULL,
  `user_intro` VARCHAR(250) NULL DEFAULT NULL,
  `authority_code` VARCHAR(15) NOT NULL,
  `status` VARCHAR(15) NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cat_community`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cat_community`.`post` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` TEXT NOT NULL,
  `authority_code` VARCHAR(15) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `modified_at` DATETIME NULL DEFAULT NULL,
  `status` VARCHAR(15) NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_post_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_post_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `cat_community`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cat_community`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cat_community`.`address` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(30) NOT NULL,
  `location_detail` VARCHAR(100) NULL DEFAULT NULL,
  `authority_code` VARCHAR(15) NOT NULL,
  `post_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_post1_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `address_ibfk_1`
    FOREIGN KEY (`post_id`)
    REFERENCES `cat_community`.`post` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cat_community`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cat_community`.`comment` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(500) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `status` VARCHAR(15) NOT NULL,
  `post_id` BIGINT UNSIGNED NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL,
  `comment_parent` BIGINT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_post1_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_comment_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_comment_comment1_idx` (`comment_parent` ASC) VISIBLE,
  CONSTRAINT `fk_comment_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `cat_community`.`post` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `cat_community`.`user` (`id`),
  CONSTRAINT `fk_comment_comment1`
    FOREIGN KEY (`comment_parent`)
    REFERENCES `cat_community`.`comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cat_community`.`like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cat_community`.`like` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(10) NOT NULL,
  `status` VARCHAR(15) NOT NULL,
  `type_id` BIGINT NOT NULL,
  `user_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_like_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_like_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `cat_community`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cat_community`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cat_community`.`tag` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `tag_name` VARCHAR(30) NOT NULL,
  `post_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tag_post1_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `tag_ibfk_1`
    FOREIGN KEY (`post_id`)
    REFERENCES `cat_community`.`post` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
