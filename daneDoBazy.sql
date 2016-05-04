-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: training_company
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Ulica 12','Kato','tomek@jakis.pl','tomek','jakis','tomek1','142 412 412','tomek'),(2,'sdf;',';l,\'l[[;[/sd','admin@ad','s;dlfd','j\'.aspldas','test','821 030 982','?user:da;');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attachment_type` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `offer_id` bigint(20) DEFAULT NULL,
  `post_in_topic_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_icuk6biewlrwkj6vax8puyn0v` (`offer_id`),
  KEY `FK_iawyflv7ku0qijb61mhb2ddr9` (`post_in_topic_id`),
  CONSTRAINT `FK_iawyflv7ku0qijb61mhb2ddr9` FOREIGN KEY (`post_in_topic_id`) REFERENCES `post_in_topic` (`id`),
  CONSTRAINT `FK_icuk6biewlrwkj6vax8puyn0v` FOREIGN KEY (`offer_id`) REFERENCES `offer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

LOCK TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
INSERT INTO `attachment` VALUES (1,0,'pierwszy',1,NULL),(2,0,'gdfg',2,NULL),(3,0,'hgh',3,NULL),(4,0,'58658',4,NULL),(5,0,'fghw',5,NULL),(6,0,'hkjhk',7,NULL),(7,0,'t34',6,NULL),(8,0,',hjkhj',8,NULL),(9,0,'test2fs',1,NULL);
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basket`
--

DROP TABLE IF EXISTS `basket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4ames7juw568ln5d42s4k5c51` (`account_id`),
  CONSTRAINT `FK_4ames7juw568ln5d42s4k5c51` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basket`
--

