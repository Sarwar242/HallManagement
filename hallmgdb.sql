-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 20, 2019 at 06:53 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hallmgdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `hallauthority`
--

DROP TABLE IF EXISTS `hallauthority`;
CREATE TABLE IF NOT EXISTS `hallauthority` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `HallPost` varchar(255) NOT NULL,
  `Teachersinfo` varchar(255) NOT NULL,
  `Dept` varchar(255) NOT NULL,
  `PhoneNo` varchar(255) NOT NULL,
  `Mail` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hallauthority`
--

INSERT INTO `hallauthority` (`Id`, `FirstName`, `LastName`, `HallPost`, `Teachersinfo`, `Dept`, `PhoneNo`, `Mail`) VALUES
(1, 'abab', 'jkd', 's,nAJ', 'SFL', 'JKDH', '17841278', 'HBDBKF');

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

DROP TABLE IF EXISTS `staffs`;
CREATE TABLE IF NOT EXISTS `staffs` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Post` varchar(255) NOT NULL,
  `Contact` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffs`
--

INSERT INTO `staffs` (`Id`, `FirstName`, `LastName`, `Post`, `Contact`) VALUES
(2, 'Huzur ', 'Khan', 'jjy', 'jyyyk');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `StudentId` varchar(255) NOT NULL,
  `HallId` varchar(255) NOT NULL,
  `RoomNo` varchar(255) NOT NULL,
  `PhoneNo` varchar(255) NOT NULL,
  `Dept` varchar(255) NOT NULL,
  `Sessions` varchar(255) NOT NULL,
  `Religion` varchar(255) NOT NULL,
  `District` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Id`, `FirstName`, `LastName`, `StudentId`, `HallId`, `RoomNo`, `PhoneNo`, `Dept`, `Sessions`, `Religion`, `District`) VALUES
(1, 'Sfhjh', 'j,Cj', 'scbscb', 'nmscbs', 'cnmsbs', 'scjjabjk', 'cmbs', 'jc', 'asbvsj', 'khulna');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
