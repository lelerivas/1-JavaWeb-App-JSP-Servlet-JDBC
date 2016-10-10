CREATE TABLE `tbposition` (
  `idposition` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idposition`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbstaff` (
  `idstaff` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `regcod` varchar(15) DEFAULT NULL,
  `maritalst` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `idposition` int(11) NOT NULL,
  PRIMARY KEY (`idstaff`),
  KEY `idposition_idx` (`idposition`),
  CONSTRAINT `idposition` FOREIGN KEY (`idposition`) REFERENCES `tbposition` (`idposition`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;