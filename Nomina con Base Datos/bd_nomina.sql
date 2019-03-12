-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-03-2019 a las 18:25:59
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_nomina`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bancos`
--

CREATE TABLE `bancos` (
  `bancodigo` varchar(5) NOT NULL,
  `bannombre` varchar(50) DEFAULT NULL,
  `bancuenta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE `concepto` (
  `concodigo` varchar(5) NOT NULL,
  `connombre` varchar(50) DEFAULT NULL,
  `conefecto` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `depcodigo` varchar(5) NOT NULL,
  `depnombre` varchar(50) DEFAULT NULL,
  `depestatus` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `empcodigo` varchar(5) NOT NULL,
  `empnombre` varchar(50) DEFAULT NULL,
  `depcodigo` varchar(5) DEFAULT NULL,
  `empestatus` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nominadetalles`
--

CREATE TABLE `nominadetalles` (
  `nomicodigo` varchar(5) NOT NULL,
  `empcodigo` varchar(5) NOT NULL,
  `concodigo` varchar(5) DEFAULT NULL,
  `nomidtotal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nominaencabezado`
--

CREATE TABLE `nominaencabezado` (
  `nomicodigo` varchar(5) NOT NULL,
  `nomifecha` date DEFAULT NULL,
  `nomimonto` int(11) DEFAULT NULL,
  `bancodigo` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `CodUsuario` int(10) NOT NULL,
  `NombreUsuario` varchar(15) COLLATE utf32_bin NOT NULL,
  `ContraUsuario` varchar(15) COLLATE utf32_bin NOT NULL,
  `EstatusUsuario` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`CodUsuario`, `NombreUsuario`, `ContraUsuario`, `EstatusUsuario`) VALUES
(1, 'Bryan', '123', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bancos`
--
ALTER TABLE `bancos`
  ADD PRIMARY KEY (`bancodigo`);

--
-- Indices de la tabla `concepto`
--
ALTER TABLE `concepto`
  ADD PRIMARY KEY (`concodigo`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`depcodigo`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`empcodigo`),
  ADD KEY `FK_departamentosempleados` (`depcodigo`);

--
-- Indices de la tabla `nominadetalles`
--
ALTER TABLE `nominadetalles`
  ADD PRIMARY KEY (`nomicodigo`),
  ADD KEY `FK_empleadosnominadetalle` (`empcodigo`),
  ADD KEY `FK_conceptonominadetalle` (`concodigo`);

--
-- Indices de la tabla `nominaencabezado`
--
ALTER TABLE `nominaencabezado`
  ADD PRIMARY KEY (`nomicodigo`),
  ADD KEY `FK_bancosnominaencabezado` (`bancodigo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`CodUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `CodUsuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
