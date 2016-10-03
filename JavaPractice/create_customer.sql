CREATE TABLE customer
(
	first_name VARCHAR(15) NOT NULL, 
	last_name VARCHAR(15) NOT NULL,
	state CHAR(2) NOT NULL DEFAULT "PA",
	birth_date DATE NOT NULL,
	sex ENUM('M','F'),
	cust_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	last_meeting TIMESTAMP,
	money_owed FLOAT NULL
);