create table STUD_ENROLLED_COURSES (
   studentCNP VARCHAR(11) NOT NULL,
   courseName VARCHAR(30) NOT NULL,
   PRIMARY KEY (studentCNP,courseName),
   FOREIGN KEY (studentCNP) REFERENCES student(cnp),
   FOREIGN KEY (courseName) REFERENCES course(name)
);