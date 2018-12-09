create table assignment (
   id INT NOT NULL auto_increment,
   course_name varchar(30) NOT NULL,
   name VARCHAR(30) NOT NULL,
   deadline DATE NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY (course_name) REFERENCES course(name)
);
  