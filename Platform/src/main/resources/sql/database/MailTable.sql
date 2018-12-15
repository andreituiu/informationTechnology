CREATE TABLE mail (
	id INT NOT NULL auto_increment,
	fromCNP varchar(11) NOT NULL,
	toCNP varchar(11) NOT NULL,
	message varchar(300) NOT NULL,
	subject varchar(30) NOT NULL,
	PRIMARY KEY(id)
);