CREATE TABLE TEACHER (
	cnp varchar(11) NOT NULL,
	name varchar(30) default NULL,
	surname varchar(30) default NULL,
	password varchar(50) default NULL,
	external_email varchar(50) default NULL,
	internal_email varchar(50) default NULL,
	PRIMARY KEY(cnp)
);