USE test;
DROP TABLE IF EXISTS parts;
CREATE TABLE parts ( 
	id INT(11) NOT NULL AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	quantity INT(11) DEFAULT 1,
    type ENUM('CPU', 'RAM', 'HDD', 'MOTHERBOARD', 'SSD', 'GPU', 'SOUND_CARD', 'CASE') NOT NULL,
    PRIMARY KEY (id));

INSERT INTO parts (title, quantity, type) VALUES ('Процессор Core i3', 3, 'CPU');
INSERT INTO parts (title, quantity, type) VALUES ('Процессор Core i5', 5, 'CPU');
INSERT INTO parts (title, quantity, type) VALUES ('Процессор Core i7', 2, 'CPU');
INSERT INTO parts (title, quantity, type) VALUES ('Процессор Core i9', 1, 'CPU'); 
INSERT INTO parts (title, quantity, type) VALUES ('Модуль памяти Corsair DDR4 3200MHz 128Gb', 1, 'RAM');
INSERT INTO parts (title, quantity, type) VALUES ('Модуль памяти G.Skil DDR4 2933MHz 32Gb', 3, 'RAM');
INSERT INTO parts (title, quantity, type) VALUES ('Модуль памяти Kingston HyperX DDR4 3200MHz 32Gb', 2, 'RAM');
INSERT INTO parts (title, quantity, type) VALUES ('Модуль памяти Patriot Memory Viper DDR4 4133MHz 16Gb', 2, 'RAM');
INSERT INTO parts (title, quantity, type) VALUES ('Жесткий диск 2Tb - Seagate Barracuda ST2000DM008', 1, 'HDD');
INSERT INTO parts (title, quantity, type) VALUES ('Жесткий диск 2Tb - Western Digital WD20EZRZ', 1, 'HDD');
INSERT INTO parts (title, quantity, type) VALUES ('Жесткий диск 4Tb - Western Digital WD40EFRX', 1, 'HDD');
INSERT INTO parts (title, quantity, type) VALUES ('Материнская плата ASUS ROG STRIX Z390-F Gaming', 1, 'MOTHERBOARD');
INSERT INTO parts (title, quantity, type) VALUES ('Материнская плата ASRock Fatal1ty B250 Gaming K4', 3, 'MOTHERBOARD');
INSERT INTO parts (title, quantity, type) VALUES ('Материнская плата GigaByte B450 AORUS PRO', 2, 'MOTHERBOARD');
INSERT INTO parts (title, quantity, type) VALUES ('Материнская плата MSI X470 Gaming Plus', 1, 'MOTHERBOARD');
INSERT INTO parts (title, quantity, type) VALUES ('SSD диск 250Gb - Samsung 860 EVO MZ-76E250BW', 1, 'SSD');
INSERT INTO parts (title, quantity, type) VALUES ('SSD диск 240Gb - Western Digital WD Green WDS240G2G0A', 1, 'SSD');
INSERT INTO parts (title, quantity, type) VALUES ('SSD диск 1Tb - Samsung 860 EVO MZ-76E1T0BW', 1, 'SSD');
INSERT INTO parts (title, quantity, type) VALUES ('Видеокарта GigaByte GeForce GTX 1060 1556Mhz 6Gb', 1, 'GPU');
INSERT INTO parts (title, quantity, type) VALUES ('Видеокарта GigaByte GeForce RTX 2070 Windforce 1620Mhz 8Gb', 1, 'GPU');
INSERT INTO parts (title, quantity, type) VALUES ('Видеокарта ASUS GeForce RTX 2080 Ti 1575Mhz 11Gb', 1, 'GPU');
INSERT INTO parts (title, quantity, type) VALUES ('Видеокарта GigaByte GeForce GTX 1080 Ti 11Gb', 1, 'GPU');
INSERT INTO parts (title, quantity, type) VALUES ('Звуковая карта ASUS Xonar Essence STX II', 2, 'SOUND_CARD');
INSERT INTO parts (title, quantity, type) VALUES ('Звуковая карта Creative Sound Blaster ZxR SB1510', 1, 'SOUND_CARD');
INSERT INTO parts (title, quantity, type) VALUES ('Корпус Cougar Conquer', 1, 'CASE');
INSERT INTO parts (title, quantity, type) VALUES ('Корпус Thermaltake Level 20 XT Black', 3, 'CASE');
INSERT INTO parts (title, quantity, type) VALUES ('Корпус Corsair Crystal Series 570X RGB Red', 2, 'CASE');
INSERT INTO parts (title, quantity, type) VALUES ('Корпус NZXT Noctis 450 Black-Red', 2, 'CASE');