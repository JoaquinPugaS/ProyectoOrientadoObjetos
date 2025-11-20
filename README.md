###### Sistema de Gestión para Almacén de Barrio - README ######

Sistema de Inventario y Ventas para un almacén de barrio. Permite
gestionar productos, inventario, boletas y métodos de pago.

Equipo de Desarrollo: - Matías Ugarte
		                  - Joaquín Puga

Descripción del Sistema: Control de productos, marcas, clases, unidades
de medida, inventario, ventas y detalles de boletas. Modelo relacional
que asegura integridad de datos.

Instalación: 1. Crear base de datos: CREATE DATABASE almacenn; USE
almacenn;

2.  Importar el script SQL con las tablas.

Ejecución: - Insertar productos y stock. - Registrar ventas mediante
boletas y detalleboleta.

Ejemplos SQL: Consultar stock: SELECT p.nmProducto, i.stock FROM
inventario i JOIN producto p ON p.idProducto = i.idProducto;

Consultar ventas: SELECT b.idBoleta, b.fcIngreso, mp.nmMetodoPago FROM
boleta b JOIN tpmetodopago mp ON mp.cdtpMetodoPago = b.cdtpMetodoPago;

