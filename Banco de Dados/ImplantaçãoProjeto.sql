CREATE DATABASE  IF NOT EXISTS `locadora` /*!40100 DEFAULT CHARACTER SET latin1 */;
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
-- Table structure for table `acesso`
--

DROP TABLE IF EXISTS `acesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acesso` (
  `CODIGO_ACESSO` int(11) NOT NULL AUTO_INCREMENT,
  `LER` int(2) DEFAULT '1',
  `ESCREVER` int(2) DEFAULT '1',
  `DELETAR` int(2) DEFAULT '1',
  `SUPER_USUARIO` int(11) DEFAULT '1',
  `USUARIO_CODIGO_USUARIO` int(11) NOT NULL,
  `INTERFACE_CODIGO_INTERFACE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_ACESSO`),
  KEY `FK_ACESSO_USUARIO1_IDX` (`USUARIO_CODIGO_USUARIO`),
  CONSTRAINT `FK_ACESSO_USUARIO1` FOREIGN KEY (`USUARIO_CODIGO_USUARIO`) REFERENCES `usuario` (`CODIGO_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acesso`
--

LOCK TABLES `acesso` WRITE;
/*!40000 ALTER TABLE `acesso` DISABLE KEYS */;
INSERT INTO `acesso` VALUES (1,0,0,0,0,1,1),(2,0,0,0,0,1,1),(3,0,0,0,0,1,2),(4,0,0,0,0,1,3),(5,0,0,0,0,1,4),(6,0,0,0,0,1,5),(7,0,0,0,0,1,6),(8,0,0,0,0,1,7),(9,0,0,0,0,1,8),(10,0,0,0,0,1,9),(11,0,0,0,0,1,10),(12,0,0,0,0,1,11),(13,0,0,0,0,1,12),(14,0,0,0,0,1,13),(15,0,0,0,0,1,14),(16,0,0,0,0,1,15),(17,0,0,0,0,1,16),(18,0,0,0,0,1,17);
/*!40000 ALTER TABLE `acesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caixa`
--

DROP TABLE IF EXISTS `caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caixa` (
  `CODIGO_CAIXA` int(11) NOT NULL AUTO_INCREMENT,
  `IP` varchar(45) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `NUMERO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_CAIXA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caixa`
--

LOCK TABLES `caixa` WRITE;
/*!40000 ALTER TABLE `caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copia`
--

DROP TABLE IF EXISTS `copia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copia` (
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
  `DIARIA_CODIGO_DIARIA` int(11) DEFAULT NULL,
  `MIDIA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_COPIA`),
  KEY `FK_COPIA_OBJETO_IDX` (`OBJETO_CODIGO_OBJETO`),
  CONSTRAINT `FK_COPIA_OBJETO` FOREIGN KEY (`OBJETO_CODIGO_OBJETO`) REFERENCES `objeto` (`CODIGO_OBJETO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copia`
--

LOCK TABLES `copia` WRITE;
/*!40000 ALTER TABLE `copia` DISABLE KEYS */;
/*!40000 ALTER TABLE `copia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependente`
--

DROP TABLE IF EXISTS `dependente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependente` (
  `CODIGO_DEPENDENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_DEPENDENTE` varchar(50) DEFAULT NULL,
  `TIPO_DEPENDENTE` int(11) DEFAULT '0',
  `PARENTESCO` varchar(45) DEFAULT NULL,
  `CPF` varchar(14) DEFAULT NULL,
  `DATA_NASCIMENTO` date DEFAULT NULL,
  `DEL_FLAG` int(2) DEFAULT '0',
  `CLIENTE_CODIGO_CLIENTE` int(11) NOT NULL,
  `TELEFONE` varchar(45) DEFAULT NULL,
  `USUARIO_CODIGO_USUARIO` int(11) NOT NULL,
  PRIMARY KEY (`CODIGO_DEPENDENTE`),
  KEY `FK_DEPENDENTE_CLIENTE1_IDX` (`CLIENTE_CODIGO_CLIENTE`),
  KEY `FK_DEPENDENTE_USUARIO1_IDX` (`USUARIO_CODIGO_USUARIO`),
  CONSTRAINT `FK_DEPENDENTE_CLIENTE1` FOREIGN KEY (`CLIENTE_CODIGO_CLIENTE`) REFERENCES `cliente` (`CODIGO_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_DEPENDENTE_USUARIO1` FOREIGN KEY (`USUARIO_CODIGO_USUARIO`) REFERENCES `usuario` (`CODIGO_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependente`
--

LOCK TABLES `dependente` WRITE;
/*!40000 ALTER TABLE `dependente` DISABLE KEYS */;
/*!40000 ALTER TABLE `dependente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diaria`
--

DROP TABLE IF EXISTS `diaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diaria` (
  `CODIGO_DIARIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_DIARIA` varchar(45) DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  `DIAS` int(11) DEFAULT NULL,
  `MULTAS` double DEFAULT NULL,
  `MAXIMO_DIAS` int(11) DEFAULT NULL,
  `ACUMULATIVO` int(11) DEFAULT '0',
  PRIMARY KEY (`CODIGO_DIARIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diaria`
--

LOCK TABLES `diaria` WRITE;
/*!40000 ALTER TABLE `diaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `diaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `IDFORNECEDOR` int(10) NOT NULL AUTO_INCREMENT,
  `RAZAOSOCIAL` varchar(70) DEFAULT NULL,
  `NOMEFANTASIA` varchar(70) DEFAULT NULL,
  `CNPJ` varchar(18) DEFAULT NULL,
  `TELEFONE` varchar(14) DEFAULT NULL,
  `FAX` varchar(14) DEFAULT NULL,
  `ENDERECO` varchar(50) DEFAULT NULL,
  `INSCRICAOESTADUAL` varchar(20) DEFAULT NULL,
  `INSCRICAOMUNICIPAL` varchar(20) DEFAULT NULL,
  `NOMEVENDEDOR` varchar(50) DEFAULT NULL,
  `TELEFONEVENDEDOR` varchar(14) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `CIDADE` varchar(25) DEFAULT NULL,
  `ESTADO` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDFORNECEDOR`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'BROADWAY','BROADWAY','02.836.799/0001.86','(62)3335-3456','(54)6545-6456','RUA','546.546.546.','165.465.465.','TESTANDO','(62)3353-2201','76.380-000','GOIANESIA','GO');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
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
INSERT INTO `genero` VALUES (1,'Aventura'),(2,'Terror'),(3,'Comedia'),(4,'Drama'),(5,'Erótico'),(6,'Ficção'),(7,'Suspense'),(8,'Thriller'),(9,'Infantil'),(10,'Policial'),(11,'Western'),(12,'Romance'),(13,'Musical'),(14,'Guerra'),(15,'Documentário'),(16,'Ação'),(17,'Bíblicos'),(18,'Série TV');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idioma`
--

DROP TABLE IF EXISTS `idioma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idioma` (
  `CODIGO_IDIOMA` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_IDIOMA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_IDIOMA`)
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
  `CODIGO_INTERFACE` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  `NOME_CLASSE` varchar(45) DEFAULT NULL,
  `DEL_FLAG` int(11) DEFAULT '0',
  PRIMARY KEY (`CODIGO_INTERFACE`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interface`
--

LOCK TABLES `interface` WRITE;
/*!40000 ALTER TABLE `interface` DISABLE KEYS */;
INSERT INTO `interface` VALUES (1,'Cliente','br.com.locadora.view.MenuCliente',0),(2,'Produto','br.com.locadora.view.MenuProduto',0),(3,'Fornecedor','br.com.locadora.view.MenuFornecedor',0),(4,'Objeto','br.com.locadora.view.MenuObjeto',0),(5,'Gênero','br.com.locadora.view.MenuGenero',0),(6,'Diária','br.com.locadora.view.MenuDiaria',0),(7,'Atendimento Locação','br.com.locadora.view.AtendimentoLocacao',0),(8,'Atendimento Devolução','br.com.locadora.view.AtendimentoDevolucao',0),(9,'Desconto (Entrada Caixa - Locação)','br.com.locadora.view.EntradaCaixa',0),(10,'Desconto (Entrada Caixa - Devolução)','br.com.locadora.view.EntradaCaixaDevolucao',0),(12,'Recebimentos','br.com.locadora.view.Recebimento',0),(13,'Usuário','br.com.locadora.view.MenuUsuario',0),(14,'Idioma','br.com.locadora.view.MenuIdioma',0),(15,'Legenda','br.com.locadora.view.MenuLegenda',0),(16,'Configurar Caixa','br.com.locadora.view.ConfiguraCaixa',0),(17,'Controle de Acessos','br.com.locadora.view.ControleAcesso',0),(18,'Autorizar pagamentos à Prazo em Promoções','br.com.locadora.view.EntradaCaixaLocacao',0);
/*!40000 ALTER TABLE `interface` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_locacao`
--

DROP TABLE IF EXISTS `item_locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_locacao` (
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
  `PROMOCAO_LOCACAO_CODIGO_PROMOCAO_LOCACAO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_ITEM_LOCACAO`),
  KEY `FK_ITEM_LOCACAO_LOCACAO1_IDX` (`LOCACAO_CODIGO_LOCACAO`),
  KEY `FK_ITEM_LOCACAO_COPIA1_IDX` (`COPIA_CODIGO_COPIA`),
  CONSTRAINT `FK_ITEM_LOCACAO_COPIA1` FOREIGN KEY (`COPIA_CODIGO_COPIA`) REFERENCES `copia` (`CODIGO_COPIA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ITEM_LOCACAO_LOCACAO1` FOREIGN KEY (`LOCACAO_CODIGO_LOCACAO`) REFERENCES `locacao` (`CODIGO_LOCACAO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_locacao`
--

LOCK TABLES `item_locacao` WRITE;
/*!40000 ALTER TABLE `item_locacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lancamento`
--

DROP TABLE IF EXISTS `lancamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lancamento` (
  `CODIGO_LANCAMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `VALOR` double DEFAULT '0',
  `DEPENDENTE_CODIGO_DEPENDENTE` int(11) NOT NULL,
  `TIPO_SERVICO_CODIGO_TIPO_SERVICO` int(11) NOT NULL,
  `USUARIO_CODIGO_USUARIO` int(11) NOT NULL,
  `LOCACAO_CODIGO_LOCACAO` int(11) DEFAULT NULL,
  `DATA_LANCAMENTO` date DEFAULT NULL,
  `CAIXA_CODIGO_CAIXA` int(11) DEFAULT NULL,
  `CLIENTE_CODIGO_CLIENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_LANCAMENTO`),
  KEY `FK_LANCAMENTO_DEPENDENTE1_IDX` (`DEPENDENTE_CODIGO_DEPENDENTE`),
  KEY `FK_LANCAMENTO_TIPO_SERVICO1_IDX` (`TIPO_SERVICO_CODIGO_TIPO_SERVICO`),
  KEY `FK_LANCAMENTO_USUARIO1_IDX` (`USUARIO_CODIGO_USUARIO`),
  KEY `FK_LANCAMENTO_LOCACAO1_IDX` (`LOCACAO_CODIGO_LOCACAO`),
  CONSTRAINT `FK_LANCAMENTO_DEPENDENTE1` FOREIGN KEY (`DEPENDENTE_CODIGO_DEPENDENTE`) REFERENCES `dependente` (`CODIGO_DEPENDENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_LANCAMENTO_LOCACAO1` FOREIGN KEY (`LOCACAO_CODIGO_LOCACAO`) REFERENCES `locacao` (`CODIGO_LOCACAO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_LANCAMENTO_TIPO_SERVICO1` FOREIGN KEY (`TIPO_SERVICO_CODIGO_TIPO_SERVICO`) REFERENCES `tipo_servico` (`CODIGO_TIPO_SERVICO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_LANCAMENTO_USUARIO1` FOREIGN KEY (`USUARIO_CODIGO_USUARIO`) REFERENCES `usuario` (`CODIGO_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `CODIGO_LEGENDA` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_LEGENDA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_LEGENDA`)
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
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locacao` (
  `CODIGO_LOCACAO` int(11) NOT NULL AUTO_INCREMENT,
  `DEL_FLAG` int(2) DEFAULT '0',
  `DEPENDENTE_CODIGO_DEPENDENTE` int(11) NOT NULL,
  `USUARIO_CODIGO_USUARIO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_LOCACAO`),
  KEY `FK_LOCACAO_DEPENDENTE1_IDX` (`DEPENDENTE_CODIGO_DEPENDENTE`),
  KEY `FK_LOCACAO_DEPENDENTE1_IDX1` (`DEPENDENTE_CODIGO_DEPENDENTE`,`USUARIO_CODIGO_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;
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
  `TIPO_MIDIA` varchar(45) DEFAULT NULL,
  `ELENCO` varchar(400) DEFAULT NULL,
  `SINOPSE` varchar(1000) DEFAULT NULL,
  `CENSURA` varchar(1000) DEFAULT '1',
  `GENERO_CODIGO_GENERO` int(10) NOT NULL,
  `DEL_FLAG` int(2) DEFAULT '0',
  PRIMARY KEY (`CODIGO_OBJETO`),
  KEY `FK_OBJETO_GENERO1_IDX` (`GENERO_CODIGO_GENERO`),
  CONSTRAINT `FK_OBJETO_GENERO1` FOREIGN KEY (`GENERO_CODIGO_GENERO`) REFERENCES `genero` (`CODIGO_GENERO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto`
--

LOCK TABLES `objeto` WRITE;
/*!40000 ALTER TABLE `objeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `objeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocao_devolucao`
--

DROP TABLE IF EXISTS `promocao_devolucao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promocao_devolucao` (
  `CODIGO_PROMOCAO_DEVOLUCAO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  `HORARIO_LOCACAO` time DEFAULT NULL,
  `HORARIO_DEVOLUCAO` time DEFAULT NULL,
  `HORAS_ANTECIPADA` time DEFAULT NULL,
  `VALOR_PROMOCAO` double DEFAULT NULL,
  `PAGAMENTO_A_VISTA` int(11) DEFAULT NULL,
  `DIARIA_CODIGO_DIARIA` int(11) DEFAULT NULL,
  `DEL_FLAG` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_PROMOCAO_DEVOLUCAO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocao_devolucao`
--

LOCK TABLES `promocao_devolucao` WRITE;
/*!40000 ALTER TABLE `promocao_devolucao` DISABLE KEYS */;
/*!40000 ALTER TABLE `promocao_devolucao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocao_locacao`
--

DROP TABLE IF EXISTS `promocao_locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promocao_locacao` (
  `CODIGO_PROMOCAO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO_PROMOCAO` varchar(45) DEFAULT NULL,
  `VALOR_PROMOCAO` double DEFAULT NULL,
  `LOCAR_QUANTIDADE` int(11) DEFAULT NULL,
  `GANHAR_QUANTIDADE` int(11) DEFAULT NULL,
  `PAGAMENTO_A_VISTA` varchar(45) DEFAULT '0',
  `ORDEM` int(11) DEFAULT NULL,
  `DOMINGO` int(11) DEFAULT '0',
  `SEGUNDA` int(11) DEFAULT '0',
  `TERCA` int(11) DEFAULT '0',
  `QUARTA` int(11) DEFAULT '0',
  `QUINTA` int(11) DEFAULT '0',
  `SEXTA` int(11) DEFAULT '0',
  `SABADO` int(11) DEFAULT '0',
  `DIARIA_CODIGO_DIARIA` int(11) DEFAULT NULL,
  `DEL_FLAG` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_PROMOCAO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocao_locacao`
--

LOCK TABLES `promocao_locacao` WRITE;
/*!40000 ALTER TABLE `promocao_locacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `promocao_locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `CODIGO_STATION` int(11) NOT NULL AUTO_INCREMENT,
  `IP` varchar(45) DEFAULT NULL,
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
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefone` (
  `CODIGO_TELEFONE` int(11) NOT NULL AUTO_INCREMENT,
  `TELEFONE` varchar(50) DEFAULT NULL,
  `CLIENTE_CODIGO_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`CODIGO_TELEFONE`),
  KEY `FK_TELEFONE_CLIENTE1_IDX` (`CLIENTE_CODIGO_CLIENTE`),
  CONSTRAINT `FK_TELEFONE_CLIENTE1` FOREIGN KEY (`CLIENTE_CODIGO_CLIENTE`) REFERENCES `cliente` (`CODIGO_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefone`
--

LOCK TABLES `telefone` WRITE;
/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;
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
  `CODIGO_TIPO_SERVICO` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(45) DEFAULT NULL,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  `MOVIMENTO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGO_TIPO_SERVICO`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_servico`
--

LOCK TABLES `tipo_servico` WRITE;
/*!40000 ALTER TABLE `tipo_servico` DISABLE KEYS */;
INSERT INTO `tipo_servico` VALUES (1,'D','Locação: Valor Locação','L'),(2,'D','Devolução: Atraso na Devolução','D'),(3,'C','Locação: Desconto','L'),(4,'C','Dinheiro','R'),(5,'D','Devolução: Débito de Devolução','D'),(6,'C','Locação: Pagamento Locação','L'),(7,'C','Devolução: Pagamento Devolução','D'),(8,'C','Devolução: Desconto','D'),(9,'C','Desconto Entrega Antecipada','D');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Administrador','admin','admin','0');
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
CREATE DEFINER=`ROOT`@`localhost` PROCEDURE `SP_LAST_CLIENTE`()
BEGIN
SELECT MAX(CODIGO_CLIENTE) FROM LOCADORA.CLIENTE;
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
CREATE DEFINER=`ROOT`@`localhost` PROCEDURE `SP_UPDATE_OBJETO_BY_PK`(
IN P_CODIGO_OBJETO INT(11),
IN P_TITULO VARCHAR(45),
IN P_TITULO_ORIGINAL VARCHAR(45),
IN P_TIPO_MOVIMENTO VARCHAR(45),
IN P_PRODUCAO VARCHAR(45),
IN P_DURACAO VARCHAR(45),
IN P_MIDIA VARCHAR(45),
IN P_TIPO_MIDIA VARCHAR(45),
IN P_ELENCO VARCHAR(1000),
IN P_SINOPSE VARCHAR(1000),
IN P_CENSURA VARCHAR(45),
IN P_GENERO_CODIGO_GENERO INT(10),
IN P_DIARIA_CODIGO_DIARIA INT(11),
IN P_DEL_FLAG INT(2)
)
BEGIN

UPDATE `LOCADORA`.`OBJETO`
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

-- Dump completed on 2014-12-26 10:17:44
