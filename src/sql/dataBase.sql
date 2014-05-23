DROP DATABASE IF EXISTS LibrosVentas;
CREATE DATABASE  IF NOT EXISTS LibrosVentas;
USE LibrosVentas;


CREATE TABLE IF NOT EXISTS temas(
    IdTema int(2) unsigned AUTO_INCREMENT PRIMARY KEY,
    Tema VARCHAR(30)
);

INSERT INTO `temas` VALUES
(1,'Informática'),
(2,'Matemáticas'),
(3,'Novela'),
(4,'Viajes'),
(5,'Belleza'),
(6,'Deportes'),
(7,'Astronomía');


CREATE TABLE Provincias(
    IdProvincia Int(2) AUTO_INCREMENT Primary key,
    Provincia VARCHAR(40)
);

INSERT INTO `Provincias` VALUES 
(1, 'Álava'),
(2, 'Albacete'),
(3, 'Alicante'),
(4, 'Almería'),
(5, 'Ávila'),
(6, 'Badajoz'),
(7, 'Baleares (Illes)'),
(8, 'Barcelona'),
(9, 'Burgos'),
(10, 'Cáceres'),
(11, 'Cádiz'),
(12, 'Castellón'),
(13, 'Ciudad Real'),
(14, 'Córdoba'),
(15, 'A Coruña'),
(16, 'Cuenca'),
(17, 'Girona'),
(18, 'Granada'),
(19, 'Guadalajara'),
(20, 'Guipúzcoa'),
(21, 'Huelva'),
(22, 'Huesca'),
(23, 'Jaén'),
(24, 'León'),
(25, 'Lleida'),
(26, 'La Rioja'),
(27, 'Lugo'),
(28, 'Madrid'),
(29, 'Málaga'),
(30, 'Murcia'),
(31, 'Navarra'),
(32, 'Ourense'),
(33, 'Asturias'),
(34, 'Palencia'),
(35, 'Las Palmas'),
(36, 'Pontevedra'),
(37, 'Salamanca'),
(38, 'Santa Cruz de Tenerife'),
(39, 'Cantabria'),
(40, 'Segovia'),
(41, 'Sevilla'),
(42, 'Soria'),
(43, 'Tarragona'),
(44, 'Teruel'),
(45, 'Toledo'),
(46, 'Valencia'),
(47, 'Valladolid'),
(48, 'Vizcaya'),
(49, 'Zamora'),
(50, 'Zaragoza'),
(51, 'Ceuta'),
(52, 'Melilla');
 
 

 CREATE TABLE IF NOT EXISTS `Editoriales` (
  IdEditorial int(4) unsigned AUTO_INCREMENT PRIMARY KEY,
  Nombre     varchar(40),
  Direccion  varchar(50),
  Poblacion  varchar(25),
  IdProvincia  int(2),  
  CodPostal  char(5) ,
  Nif        char(9) Unique,
  Telefono  char(9),
  Fax        char(9),
  Email      varchar(40) unique,
  Web        varchar(40) unique,
  NombreContacto varchar(40),
  FOREIGN KEY (IdProvincia) REFERENCES `provincias` (IdProvincia)
  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `editoriales` VALUES
(1,'Ediciones Paraninfo S.A.','Avda. Filipinas, 50, Bajo, Dcha. puerta A',
'Madrid',28,'28003','A81461477','902995240',null, null, 'http://www.paraninfo.es', 'Patricia García'),
(2,'MCGRAWHILL','C/ Basauri, 17, 1ª Planta','Aravaca',28,'28023','B28914323', '911803000',null, null, 'http://www.mcgraw-hill.es/', 'Raquel Huertas'),
(3,'RA-MA, S.A. Editorial y Publicaciones','Cl. Jarama, 3A Polígono Industrial IGARSA','Paracuellos de Jarama',28, '28860','M16584280', '916628139', '916628131','editorial@ra-ma.com','http://www.ra-ma.es/', 'Rocio García'),
(4,'Editorial Planeta, S.A.U.','Avda Diagonal 662-664','Barcelona',8,'08034','A08186249','934928978',null,'viajeros@geoplaneta.es','www.editorial.planeta.es','Roberto Rodríguez' ),
(5,'ALFAGUARA','Calle Torrelaguna, 60','Madrid',28,'28043','A0818624X','917449060','917449224','alfaguara@santillana.es','http://www.alfaguara.com/es/', 'Isidoro Moreno'),
(6, 'Anaya', 'Calle San Francisco, 30 A', 'Madrid', 28, '28014', 'A0012514C', '917458458', '963547852', 'info@anaya.es', 'www.anaya.com', 'Rosario Vázquez');

--
-- Table structure for table `clientes`
--


CREATE TABLE `clientes` (
  `Idcliente` int(8) unsigned AUTO_INCREMENT Primary Key,
  `Nombre` varchar(40),
  `Direccion` varchar(50),
  `Poblacion` varchar(50),
  `CodPostal` char(5),
  `IdProvincia` int(2),
  `NIF` char(9) unique,
  `Telefono` char(9),
  `Fax` char(9),
  `Email` varchar(45),
  `Fecha` date,
   FOREIGN KEY (`IdProvincia`) REFERENCES `provincias` (`IdProvincia`)
   ON DELETE CASCADE ON UPDATE CASCADE
) ;


--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` VALUES 
(1,'CP Rio Tajo','C/Las Flores 23','Guadalajara','19003',19,'34343434L','949876655','949876655','cpriotajo@gmail.com','2011/03/24'),
(2,'IES Brianda de Mendoza','C/Hnos Fernández Galiano 6','Guadalajara','19004',19,'76767667F','949772211','949256376','brianda@correo.es','2011/03/20'),
(3,'Manuel Fernández','Avenida del Atance 24','Guadalajara','19008',19,'22234567E','94980009','949800090','manuel@correo.es','2011-2-28'),
(4,'Alicia Perez González','C/La Azucena 123','Talavera de La Reina','45678',45,'56564564J','925678090','','alicia@sucorreo.es','2011-05-21'),
(5,'Academia Central','C/Espliego 25, Polig Industrial Balconcillo','Azuqueca de Henares','19008',19,'23124234G','949008866','949008866','academia@central.es','2011-07-12'),
(6, 'Ayuntamiento de Ubrique', 'La Plaza, 1', 'Ubrique', '11600', 11, 'E2333213R', '956461290', '956463230', 'info@aytoubrique.es', '2012-08-11'),
(7, 'IES Ntra. Sra. Los Remedios', 'Avd. Herrera Oria, s/n', 'Ubrique', '11600', 11, 'E1212121R', '956461293', '956847841', 'info@ieslosremedios.org', '2013-08-10');


--
-- Table structure for table `libros`
--



CREATE TABLE `libros` (
  `IdLibro` int(8) unsigned AUTO_INCREMENT Primary Key,
  `ISBN` char(13) unique,
  `EAN` char(13) unique,
  `TITULO` varchar(80) NOT NULL,
  `AUTORES` varchar(80) NOT NULL,
  `IdEditorial` int(4) unsigned,
  `IdTema` int(2) unsigned,
  `PRECIOCOSTE` decimal(8,2) DEFAULT '0.00',
  `PVPSINIVA` decimal(8,2) DEFAULT '0.00',
  `STOCKACTUAL` int(8) DEFAULT '0',
  `STOCKMINIMO` int(8) unsigned DEFAULT '0',
  `STOCKMAXIMO` int(8) unsigned DEFAULT '0',
  FechaEdicion date,
  FOREIGN KEY (`IdEditorial`) REFERENCES `editoriales` (`IdEditorial`)
  ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`IdTema`) REFERENCES `temas` (`IdTema`)
  ON DELETE CASCADE ON UPDATE CASCADE
);

--
-- Dumping data for table `libros`
--

INSERT INTO `libros` VALUES 
(1,'8497325524','9788497325523','Operaciones Bases de Datos','ALICIA Y MARIA JESÚS RAMOS MARTÍN',1,2,'20.00','30.00',16,1,20,'2011-05-10'),
(2,'8448199588','9788448199586','Instalación y Mantenimiento de Equipos','M.J.RAMOS, A.RAMOS, S. RUBIO',2,3,'22.00','34.00',15,1,20,'2011-09-23'),
(3,'844814760X','9788448147600','Desarrollo Aplicaciones Entorno','M.J.RAMOS, A.RAMOS, F.MONTERO',2,3,'24.00','38.32',18,2,21,'2011-10-30'),
(4,'8448148797','9788448148799','Sistemas Gestores de Bases de Datos','M.J.RAMOS, A.RAMOS, F.MONTERO',2,3,'25.00','34.23',14,1,15,'2011-01-21'),
(5,'9788408096511',null,'Camboya','Nick Ray,D.Robinson,G.Bloom',4,1,'20.00','24.00',8,1,10,'2011-01-21'),
(6,'9788408086833',null,'Atlas de los exploradores españoles','Andrea de Porti',4,1,'30.00','45.00',6,1,7,'2011-02-10'),
(7,'9788420405094',null,'CAIN','José Saramago',5,5,'12.00','17.20',7,1,10,'2011-11-20'),
(8,'9788497328135',null,'Aplicaciones Web','ALICIA Y MARÍA JESÚS RAMOS MARTÍN',1,2,'22.00',25.00,15,1,20,'2011-10-06'),
(9,'9788448170783',null,'Montaje y Mantenimiento de Equipos','M. JESÚS RAMOS, ALICIA RAMOS, SANTIAGO VIÑAS',2,3,25.00,30.00,5,1,10,'2011-03-20'),
(10, '9788448170785', null, 'Programación en PHP Orientada a Objetos', 'Carlos Caballero', 3, 1, 17, 25, 10, 3, 30, '2014-04-10'),
(11, '9788448170786', null, 'Desarrollo Web con PHP y MSQL', 'Luke Welling y Laura Thonson', 6, 1, 20, 30, 12, 3, 30, '2013-04-10'),
(12, '9788448170787', null, 'La Vida del Lazarillo de Tormes', 'Anónimo', 3, 3, 10, 13, 12, 3, 30, '2012-03-10'),
(13, '9788448170788', null, 'Le Petit Prince', 'Saint Exupery', 5, 3, 10.30, 12, 12, 3, 30, '2012-01-11'),
(14, '9788448170789', null, 'Pepita Jiménez', 'Juan Valera', 5, 3, 9.30, 12.30, 11, 2, 16, '2014-04-11'),
(15, '9788448170790', null, 'Cantar de Mio cid', 'Anónimo', 6, 3, 8.30, 9.50, 1, 1, 30, '2010-01-11'),
(16, '9788448170791', null, 'Cien Años de Soledad', 'Gabriel García Márquez', 6, 3, 20.30, 25.60, 20, 3, 30, '2010-06-11'),
(17, '9788448170792', null, 'Dioses Clásicos de la Mitología', 'Morgan Roberts', 5, 3, 5.30, 12, 6, 3, 10, '2012-12-11'),
(18, '9788448170793', null, 'La Historia Interminable', 'Mikel Ende', 5, 4, 10.30, 15, 6, 2, 10, '1985-12-11');


--
-- Table structure for table `ventas`
--


CREATE TABLE `ventas` (
  `IdVenta` int(8) unsigned AUTO_INCREMENT,
  `IdCliente` int(8) unsigned,
  `FechaVenta` date,
  `ImporteBruto` decimal(10,2) NOT NULL,
  `ImporteIva` decimal(10,2) NOT NULL,
  `ImporteTotal` decimal(10,2),
  PRIMARY KEY (`IdVenta`),
  FOREIGN KEY (`IdCliente`) REFERENCES `clientes` (`IdCliente`)
  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `ventas` VALUES 
(1,3,'2012-02-18',122.32,4.89,127.21),
(2,6,'2013-01-18',364.00,76.44,440.44),
(3,4,'2014-01-15',256.00,53.71,309.76),
(4,7,'2014-01-15',1311.00,275.31,1586.31),
(5,5,'2014-03-15',1129.20,237.13,1366.33),
(6,1,'2014-03-24',1617.5,339.68,1957.18),
(7,7,'2014-03-26',2787.00,585.27,3372.27),
(8,6,'2014-03-25',633.00,132.93,765.93),
(9,7,'2014-03-25',430.00,90.30,520.30),
(10,1,'2014-03-21',243.00,51.30,294.03);
--
-- Table structure for table `lineasventas`
--


CREATE TABLE `lineasventas` (
  `IdLineaVenta` int(8) unsigned AUTO_INCREMENT,
  `IdVenta` int(8) unsigned NOT NULL,
  `NumeroLinea` int(8) unsigned NOT NULL,
   IdLibro int(8) unsigned, 
   Iva decimal(3,2) not null,
  `Cantidad` mediumint(8) unsigned NOT NULL,
  `PvpSinIva` decimal(8,2) NOT NULL,
  `Importe` decimal(10,2) NOT NULL,
  PRIMARY KEY (`IdLineaVenta`),
  UNIQUE (`IdVenta`,`NumeroLinea`),
  FOREIGN KEY (`IdVenta`) REFERENCES `ventas` (`IdVenta`)
  ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`IdLibro`) REFERENCES `libros` (`IdLibro`)
  ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO `lineasventas` VALUES 
-- Venta 1
(1,1,1,1,0.18,1, 38.32,38.32),
(2,1,2,2,0.18,2,34.00,68.00),
(3,1,3,3,0.18,2,25.00,50.00),
(4,1,4,4,0.18,4,25.00,100.00),
(5,1,5,5,0.18,5,30.00,150.00),

-- Venta 2
(6,2,1,5,0.21,10, 24.00,240.00),
(7,2,2,6,0.21,2,45.00,90.00),
(8,2,3,7,0.21,2,17.20,34.40),

-- Venta 3
 (9,3,1,4,0.21,4,34.00,136.00),
(10,3,2,5,0.21,5,24.00,120.00),

-- Venta 4
(11,4,1,6,0.21,10, 45.00,450.00),
(12,4,2,7,0.21,5,17.20,86.00),
(13,4,3,8,0.21,3,25.00,75.00),
(14,4,4,9,0.21,20,30.00,600.00),
(15,4,5,10,0.21,4,25.00,100.00),

-- Venta 5
(16,5,1,11,0.21,10, 25.00,250.00),
(17,5,2,12,0.21,7,30.00,210.00),
(18,5,3,13,0.21,30,13.00,260.00),
(19,5,4,14,0.21,20,12.00,360.00),
(20,5,5,15,0.21,4,12.30,49.20),

-- Venta 6
(21,6,1,14,0.21,10, 12.30,123.00),
(22,6,2,15,0.21,5,9.50,142.50),
(23,6,3,16,0.21,20,25.60,512.00),
(24,6,4,17,0.21,30,12.00,360.00),
(25,6,5,13,0.21,40,12.00,480.20),

-- Venta 7
(26,7,1,5,0.21,10, 24.00,240.00),
(27,7,2,7,0.21,15,12.20,183.00),
(28,7,3,10,0.21,20,25.00,500.00),
(29,7,4,13,0.21,30,12.00,360.00),
(30,7,5,16,0.21,40,25.60,1024.00),
(31,7,6,17,0.21,40,12.00,480.00),

-- Venta 8
(32,8,1,6,0.21,10, 45.00,450.00),
(33,8,2,7,0.21,15,12.20,183.00),

-- Venta 9
(34,9,1,11,0.21,10, 30.00,300.00),
(35,9,2,12,0.21,10,13.00,130.00),

-- Venta 10
(36,10,1,13,0.21,10, 12.00,120.00),
(37,10,2,14,0.21,10,12.30,123.00);

