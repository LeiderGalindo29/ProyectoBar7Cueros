/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alrod
 * Created: 3/08/2022
 */

CREATE DATABASE BAR7CUEROS;

USE BAR7CUEROS;

CREATE TABLE Usuario(
id_usuario INTEGER AUTO_INCREMENT,
usuario_nombre VARCHAR(30),
usuario_apellido VARCHAR(30),
usuario_password VARCHAR(30),
usuario_estado INT,
id_rol INTEGER,
PRIMARY KEY(id_usuario)
);


CREATE TABLE Pedido(
id_pedido INTEGER AUTO_INCREMENT,
id_usuarioFK INTEGER,
id_mesaFK INTEGER,
id_clienteFK INT,
pedido_estado INT,
valor_pedido DOUBLE,
id_detalleFK INTEGER,
metodo_pago INT,
PRIMARY KEY(id_pedido)
);

CREATE TABLE Des_pedido(
id_desc INTEGER AUTO_INCREMENT,
id_productoFK INTEGER,
pedidoFK INTEGER,
PRIMARY KEY(id_desc)
);

CREATE TABLE Producto(
id_producto INTEGER AUTO_INCREMENT,
producto_nombre VARCHAR(30) UNIQUE,
producto_precio DOUBLE,
producto_estado INT,
PRIMARY KEY(id_producto)
);

CREATE TABLE Factura(
id_factura INTEGER AUTO_INCREMENT,
id_pedidoFK INT,
id_clienteFK INT,
valor_total DOUBLE,
PRIMARY KEY(id_factura)
);

CREATE TABLE Cliente(
id_cliente INTEGER AUTO_INCREMENT,
numero_documento INTEGER UNIQUE,
cliente_nombre VARCHAR(30),
cliente_apellido VARCHAR(30),
cliente_estado INT,
cliente_correo VARCHAR(30),
fecha_nacimiento DATE,
tipo_documento INT,
PRIMARY KEY(id_cliente)
);

CREATE TABLE Mesa(
id_mesa INTEGER AUTO_INCREMENT,
mesa_numero INTEGER,
mesa_estado INT,
PRIMARY KEY(id_mesa)
);

CREATE TABLE Detalle(
id_detalle INTEGER AUTO_INCREMENT,
producto_idFK INTEGER,
PRIMARY KEY(id_detalle)
);

ALTER TABLE PEDIDO ADD CONSTRAINT id_usuarioFK FOREIGN KEY(id_usuarioFK) REFERENCES USUARIO(id_usuario);

ALTER TABLE PEDIDO ADD CONSTRAINT id_mesaFK FOREIGN KEY(id_mesaFK ) REFERENCES MESA(id_mesa);

ALTER TABLE FACTURA ADD CONSTRAINT id_pedidoFK FOREIGN KEY(id_pedidoFK) REFERENCES PEDIDO(id_pedido);

ALTER TABLE PEDIDO ADD CONSTRAINT id_clienteFK FOREIGN KEY(id_clienteFK) REFERENCES CLIENTE(id_cliente);

ALTER TABLE DES_PEDIDO ADD CONSTRAINT id_productoFK FOREIGN KEY(id_productoFK) REFERENCES PRODUCTO(id_producto);

ALTER TABLE DES_PEDIDO ADD CONSTRAINT pedidoFK FOREIGN KEY(pedidoFK) REFERENCES PEDIDO(id_pedido);

ALTER TABLE Detalle ADD CONSTRAINT producto_idFK FOREIGN KEY(producto_idFK) REFERENCES Producto(id_producto);

ALTER TABLE Pedido ADD CONSTRAINT id_detalleFK FOREIGN KEY(id_detalleFK) REFERENCES Detalle(id_detalle);

DESCRIBE USUARIO;
DESCRIBE PEDIDO;
DESCRIBE MESA;
DESCRIBE DES_PEDIDO;
DESCRIBE FACTURA;
DESCRIBE PRODUCTO;
DESCRIBE CLIENTE;