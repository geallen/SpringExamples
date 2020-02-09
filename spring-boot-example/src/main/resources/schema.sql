DROP TABLE IF EXISTS TBL_EMPLOYEES;
  
CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS TODOS;

CREATE TABLE TODOS(
	id INT AUTO_INCREMENT PRIMARY KEY,
	user VARCHAR(250) NOT NULL,
	desc VARCHAR(250) NOT NULL,
	target_date DATE,
	is_done BOOLEAN
);
