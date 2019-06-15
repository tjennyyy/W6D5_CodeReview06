-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2019 at 03:33 PM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cr6`
--

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `studentID` int(11) NOT NULL,
  `className` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`studentID`, `className`) VALUES
(10, '1a'),
(9, '1a'),
(8, '1b'),
(7, '1b'),
(6, '2a'),
(5, '2a'),
(4, '2b'),
(3, '2b'),
(1, '2a'),
(2, '1a');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentID` int(11) NOT NULL,
  `studentName` varchar(30) NOT NULL,
  `studentSurname` varchar(30) NOT NULL,
  `studentEMail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `studentName`, `studentSurname`, `studentEMail`) VALUES
(1, 'John', 'Doe', 'john.doe@example.com'),
(2, 'Jane ', 'Dew', 'jane.dew@example.com'),
(3, 'Dwayne', 'Flow', 'dwayne.flow@example.com'),
(4, 'Isis', 'Moi', 'isis.moi@example.com'),
(5, 'Jack', 'Fine', 'jack.fine@example.com'),
(6, 'Jacky', 'Drew', 'jacky.drew@example.com'),
(7, 'Mark', 'Pane', 'mark.pane@example.com'),
(8, 'Mariah', 'Carrie', 'mariah.carrie@example.com'),
(9, 'Mike', 'Muster', 'mike.muster@example.com'),
(10, 'Maxina', 'Kluster', 'maxina.kluster@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacherID` int(11) NOT NULL,
  `teacherName` varchar(30) NOT NULL,
  `teacherSurname` varchar(30) NOT NULL,
  `teacherEMail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacherID`, `teacherName`, `teacherSurname`, `teacherEMail`) VALUES
(11, 'Klaus', 'Origin', 'klaus.origin@example.com'),
(22, 'Michelle', 'Pfeiffer', 'michelle.pfeiffer@example.com'),
(33, 'Hank', 'Booth', 'hank.booth@example.com'),
(55, 'Harriett', 'Noir', 'harriett.noir@example.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD KEY `studentID` (`studentID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacherID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `studentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacherID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
