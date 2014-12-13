CREATE DATABASE  IF NOT EXISTS `locadora` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `locadora`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: locadora
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ACESSO`
--

DROP TABLE IF EXISTS `ACESSO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACESSO` (
  `CODIGO_ACESSO` int(11) NOT NULL AUTO_INCREMENT,
  `ACTION` varchar(45) DEFAULT NULL,
  `LER` int(2) DEFAULT '1',
  `ESCREVER` int(2) DEFAULT '1',
  `DELETAR` int(2) DEFAULT '1',
  `SUPER_USUARIO` int(11) DEFAULT '1',
  `USUARIO_CODIGO_USUARIO` int(11) NOT NULL,
  `INTERFACE_CODIGO_INTERFACE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_ACESSO`),
  KEY `fk_ACESSO_USUARIO1_idx` (`USUARIO_CODIGO_USUARIO`),
  CONSTRAINT `fk_ACESSO_USUARIO1` FOREIGN KEY (`USUARIO_CODIGO_USUARIO`) REFERENCES `usuario` (`CODIGO_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACESSO`
--

LOCK TABLES `ACESSO` WRITE;
/*!40000 ALTER TABLE `ACESSO` DISABLE KEYS */;
INSERT INTO `ACESSO` VALUES (1,NULL,0,0,0,0,3,13),(2,NULL,0,0,0,0,3,11),(3,NULL,0,0,0,0,3,1),(4,NULL,0,0,0,0,3,2),(5,NULL,0,0,0,0,3,3),(6,NULL,0,0,0,0,3,4),(7,NULL,0,0,0,0,3,5),(8,NULL,0,0,0,0,3,6),(9,NULL,0,0,0,0,3,7),(10,NULL,0,0,0,0,3,8),(11,NULL,0,0,0,0,3,9),(12,NULL,0,0,0,0,3,10),(13,NULL,0,0,0,0,3,12),(14,NULL,0,0,0,0,3,14),(15,NULL,0,0,0,0,3,15);
/*!40000 ALTER TABLE `ACESSO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAIXA`
--

DROP TABLE IF EXISTS `CAIXA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAIXA` (
  `CODIGO_CAIXA` int(11) NOT NULL AUTO_INCREMENT,
  `IP` varchar(45) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `NUMERO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_CAIXA`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAIXA`
--

