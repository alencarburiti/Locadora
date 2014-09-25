# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.20)
# Database: locadora
# Generation Time: 2014-09-25 20:51:21 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ACESSO
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ACESSO`;

CREATE TABLE `ACESSO` (
  `CODIGO_ACESSO` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO_CLIENTE` varchar(45) DEFAULT NULL,
  `TELA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_ACESSO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table CLIENTE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `CLIENTE`;

CREATE TABLE `CLIENTE` (
  `CODIGO_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_CLIENTE` varchar(45) DEFAULT NULL,
  `NOME_EMPRESA_TRABALHO` varchar(45) DEFAULT NULL,
  `PROFISSAO` varchar(45) DEFAULT NULL,
  `CPF` varchar(15) DEFAULT NULL,
  `DATA_NASCIMENTO` date DEFAULT NULL,
  `DATA_CADASTRO` date DEFAULT NULL,
  `ENDERECO` varchar(45) DEFAULT NULL,
  `BAIRRO` varchar(45) DEFAULT NULL,
  `COMPLEMENTO` varchar(30) DEFAULT NULL,
  `CIDADE` varchar(30) DEFAULT NULL,
  `ESTADO` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `LOGIN` varchar(20) DEFAULT NULL,
  `SENHA` varchar(16) DEFAULT NULL,
  `OBSERVACAO` varchar(45) DEFAULT NULL,
  `STATUS` varchar(2) DEFAULT 'A',
  PRIMARY KEY (`CODIGO_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;

INSERT INTO `CLIENTE` (`CODIGO_CLIENTE`, `NOME_CLIENTE`, `NOME_EMPRESA_TRABALHO`, `PROFISSAO`, `CPF`, `DATA_NASCIMENTO`, `DATA_CADASTRO`, `ENDERECO`, `BAIRRO`, `COMPLEMENTO`, `CIDADE`, `ESTADO`, `EMAIL`, `LOGIN`, `SENHA`, `OBSERVACAO`, `STATUS`)
VALUES
	(13,'Alencar Buriti','Hospital Sao Francisco de Assis','Analista de Sistemas Senior','018.823.491.80','1990-03-19',NULL,'Rua Buriti N 10','José Carrilho','QD 55 LT 2/3','Goianésia','GO','alencarburiti@gmail.com',NULL,NULL,'','A'),
	(14,'Eliesio Xavier','Hospital São Francisco de Assis','Analista de Sistemas Senior','018.823.491.80','1990-03-19',NULL,'Rua Buriti N 10','José Carrilho','QD 55 LT 2/3','Goianésia','GO','alencarburiti@gmail.com',NULL,NULL,'','A');

/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table COPIA
# ------------------------------------------------------------

DROP TABLE IF EXISTS `COPIA`;

