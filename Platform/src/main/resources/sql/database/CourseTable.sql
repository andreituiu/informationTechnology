CREATE TABLE course (
	course_name varchar(30) NOT NULL,
	specialization varchar(30) NOT NULL,
	teacherCNP varchar(11) NOT NULL,
	PRIMARY KEY(name)
	FOREIGN KEY (specialization) REFERENCES specialization(name)
);