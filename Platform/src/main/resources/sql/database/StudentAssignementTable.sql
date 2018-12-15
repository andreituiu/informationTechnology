create table student_assignment (
   student_id varchar(11)not null,
   assignment_id int NOT NULL,
   lastUpdate DATE NOT NULL,
   grade DOUBLE NOT NULL,
   PRIMARY KEY(student_id, assignment_id),
   FOREIGN KEY (student_id) REFERENCES student(cnp),
   FOREIGN KEY (assignment_id) REFERENCES assignment(id)
);