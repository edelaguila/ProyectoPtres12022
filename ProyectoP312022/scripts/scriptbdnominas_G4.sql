-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-04-2022 a las 02:14:06
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdnominas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_nomina`
--

CREATE TABLE `tbl_nomina` (
  `nomid` int(11) NOT NULL,
  `nomnombre` varchar(45) NOT NULL,
  `momcargo` varchar(45) NOT NULL,
  `nomdepartamento` varchar(45) NOT NULL,
  `nompercepciones` int(15) NOT NULL,
  `nomdeducciones` int(15) NOT NULL,
  `nomdiaslaborados` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_nomina`
--
ALTER TABLE `tbl_nomina`
  ADD PRIMARY KEY (`nomid`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_nomina`
--
ALTER TABLE `tbl_nomina`
  MODIFY `nomid` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
