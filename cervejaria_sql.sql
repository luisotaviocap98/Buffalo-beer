-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cerveja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cerveja` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `indice_alcool` FLOAT NOT NULL,
  `mililitros` INT(11) NOT NULL,
  `preco` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Insumos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Insumos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Unidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Unidades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cerveja_has_Insumos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cerveja_has_Insumos` (
  `quantidade` INT(11) NOT NULL,
  `Cerveja_id` INT(11) NOT NULL,
  `Insumos_id` INT NOT NULL,
  `Unidades_id` INT NOT NULL,
  PRIMARY KEY (`Cerveja_id`, `Insumos_id`, `Unidades_id`),
  INDEX `fk_Cerveja_has_Insumos_Insumos1_idx` (`Insumos_id` ASC),
  INDEX `fk_Cerveja_has_Insumos_Unidades1_idx` (`Unidades_id` ASC),
  CONSTRAINT `fk_Cerveja_has_Insumos_Cerveja`
    FOREIGN KEY (`Cerveja_id`)
    REFERENCES `mydb`.`Cerveja` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cerveja_has_Insumos_Insumos1`
    FOREIGN KEY (`Insumos_id`)
    REFERENCES `mydb`.`Insumos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cerveja_has_Insumos_Unidades1`
    FOREIGN KEY (`Unidades_id`)
    REFERENCES `mydb`.`Unidades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
