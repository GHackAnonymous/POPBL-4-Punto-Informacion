INSERT INTO administradores (nick, nombre, clave) VALUES ('algo1', 'Algo1nombre', 'algo1Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo2', 'Algo2nombre', 'algo2Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo3', 'Algo3nombre', 'algo3Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo4', 'Algo4nombre', 'algo4Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo5', 'Algo5nombre', 'algo5Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo6', 'Algo6nombre', 'algo6Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo7', 'Algo7nombre', 'algo7Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo8', 'Algo8nombre', 'algo8Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo9', 'Algo9nombre', 'algo9Clave');
INSERT INTO administradores (nick, nombre, clave) VALUES ('algo10', 'Algo10nombre', 'algo10Clave');

INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo1', 1);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo2', 2);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo3', 3);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo4', 4);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo5', 5);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo6', 6);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo7', 7);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo8', 8);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo9', 9);
INSERT INTO tipoAdmin (tipo, id_admin) VALUES ('tipoalgo10', 10);


INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo1', 1, 1);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo2', 2, 2);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo3', 3, 3);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo4', 4, 4);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo5', 5, 5);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo6', 6, 6);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo7', 7, 7);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo8', 8, 8);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo9', 9, 9);
INSERT INTO logs (contenido, id_tipo, id_admin) VALUES ('comentarioalgo10', 10, 10);

INSERT INTO tipos_de_tipos_anuncios (descripcion) VALUES ('Descripcionalgo1');
INSERT INTO tipos_de_tipos_anuncios (descripcion) VALUES ('Descripcionalgo2');
INSERT INTO tipos_de_tipos_anuncios (descripcion) VALUES ('Descripcionalgo3');

