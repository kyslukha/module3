-- MySQL Script generated by MySQL Workbench
-- Tue Mar 30 21:20:49 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema modul3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema modul3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `modul3` DEFAULT CHARACTER SET utf8 ;
USE `modul3` ;

-- -----------------------------------------------------
-- Table `modul3`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `modul3`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `fullName` VARCHAR(100) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL COMMENT 'must have\"@\"',
  `age` INT NOT NULL COMMENT '>18',
  `isAuthor` TINYINT NULL,
  `isModerator` TINYINT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `modul3`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `modul3`.`post` (
  `idpost` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `author` INT NOT NULL DEFAULT 0,
  `moderator` INT NOT NULL,
  `rating` INT NULL DEFAULT 0,
  `post_status` ENUM('DRAFT', 'IN_PROGRESS', 'WORKSHEET', 'PUBLISHED') NULL DEFAULT 'DRAFT',
  PRIMARY KEY (`idpost`),
  UNIQUE INDEX `idpost_UNIQUE` (`idpost` ASC) VISIBLE,
  INDEX `iduser_idx` (`author` ASC) VISIBLE,
  INDEX `iduser_idx1` (`moderator` ASC) VISIBLE,
  CONSTRAINT `author`
    FOREIGN KEY (`author`)
    REFERENCES `modul3`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `moderator`
    FOREIGN KEY (`moderator`)
    REFERENCES `modul3`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `modul3`.`rating`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `modul3`.`rating` (
  `rating` INT NOT NULL DEFAULT 0,
  `votes` INT NOT NULL DEFAULT 0,
  `idrating` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idrating`),
  UNIQUE INDEX `idpost_UNIQUE` (`idrating` ASC) VISIBLE,
  CONSTRAINT `rating_fk`
    FOREIGN KEY (`idrating`)
    REFERENCES `modul3`.`post` (`idpost`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `modul3`.`followers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `modul3`.`followers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `youreadme` INT NOT NULL,
  PRIMARY KEY (`id`, `youreadme`),
  INDEX `youreadme_idx` (`youreadme` ASC) VISIBLE,
  CONSTRAINT `id_fk`
    FOREIGN KEY (`id`)
    REFERENCES `modul3`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `youreadme`
    FOREIGN KEY (`youreadme`)
    REFERENCES `modul3`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;