LOCK TABLES `basket` WRITE;
/*!40000 ALTER TABLE `basket` DISABLE KEYS */;
INSERT INTO `basket` VALUES (1,1);
/*!40000 ALTER TABLE `basket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tq5kr7wfeog5tjjr1eqtww5oh` (`account_id`),
  CONSTRAINT `FK_tq5kr7wfeog5tjjr1eqtww5oh` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `greeting`
--

DROP TABLE IF EXISTS `greeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `greeting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `greeting`
--

LOCK TABLES `greeting` WRITE;
/*!40000 ALTER TABLE `greeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `greeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `session_id` varchar(255) DEFAULT NULL,
  `offer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_lo5xsdkgi9gv1gn4b0w505nc9` (`offer_id`),
  CONSTRAINT `FK_lo5xsdkgi9gv1gn4b0w505nc9` FOREIGN KEY (`offer_id`) REFERENCES `offer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest`
--

LOCK TABLES `guest` WRITE;
/*!40000 ALTER TABLE `guest` DISABLE KEYS */;
INSERT INTO `guest` VALUES (1,'2016-04-28 11:01:53','38E1FFC8A8A8E314248A9D5013EDEFAA',1),(2,'2016-04-28 11:43:10','1510370B94C60A7AF1DFDCCF63A33337',1),(3,'2016-04-28 11:45:59','1D68650FE03A4825499FB0B629B713E3',2),(4,'2016-04-28 11:47:31','B771A2F872617367BEE84A14F0831772',5),(5,'2016-04-28 11:47:45','B771A2F872617367BEE84A14F0831772',1),(6,'2016-04-28 11:47:55','B771A2F872617367BEE84A14F0831772',2),(7,'2016-04-28 11:51:55','3E8E21907E83F2E9BE799B76238B8056',1),(8,'2016-04-28 12:06:36','E1DC2BD67E0E3D9BA98BE5A064589C4B',5),(9,'2016-05-03 21:45:55','38271F64E97D9780C684DE4EEF4B77C7',5),(10,'2016-05-03 21:46:20','38271F64E97D9780C684DE4EEF4B77C7',15),(11,'2016-05-03 22:03:51','C88F34D3513F6D33F2841C3E82E21972',2),(12,'2016-05-03 22:09:19','BFCB20B4EF27BDE987987A814401A785',2),(13,'2016-05-03 22:09:56','BFCB20B4EF27BDE987987A814401A785',11),(14,'2016-05-03 22:10:09','BFCB20B4EF27BDE987987A814401A785',5),(15,'2016-05-03 22:12:21','7DFF7CE777560B6832841EA491FF9DAB',4),(16,'2016-05-03 22:15:52','D80AC6BC641FA0F497213E2E229060A6',3),(17,'2016-05-03 22:19:54','5F80ED37F56F084665F1A9924F68F89B',3),(18,'2016-05-03 22:21:05','5F80ED37F56F084665F1A9924F68F89B',7),(19,'2016-05-03 22:22:49','5F80ED37F56F084665F1A9924F68F89B',9),(20,'2016-05-03 22:30:21','BA0A019649EBF9E4DEF0B65BD036FB06',1),(21,'2016-05-03 22:34:52','4260698137893AF9180795D1F4613BBA',2),(22,'2016-05-03 22:48:53','F752492890086DCE86CFB9C3D67D4D0C',1),(23,'2016-05-03 23:08:12','897D0DA2CDD801FAFE04450236C5C336',1),(24,'2016-05-03 23:08:37','897D0DA2CDD801FAFE04450236C5C336',2),(25,'2016-05-03 23:11:12','2E581920014E904C60A035B1355169F0',1),(26,'2016-05-03 23:12:37','2E581920014E904C60A035B1355169F0',9),(27,'2016-05-03 23:20:15','080B21BC9BC15F65D62DE548E8FD7448',1),(28,'2016-05-03 23:27:07','40C545D0520ADDF937FA5B83D3D2803E',1),(29,'2016-05-03 23:27:25','40C545D0520ADDF937FA5B83D3D2803E',4),(30,'2016-05-03 23:31:17','BF915F07BD9CB253E44FE5CD5241179B',1),(31,'2016-05-03 23:33:56','BF915F07BD9CB253E44FE5CD5241179B',12),(32,'2016-05-04 16:54:06','09C60151252A0F2F5E7DF80DDC8B9ED4',3),(33,'2016-05-04 16:54:13','09C60151252A0F2F5E7DF80DDC8B9ED4',1),(34,'2016-05-04 16:55:01','09C60151252A0F2F5E7DF80DDC8B9ED4',15);
/*!40000 ALTER TABLE `guest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model_one`
--

DROP TABLE IF EXISTS `model_one`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `model_one` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descrption` varchar(255) DEFAULT NULL,
  `greeting` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_i3n6jw53tt107uv5y81ngjal4` (`greeting`),
  CONSTRAINT `FK_i3n6jw53tt107uv5y81ngjal4` FOREIGN KEY (`greeting`) REFERENCES `greeting` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model_one`
--

LOCK TABLES `model_one` WRITE;
/*!40000 ALTER TABLE `model_one` DISABLE KEYS */;
/*!40000 ALTER TABLE `model_one` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(1500) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `offer_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_35bkvrprwtalotnt87ou7nynh` (`offer_category_id`),
  CONSTRAINT `FK_35bkvrprwtalotnt87ou7nynh` FOREIGN KEY (`offer_category_id`) REFERENCES `offer_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (1,'Budowanie pozycji lidera jest bardzo ważnym i dalekowzrocznym działaniem mającym na celu stworzenie organizacji nastawionej na rozwój i dążącej do ciągłego doskonalenia się. Skoro to jest takie oczywiste to dla czego takie trudne? Bycie liderem to nie tylko umiejętność komunikacji czy bycia asertywnym. To również budowanie narzędzi, które pomogą podległemu personelowi realizować się w firmie i przestrzegać wartości, które wynikają z ich przekonań a nie przymusu.\n\nAsertywność to umiejętność wyrażania własnych uczuć, opinii, pragnień w różnych sytuacjach zawodowych w sposób otwarty i pozbawiony lęku, a zarazem respektujący uczucia i postawy innych.\nAsertywny lider to taki który jasno stawia granice a nie uważa, że pracownicy się ich domyślą, wspiera a nie wyręcza, nagradza a nie schlebia, egzekwuje a nie krzyczy, udziela jasnych informacji, a nie krytykuje, a także wyciąga konsekwencje i umie odmawiać',NULL,'KSZTAŁTOWANIE ASERTYWNEJ SYLWETKI LIDERA Z ELEMENTAMI RADZENIA SOBIE ZE STRESEM',95,8,1),(2,'Zapraszamy Państwa na szkolenie podczas którego, uczestnicy przygotują się do profesjonalnego i skutecznego prowadzania rozmów dotyczących ceny oraz negocjacji cenowych ze swoimi partnerami biznesowymi. Uczestnicy będą mogli przećwiczyć praktycznie techniki dotyczące obrony ceny przy wykorzystaniu dobranych argumentów.',NULL,'TECHNIKI OBRONY CENY',1539,76,1),(3,'Podstawowym celem warsztatu jest zatem dostarczenie uczestnikom wiedzy i umiejętności z zakresu skutecznego komunikowania się w sytuacjach zawodowych, w których sprawna komunikacja jest narzędziem tworzenia i podtrzymywania relacji społecznych oraz współpracy między ludźmi. Sprawna komunikacja i współpraca wewnątrz firmy ma bezpośrednie przełożenie na relacje i współpracę z innymi podmiotami. Znaczną część warsztatu zajmować będą aktywności tworzące pozytywny klimat sprzyjający komunikacji nastawionej na współpracę. ',NULL,'Szkolenie - Komunikacja nastawiona na budowanie współpracy',617,30,1),(4,'Warsztaty skierowane są do wszystkich osób zainteresowanych tematyką Asertywności, które pragną poszerzyć swoją wiedze w tym temacie.',NULL,'Szkolenie - Asertywność w pracy. Czy można się tego nauczyć ?',1452,34,1),(5,'Zasady wystąpień publicznych\n- Tworzenie scenariusza dobrej prezentacji/wystąpienia (struktura, spójność wypowiedzi, myśl przewodnia, kompozycja ramowa, oryginalność)\n- Budowanie kontaktu z audytorium (nawiązywanie dobrego kontaktu z odbiorcami, panowanie nad audytorium, radzenie sobie z trudnymi słuchaczami)\n- Praktyczne sposoby walki z tremą\n- Elementy fonetyki, dykcja, emisja głosu\n\nBudowanie wizerunku\n- Znaczenie efektu pierwszego wrażenia (umiejętność skupienia uwagi, nieszablonowość, dostosowanie do audytorium, dobór argumentacji)\n- Podstawy komunikacji werbalnej i niewerbalnej\n- Kreowanie wizerunku statycznego – wygląd zewnętrzny\n- Kreowanie wizerunku dynamicznego – sposób poruszania się, mimika, gestykulacja, ekspresja wypowiedzi',NULL,'Szkolenie - Autoprezentacja czyli jak dobrze wypaść przed każdą publicznością',1450,76,1),(6,'Warsztaty szkoleniowe rozwijające kreatywne myślenie w zarządzaniu zespołem, oparte na poszukiwaniu niestandardowych rozwiązań wpływających na zwiększenie efektywności swoich współpracowników. Uczestnicy szkolenia zdobędą wiedzę i podniosą swoje kompetencje, które pozwolą m.in. sprawnie delegować zadania, motywować pracowników radzić sobie w sytuacjach konfliktowych oraz budować pozytywne relacje w zespole.',NULL,'NOWOCZESNE STRATEGIE ZARZĄDZANIA ZESPOŁEM intensywne warsztaty dla kadry kierowniczej',716,99,2),(7,'Zmotywowany, efektywny, zaangażowany zespół jest filarem prężnie działającej firmy i podstawą skutecznego realizowania wyznaczonych zadań. Stworzenie mocnego zespołu wymaga działań nastawionych na budowanie zespołowego poczucia celu i wartości, kreowania atmosfery efektywnej współpracy i efektywnej komunikacji, która gwarantuje sukces.',NULL,'BUDOWANIE EFEKTYWNEGO ZESPOŁU',1938,41,2),(8,'Celem szkolenia jest rozwój kompetencji menadżerskich u szefów średniego i niższego szczebla, które pomogą im poradzić sobie w trudnych sytuacjach z jakimi może on się spotkać na produkcji. Przeanalizujemy jak należy prowadzić zespół i jak go zmieniać, żeby był przygotowany do podejmowania nowych wyzwań przy ograniczeniu sytuacji konfliktowych. Zastanowimy się jak przy wzrastającej ilości zadań nakładanych na menadżerów wygospodarować czas na rozmowę z pracownikiem oraz umiejętnie obciążyć zespół zadaniami, które będą go rozwijać i motywować. Przećwiczymy narzędzia, które powodują wzrost motywacji indywidualnej i zespołowej. Prześledzimy na zapisach video jakie błędy popełniamy podczas trudnych rozmów z pracownikami.',NULL,'Doskonalenie kompetencji lidera produkcji',1825,71,2),(9,'Cel szkolenia:\nNakreślenie mapy podstawowych cech i umiejętności skutecznego menedżera\nDostarczenie wiedzy o podstawowych obszarach działań lidera\nPrzećwiczenie umiejętności kierowania działaniami innych i wpływania na jakość pracy oraz decyzje i zaangażowanie współpracowników\nUmożliwienie autodiagnozy własnych predyspozycji menedżerskich',NULL,'Doskonalenie umiejętności menadżerskich',603,61,2),(10,'Program kładzie nacisk na elementy, które nie pojawiają się w Państwa programie szkolenia podstawowego takie jak:\nzaawansowane ćwiczenia konkretnych przypadków zgłoszonych przez uczestników;\nzarządzanie sytuacyjne – model Hersey’a / Blanchard’a;\npokolenie Y ;\nkonflikt w zespole;\ncoaching, jako narzędzie menedżera;\nelementy języka perswazji;\nprzyjmowanie feedbacku, jako podstawowa umiejętność w ciągłym rozwoju menedżera;\nmotywację jako ważne narzędzie menadżera.',NULL,'rozwój kompetencji menadżerskich ,poziom zaawansowany',823,26,2),(11,'',NULL,'',1007,86,3),(12,'',NULL,'',1009,74,3),(13,'',NULL,'',1083,63,3),(14,'',NULL,'',1785,15,3),(15,'',NULL,'',347,42,3),(16,'',NULL,'',1023,52,4);
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer_category`
--

DROP TABLE IF EXISTS `offer_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cbittq8es9c11nyh7irp84ge8` (`parent_category_id`),
  CONSTRAINT `FK_cbittq8es9c11nyh7irp84ge8` FOREIGN KEY (`parent_category_id`) REFERENCES `offer_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer_category`
--

LOCK TABLES `offer_category` WRITE;
/*!40000 ALTER TABLE `offer_category` DISABLE KEYS */;
INSERT INTO `offer_category` VALUES (1,'Umiejętności osobiste','Umiejętności osobiste',NULL),(2,'Zarządzanie zespołem','Zarządzanie zespołem',NULL),(3,'Sprzedaż i marketing','Sprzedaż i marketing',NULL),(4,'Finanse i rachunkowość','Finanse i rachunkowość',NULL),(5,'Zarządzanie organizacją','Zarządzanie organizacją',NULL),(6,'Zarządzanie jakością','Zarządzanie jakością',NULL),(7,'Szkolenia zawodowe','Szkolenia zawodowe',NULL),(8,'Kursy','Kursy',NULL),(9,'Unia Europejska','Unia Europejska',NULL),(10,'Administracja IT','Administracja IT',NULL),(11,'Obsługa oprogramowania','Obsługa oprogramowania',NULL),(12,'Informatyka certyfikaty','Informatyka certyfikaty',NULL),(13,'Projektowanie','Projektowanie',NULL),(14,'Programowanie','Programowanie',NULL),(15,'Prawo i zamówienia publiczne','Prawo i zamówienia publiczne',NULL),(16,'Ochrona środowiska','Ochrona środowiska',NULL),(17,'Laboratoria','Laboratoria',NULL),(18,'Internet','Internet',NULL),(19,'Logistyka','Logistyka',NULL),(20,'Produkcja','Produkcja',NULL),(21,'Szkolenia zawodowe','Szkolenia zawodowe',NULL),(22,'Szkolenia HR','Szkolenia HR',NULL),(23,'Placówki ochrony zdrowia','Placówki ochrony zdrowia',NULL),(24,'Administracja','Administracja',NULL),(25,'Studia podyplomowe','Studia podyplomowe',NULL),(26,'Ubezpieczenia','Ubezpieczenia',NULL),(27,'Konferencje','Konferencje',NULL),(28,'ABI','ABI',NULL),(29,'Telekomunikacja','Telekomunikacja',NULL),(30,'Kursy kosztorysowania','Kursy kosztorysowania',NULL),(31,'Projektowanie komputerowe','Projektowanie komputerowe',NULL),(32,'Inne','Inne',NULL);
/*!40000 ALTER TABLE `offer_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` bigint(20) DEFAULT NULL,
  `basket_id` bigint(20) DEFAULT NULL,
  `offer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_puensrfaci9xi45qwxwrd1jqf` (`basket_id`),
  KEY `FK_ka64qhvamgy6mkiwm983mtfdy` (`offer_id`),
  CONSTRAINT `FK_ka64qhvamgy6mkiwm983mtfdy` FOREIGN KEY (`offer_id`) REFERENCES `offer` (`id`),
  CONSTRAINT `FK_puensrfaci9xi45qwxwrd1jqf` FOREIGN KEY (`basket_id`) REFERENCES `basket` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,2,1,1),(2,5,1,5),(3,1,1,4);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_in_topic`
--

DROP TABLE IF EXISTS `post_in_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_in_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `topic_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1erde7kjqbvv5a98ano1ju121` (`topic_id`),
  CONSTRAINT `FK_1erde7kjqbvv5a98ano1ju121` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_in_topic`
--

LOCK TABLES `post_in_topic` WRITE;
/*!40000 ALTER TABLE `post_in_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_in_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `section_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bwdhk5ql2q1fepkq3jeq20a9l` (`account_id`),
  KEY `FK_c8sks2s4jp6f7p28s9a6s4hlh` (`section_id`),
  CONSTRAINT `FK_bwdhk5ql2q1fepkq3jeq20a9l` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK_c8sks2s4jp6f7p28s9a6s4hlh` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tpx9llq6mx8il4lfjpq4gqt88` (`account_id`),
  CONSTRAINT `FK_tpx9llq6mx8il4lfjpq4gqt88` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `UK_stlxfukw77ov5w1wo1tm3omca` (`role`,`username`),
  KEY `FK_9ry105icat2dux14oyixybw9l` (`username`),
  CONSTRAINT `FK_9ry105icat2dux14oyixybw9l` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (2,'ROLE_USER','?user:da;'),(1,'ROLE_USER','tomek');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('?user:da;','','test'),('tomek','','tomek1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-04 16:57:36
