CREATE TABLE `cadastrofuncionarioscoti`.`tbstaff` (
  `idstaff` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `regcod` VARCHAR(15) NULL,
  `maritalst` VARCHAR(10) NULL,
  `gender` VARCHAR(10) NULL,
  `salary` DECIMAL(8,2) NULL,
  PRIMARY KEY (`idstaff`));