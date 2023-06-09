-- MySQL Script generated by MySQL Workbench
-- Tue May 16 23:56:11 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema erp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema erp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `erp` DEFAULT CHARACTER SET utf8 ;
USE `erp` ;

-- -----------------------------------------------------
-- Table `erp`.`erpparti`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `erp`.`erpparti` ;

CREATE TABLE IF NOT EXISTS `erp`.`erpparti` (
  `c_idparti` VARCHAR(20) NOT NULL,
  `c_ocupparti` VARCHAR(50) NOT NULL,
  `n_vencparti` DECIMAL(5,2) NULL,
  PRIMARY KEY (`c_idparti`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `erp`.`erpinter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `erp`.`erpinter` ;

CREATE TABLE IF NOT EXISTS `erp`.`erpinter` (
  `c_idparti` VARCHAR(20) NOT NULL,
  `c_senhinter` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`c_idparti`),
  CONSTRAINT `fk_erpinter_erpparti`
    FOREIGN KEY (`c_idparti`)
    REFERENCES `erp`.`erpparti` (`c_idparti`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `erp`.`erpexter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `erp`.`erpexter` ;

CREATE TABLE IF NOT EXISTS `erp`.`erpexter` (
  `c_idparti` VARCHAR(20) NOT NULL,
  `c_statexter` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`c_idparti`),
  CONSTRAINT `fk_erpexter_erpparti`
    FOREIGN KEY (`c_idparti`)
    REFERENCES `erp`.`erpparti` (`c_idparti`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `erp`.`erpfunci`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `erp`.`erpfunci` ;

CREATE TABLE IF NOT EXISTS `erp`.`erpfunci` (
  `c_idparti` VARCHAR(20) NOT NULL,
  `n_cargfunci` INT NOT NULL,
  `n_pausfunci` DECIMAL(1,1) NOT NULL,
  `c_tipofunci` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`c_idparti`),
  CONSTRAINT `fk_erpfunci_erpparti`
    FOREIGN KEY (`c_idparti`)
    REFERENCES `erp`.`erpinter` (`c_idparti`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `erp`.`erptaref`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `erp`.`erptaref` ;

CREATE TABLE IF NOT EXISTS `erp`.`erptaref` (
  `c_idtaref` INT NOT NULL AUTO_INCREMENT,
  `c_idparti` VARCHAR(20) NOT NULL,
  `c_desctaref` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`c_idtaref`),
  INDEX `fk_erptaref_erpfunci_idx` (`c_idparti` ASC) VISIBLE,
  CONSTRAINT `fk_erptaref_erpfunci`
    FOREIGN KEY (`c_idparti`)
    REFERENCES `erp`.`erpparti` (`c_idparti`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
