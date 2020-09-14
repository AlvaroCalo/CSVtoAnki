-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 14, 2020 at 07:24 PM
-- Server version: 5.7.31-0ubuntu0.18.04.1
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2_working_sound_pair`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_words`
--

CREATE TABLE `data_words` (
  `Id` smallint(6) NOT NULL,
  `Words_Id` smallint(6) DEFAULT NULL,
  `IPA` varchar(1000) DEFAULT NULL,
  `Sound` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `data_words`
--

INSERT INTO `data_words` (`Id`, `Words_Id`, `IPA`, `Sound`) VALUES
(1, 1, '/liːv/', 'leave.mp3'),
(2, 1, '/liːv/', 'leave.mp3'),
(3, 1, '/liːvz/', 'leaves.mp3'),
(4, 1, '/left/', 'left.mp3'),
(5, 1, '/left/', 'left.mp3'),
(6, 1, '/ˈliːvɪŋ/', 'leaving.mp3'),
(7, 2, '/lɪv/', 'live.mp3'),
(8, 2, '/lɪv/', 'live.mp3'),
(9, 2, '/lɪvz/', 'lives.mp3'),
(10, 2, '/lɪvd/', 'lived.mp3');

-- --------------------------------------------------------

--
-- Table structure for table `words`
--

CREATE TABLE `words` (
  `Id` smallint(6) NOT NULL,
  `Word` varchar(1000) NOT NULL,
  `Scraped` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `words`
--

INSERT INTO `words` (`Id`, `Word`, `Scraped`) VALUES
(1, 'leave', 1),
(2, 'live', 1),
(3, 'field', 1),
(4, 'filled', 1),
(5, 'feel', 1),
(6, 'fill', 1),
(7, 'team', 1),
(8, 'Tim', 1),
(9, 'seat', 1),
(10, 'sit', 1);

-- --------------------------------------------------------

--
-- Table structure for table `word_pairs`
--

CREATE TABLE `word_pairs` (
  `Id` smallint(6) NOT NULL,
  `Pair_Num` char(15) NOT NULL,
  `Word1` smallint(6) NOT NULL,
  `Word2` smallint(6) NOT NULL,
  `CSV` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `word_pairs`
--

INSERT INTO `word_pairs` (`Id`, `Pair_Num`, `Word1`, `Word2`, `CSV`) VALUES
(1, 'pair:1', 1, 2, 0),
(2, 'pair:1', 3, 4, 0),
(3, 'pair:1', 5, 6, 0),
(4, 'pair:1', 7, 8, 0),
(5, 'pair:1', 9, 10, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_words`
--
ALTER TABLE `data_words`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Words_Id` (`Words_Id`);

--
-- Indexes for table `words`
--
ALTER TABLE `words`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `word_pairs`
--
ALTER TABLE `word_pairs`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Word1` (`Word1`),
  ADD KEY `Word2` (`Word2`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_words`
--
ALTER TABLE `data_words`
  MODIFY `Id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2143;

--
-- AUTO_INCREMENT for table `words`
--
ALTER TABLE `words`
  MODIFY `Id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=914;

--
-- AUTO_INCREMENT for table `word_pairs`
--
ALTER TABLE `word_pairs`
  MODIFY `Id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=598;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_words`
--
ALTER TABLE `data_words`
  ADD CONSTRAINT `data_words_ibfk_1` FOREIGN KEY (`Words_Id`) REFERENCES `words` (`Id`);

--
-- Constraints for table `word_pairs`
--
ALTER TABLE `word_pairs`
  ADD CONSTRAINT `word_pairs_ibfk_1` FOREIGN KEY (`Word1`) REFERENCES `words` (`Id`),
  ADD CONSTRAINT `word_pairs_ibfk_2` FOREIGN KEY (`Word2`) REFERENCES `words` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
