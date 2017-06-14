create database basedatos;

use basedatos;

CREATE TABLE administradores
(	id_admin int(10) NOT NULL AUTO_INCREMENT,
	nick varchar(100) NOT NULL,
	nombre_admin varchar(100) NOT NULL,
	clave varchar(300) NOT NULL,
	CONSTRAINT id_admin_pk PRIMARY KEY(id_admin)
);

CREATE TABLE tipoAdmin
(
	id_tipo int(10) NOT NULL AUTO_INCREMENT,
	tipo varchar(40) NOT NULL,
	id_admin int(10) NOT NULL,
	CONSTRAINT id_tipo_pk PRIMARY KEY(id_tipo),
	FOREIGN KEY (id_admin) REFERENCES administradores(id_admin)
);

CREATE TABLE logs
(
	id_log int(10) NOT NULL AUTO_INCREMENT,
	contenido varchar(300),
	id_tipo int(10) NOT NULL,
	id_admin int(10) NOT NULL,
	CONSTRAINT id_log_pk PRIMARY KEY(id_log),
	CONSTRAINT id_tipo_fk FOREIGN KEY(id_tipo)
		REFERENCES tipoAdmin(id_tipo),
	CONSTRAINT id_admin_fk FOREIGN KEY(id_admin)
		REFERENCES administradores(id_admin)
);

CREATE TABLE tipos_de_tipos_anuncios
(
	id_tipos_de_tipos_anuncios int(10) NOT NULL AUTO_INCREMENT,
	descripcion varchar(300),
	CONSTRAINT tipos_de_tipos_anuncios_pk PRIMARY KEY(id_tipos_de_tipos_anuncios)
);

CREATE TABLE anuncios
(
	id_anuncios int(10) NOT NULL AUTO_INCREMENT,
	titulo varchar(300),
	descripcion varchar(300),
	url_foto_anuncio varchar(300),
	ubicacion varchar(300),
	contacto varchar(300),
	horarios varchar(300),
	fecha_anuncio varchar(300),
	CONSTRAINT id_anuncios_pk PRIMARY KEY(id_anuncios)
);

CREATE TABLE menu
(
	id_menu int(10) NOT NULL AUTO_INCREMENT,
	nombre_menu varchar(300),
	ingedientes varchar(300),
	precio varchar(300),
	CONSTRAINT id_menu_pk PRIMARY KEY(id_menu)
);

CREATE TABLE gastronomia
(
	id_gastronomia int(10) NOT NULL AUTO_INCREMENT,
	id_menu int(10) NOT NULL,
	id_anuncios_gastronomia int(10) NOT NULL,
	CONSTRAINT id_gastronomia_pk PRIMARY KEY(id_gastronomia),
	CONSTRAINT id_menu_fk FOREIGN KEY(id_menu)
		REFERENCES menu(id_menu),
	CONSTRAINT id_anuncios_fk FOREIGN KEY(id_anuncios_gastronomia)
		REFERENCES anuncios(id_anuncios)
);

CREATE TABLE productos
(
	id_producto int(10) NOT NULL AUTO_INCREMENT,
	nombre_producto varchar(300),
	precio varchar(300),
	url_foto_producto varchar(300),
	id_anuncios_productos int(10) NOT NULL,
	CONSTRAINT id_producto_pk PRIMARY KEY(id_producto),
	CONSTRAINT id_anuncios_fk2 FOREIGN KEY(id_anuncios_productos) 
		REFERENCES anuncios(id_anuncios)
);

CREATE TABLE tiendas
(
	id_tiendas int(10) NOT NULL AUTO_INCREMENT,
	nombre_tienda varchar(300),
	id_producto int(10) NOT NULL,
	id_anuncios_tiendas int(10) NOT NULL,
	CONSTRAINT id_tiendas_pk PRIMARY KEY(id_tiendas),
	CONSTRAINT id_producto_fk2 FOREIGN KEY(id_producto)
		REFERENCES productos(id_producto),
	CONSTRAINT id_anuncios_fk3 FOREIGN KEY(id_anuncios_tiendas)
		REFERENCES anuncios(id_anuncios)
);

CREATE TABLE servicios
(
	id_servicios int(10) NOT NULL AUTO_INCREMENT,
	url_foto_servicio varchar(300),
	precios varchar(300),
	id_anuncios_servicios int(10) NOT NULL,
	CONSTRAINT id_servicios_pk PRIMARY KEY(id_servicios),
	CONSTRAINT id_anuncios_fk4 FOREIGN KEY(id_anuncios_servicios)
		REFERENCES anuncios(id_anuncios)
);

CREATE TABLE dispositivo
(
	id_dispositivo int(10) AUTO_INCREMENT,
	nombre_dispositivo varchar(100),
	fecha_dispositivo varchar(300),
	CONSTRAINT id_dispositivo_pk PRIMARY KEY(id_dispositivo)
);

CREATE TABLE info
(
	id_info int(10) AUTO_INCREMENT,
	CONSTRAINT id_info_pk PRIMARY KEY(id_info)
);

CREATE TABLE tipoInformacion
(
	id_tipoInformacion int(10) AUTO_INCREMENT,
	tipo varchar(100),
	id_info int(10),
	CONSTRAINT id_tipoInformacion_pk PRIMARY KEY(id_tipoInformacion),
	CONSTRAINT id_info_fk FOREIGN KEY(id_info)
		REFERENCES info(id_info)
);