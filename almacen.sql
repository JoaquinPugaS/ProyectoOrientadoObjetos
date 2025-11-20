-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2025 a las 06:49:01
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `almacen`
--
CREATE DATABASE IF NOT EXISTS almacen;

use almacen;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `idDetalleVenta` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `idInventario` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`idDetalleVenta`, `idVenta`, `idInventario`, `cantidad`) VALUES
(1, 8, 3, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `idInventario` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `stockCritico` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`idInventario`, `idProducto`, `stockCritico`, `stock`) VALUES
(1, 1, 10, 50),
(2, 2, 5, 30),
(3, 3, 8, 30),
(4, 4, 5, 60),
(5, 5, 12, 70);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `cdtpMarca` int(11) NOT NULL,
  `cdtpUnidadMedida` int(11) NOT NULL,
  `cdtpClase` int(11) NOT NULL,
  `medida` int(11) NOT NULL,
  `nmProducto` varchar(22) NOT NULL,
  `precioProducto` int(11) NOT NULL,
  `fcIngreso` datetime NOT NULL,
  `fcExpiracion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `cdtpMarca`, `cdtpUnidadMedida`, `cdtpClase`, `medida`, `nmProducto`, `precioProducto`, `fcIngreso`, `fcExpiracion`) VALUES
(1, 3, 2, 1, 1500, 'Coca-Cola 1.5L', 1800, '2025-11-20 00:39:12', NULL),
(2, 1, 3, 3, 500, 'Pan de Molde Ideal', 1600, '2025-11-20 00:39:12', NULL),
(3, 4, 2, 2, 1000, 'Leche Entera Colun 1L', 1200, '2025-11-20 00:39:12', NULL),
(4, 5, 3, 4, 400, 'Tallarines Carozzi 400', 900, '2025-11-20 00:39:12', NULL),
(5, 2, 3, 4, 1000, 'Arroz Grado 1 1Kg', 1300, '2025-11-20 00:39:12', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tpclase`
--

CREATE TABLE `tpclase` (
  `cdtpClase` int(11) NOT NULL,
  `nmClase` varchar(22) NOT NULL,
  `lgEliminado` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tpclase`
--

INSERT INTO `tpclase` (`cdtpClase`, `nmClase`, `lgEliminado`) VALUES
(1, 'Bebidas', '0'),
(2, 'Lácteos', '0'),
(3, 'Panadería', '0'),
(4, 'Abarrotes', '0'),
(5, 'Snacks', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tpmarca`
--

CREATE TABLE `tpmarca` (
  `cdtpMarca` int(11) NOT NULL,
  `nmMarca` varchar(20) NOT NULL,
  `lgEliminado` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tpmarca`
--

INSERT INTO `tpmarca` (`cdtpMarca`, `nmMarca`, `lgEliminado`) VALUES
(1, 'Ideal', '0'),
(2, 'Lider', '0'),
(3, 'Coca-Cola', '0'),
(4, 'Colun', '0'),
(5, 'Carozzi', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tpmedida`
--

CREATE TABLE `tpmedida` (
  `cdtpUnidadMedida` int(11) NOT NULL,
  `nmUnidadMedida` varchar(12) NOT NULL,
  `lgEliminado` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tpmedida`
--

INSERT INTO `tpmedida` (`cdtpUnidadMedida`, `nmUnidadMedida`, `lgEliminado`) VALUES
(1, 'Unidad', '0'),
(2, 'Litro', '0'),
(3, 'Gramos', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tpmetodopago`
--

CREATE TABLE `tpmetodopago` (
  `cdtpMetodoPago` int(11) NOT NULL,
  `nmMetodoPago` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tpmetodopago`
--

INSERT INTO `tpmetodopago` (`cdtpMetodoPago`, `nmMetodoPago`) VALUES
(1, 'Credito'),
(2, 'Debito'),
(3, 'Efectivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `fcIngreso` datetime NOT NULL,
  `cdtpMetodoPago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `fcIngreso`, `cdtpMetodoPago`) VALUES
(8, '2025-11-20 02:46:32', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`idDetalleVenta`),
  ADD KEY `idVenta` (`idVenta`),
  ADD KEY `idInventario` (`idInventario`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`idInventario`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `cdtpMarca` (`cdtpMarca`),
  ADD KEY `cdtpUnidadMedida` (`cdtpUnidadMedida`),
  ADD KEY `cdtpClase` (`cdtpClase`);

--
-- Indices de la tabla `tpclase`
--
ALTER TABLE `tpclase`
  ADD PRIMARY KEY (`cdtpClase`);

--
-- Indices de la tabla `tpmarca`
--
ALTER TABLE `tpmarca`
  ADD PRIMARY KEY (`cdtpMarca`);

--
-- Indices de la tabla `tpmedida`
--
ALTER TABLE `tpmedida`
  ADD PRIMARY KEY (`cdtpUnidadMedida`);

--
-- Indices de la tabla `tpmetodopago`
--
ALTER TABLE `tpmetodopago`
  ADD PRIMARY KEY (`cdtpMetodoPago`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `cdtpMetodoPago` (`cdtpMetodoPago`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `idDetalleVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `idInventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tpclase`
--
ALTER TABLE `tpclase`
  MODIFY `cdtpClase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tpmarca`
--
ALTER TABLE `tpmarca`
  MODIFY `cdtpMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tpmedida`
--
ALTER TABLE `tpmedida`
  MODIFY `cdtpUnidadMedida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tpmetodopago`
--
ALTER TABLE `tpmetodopago`
  MODIFY `cdtpMetodoPago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`),
  ADD CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`idInventario`) REFERENCES `inventario` (`idInventario`);

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`cdtpMarca`) REFERENCES `tpmarca` (`cdtpMarca`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`cdtpUnidadMedida`) REFERENCES `tpmedida` (`cdtpUnidadMedida`),
  ADD CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`cdtpClase`) REFERENCES `tpclase` (`cdtpClase`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`cdtpMetodoPago`) REFERENCES `tpmetodopago` (`cdtpMetodoPago`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