LOCK TABLES `CAIXA` WRITE;
/*!40000 ALTER TABLE `CAIXA` DISABLE KEYS */;
INSERT INTO `CAIXA` VALUES (1,NULL,NULL,NULL),(2,NULL,NULL,NULL),(3,NULL,NULL,NULL),(4,NULL,NULL,NULL),(5,NULL,NULL,NULL),(6,NULL,NULL,NULL),(7,NULL,NULL,NULL),(8,NULL,NULL,NULL),(9,NULL,NULL,NULL),(10,NULL,NULL,NULL),(11,'127.0.0.1','Null',1),(12,'127.0.0.1','Null',1);
/*!40000 ALTER TABLE `CAIXA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `DEL_FLAG` int(2) DEFAULT '0',
  PRIMARY KEY (`CODIGO_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
INSERT INTO `CLIENTE` VALUES (3,'Alencar Santos Buriti Junior','Freenlancer','Analista de Sistemas','018.823.491-80','1990-03-19',NULL,'Avenidade Cecilia Simoes','Balneário','Qd 55 Lt 2/3 Ap 3','Goiânia','GO','alencarburiti@gmail.com',NULL,NULL,'',0);
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COPIA`
--

DROP TABLE IF EXISTS `COPIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COPIA` (
  `CODIGO_COPIA` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO_BARRAS` varchar(100) DEFAULT NULL,
  `IDIOMA` varchar(45) DEFAULT NULL,
  `LEGENDA` varchar(45) DEFAULT NULL,
  `DATA_AQUISICAO` date DEFAULT NULL,
  `PRECO_CUSTO` double DEFAULT NULL,
  `OBJETO_CODIGO_OBJETO` int(11) NOT NULL,
  `NUMERO_COPIA` int(11) DEFAULT '1',
  `DEL_FLAG` int(1) DEFAULT '0',
  `DEFECT_FLAG` int(1) DEFAULT '0',
  PRIMARY KEY (`CODIGO_COPIA`),
  KEY `fk_COPIA_OBJETO_idx` (`OBJETO_CODIGO_OBJETO`),
  CONSTRAINT `fk_COPIA_OBJETO` FOREIGN KEY (`OBJETO_CODIGO_OBJETO`) REFERENCES `objeto` (`CODIGO_OBJETO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COPIA`
--

LOCK TABLES `COPIA` WRITE;
/*!40000 ALTER TABLE `COPIA` DISABLE KEYS */;
INSERT INTO `COPIA` VALUES (15,'3-1','Português','Português','2001-02-01',10,3,1,0,0),(16,'3-2','Chinês','Chinês','2001-01-01',10,3,2,0,0),(17,'3-3','Chinês','Chinês','2001-01-01',10,3,3,0,0),(18,'3-4','Chinês','Chinês','2001-01-01',0,3,4,0,0),(19,'3-5','Chinês','Chinês','2001-01-01',10,3,5,0,0),(20,'4-1','Chinês','Chinês','2001-01-01',0,4,1,0,0),(21,'4-2','Chinês','Chinês','2001-01-01',10,4,2,0,0);
/*!40000 ALTER TABLE `COPIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DEPENDENTE`
--

DROP TABLE IF EXISTS `DEPENDENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DEPENDENTE` (
  `CODIGO_DEPENDENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_DEPENDENTE` varchar(50) DEFAULT NULL,
  `TIPO_DEPENDENTE` int(11) DEFAULT '0',
  `PARENTESCO` varchar(45) DEFAULT NULL,
  `CPF` varchar(14) DEFAULT NULL,
  `DATA_NASCIMENTO` date DEFAULT NULL,
  `DEL_FLAG` int(2) DEFAULT '0',
  `CLIENTE_CODIGO_CLIENTE` int(11) NOT NULL,
  `TELEFONE` varchar(45) DEFAULT NULL,
  `usuario_CODIGO_USUARIO` int(11) NOT NULL,
  PRIMARY KEY (`CODIGO_DEPENDENTE`),
  KEY `fk_DEPENDENTE_CLIENTE1_idx` (`CLIENTE_CODIGO_CLIENTE`),
  KEY `fk_dependente_usuario1_idx` (`usuario_CODIGO_USUARIO`),
  CONSTRAINT `fk_DEPENDENTE_CLIENTE1` FOREIGN KEY (`CLIENTE_CODIGO_CLIENTE`) REFERENCES `cliente` (`CODIGO_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dependente_usuario1` FOREIGN KEY (`usuario_CODIGO_USUARIO`) REFERENCES `usuario` (`CODIGO_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEPENDENTE`
--

LOCK TABLES `DEPENDENTE` WRITE;
/*!40000 ALTER TABLE `DEPENDENTE` DISABLE KEYS */;
INSERT INTO `DEPENDENTE` VALUES (1,'Alencar Santos Buriti Junior',0,NULL,NULL,'1990-03-19',0,3,NULL,3),(2,'Aliny Cristhyna Silva Souza',1,'Esposa','','1997-07-24',0,3,'(62) 8200-7398',3),(3,'Erica',1,'Outro','653.829.823-09','1990-03-19',0,3,'(89) 0898-0809',3),(4,'Erica',1,'Irmã','243.384.423-10','1990-02-19',0,3,'(78) 9798-7897',3);
/*!40000 ALTER TABLE `DEPENDENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DIARIA`
--

DROP TABLE IF EXISTS `DIARIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DIARIA` (
  `CODIGO_DIARIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_DIARIA` varchar(45) DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  `DIAS` int(11) DEFAULT NULL,
  `MULTAS` double DEFAULT NULL,
  `MAXIMO_DIAS` int(11) DEFAULT NULL,
  `ACUMULATIVO` int(11) DEFAULT '0',
  PRIMARY KEY (`CODIGO_DIARIA`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DIARIA`
--

LOCK TABLES `DIARIA` WRITE;
/*!40000 ALTER TABLE `DIARIA` DISABLE KEYS */;
INSERT INTO `DIARIA` VALUES (3,'Catalogo DVD',2,1,2,8,0),(4,'Catalogo BluRay',3,1,3,8,0),(5,'Super Lancamento DVD',5,1,5,1,1),(6,'Super Lancamento BluRay',6,1,6,1,1),(7,'Lancamento DVD',4,1,4,1,1),(8,'Lancamento BluRay',5,1,5,1,1);
/*!40000 ALTER TABLE `DIARIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FORNECEDOR`
--

DROP TABLE IF EXISTS `FORNECEDOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FORNECEDOR`
--

LOCK TABLES `FORNECEDOR` WRITE;
/*!40000 ALTER TABLE `FORNECEDOR` DISABLE KEYS */;
INSERT INTO `FORNECEDOR` VALUES (1,'BROADWAY','BROADWAY','02.836.799/0001.86','(62)3335-3456','(54)6545-6456','RUA','546.546.546.','165.465.465.','TESTANDO','(62)3353-2201','76.380-000','GOIANESIA','GO');
/*!40000 ALTER TABLE `FORNECEDOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ITEM_LOCACAO`
--

DROP TABLE IF EXISTS `ITEM_LOCACAO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ITEM_LOCACAO` (
  `CODIGO_ITEM_LOCACAO` int(11) NOT NULL AUTO_INCREMENT,
  `DATA_LOCACAO` datetime DEFAULT NULL,
  `DATA_PREVISTA` date DEFAULT NULL,
  `DATA_DEVOLUCAO` timestamp NULL DEFAULT NULL,
  `DEL_FLAG` int(2) DEFAULT '0',
  `VALOR_LOCADO` double DEFAULT '0',
  `VALOR_PAGO` double DEFAULT '0',
  `LOCACAO_CODIGO_LOCACAO` int(11) NOT NULL,
  `COPIA_CODIGO_COPIA` int(11) NOT NULL,
  `DIAS_RELOCACAO` int(11) DEFAULT '0',
  `VALOR_RELOCACAO` double DEFAULT '0',
  PRIMARY KEY (`CODIGO_ITEM_LOCACAO`),
  KEY `fk_ITEM_LOCACAO_LOCACAO1_idx` (`LOCACAO_CODIGO_LOCACAO`),
  KEY `fk_ITEM_LOCACAO_COPIA1_idx` (`COPIA_CODIGO_COPIA`),
  CONSTRAINT `fk_ITEM_LOCACAO_COPIA1` FOREIGN KEY (`COPIA_CODIGO_COPIA`) REFERENCES `copia` (`CODIGO_COPIA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ITEM_LOCACAO_LOCACAO1` FOREIGN KEY (`LOCACAO_CODIGO_LOCACAO`) REFERENCES `locacao` (`CODIGO_LOCACAO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITEM_LOCACAO`
--

LOCK TABLES `ITEM_LOCACAO` WRITE;
/*!40000 ALTER TABLE `ITEM_LOCACAO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ITEM_LOCACAO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOCACAO`
--

DROP TABLE IF EXISTS `LOCACAO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOCACAO` (
  `CODIGO_LOCACAO` int(11) NOT NULL AUTO_INCREMENT,
  `DEL_FLAG` int(2) DEFAULT '0',
  `DEPENDENTE_CODIGO_DEPENDENTE` int(11) NOT NULL,
  `USUARIO_CODIGO_USUARIO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_LOCACAO`),
  KEY `fk_LOCACAO_DEPENDENTE1_idx` (`DEPENDENTE_CODIGO_DEPENDENTE`),
  KEY `fk_LOCACAO_DEPENDENTE1_idx1` (`DEPENDENTE_CODIGO_DEPENDENTE`,`USUARIO_CODIGO_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOCACAO`
--

LOCK TABLES `LOCACAO` WRITE;
/*!40000 ALTER TABLE `LOCACAO` DISABLE KEYS */;
INSERT INTO `LOCACAO` VALUES (1,0,1,3),(2,0,1,3),(3,0,1,3),(4,0,2,3),(5,0,2,3),(6,0,1,3),(7,0,2,3),(8,0,2,3),(9,0,2,3),(10,0,2,3),(11,0,1,3),(12,0,1,3);
/*!40000 ALTER TABLE `LOCACAO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TELEFONE`
--

DROP TABLE IF EXISTS `TELEFONE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TELEFONE` (
  `CODIGO_TELEFONE` int(11) NOT NULL AUTO_INCREMENT,
  `TELEFONE` varchar(50) DEFAULT NULL,
  `CLIENTE_CODIGO_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`CODIGO_TELEFONE`),
  KEY `fk_TELEFONE_CLIENTE1_idx` (`CLIENTE_CODIGO_CLIENTE`),
  CONSTRAINT `fk_TELEFONE_CLIENTE1` FOREIGN KEY (`CLIENTE_CODIGO_CLIENTE`) REFERENCES `cliente` (`CODIGO_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TELEFONE`
--

LOCK TABLES `TELEFONE` WRITE;
/*!40000 ALTER TABLE `TELEFONE` DISABLE KEYS */;
INSERT INTO `TELEFONE` VALUES (1,'(62) 8100-0456',3),(2,'(62) 3586-5962',3),(3,'(62) 8100-0000',3),(5,'(87) 9890-8098',3);
/*!40000 ALTER TABLE `TELEFONE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `CODIGO_GENERO` int(10) NOT NULL AUTO_INCREMENT,
  `NOME_GENERO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_GENERO`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Aventura'),(2,'Terror'),(3,'Comedia'),(4,'Drama'),(5,'Erotico'),(6,'Ficção'),(7,'Suspence'),(8,'Thriller'),(9,'Infantil'),(10,'Policial'),(11,'Western'),(12,'Romance'),(13,'Musical'),(14,'Guerra'),(15,'Documentario'),(16,'Ação'),(17,'Biblicos'),(18,'Serie TV');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idioma`
--

DROP TABLE IF EXISTS `idioma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idioma` (
  `codigo_idioma` int(11) NOT NULL AUTO_INCREMENT,
  `nome_idioma` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_idioma`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idioma`
--

LOCK TABLES `idioma` WRITE;
/*!40000 ALTER TABLE `idioma` DISABLE KEYS */;
INSERT INTO `idioma` VALUES (1,'Chinês'),(2,'Espanhol'),(3,'Francês'),(4,'Inglês'),(5,'Italiano'),(6,'Japonês'),(7,'Polonês'),(8,'Português');
/*!40000 ALTER TABLE `idioma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interface`
--

DROP TABLE IF EXISTS `interface`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interface` (
  `codigo_interface` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `nome_classe` varchar(45) DEFAULT NULL,
  `tipo` varchar(1) DEFAULT NULL,
  `codigo_pai` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT '0',
  PRIMARY KEY (`codigo_interface`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interface`
--

LOCK TABLES `interface` WRITE;
/*!40000 ALTER TABLE `interface` DISABLE KEYS */;
INSERT INTO `interface` VALUES (1,'Cliente','br.com.locadora.view.MenuCliente','P',1,0),(2,'Produto','br.com.locadora.view.MenuProduto','P',1,0),(3,'Fornecedor','br.com.locadora.view.MenuFornecedor','P',1,0),(4,'Objeto','br.com.locadora.view.MenuObjeto','P',NULL,0),(5,'Gênero','br.com.locadora.view.MenuGenero',NULL,NULL,0),(6,'Diária','br.com.locadora.view.MenuDiaria',NULL,NULL,0),(7,'Atendimento Locação','br.com.locadora.view.AtendimentoLocacao',NULL,1,0),(8,'Atendimento Devolução','br.com.locadora.view.AtendimentoDevolucao',NULL,NULL,0),(9,'Desconto (Entrada Caixa - Locação)','br.com.locadora.view.EntradaCaixa',NULL,NULL,0),(10,'Desconto (Entrada Caixa - Devolucao)','br.com.locadora.view.EntradaCaixaDevolucao',NULL,NULL,0),(11,'Acessos','br.com.locadora.view.AcessoInterface',NULL,NULL,0),(12,'Recebimentos','br.com.locadora.view.Recebimento',NULL,NULL,0),(13,'Usuario','br.com.Locadora.view.MenuUsuario',NULL,NULL,0),(14,'Idioma','br.com.locadora.view.MenuIdioma',NULL,NULL,0),(15,'Legenda','br.com.locadora.view.MenuLegenda',NULL,NULL,0);
/*!40000 ALTER TABLE `interface` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lancamento`
--

DROP TABLE IF EXISTS `lancamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lancamento` (
  `codigo_lancamento` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double DEFAULT '0',
  `dependente_CODIGO_DEPENDENTE` int(11) NOT NULL,
  `tipo_servico_codigo_tipo_servico` int(11) NOT NULL,
  `usuario_CODIGO_USUARIO` int(11) NOT NULL,
  `locacao_CODIGO_LOCACAO` int(11) DEFAULT NULL,
  `data_lancamento` date DEFAULT NULL,
  `caixa_codigo_caixa` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_lancamento`),
  KEY `fk_lancamento_dependente1_idx` (`dependente_CODIGO_DEPENDENTE`),
  KEY `fk_lancamento_tipo_servico1_idx` (`tipo_servico_codigo_tipo_servico`),
  KEY `fk_lancamento_usuario1_idx` (`usuario_CODIGO_USUARIO`),
  KEY `fk_lancamento_locacao1_idx` (`locacao_CODIGO_LOCACAO`),
  CONSTRAINT `fk_lancamento_dependente1` FOREIGN KEY (`dependente_CODIGO_DEPENDENTE`) REFERENCES `dependente` (`CODIGO_DEPENDENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lancamento_locacao1` FOREIGN KEY (`locacao_CODIGO_LOCACAO`) REFERENCES `locacao` (`CODIGO_LOCACAO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lancamento_tipo_servico1` FOREIGN KEY (`tipo_servico_codigo_tipo_servico`) REFERENCES `tipo_servico` (`codigo_tipo_servico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lancamento_usuario1` FOREIGN KEY (`usuario_CODIGO_USUARIO`) REFERENCES `usuario` (`CODIGO_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lancamento`
--

LOCK TABLES `lancamento` WRITE;
/*!40000 ALTER TABLE `lancamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `lancamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legenda`
--

DROP TABLE IF EXISTS `legenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legenda` (
  `codigo_legenda` int(11) NOT NULL AUTO_INCREMENT,
  `nome_legenda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_legenda`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legenda`
--

LOCK TABLES `legenda` WRITE;
/*!40000 ALTER TABLE `legenda` DISABLE KEYS */;
INSERT INTO `legenda` VALUES (1,'Chinês'),(2,'Espanhol'),(3,'Francês'),(4,'Inglês'),(5,'Italiano'),(6,'Japonês'),(7,'Polonês'),(8,'Português'),(9,'Não Legendado');
/*!40000 ALTER TABLE `legenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objeto`
--

DROP TABLE IF EXISTS `objeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objeto` (
  `CODIGO_OBJETO` int(11) NOT NULL AUTO_INCREMENT,
  `TITULO` varchar(45) DEFAULT NULL,
  `TITULO_ORIGINAL` varchar(45) DEFAULT NULL,
  `TIPO_MOVIMENTO` varchar(45) DEFAULT NULL,
  `PRODUCAO` varchar(45) DEFAULT NULL,
  `DURACAO` varchar(45) DEFAULT NULL,
  `MIDIA` varchar(45) DEFAULT NULL,
  `TIPO_MIDIA` varchar(45) DEFAULT NULL,
  `ELENCO` varchar(400) DEFAULT NULL,
  `SINOPSE` varchar(1000) DEFAULT NULL,
  `CENSURA` varchar(1000) DEFAULT '1',
  `GENERO_CODIGO_GENERO` int(10) NOT NULL,
  `DIARIA_CODIGO_DIARIA` int(11) NOT NULL,
  `DEL_FLAG` int(2) DEFAULT '0',
  PRIMARY KEY (`CODIGO_OBJETO`),
  KEY `fk_OBJETO_GENERO1_idx` (`GENERO_CODIGO_GENERO`),
  KEY `fk_OBJETO_DIARIA1_idx` (`DIARIA_CODIGO_DIARIA`),
  CONSTRAINT `fk_OBJETO_DIARIA1` FOREIGN KEY (`DIARIA_CODIGO_DIARIA`) REFERENCES `diaria` (`CODIGO_DIARIA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OBJETO_GENERO1` FOREIGN KEY (`GENERO_CODIGO_GENERO`) REFERENCES `genero` (`CODIGO_GENERO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto`
--

LOCK TABLES `objeto` WRITE;
/*!40000 ALTER TABLE `objeto` DISABLE KEYS */;
INSERT INTO `objeto` VALUES (3,'Mulher Infernal','Mulher Infernal','Locação','Americana','120','DVD','Filme','\n','\n','12',1,5,0),(4,'Teste 1 - Alterando','Teste 1 - Alterando','Locação','Americana','Teste 1 - Alterando','Blu Ray','Filme','Teste 1 - Alterando\n','Teste 1 - Alterando\n','15',1,3,0);
/*!40000 ALTER TABLE `objeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocao`
--

DROP TABLE IF EXISTS `promocao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promocao` (
  `codigo_promocao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_promocao` varchar(45) DEFAULT NULL,
  `valor_promocao` double DEFAULT NULL,
  `locar_quantidade` int(11) DEFAULT NULL,
  `ganhar_quantidade` int(11) DEFAULT NULL,
  `pagamento_a_vista` varchar(45) DEFAULT '0',
  `ordem` int(11) DEFAULT NULL,
  `domingo` int(11) DEFAULT '0',
  `segunda` int(11) DEFAULT '0',
  `terca` int(11) DEFAULT '0',
  `quarta` int(11) DEFAULT '0',
  `quinta` int(11) DEFAULT '0',
  `sexta` int(11) DEFAULT '0',
  `sabado` int(11) DEFAULT '0',
  `diaria_codigo_diaria` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_promocao`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocao`
--

LOCK TABLES `promocao` WRITE;
/*!40000 ALTER TABLE `promocao` DISABLE KEYS */;
INSERT INTO `promocao` VALUES (4,'Quarta 50% OFF',1,1,0,'0',1,1,1,1,0,1,1,1,3),(8,'Leve 3 Pague 1',3,3,1,'1',2,0,0,0,0,0,0,0,4),(9,'Normal',3,1,0,'1',3,0,0,0,0,0,0,0,4),(10,'Leve 3 Pague 1',2,3,1,'1',2,0,0,0,0,0,0,0,3),(11,'Normal',2,1,0,'1',3,0,0,0,0,0,0,0,3),(12,'Quarta 50% OFF',1.5,1,0,'0',1,1,1,1,0,1,1,1,4),(13,'Quarta 50% OFF',2.5,1,0,'0',1,1,1,1,0,1,1,1,5),(16,'Normal',5,1,0,'1',2,0,0,0,0,0,0,0,5),(17,'Quarta 50% OFF',3,1,0,'0',1,1,1,1,0,1,1,1,6),(18,'Normal',6,1,0,'1',2,0,0,0,0,0,0,0,6),(19,'Quarta 50% OFF',2,1,0,'0',1,1,1,1,0,1,1,1,7),(20,'Normal',4,1,0,'1',2,0,0,0,0,0,0,0,7),(21,'Quarta 50% OFF',2.5,1,0,'0',1,1,1,1,0,1,1,1,8),(22,'Normal',5,1,0,'1',2,0,0,0,0,0,0,0,8);
/*!40000 ALTER TABLE `promocao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocao_devolucao`
--

DROP TABLE IF EXISTS `promocao_devolucao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promocao_devolucao` (
  `codigo_promocao_devolucao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `horario_locacao` time DEFAULT NULL,
  `horario_devolucao` time DEFAULT NULL,
  `horas_antecipada` time DEFAULT NULL,
  `valor_promocao` double DEFAULT NULL,
  `pagamento_a_vista` int(11) DEFAULT NULL,
  `diaria_codigo_diaria` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_promocao_devolucao`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocao_devolucao`
--

LOCK TABLES `promocao_devolucao` WRITE;
/*!40000 ALTER TABLE `promocao_devolucao` DISABLE KEYS */;
INSERT INTO `promocao_devolucao` VALUES (8,'teste','09:00:00','16:00:00','10:00:00',2,1,9),(9,'Teste 1','09:00:00','16:00:00','10:00:00',1,1,15);
/*!40000 ALTER TABLE `promocao_devolucao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `CODIGO_STATION` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO_STATION` varchar(45) DEFAULT NULL,
  `DEL_FLAG` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_STATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_objeto`
--

DROP TABLE IF EXISTS `tipo_objeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_objeto` (
  `CODIGO_TIPO_OBJETO` int(11) NOT NULL,
  `NOME_TIPO_OBJETO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_TIPO_OBJETO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_objeto`
--

LOCK TABLES `tipo_objeto` WRITE;
/*!40000 ALTER TABLE `tipo_objeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_objeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_servico`
--

DROP TABLE IF EXISTS `tipo_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_servico` (
  `codigo_tipo_servico` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `movimento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_tipo_servico`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_servico`
--

LOCK TABLES `tipo_servico` WRITE;
/*!40000 ALTER TABLE `tipo_servico` DISABLE KEYS */;
INSERT INTO `tipo_servico` VALUES (1,'D','Locação: Valor Locação','L'),(2,'D','Devolução: Atraso na Devolução','D'),(3,'C','Locação: Desconto','L'),(4,'C','Dinheiro',NULL),(5,'D','Devolução: Débito de Devolução','D'),(6,'C','Locação: Pagamento Locação','L'),(7,'C','Devolução: Pagamento de Locação','D'),(8,'C','Devolução: Desconto','D');
/*!40000 ALTER TABLE `tipo_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `CODIGO_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_USUARIO` varchar(50) DEFAULT NULL,
  `LOGIN` varchar(20) DEFAULT NULL,
  `SENHA` varchar(10) DEFAULT NULL,
  `DEL_FLAG` varchar(45) DEFAULT '0',
  PRIMARY KEY (`CODIGO_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (3,'Alencar Santos Buriti Junior','admin','admin','0'),(4,'Eliesio Xavier','eliesio.xavier','eliesio','0'),(5,'Teste 1','Teste 1','Teste 1','0'),(6,'Teste 2','teste','adm','0');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'locadora'
--

--
-- Dumping routines for database 'locadora'
--
/*!50003 DROP PROCEDURE IF EXISTS `SP_LAST_CLIENTE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LAST_CLIENTE`()
BEGIN
SELECT MAX(CODIGO_CLIENTE) FROM locadora.CLIENTE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_UPDATE_CLIENTE_BY_PK` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_UPDATE_CLIENTE_BY_PK`(
IN P_CODIGO_CLIENTE int(11),
IN P_NOME_CLIENTE varchar(45),
IN P_NOME_EMPRESA_TRABALHO varchar(45),
IN P_PROFISSAO varchar(45),
IN P_CPF varchar(15),
IN P_DATA_NASCIMENTO date,
IN P_ENDERECO varchar(45),
IN P_BAIRRO varchar(45),
IN P_COMPLEMENTO varchar(30),
IN P_CIDADE varchar(30),
IN P_ESTADO varchar(30),
IN P_EMAIL varchar(30),
IN P_OBSERVACAO varchar(40),
IN P_DEL_FLAG int(11)
)
BEGIN

UPDATE locadora.CLIENTE
SET
NOME_CLIENTE = P_NOME_CLIENTE,
NOME_EMPRESA_TRABALHO = P_NOME_EMPRESA_TRABALHO,
PROFISSAO = P_PROFISSAO,
CPF = P_CPF,
DATA_NASCIMENTO = P_DATA_NASCIMENTO,
ENDERECO = P_ENDERECO,
BAIRRO = P_BAIRRO,
COMPLEMENTO = P_COMPLEMENTO,
CIDADE = P_CIDADE,
ESTADO = P_ESTADO,
EMAIL = P_EMAIL,
OBSERVACAO = P_OBSERVACAO,
DEL_FLAG = P_DEL_FLAG
WHERE CODIGO_CLIENTE = P_CODIGO_CLIENTE;

UPDATE locadora.DEPENDENTE SET
NOME_DEPENDENTE = P_NOME_CLIENTE
WHERE CLIENTE_CODIGO_CLIENTE = P_CODIGO_CLIENTE
AND TIPO_DEPENDENTE = 0;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_UPDATE_OBJETO_BY_PK` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_UPDATE_OBJETO_BY_PK`(
IN P_CODIGO_OBJETO int(11),
IN P_TITULO varchar(45),
IN P_TITULO_ORIGINAL varchar(45),
IN P_TIPO_MOVIMENTO varchar(45),
IN P_PRODUCAO varchar(45),
IN P_DURACAO varchar(45),
IN P_MIDIA varchar(45),
IN P_TIPO_MIDIA varchar(45),
IN P_ELENCO varchar(1000),
IN P_SINOPSE varchar(1000),
IN P_CENSURA varchar(45),
IN P_GENERO_CODIGO_GENERO int(10),
IN P_DIARIA_CODIGO_DIARIA int(11),
IN P_DEL_FLAG int(2)
)
BEGIN

UPDATE `locadora`.`objeto`
SET
`CODIGO_OBJETO` = P_CODIGO_OBJETO,
`TITULO` = P_TITULO,
`TITULO_ORIGINAL` = P_TITULO_ORIGINAL,
`TIPO_MOVIMENTO` = P_TIPO_MOVIMENTO,
`PRODUCAO` = P_PRODUCAO,
`DURACAO` = P_DURACAO,
`MIDIA` = P_MIDIA,
`TIPO_MIDIA` = P_TIPO_MIDIA,
`ELENCO` = P_ELENCO,
`SINOPSE` = P_SINOPSE,
`CENSURA` = P_CENSURA,
`GENERO_CODIGO_GENERO` = P_GENERO_CODIGO_GENERO,
`DIARIA_CODIGO_DIARIA` = P_DIARIA_CODIGO_DIARIA,
`DEL_FLAG` = P_DEL_FLAG
WHERE `CODIGO_OBJETO` = P_CODIGO_OBJETO;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-12 18:44:32
