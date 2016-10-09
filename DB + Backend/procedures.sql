USE `mhacks8`;
DROP procedure IF EXISTS `spAddMedicine`;
DELIMITER $$
USE `mhacks8`$$
CREATE PROCEDURE `spAddMedicine` (
IN p_name varchar(100),
IN p_dosage int
)
BEGIN
insert into medicine
(   
    name,
    dosage
)
values
(   
    p_name,
    p_dosage
);
END$$
DELIMITER ;

USE `mhacks8`;
DROP procedure IF EXISTS `spAddDoctor`;
DELIMITER $$
USE `mhacks8`$$
CREATE PROCEDURE `spAddDoctor`(
IN p_firstname varchar(45),
IN p_lastname varchar(45),
IN p_age int,
IN p_address varchar(100),
IN p_phone varchar(10),
IN p_email varchar(45),
IN p_password varchar(45)
)
BEGIN
insert into doctors
(
	email,
	password,
	firstname,
	lastname,
	age,
	address,
	phone
)
values
(
	p_email,
	p_password,
	p_firstname,
	p_lastname,
	p_age,
	p_address,
	p_phone
);
END$$

DELIMITER ;

USE `mhacks8`;
DROP procedure IF EXISTS `sp_authenticateDoctor`;

DELIMITER $$
USE `mhacks8`$$
CREATE procedure `sp_authenticateDoctor`(
IN p_email varchar(45)
)
BEGIN
if (select EXISTS (select 1 from doctors where email = p_email)) then
	select * from doctors where email = p_email;
else
	select 'Incorrect email';
end if;
end $$
DELIMITER ;



USE `mhacks8`;
DROP procedure IF EXISTS `spAddPatient`;
DELIMITER $$
USE `mhacks8`$$
CREATE PROCEDURE `spAddPatient`(
IN p_firstname varchar(45),
IN p_lastname varchar(45),
IN p_age int,
IN p_address varchar(100),
IN p_phone varchar(10),
IN p_email varchar(45),
IN p_password varchar(45),
IN p_doctor varchar(45)
)
BEGIN

if (select EXISTS (select 1 from doctors where email = p_doctor)) then

	insert into patients
	(
		email,
		password,
		firstname,
		lastname,
		age,
		address,
		phone,
		doctor
	)
	values
	(
		p_email,
		p_password,
		p_firstname,
		p_lastname,
		p_age,
		p_address,
		p_phone,
		p_doctor
	);

else
	select 'doctor does not exist';

end if;

END$$

DELIMITER ;


USE `mhacks8`;
DROP procedure IF EXISTS `sp_authenticatePatient`;

DELIMITER $$
USE `mhacks8`$$
CREATE procedure `sp_authenticatePatient`(
IN p_email varchar(45)
)
BEGIN
if (select EXISTS (select 1 from patients where email = p_email)) then
	select * from patients where email = p_email;
else
	select 'Incorrect email';
end if;
end $$
DELIMITER ;

USE `mhacks8`;
DROP PROCEDURE IF EXISTS `sp_addMeds`;

DELIMITER $$
USE `mhacks8`$$
CREATE PROCEDURE `sp_addMeds` (
IN p_medicine varchar(100),
IN p_dosage int,
IN p_med int,
IN p_patientemail varchar(45),
IN p_quantity int,
IN p_form varchar(100),
IN p_color varchar(10)
)
BEGIN

SET p_med = (select id from medicine where p_medicine = name and p_dosage = dosage LIMIT 1);

insert into timeSchedule
(
	medID,
	patientEmail,
	quantity,
	formOfConsumption,
	color
)
values
(
	p_med,
	p_patientemail,
	p_quantity,
	p_form,
	p_color
);
end $$
DELIMITER ;

DELIMITER $$
USE `mhacks8`$$
CREATE PROCEDURE `sp_addtime`(
IN p_medicine varchar(100),
IN p_patientemail varchar(45),
IN p_day varchar(10),
IN p_usageID int,
IN p_timee TIME
)
BEGIN
SET p_usageID = (select id from timeSchedule where medicine = p_medicine and p_patientemail = patientEmail LIMIT 1);

insert into day
(
	day,
	timee,
	usageId
)
values
(
	p_day,
	p_timee,
	p_usageID
);
end $$
DELIMITER ;

DELIMITER $$
USE `mhacks8`$$
CREATE PROCEDURE `sp_getPatients`(
IN p_doctor varchar(45)
)
select * from patients where p_doctor = doctors;
end $$
DELIMITER ;

DELIMITER $$
USE `mhacks8`$$
CREATE procedure `sp_allMedicine`(
IN p_patientemail
)
select medID from timeSchedule where patientEmail = p_patientemail;