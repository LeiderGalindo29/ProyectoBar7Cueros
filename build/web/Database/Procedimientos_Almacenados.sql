/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alrod
 * Created: 3/08/2022
 */
/*procedimientos almacenados*/

/*LOGIN*/

DELIMITER $$
CREATE PROCEDURE `login`(IN `user_name` VARCHAR(30), IN `user_password` VARCHAR(30), IN `user_rol` INT)
SELECT * FROM usuario
WHERE usuario_nombre=user_name and usuario_password=user_password and id_rol=user_rol$$
DELIMITER ;


/*REGISTRAR_PRODUCTO*/

DELIMITER $$
CREATE PROCEDURE `Registrar_Producto`(IN `nom_prod` VARCHAR(30), IN `precio_prod` DOUBLE, IN `prod_estado` INT)
INSERT INTO producto(producto_nombre, producto_precio, producto_estado) VALUES (nom_prod,precio_prod,prod_estado)$$
DELIMITER ;

/*SELECCIONAR PRODUCTOS*/
DELIMITER $$
CREATE PROCEDURE `Select_Productos`()
SELECT * FROM producto$$
DELIMITER ;

/*REGISTRAR MESA*/

DELIMITER $$
CREATE PROCEDURE `Registrar_Mesa`(IN `num_mesa` INT, IN `estado_mesa` INT)
INSERT INTO mesa(mesa_numero, mesa_estado) VALUES (num_mesa ,estado_mesa)$$
DELIMITER ;


/*Registrar Cliente*/

DELIMITER $$
CREATE PROCEDURE `Registrar_Cliente`(IN `num_doc` INT, IN `cliente_nombre` VARCHAR(30), IN `cliente_apellido` VARCHAR(30), IN `cliente_estado` INT, IN `cliente_correo` VARCHAR(30), IN `fecha_nac` DATE, IN `tipo_doc` INT)
INSERT INTO cliente(numero_documento, cliente_nombre, cliente_apellido, cliente_estado, cliente_corrreo, fecha_nacimiento, tipo_documento) 
VALUES (num_doc,cliente_nombre,cliente_apellido,cliente_estado,cliente_correo,fecha_nac,tipo_doc)$$
DELIMITER ;