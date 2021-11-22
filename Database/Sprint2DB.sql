-- MySQL Script generated by MySQL Workbench
-- Thu Nov 18 11:36:19 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cps
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cps
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cps` DEFAULT CHARACTER SET utf8 ;
USE `cps` ;

-- -----------------------------------------------------
-- Table `cps`.`timestamps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`timestamps` (
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `cps`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`user` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP);


-- -----------------------------------------------------
-- Table `cps`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`category` (
  `category_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`));


-- -----------------------------------------------------
-- Table `cps`.`cps_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`cps_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL,
  `blacklisted` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cps`.`owner_preference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`owner_preference` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `music` CHAR(1) NOT NULL,
  `smoking` CHAR(1) NOT NULL,
  `pets_allowed` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cps`.`owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`owner` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(1000) NOT NULL,
  `mobile` VARCHAR(10) NOT NULL,
  `licence_number` VARCHAR(30) NULL,
  `licence_url` VARCHAR(2000) NULL,
  `aadhar_number` VARCHAR(15) NULL,
  `aadhar_url` VARCHAR(2000) NULL,
  `user_id` INT NOT NULL,
  `owner_preference_id` INT NULL,
  `status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `owner_user_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `owner_preference_fk_idx` (`owner_preference_id` ASC) VISIBLE,
  CONSTRAINT `owner_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `cps`.`cps_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `owner_preference_fk`
    FOREIGN KEY (`owner_preference_id`)
    REFERENCES `cps`.`owner_preference` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cps`.`passenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`passenger` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `mobile` VARCHAR(10) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `passenger_user_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `passenger_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `cps`.`cps_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cps`.`trip`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`trip` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `origin` VARCHAR(45) NOT NULL,
  `destination` VARCHAR(45) NOT NULL,
  `departure_time` TIME NOT NULL,
  `price` DOUBLE NOT NULL,
  `date` DATE NOT NULL,
  `owner_id` INT NOT NULL,
  `number_of_passengers` INT NOT NULL,
  `number_of_seats_available` INT NOT NULL,
  `car_type` VARCHAR(45) NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `owner_fk_idx` (`owner_id` ASC) VISIBLE,
  CONSTRAINT `owner_fk`
    FOREIGN KEY (`owner_id`)
    REFERENCES `cps`.`owner` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cps`.`passanger_rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`passanger_rating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` INT NULL,
  `trip_id` INT NULL,
  `passenger_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `passenger_fkk_idx` (`passenger_id` ASC) VISIBLE,
  INDEX `trip_fkk_idx` (`trip_id` ASC) VISIBLE,
  CONSTRAINT `passenger_fkk`
    FOREIGN KEY (`passenger_id`)
    REFERENCES `cps`.`passenger` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `trip_fkk`
    FOREIGN KEY (`trip_id`)
    REFERENCES `cps`.`trip` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cps`.`owner_rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`owner_rating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` INT NULL,
  `passenger_id` INT NULL,
  `owner_id` INT NULL,
  `review` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  INDEX `passenger1_fk_idx` (`passenger_id` ASC) VISIBLE,
  INDEX `owner1_fk_idx` (`owner_id` ASC) VISIBLE,
  CONSTRAINT `passenger1_fk`
    FOREIGN KEY (`passenger_id`)
    REFERENCES `cps`.`passenger` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `owner1_fk`
    FOREIGN KEY (`owner_id`)
    REFERENCES `cps`.`owner` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cps`.`trip_bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cps`.`trip_bookings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trip_id` INT NOT NULL,
  `passenger_id` INT NOT NULL,
  `seats_booked` INT NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `trip_fk_idx` (`trip_id` ASC) VISIBLE,
  INDEX `passenger_fk_idx` (`passenger_id` ASC) VISIBLE,
  CONSTRAINT `trip_fk`
    FOREIGN KEY (`trip_id`)
    REFERENCES `cps`.`trip` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `passenger_fk`
    FOREIGN KEY (`passenger_id`)
    REFERENCES `cps`.`passenger` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;