INSERT INTO anuncios (titulo, descripcion, url_foto, ubicacion, contacto, horarios, fecha) 
	VALUES ('tituloalgo1', 'Descripcionalgo1', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', 06/23/2017);
INSERT INTO anuncios (titulo, descripcion, url_foto, ubicacion, contacto, horarios, fecha) 
	VALUES ('tituloalgo2', 'Descripcionalgo2', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', 06/23/2017);
INSERT INTO anuncios (titulo, descripcion, url_foto, ubicacion, contacto, horarios, fecha) 
	VALUES ('tituloalgo3', 'Descripcionalgo3', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', 06/23/2017);
INSERT INTO anuncios (titulo, descripcion, url_foto, ubicacion, contacto, horarios, fecha) 
	VALUES ('tituloalgo4', 'Descripcionalgo4', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', 06/23/2017);
INSERT INTO anuncios (titulo, descripcion, url_foto, ubicacion, contacto, horarios, fecha) 
	VALUES ('tituloalgo5', 'Descripcionalgo5', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', 06/23/2017);
INSERT INTO anuncios (titulo, descripcion, url_foto, ubicacion, contacto, horarios, fecha) 
	VALUES ('tituloalgo6', 'Descripcionalgo6', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', 06/23/2017);
INSERT INTO anuncios (titulo, descripcion, url_foto, ubicacion, contacto, horarios, fecha) 
	VALUES ('tituloalgo7', 'Descripcionalgo7', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', 06/23/2017);
INSERT INTO anuncios (titulo, descripcion, url_foto, ubicacion, contacto, horarios, fecha) 
	VALUES ('tituloalgo8', 'Descripcionalgo8', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', 06/23/2017);

INSERT INTO menu (nombre, ingedientes, precio) VALUES ('nombrealgo1', 'cebolla-patata-carne', '3€');
INSERT INTO menu (nombre, ingedientes, precio) VALUES ('nombrealgo2', 'cebolla-patata-pescado', '3€');
INSERT INTO menu (nombre, ingedientes, precio) VALUES ('nombrealgo3', 'cebolla-patata-zanaoria', '3€');
INSERT INTO menu (nombre, ingedientes, precio) VALUES ('nombrealgo4', 'cebolla-patata', '3€');
INSERT INTO menu (nombre, ingedientes, precio) VALUES ('nombrealgo5', 'cebolla-patata-lechuga', '3€');

INSERT INTO gastronomia (id_menu, id_anuncios) VALUES (1, 1);
INSERT INTO gastronomia (id_menu, id_anuncios) VALUES (2, 2);
INSERT INTO gastronomia (id_menu, id_anuncios) VALUES (3, 3);
INSERT INTO gastronomia (id_menu, id_anuncios) VALUES (4, 4);
INSERT INTO gastronomia (id_menu, id_anuncios) VALUES (5, 5);

INSERT INTO productos (nombre, precio, url_foto, id_anuncios) VALUES ('nombrealgo1', '4€', 'plusgreen.png', 1);
INSERT INTO productos (nombre, precio, url_foto, id_anuncios) VALUES ('nombrealgo2', '4€', 'plusgreen.png', 2);
INSERT INTO productos (nombre, precio, url_foto, id_anuncios) VALUES ('nombrealgo3', '4€', 'plusgreen.png', 3);
INSERT INTO productos (nombre, precio, url_foto, id_anuncios) VALUES ('nombrealgo4', '4€', 'plusgreen.png', 4);
INSERT INTO productos (nombre, precio, url_foto, id_anuncios) VALUES ('nombrealgo5', '4€', 'plusgreen.png', 5);
INSERT INTO productos (nombre, precio, url_foto, id_anuncios) VALUES ('nombrealgo6', '4€', 'plusgreen.png', 6);

INSERT INTO tiendas (nombre, id_producto, id_anuncios) VALUES ('nombrealgo1', 1, 1);
INSERT INTO tiendas (nombre, id_producto, id_anuncios) VALUES ('nombrealgo1', 1, 2);
INSERT INTO tiendas (nombre, id_producto, id_anuncios) VALUES ('nombrealgo1', 1, 3);
INSERT INTO tiendas (nombre, id_producto, id_anuncios) VALUES ('nombrealgo1', 1, 4);
INSERT INTO tiendas (nombre, id_producto, id_anuncios) VALUES ('nombrealgo1', 1, 5);
INSERT INTO tiendas (nombre, id_producto, id_anuncios) VALUES ('nombrealgo1', 1, 6);

INSERT INTO servicios (url_foto_servicio, precios, id_anuncios) VALUES ('gastronomia.png','5€', 1);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios) VALUES ('gastronomia.png','5€', 2);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios) VALUES ('gastronomia.png','5€', 3);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios) VALUES ('gastronomia.png','5€', 4);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios) VALUES ('gastronomia.png','5€', 5);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios) VALUES ('gastronomia.png','5€', 6);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios) VALUES ('gastronomia.png','5€', 7);

INSERT INTO dispositivo (nombre, fecha) VALUES ('NombreAlgo1', 06/23/2017);
INSERT INTO dispositivo (nombre, fecha) VALUES ('NombreAlgo2', 06/23/2017);
INSERT INTO dispositivo (nombre, fecha) VALUES ('NombreAlgo3', 06/23/2017);
INSERT INTO dispositivo (nombre, fecha) VALUES ('NombreAlgo4', 06/23/2017);
INSERT INTO dispositivo (nombre, fecha) VALUES ('NombreAlgo5', 06/23/2017);
INSERT INTO dispositivo (nombre, fecha) VALUES ('NombreAlgo6', 06/23/2017);

INSERT INTO info () VALUES ();
INSERT INTO info () VALUES ();
INSERT INTO info () VALUES ();
INSERT INTO info () VALUES ();

INSERT INTO tipoInformacion (tipo, id_info) VALUES ('TipoAlgo1', 1);
INSERT INTO tipoInformacion (tipo, id_info) VALUES ('TipoAlgo2', 2);
INSERT INTO tipoInformacion (tipo, id_info) VALUES ('TipoAlgo3', 2);
INSERT INTO tipoInformacion (tipo, id_info) VALUES ('TipoAlgo4', 3);
INSERT INTO tipoInformacion (tipo, id_info) VALUES ('TipoAlgo5', 3);
INSERT INTO tipoInformacion (tipo, id_info) VALUES ('TipoAlgo6', 4);