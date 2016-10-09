USE `mhacks8`;
DROP table IF EXISTS day;
DROP table IF EXISTS timeSchedule;
DROP table IF EXISTS medicine;
DROP table IF EXISTS patients;
DROP table IF EXISTS doctors;

CREATE TABLE doctors ( firstname VARCHAR(45) NOT NULL,
lastname VARCHAR(45) NOT NULL,
age int(2) NOT NULL,
address VARCHAR(100) NOT NULL,
phone VARCHAR(10) NOT NULL,
email VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
PRIMARY KEY(email)
) ENGINE=InnoDB;


CREATE TABLE patients ( firstname VARCHAR(45) NOT NULL,
lastname VARCHAR(45) NULL,
email VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
age int(2) NOT NULL,
address VARCHAR(100) NOT NULL,
phone VARCHAR (10) NOT NULL,
doctor VARCHAR(45) NOT NULL,
PRIMARY KEY (email),
FOREIGN KEY (doctor) REFERENCES doctors(email) ON DELETE CASCADE
) ENGINE=INNODB;


CREATE TABLE medicine ( id int NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
dosage int NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE timeSchedule (id int NOT NULL AUTO_INCREMENT,
medID int NOT NULL,
patientEmail VARCHAR (45) NOT NULL,
quantity int NOT NULL,
formOfConsumption VARCHAR(100) NOT NULL,
color VARCHAR(10) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (medID) REFERENCES medicine (id) ON DELETE CASCADE,
FOREIGN KEY (patientEmail) REFERENCES patients (email) ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE day ( id int NOT NULL AUTO_INCREMENT,
day VARCHAR(10) NOT NULL,
timee TIME NOT NULL,
usageId int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (usageId) REFERENCES timeSchedule(id) ON DELETE CASCADE
) ENGINE=InnoDB;