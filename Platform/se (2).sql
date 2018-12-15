-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2018 at 03:47 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `se`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `cnp` varchar(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL,
  `external_email` varchar(30) DEFAULT NULL,
  `internal_email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`cnp`, `name`, `surname`, `pass`, `external_email`, `internal_email`) VALUES
('3', 'n', 'n', 's', 'e', 'r'),
('64', NULL, NULL, 'a', 'test', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

CREATE TABLE `assignment` (
  `id` int(11) NOT NULL,
  `course_name` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `deadline` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assignment`
--

INSERT INTO `assignment` (`id`, `course_name`, `name`, `deadline`) VALUES
(1, 'cname', 't1', '2018-05-01'),
(2, 'cname', 't2', '2018-05-01'),
(3, 'cname', 't3', '2018-04-03'),
(4, 'c1', 'tes', '2018-04-03'),
(5, 'coursee', 'ass', '2016-12-12');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_name` varchar(30) NOT NULL,
  `specialization` varchar(30) NOT NULL,
  `teacherCNP` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_name`, `specialization`, `teacherCNP`) VALUES
('23', '2131', '123'),
('c1', 'ce', '123'),
('cname', 'ce', '123'),
('coursee', 'a', '98'),
('frame0', 'a', '123');

-- --------------------------------------------------------

--
-- Table structure for table `mail`
--

CREATE TABLE `mail` (
  `id` int(11) NOT NULL,
  `fromCNP` varchar(11) NOT NULL,
  `toCNP` varchar(11) NOT NULL,
  `message` varchar(300) NOT NULL,
  `subject` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mail`
--

INSERT INTO `mail` (`id`, `fromCNP`, `toCNP`, `message`, `subject`) VALUES
(1, '1', '2', 'n', 'm'),
(2, '2', '1', 'message', 'subj'),
(3, '1', '1', 'dasda', 's'),
(4, '1', '2', '3', '4');

-- --------------------------------------------------------

--
-- Table structure for table `specialization`
--

CREATE TABLE `specialization` (
  `specializationName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `specialization`
--

INSERT INTO `specialization` (`specializationName`) VALUES
('2131'),
('a'),
('ce');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `cnp` varchar(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `external_email` varchar(50) DEFAULT NULL,
  `internal_email` varchar(50) DEFAULT NULL,
  `specialization` varchar(50) DEFAULT NULL,
  `study_year` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`cnp`, `name`, `surname`, `password`, `external_email`, `internal_email`, `specialization`, `study_year`) VALUES
('1', 'nume', 'prenume', NULL, NULL, NULL, NULL, NULL),
('11', '2', '3', '', NULL, '', 'a', 1),
('2', 'nume', 'prenume', NULL, NULL, NULL, NULL, NULL),
('23', 's', 's', 'a', NULL, '', 'a', 4),
('5', '2', '3', 'ew', NULL, 'ew', 'a', 1),
('99', 'nume', 'student', 'a', NULL, '', 'a', 2),
('a', 'a', 'a', 'a', NULL, 'a', 'a', 1);

-- --------------------------------------------------------

--
-- Table structure for table `student_assignment`
--

CREATE TABLE `student_assignment` (
  `student_id` varchar(11) NOT NULL,
  `assignment_id` int(11) NOT NULL,
  `lastUpdate` date DEFAULT NULL,
  `grade` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_assignment`
--

INSERT INTO `student_assignment` (`student_id`, `assignment_id`, `lastUpdate`, `grade`) VALUES
('1', 1, NULL, 6),
('1', 2, '2018-05-02', 10),
('1', 3, NULL, 5),
('2', 1, '2018-05-02', 6),
('2', 2, '2018-05-02', 3);

-- --------------------------------------------------------

--
-- Table structure for table `stud_enrolled_courses`
--

CREATE TABLE `stud_enrolled_courses` (
  `studentCNP` varchar(11) NOT NULL,
  `courseName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stud_enrolled_courses`
--

INSERT INTO `stud_enrolled_courses` (`studentCNP`, `courseName`) VALUES
('1', 'c1'),
('1', 'cname');

-- --------------------------------------------------------

--
-- Table structure for table `stud_pending_courses`
--

CREATE TABLE `stud_pending_courses` (
  `studentCNP` varchar(11) NOT NULL,
  `courseName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stud_pending_courses`
--

INSERT INTO `stud_pending_courses` (`studentCNP`, `courseName`) VALUES
('99', 'c1'),
('99', 'frame0');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `cnp` varchar(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `external_email` varchar(50) DEFAULT NULL,
  `internal_email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`cnp`, `name`, `surname`, `password`, `external_email`, `internal_email`) VALUES
('123', 'test', NULL, NULL, NULL, NULL),
('98', 'teacher', '', 'a', NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userCNP` varchar(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userCNP`, `name`, `surname`, `role`) VALUES
('64', 'fsd', 'gfd', 'admin'),
('98', '', '', 'teacher'),
('99', '', '', 'student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`cnp`);

--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `course_name` (`course_name`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_name`),
  ADD KEY `specialization` (`specialization`),
  ADD KEY `teacherCNP` (`teacherCNP`);

--
-- Indexes for table `mail`
--
ALTER TABLE `mail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fromCNP` (`fromCNP`),
  ADD KEY `toCNP` (`toCNP`);

--
-- Indexes for table `specialization`
--
ALTER TABLE `specialization`
  ADD PRIMARY KEY (`specializationName`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`cnp`);

--
-- Indexes for table `student_assignment`
--
ALTER TABLE `student_assignment`
  ADD PRIMARY KEY (`student_id`,`assignment_id`),
  ADD KEY `assignment_id` (`assignment_id`);

--
-- Indexes for table `stud_enrolled_courses`
--
ALTER TABLE `stud_enrolled_courses`
  ADD PRIMARY KEY (`studentCNP`,`courseName`),
  ADD KEY `courseName` (`courseName`);

--
-- Indexes for table `stud_pending_courses`
--
ALTER TABLE `stud_pending_courses`
  ADD PRIMARY KEY (`studentCNP`,`courseName`),
  ADD KEY `courseName` (`courseName`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`cnp`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userCNP`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignment`
--
ALTER TABLE `assignment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `mail`
--
ALTER TABLE `mail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignment`
--
ALTER TABLE `assignment`
  ADD CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`course_name`) REFERENCES `course` (`course_name`);

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`specialization`) REFERENCES `specialization` (`specializationName`),
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`teacherCNP`) REFERENCES `teacher` (`cnp`);

--
-- Constraints for table `student_assignment`
--
ALTER TABLE `student_assignment`
  ADD CONSTRAINT `student_assignment_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`cnp`),
  ADD CONSTRAINT `student_assignment_ibfk_2` FOREIGN KEY (`assignment_id`) REFERENCES `assignment` (`id`);

--
-- Constraints for table `stud_enrolled_courses`
--
ALTER TABLE `stud_enrolled_courses`
  ADD CONSTRAINT `stud_enrolled_courses_ibfk_1` FOREIGN KEY (`studentCNP`) REFERENCES `student` (`cnp`),
  ADD CONSTRAINT `stud_enrolled_courses_ibfk_2` FOREIGN KEY (`courseName`) REFERENCES `course` (`course_name`);

--
-- Constraints for table `stud_pending_courses`
--
ALTER TABLE `stud_pending_courses`
  ADD CONSTRAINT `stud_pending_courses_ibfk_1` FOREIGN KEY (`studentCNP`) REFERENCES `student` (`cnp`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stud_pending_courses_ibfk_2` FOREIGN KEY (`courseName`) REFERENCES `course` (`course_name`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
