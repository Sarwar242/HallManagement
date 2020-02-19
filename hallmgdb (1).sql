-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 20, 2019 at 03:29 PM
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
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hallauthority`
--

INSERT INTO `hallauthority` (`Id`, `FirstName`, `LastName`, `HallPost`, `Teachersinfo`, `Dept`, `PhoneNo`, `Mail`) VALUES
(1, 'abab', 'abc', 's,nAJ', 'SFL', 'JKDH', '17841278', 'HBDBKF@gm.c'),
(3, 'shsjak', 'shahxvc', 'scd', 'sarm', 'aweqdf', '12314235', 'svsfsd@xmm.cc'),
(4, 'kmxsdn', 'smdss', 'wec', 'we', 'wew', '32525', 'dsgsdff'),
(5, 'njjj', 'sm', 'wec', 'we', 'wew', '32525', 'dsgsdff'),
(6, 'jamla', 'mamla', 'ekkkk', 'wewe', 'wewwe', '22232525', 'dddskds@ds//'),
(7, 'jamla', 'mamla', 'ekkkk', 'wewe', 'wewwe', '22232525', 'dddskds@ds//');

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
(2, 'Balod', 'Khan', 'jjy', 'jyyyk');

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
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Id`, `FirstName`, `LastName`, `StudentId`, `HallId`, `RoomNo`, `PhoneNo`, `Dept`, `Sessions`, `Religion`, `District`) VALUES
(1, 'Sfhjh', 'j,Cj', 'scbscb', 'nmscbs', 'cnmsbs', 'scjjabjk', 'cmbs', 'jc', 'asbvsj', 'khulna'),
(3, 'askfsm', 'smnfs', '3jjwm3', 'nmscbssedmf', '32234', '2325323425', 'sdm', '2321', 'sdnf', 'Dhaka'),
(4, 'jnkl.', 'hhlhkjk', '45656', '3344', '657657', '65657766656', 'jhgjhk', '7765', 'ghh', 'Barishal'),
(5, 'jamil', 'khan', '1223', '334455', '65766', '6565656', 'cse', '7765', 'islam', 'Barishal'),
(6, 'Sfhjhkl', 'jhghjgjk', '1334', '65666', '1388s', '65544267', 'lhg', '998', 'hggj', 'khulna'),
(7, 'Sfhjhkl', 'jhghjgjk', '1334', '65666', '1388s', '65544267', 'lhg', '998', 'hggj', 'khulna'),
(8, 'Chapabuzz', 'Miao', '3443', '\r 420', '420', '420', 'csm', '2014-15', 'Islam', 'Brsl');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
