-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 19 mai 2024 à 19:23
-- Version du serveur : 8.0.31
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `demo`
--

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `idcourse` int NOT NULL AUTO_INCREMENT,
  `course` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `degree` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idcourse`),
  UNIQUE KEY `idcourse_UNIQUE` (`idcourse`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `course`
--

INSERT INTO `course` (`idcourse`, `course`, `description`, `degree`) VALUES
(3, 'Anglais', 'Anglais', 'Supérieur'),
(5, 'Math', 'Maths Appliquée2', 'Supérieur');

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `idstudent` int NOT NULL AUTO_INCREMENT,
  `studentNum` bigint NOT NULL,
  `year` varchar(100) NOT NULL,
  `course` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `birth` date DEFAULT NULL,
  `status` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`idstudent`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `student`
--

INSERT INTO `student` (`idstudent`, `studentNum`, `year`, `course`, `firstName`, `lastName`, `gender`, `birth`, `status`, `image`, `date`) VALUES
(8, 732649, 'Licence', 'Anglais', 'Logre', 'Trolli', 'Féminin', '2004-05-01', 'Accepté', 'C:\\\\Users\\\\hugob\\\\OneDrive\\\\Images\\\\Honkai\\\\Capture d\'écran 2024-02-29 034829.png', '2024-05-17'),
(7, 8723452, 'Première année', 'Math', 'Libra', 'Lionn', 'Masculin', '2010-05-04', 'Accepté', '', '2024-05-17'),
(9, 893424, 'Seconde année', 'Anglais', 'Eve', 'Evelynn', 'Féminin', '2014-05-08', 'Accepté', 'C:\\\\Users\\\\hugob\\\\OneDrive\\\\Images\\\\Honkai\\\\Capture d\'écran 2024-02-29 034547.png', '2024-05-18');

-- --------------------------------------------------------

--
-- Structure de la table `student_grade`
--

DROP TABLE IF EXISTS `student_grade`;
CREATE TABLE IF NOT EXISTS `student_grade` (
  `idstudent_grade` int NOT NULL AUTO_INCREMENT,
  `studentNum` bigint NOT NULL,
  `year` varchar(100) NOT NULL,
  `course` varchar(100) NOT NULL,
  `first_sem` double NOT NULL,
  `second_sem` double NOT NULL,
  `final` double NOT NULL,
  PRIMARY KEY (`idstudent_grade`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `student_grade`
--

INSERT INTO `student_grade` (`idstudent_grade`, `studentNum`, `year`, `course`, `first_sem`, `second_sem`, `final`) VALUES
(3, 732649, 'Licence', 'Anglais', 2, 3, 3.5),
(2, 8723452, 'Seconde année', 'Math', 2, 5, 4.5),
(4, 893424, 'Seconde année', 'Anglais', 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `user_accounts`
--

DROP TABLE IF EXISTS `user_accounts`;
CREATE TABLE IF NOT EXISTS `user_accounts` (
  `iduser_accounts` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser_accounts`),
  UNIQUE KEY `iduser_accounts_UNIQUE` (`iduser_accounts`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user_accounts`
--

INSERT INTO `user_accounts` (`iduser_accounts`, `lastname`, `firstname`, `username`, `password`) VALUES
(6, 'admin', 'admin', 'admin', 'admin1'),
(7, 'azer', 'azer', 'aezr', 'azer');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