CREATE TABLE `COPIA` (
  `CODIGO_COPIA` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO_BARRAS` varchar(100) DEFAULT NULL,
  `IDIOMA` varchar(45) DEFAULT NULL,
  `LEGENDA` varchar(45) DEFAULT NULL,
  `DATA_AQUISICAO` date DEFAULT NULL,
  `PRECO_CUSTO` double DEFAULT NULL,
  `CODIGO_OBJETO` int(11) DEFAULT NULL,
  `DEL_FLAG` int(1) DEFAULT '0',
  `DEFECT_FLAG` int(1) DEFAULT '0',
  `NUMERO_COPIA` int(11) DEFAULT '1',
  PRIMARY KEY (`CODIGO_COPIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `COPIA` WRITE;
/*!40000 ALTER TABLE `COPIA` DISABLE KEYS */;

INSERT INTO `COPIA` (`CODIGO_COPIA`, `CODIGO_BARRAS`, `IDIOMA`, `LEGENDA`, `DATA_AQUISICAO`, `PRECO_CUSTO`, `CODIGO_OBJETO`, `DEL_FLAG`, `DEFECT_FLAG`, `NUMERO_COPIA`)
VALUES
	(1,NULL,'Chinês','Chinês','2000-03-19',2,NULL,0,0,1),
	(2,NULL,'Chinês','Chinês','2000-03-19',2,NULL,0,0,1),
	(3,'1','Chinês','Chinês','2000-03-19',2,6,0,0,1),
	(4,NULL,'Chinês','Chinês','2000-03-19',0,6,0,1,1),
	(5,'2345678900987654','Inglês','Inglês','2000-03-19',2,7,0,0,1),
	(6,'2345678900987654','Chinês','Chinês','2000-03-19',0,7,0,0,1),
	(7,'2345678987654324','Chinês','Chinês','2000-03-19',2,8,0,0,1),
	(8,'3210987654567','Chinês','Chinês','2000-03-19',2,9,0,0,1),
	(9,NULL,'Chinês','Chinês','2000-03-19',2,10,0,0,1),
	(10,NULL,'Francês','Espanhol','2000-03-19',0,10,0,0,1),
	(11,'11',NULL,NULL,NULL,NULL,NULL,0,0,1),
	(12,'O12',NULL,NULL,NULL,NULL,NULL,0,0,1),
	(13,NULL,'Chinês','Chinês','2000-03-19',2,12,0,0,1),
	(14,NULL,'Chinês','Chinês','2000-03-19',0,12,0,0,1),
	(15,NULL,'Chinês','Chinês','2000-03-19',2,13,0,0,1),
	(16,'1','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(17,NULL,'Chinês','Espanhol','2000-03-19',0,13,0,0,1),
	(18,'2','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(19,'3','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(20,'4','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(21,'5','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(22,'6','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(23,'7','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(24,'8','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(25,'9','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(26,'10','Chinês','Chinês','2000-03-19',0,13,0,0,1),
	(27,'0','Chinês','Chinês','2000-03-19',2,15,0,0,1),
	(28,'1','Chinês','Chinês','2000-03-19',0,15,0,0,1),
	(29,'2','Chinês','Chinês','2000-03-19',0,15,0,0,1),
	(30,'3','Chinês','Chinês','2000-03-19',0,15,0,0,1),
	(31,'4','Chinês','Chinês','2000-03-19',0,15,0,0,1),
	(32,'5','Chinês','Chinês','2000-03-19',0,15,0,0,1),
	(33,'6','Chinês','Chinês','2000-03-19',0,15,0,0,1),
	(34,'7','Chinês','Chinês','2000-03-19',0,15,0,0,1),
	(35,'1','Chinês','Chinês','2000-03-19',2,16,0,0,1),
	(36,'2','Chinês','Chinês','2000-03-19',0,16,0,0,1),
	(37,'3','Chinês','Chinês','2000-03-19',0,16,0,0,1),
	(38,'4','Chinês','Chinês','2000-03-19',0,16,0,0,1),
	(39,'5','Chinês','Chinês','2000-03-19',0,16,0,0,1),
	(40,'6','Chinês','Chinês','2000-03-19',0,16,0,0,1),
	(41,'7','Chinês','Chinês','2000-03-19',0,16,0,0,1),
	(42,'8','Chinês','Chinês','2000-03-19',0,16,0,0,1),
	(43,'9','Chinês','Chinês','2000-03-19',0,16,0,0,1),
	(44,'1','Chinês','Chinês','2000-03-19',2,18,0,0,1),
	(45,'1','Chinês','Chinês','2000-03-19',2,19,0,0,1),
	(46,'2','Chinês','Chinês','2000-03-19',0,19,0,0,1),
	(47,'3','Chinês','Chinês','2000-03-19',0,19,0,0,1),
	(48,'4','Chinês','Chinês','2000-03-19',0,19,0,0,1),
	(49,'5','Chinês','Chinês','2000-03-19',0,19,0,0,1),
	(50,'1','Chinês','Chinês','2000-03-19',2,20,0,0,1),
	(51,'2','Chinês','Chinês','2000-03-19',0,20,0,0,1),
	(52,'1','Chinês','Chinês','2000-03-19',2,21,0,0,1),
	(53,'2','Chinês','Chinês','2000-03-19',0,21,0,0,1),
	(54,'3','Chinês','Chinês','2000-03-19',0,21,0,0,1),
	(55,'4','Chinês','Chinês','2000-03-19',0,21,0,0,1),
	(56,'5','Chinês','Chinês','2000-03-19',0,21,0,0,1),
	(57,'22-1','Chinês','Chinês','2000-03-19',2,22,0,0,1),
	(58,'24-1','Chinês','Chinês','2000-03-19',2,24,0,0,1),
	(59,'24-2','Chinês','Chinês','2000-03-19',0,24,0,0,2),
	(60,'24-3','Chinês','Chinês','2000-03-19',0,24,0,0,3),
	(61,'24-4','Chinês','Chinês','2000-03-19',0,24,0,0,4),
	(62,'24-5','Chinês','Chinês','2000-03-19',0,24,0,0,5),
	(63,'24-6','Chinês','Chinês','2000-03-19',0,24,0,0,6),
	(64,'24-7','Chinês','Chinês','2000-03-19',0,24,0,0,7),
	(65,'24-8','Chinês','Chinês','2000-03-19',0,24,0,0,8),
	(66,'24-9','Chinês','Chinês','2000-03-19',0,24,0,0,9),
	(67,'24-10','Chinês','Chinês','2000-03-19',9,24,0,0,10),
	(68,'25-1','Chinês','Chinês','2000-03-19',2,25,0,0,1),
	(69,'26-1','Chinês','Chinês','2000-03-19',2,26,0,0,1),
	(70,'27-1','Chinês','Chinês','2000-03-19',2,27,0,0,1),
	(71,'28-1','Chinês','Chinês','2000-03-19',2,28,0,0,1),
	(72,'28-2','Chinês','Chinês','2000-03-19',0,28,0,0,2),
	(73,'28-3','Chinês','Chinês','2000-03-19',0,28,0,0,3),
	(74,'28-4','Chinês','Chinês','2000-03-19',0,28,0,0,4),
	(75,'28-5','Chinês','Chinês','2000-03-19',0,28,0,0,5),
	(76,'28-6','Chinês','Chinês','2000-03-19',0,28,0,0,6),
	(77,'28-7','Chinês','Chinês','2000-03-19',0,28,0,0,7),
	(78,'28-8','Chinês','Chinês','2000-03-19',0,28,0,0,8),
	(79,'28-9','Chinês','Chinês','2000-03-19',0,28,0,0,9),
	(80,'28-10','Chinês','Chinês','2000-03-19',0,28,0,0,10),
	(81,'28-11','Chinês','Chinês','2000-03-19',0,28,0,0,11),
	(82,'28-12','Chinês','Chinês','2000-03-19',0,28,0,0,12),
	(83,'28-13','Chinês','Chinês','2000-03-19',0,28,0,0,13),
	(84,'28-14','Chinês','Chinês','2000-03-19',0,28,0,0,14),
	(85,'28-15','Chinês','Chinês','2000-03-19',0,28,0,0,15),
	(86,'28-16','Chinês','Chinês','2000-03-19',0,28,0,0,16),
	(87,'28-17','Chinês','Chinês','2000-03-19',0,28,0,0,17);

/*!40000 ALTER TABLE `COPIA` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table DEPENDENTE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `DEPENDENTE`;

CREATE TABLE `DEPENDENTE` (
  `CODIGO_DEPENDENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_DEPENDENTE` varchar(50) DEFAULT NULL,
  `CODIGO_CLIENTE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_DEPENDENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `DEPENDENTE` WRITE;
/*!40000 ALTER TABLE `DEPENDENTE` DISABLE KEYS */;

INSERT INTO `DEPENDENTE` (`CODIGO_DEPENDENTE`, `NOME_DEPENDENTE`, `CODIGO_CLIENTE`)
VALUES
	(6,'Erica Pereira Buriti de Barros','5'),
	(7,'432141324312fds','5'),
	(8,'Erica Pereira Buriti de Barros','7'),
	(9,'Erica Pereira Buriti de Barros','9'),
	(10,'Erica Pereira Buriti de Barros','12'),
	(11,'Erica Pereira Buriti de Barros','13'),
	(12,'Erica Pereira Buriti de Barros','14'),
	(13,'Sandra Xavier','14');

/*!40000 ALTER TABLE `DEPENDENTE` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table DIARIA
# ------------------------------------------------------------

DROP TABLE IF EXISTS `DIARIA`;

CREATE TABLE `DIARIA` (
  `CODIGO_DIARIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_DIARIA` varchar(45) DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  `VALOR_PROMOCAO` double DEFAULT NULL,
  `DIAS` int(11) DEFAULT NULL,
  `MULTAS` double DEFAULT NULL,
  PRIMARY KEY (`CODIGO_DIARIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `DIARIA` WRITE;
/*!40000 ALTER TABLE `DIARIA` DISABLE KEYS */;

INSERT INTO `DIARIA` (`CODIGO_DIARIA`, `NOME_DIARIA`, `VALOR`, `VALOR_PROMOCAO`, `DIAS`, `MULTAS`)
VALUES
	(1,'LANÇAMENTO',3,2,1,0.5),
	(2,'Catálogo',5,4,1,1),
	(3,'Testando',3,2.5,1,0.5);

/*!40000 ALTER TABLE `DIARIA` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table FORNECEDOR
# ------------------------------------------------------------

DROP TABLE IF EXISTS `FORNECEDOR`;

CREATE TABLE `FORNECEDOR` (
  `idfornecedor` int(10) NOT NULL AUTO_INCREMENT,
  `razaoSocial` varchar(70) DEFAULT NULL,
  `nomeFantasia` varchar(70) DEFAULT NULL,
  `cnpj` varchar(18) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `fax` varchar(14) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `inscricaoEstadual` varchar(20) DEFAULT NULL,
  `inscricaoMunicipal` varchar(20) DEFAULT NULL,
  `nomeVendedor` varchar(50) DEFAULT NULL,
  `telefoneVendedor` varchar(14) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `cidade` varchar(25) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idfornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `FORNECEDOR` WRITE;
/*!40000 ALTER TABLE `FORNECEDOR` DISABLE KEYS */;

INSERT INTO `FORNECEDOR` (`idfornecedor`, `razaoSocial`, `nomeFantasia`, `cnpj`, `telefone`, `fax`, `endereco`, `inscricaoEstadual`, `inscricaoMunicipal`, `nomeVendedor`, `telefoneVendedor`, `cep`, `cidade`, `estado`)
VALUES
	(1,'BROADWAY','BROADWAY','02.836.799/0001.86','(62)3335-3456','(54)6545-6456','RUA','546.546.546.','165.465.465.','TESTANDO','(62)3353-2201','76.380-000','GOIANESIA','GO');

/*!40000 ALTER TABLE `FORNECEDOR` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table GENERO
# ------------------------------------------------------------

DROP TABLE IF EXISTS `GENERO`;

CREATE TABLE `GENERO` (
  `CODIGO_GENERO` int(10) NOT NULL AUTO_INCREMENT,
  `NOME_GENERO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_GENERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `GENERO` WRITE;
/*!40000 ALTER TABLE `GENERO` DISABLE KEYS */;

INSERT INTO `GENERO` (`CODIGO_GENERO`, `NOME_GENERO`)
VALUES
	(1,'COMEDIA'),
	(2,'AVENTURA'),
	(3,'DANÇA'),
	(4,'DOCUMENTÁRIOS'),
	(5,'AMOSTRA GRATIS'),
	(6,'Teste'),
	(7,'Testata'),
	(8,'Outros');

/*!40000 ALTER TABLE `GENERO` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ITEM_LOCACAO
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ITEM_LOCACAO`;

CREATE TABLE `ITEM_LOCACAO` (
  `CODIGO_ITEM_LOCACAO` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO_COPIA` int(11) DEFAULT NULL,
  `CODIGO_LOCACAO` int(11) DEFAULT NULL,
  `DATA_LOCACAO` date DEFAULT NULL,
  `DATA_DEVOLUCAO` timestamp NULL DEFAULT NULL,
  `DEL_FLAG` int(2) DEFAULT '0',
  PRIMARY KEY (`CODIGO_ITEM_LOCACAO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `ITEM_LOCACAO` WRITE;
/*!40000 ALTER TABLE `ITEM_LOCACAO` DISABLE KEYS */;

INSERT INTO `ITEM_LOCACAO` (`CODIGO_ITEM_LOCACAO`, `CODIGO_COPIA`, `CODIGO_LOCACAO`, `DATA_LOCACAO`, `DATA_DEVOLUCAO`, `DEL_FLAG`)
VALUES
	(1,3,NULL,NULL,NULL,0),
	(2,3,NULL,NULL,NULL,0),
	(3,3,NULL,NULL,NULL,0),
	(4,3,3,NULL,NULL,0),
	(5,3,3,NULL,NULL,0),
	(6,3,3,NULL,NULL,0),
	(7,3,3,NULL,NULL,0),
	(8,3,3,NULL,NULL,0),
	(9,3,3,NULL,'2014-09-14 19:14:56',1),
	(10,3,3,NULL,NULL,0),
	(11,3,3,NULL,NULL,0),
	(12,3,3,'2014-09-15',NULL,0),
	(13,3,4,'2014-04-18',NULL,0),
	(14,2,2,'2014-09-23',NULL,0),
	(15,8,13,'2014-09-23',NULL,0),
	(16,87,14,'2014-09-24','2014-09-24 20:14:37',1),
	(17,86,17,'2014-09-24','2014-09-25 11:39:48',1),
	(18,87,17,'2014-09-24',NULL,0),
	(19,85,18,'2014-09-25',NULL,0),
	(20,83,19,'2014-09-25',NULL,0),
	(21,82,19,'2014-09-25',NULL,0),
	(22,82,20,'2014-09-25',NULL,0),
	(23,87,22,'2014-09-25',NULL,0),
	(24,86,23,'2014-09-25',NULL,0),
	(25,87,24,'2014-09-25',NULL,0);

/*!40000 ALTER TABLE `ITEM_LOCACAO` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table LOCACAO
# ------------------------------------------------------------

DROP TABLE IF EXISTS `LOCACAO`;

CREATE TABLE `LOCACAO` (
  `CODIGO_LOCACAO` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO_CLIENTE` int(11) DEFAULT NULL,
  `DEL_FLAG` int(2) DEFAULT '0',
  PRIMARY KEY (`CODIGO_LOCACAO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `LOCACAO` WRITE;
/*!40000 ALTER TABLE `LOCACAO` DISABLE KEYS */;

INSERT INTO `LOCACAO` (`CODIGO_LOCACAO`, `CODIGO_CLIENTE`, `DEL_FLAG`)
VALUES
	(1,8,0),
	(2,7,0),
	(3,8,0),
	(4,11,0),
	(5,10,0),
	(6,11,0),
	(7,11,0),
	(8,11,0),
	(9,11,0),
	(10,11,0),
	(11,11,0),
	(12,12,0),
	(13,11,0),
	(14,14,0),
	(15,14,0),
	(16,14,0),
	(17,14,0),
	(18,14,0),
	(19,14,0),
	(20,14,0),
	(21,14,0),
	(22,14,0),
	(23,14,0),
	(24,13,0);

/*!40000 ALTER TABLE `LOCACAO` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table OBJETO
# ------------------------------------------------------------

DROP TABLE IF EXISTS `OBJETO`;

CREATE TABLE `OBJETO` (
  `CODIGO_OBJETO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO_OBJETO` varchar(45) DEFAULT NULL,
  `TITULO_ORIGINAL` varchar(45) DEFAULT NULL,
  `DESCRICAO_RESUMIDA` varchar(45) DEFAULT NULL,
  `TIPO_MOVIMENTO` varchar(45) DEFAULT NULL,
  `PRODUCAO` varchar(45) DEFAULT NULL,
  `DURACAO` varchar(45) DEFAULT NULL,
  `MIDIA` varchar(45) DEFAULT NULL,
  `TIPO_MIDIA` varchar(45) DEFAULT NULL,
  `CODIGO_DIARIA` int(11) DEFAULT NULL,
  `CODIGO_GENERO` int(11) DEFAULT NULL,
  `ELENCO` varchar(45) DEFAULT NULL,
  `SINOPSE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_OBJETO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `OBJETO` WRITE;
/*!40000 ALTER TABLE `OBJETO` DISABLE KEYS */;

INSERT INTO `OBJETO` (`CODIGO_OBJETO`, `DESCRICAO_OBJETO`, `TITULO_ORIGINAL`, `DESCRICAO_RESUMIDA`, `TIPO_MOVIMENTO`, `PRODUCAO`, `DURACAO`, `MIDIA`, `TIPO_MIDIA`, `CODIGO_DIARIA`, `CODIGO_GENERO`, `ELENCO`, `SINOPSE`)
VALUES
	(1,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,1,'Eliesio Xavier',NULL),
	(2,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,1,NULL,NULL),
	(3,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,3,NULL,NULL),
	(4,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,3,NULL,NULL),
	(5,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,2,NULL,NULL),
	(6,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,3,NULL,NULL),
	(7,'A salvação','A salvacao','A salvação','Locação','Italiana','90min','Playstation','Game',2,1,NULL,NULL),
	(8,'A Salvacao 2','A Salvacao 2','A Salvacao 2','Locação','Americana','90min','Blu Ray','Filme',1,3,NULL,NULL),
	(9,'Testando 2','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,2,NULL,NULL),
	(10,'A traças 2','A tracas 2','A traças 2','Locação','Espanhola','90min','Blu Ray','Filme',1,2,NULL,NULL),
	(11,'Aruqle 2341vbn','Aruqle 2341vbn','Aruqle 2341vbn','Locação','Americana','90min','Blu Ray','Filme',1,2,NULL,NULL),
	(12,'fdsafdsa','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',3,1,NULL,NULL),
	(13,'dfadsfdas','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,2,NULL,NULL),
	(14,'1234567890','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,2,NULL,NULL),
	(15,'dfgcbdhsjnakml','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',3,3,NULL,NULL),
	(16,'231','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,4,NULL,NULL),
	(17,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,4,NULL,NULL),
	(18,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,5,NULL,NULL),
	(19,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,3,NULL,NULL),
	(20,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,1,NULL,NULL),
	(21,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,3,NULL,NULL),
	(22,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',2,5,NULL,NULL),
	(23,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',3,1,NULL,NULL),
	(24,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,2,NULL,NULL),
	(25,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,1,NULL,NULL),
	(26,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,3,NULL,NULL),
	(27,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,2,NULL,NULL),
	(28,'Mulher Infernal','Evil Woman','Mulher Infernal','Locação','Americana','90min','Blu Ray','Filme',1,2,NULL,NULL);

/*!40000 ALTER TABLE `OBJETO` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table TELEFONE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `TELEFONE`;

CREATE TABLE `TELEFONE` (
  `CODIGO_TELEFONE` int(11) NOT NULL AUTO_INCREMENT,
  `TELEFONE` varchar(50) DEFAULT NULL,
  `CODIGO_CLIENTE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_TELEFONE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `TELEFONE` WRITE;
/*!40000 ALTER TABLE `TELEFONE` DISABLE KEYS */;

INSERT INTO `TELEFONE` (`CODIGO_TELEFONE`, `TELEFONE`, `CODIGO_CLIENTE`)
VALUES
	(6,'(62)8100-0456','5'),
	(7,'43214321','5'),
	(8,'(62)8100-0456','7'),
	(9,'(62)8100-0456','9'),
	(10,'(62)8100-0456','12'),
	(11,'(62)8100-0456','13'),
	(12,'(62)8100-0456','14'),
	(13,'3245','14');

/*!40000 ALTER TABLE `TELEFONE` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table TIPO_OBJETO
# ------------------------------------------------------------

DROP TABLE IF EXISTS `TIPO_OBJETO`;

CREATE TABLE `TIPO_OBJETO` (
  `CODIGO_TIPO_OBJETO` int(11) NOT NULL,
  `NOME_TIPO_OBJETO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_TIPO_OBJETO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table USUARIO
# ------------------------------------------------------------

DROP TABLE IF EXISTS `USUARIO`;

CREATE TABLE `USUARIO` (
  `CODIGO_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_USUARIO` varchar(50) DEFAULT NULL,
  `LOGIN` varchar(20) DEFAULT NULL,
  `SENHA` varchar(10) DEFAULT NULL,
  `TIPO_USUARIO` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;

INSERT INTO `USUARIO` (`CODIGO_USUARIO`, `NOME_USUARIO`, `LOGIN`, `SENHA`, `TIPO_USUARIO`)
VALUES
	(3,'ADMINISTRADOR','ADMIN','','administrador'),
	(4,'FERNANDA','FERNANDA','FERNADNA','administrador'),
	(5,'ENFERMAGEM','POSTO','POSTO','usuario');

/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
