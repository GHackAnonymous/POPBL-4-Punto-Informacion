INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo1', 'Algo1nombre', 'algo1Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo2', 'Algo2nombre', 'algo2Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo3', 'Algo3nombre', 'algo3Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo4', 'Algo4nombre', 'algo4Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo5', 'Algo5nombre', 'algo5Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo6', 'Algo6nombre', 'algo6Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo7', 'Algo7nombre', 'algo7Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo8', 'Algo8nombre', 'algo8Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo9', 'Algo9nombre', 'algo9Clave');
INSERT INTO administradores (nick, nombre_admin, clave) VALUES ('algo10', 'Algo10nombre', 'algo10Clave');

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


INSERT INTO anuncios (titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) 
	VALUES ('tituloalgo1', 'Descripcionalgo1', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', '06/23/2017');
INSERT INTO anuncios (titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) 
	VALUES ('tituloalgo2', 'Descripcionalgo2', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', '06/23/2017');
INSERT INTO anuncios (titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) 
	VALUES ('tituloalgo3', 'Descripcionalgo3', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', '06/23/2017');
INSERT INTO anuncios (titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) 
	VALUES ('tituloalgo4', 'Descripcionalgo4', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', '06/23/2017');
INSERT INTO anuncios (titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) 
	VALUES ('tituloalgo5', 'Descripcionalgo5', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', '06/23/2017');
INSERT INTO anuncios (titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) 
	VALUES ('tituloalgo6', 'Descripcionalgo6', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', '06/23/2017');
INSERT INTO anuncios (titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) 
	VALUES ('tituloalgo7', 'Descripcionalgo7', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', '06/23/2017');
INSERT INTO anuncios (titulo, descripcion, url_foto_anuncio, ubicacion, contacto, horarios, fecha_anuncio) 
	VALUES ('tituloalgo8', 'Descripcionalgo8', 'log.png', 'Bilbo', 'eder', '09:00 - 22:00', '06/23/2017');

INSERT INTO menu (nombre_menu, ingedientes, precio) VALUES ('nombrealgo1', 'cebolla-patata-carne', '3€');
INSERT INTO menu (nombre_menu, ingedientes, precio) VALUES ('nombrealgo2', 'cebolla-patata-pescado', '3€');
INSERT INTO menu (nombre_menu, ingedientes, precio) VALUES ('nombrealgo3', 'cebolla-patata-zanaoria', '3€');
INSERT INTO menu (nombre_menu, ingedientes, precio) VALUES ('nombrealgo4', 'cebolla-patata', '3€');
INSERT INTO menu (nombre_menu, ingedientes, precio) VALUES ('nombrealgo5', 'cebolla-patata-lechuga', '3€');

INSERT INTO gastronomia (id_menu, id_anuncios_gastronomia) VALUES (1, 1);
INSERT INTO gastronomia (id_menu, id_anuncios_gastronomia) VALUES (2, 2);
INSERT INTO gastronomia (id_menu, id_anuncios_gastronomia) VALUES (3, 3);
INSERT INTO gastronomia (id_menu, id_anuncios_gastronomia) VALUES (4, 4);
INSERT INTO gastronomia (id_menu, id_anuncios_gastronomia) VALUES (5, 5);

INSERT INTO productos (nombre_producto, precio, url_foto_producto, id_anuncios_productos) VALUES ('nombrealgo1', '4€', 'plusgreen.png', 1);
INSERT INTO productos (nombre_producto, precio, url_foto_producto, id_anuncios_productos) VALUES ('nombrealgo2', '4€', 'plusgreen.png', 2);
INSERT INTO productos (nombre_producto, precio, url_foto_producto, id_anuncios_productos) VALUES ('nombrealgo3', '4€', 'plusgreen.png', 3);
INSERT INTO productos (nombre_producto, precio, url_foto_producto, id_anuncios_productos) VALUES ('nombrealgo4', '4€', 'plusgreen.png', 4);
INSERT INTO productos (nombre_producto, precio, url_foto_producto, id_anuncios_productos) VALUES ('nombrealgo5', '4€', 'plusgreen.png', 5);
INSERT INTO productos (nombre_producto, precio, url_foto_producto, id_anuncios_productos) VALUES ('nombrealgo6', '4€', 'plusgreen.png', 6);

INSERT INTO tiendas (nombre_tienda, id_producto, id_anuncios_tiendas) VALUES ('nombrealgo1', 1, 1);
INSERT INTO tiendas (nombre_tienda, id_producto, id_anuncios_tiendas) VALUES ('nombrealgo1', 2, 2);
INSERT INTO tiendas (nombre_tienda, id_producto, id_anuncios_tiendas) VALUES ('nombrealgo1', 3, 3);
INSERT INTO tiendas (nombre_tienda, id_producto, id_anuncios_tiendas) VALUES ('nombrealgo1', 4, 4);
INSERT INTO tiendas (nombre_tienda, id_producto, id_anuncios_tiendas) VALUES ('nombrealgo1', 5, 5);
INSERT INTO tiendas (nombre_tienda, id_producto, id_anuncios_tiendas) VALUES ('nombrealgo1', 6, 6);

INSERT INTO servicios (url_foto_servicio, precios, id_anuncios_servicios) VALUES ('gastronomia.png','5€', 1);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios_servicios) VALUES ('gastronomia.png','5€', 2);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios_servicios) VALUES ('gastronomia.png','5€', 3);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios_servicios) VALUES ('gastronomia.png','5€', 4);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios_servicios) VALUES ('gastronomia.png','5€', 5);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios_servicios) VALUES ('gastronomia.png','5€', 6);
INSERT INTO servicios (url_foto_servicio, precios, id_anuncios_servicios) VALUES ('gastronomia.png','5€', 7);

INSERT INTO dispositivo (nombre_dispositivo, fecha_dispositivo) VALUES ('NombreAlgo1', '06/23/2017');
INSERT INTO dispositivo (nombre_dispositivo, fecha_dispositivo) VALUES ('NombreAlgo2', '06/23/2017');
INSERT INTO dispositivo (nombre_dispositivo, fecha_dispositivo) VALUES ('NombreAlgo3', '06/23/2017');
INSERT INTO dispositivo (nombre_dispositivo, fecha_dispositivo) VALUES ('NombreAlgo4', '06/23/2017');
INSERT INTO dispositivo (nombre_dispositivo, fecha_dispositivo) VALUES ('NombreAlgo5', '06/23/2017');
INSERT INTO dispositivo (nombre_dispositivo, fecha_dispositivo) VALUES ('NombreAlgo6', '06/23/2017');

INSERT INTO info (tipo, url_foto_info) VALUES ('Los cientos de visitantes que se acercan al Museo \r\nGuggenheim Bilbao, cuentan con una oficina ubicada\r\n junto a la entrada de la pinacoteca, que proporciona \r\ninformación sobre Bilbao, Bizkaia y Euskadi. Además, \r\nofrece servicio de visitas guiadas, vende la tarjeta turística \r\nBilbao Card y trabaj', 'gunne.jpg');
INSERT INTO info (tipo, url_foto_info) VALUES ('A lo largo del siglo XX y en la actualidad, los vascos\r\n mantienen una polémica interna y con el resto de\r\n los pueblos con los que se relacionan acerca de la\r\n naturaleza, extensión y consecuencias de la\r\n condición de vasco.\r\n\r\nLas tendencias constitucionalistas, no nacionalistas\r\n vascas y nacion', 'gunne.jpg');
INSERT INTO info (tipo, url_foto_info) VALUES ('La visita a Bergara es completamente modulable. \r\nPartiendo de una experiencia tranquila -un suave paseo \r\npor las calles viejas, relajarse en los jardines, disfrutar del \r\nAnillo Verde...- podemos llegar hasta el deporte extremo\r\n - subida a Gorla, BBT, piraguismo, rocódromo...-. \r\nLa intensidad se', 'puente-de-calatrava.jpg');
INSERT INTO info (tipo, url_foto_info) VALUES ('Zarauz3 1 (en euskera y oficialmente Zarautz) es una villa\r\n turística situada en el centro de la costa de la provincia\r\n y territorio histórico de Guipúzcoa, en el \r\nPaís Vasco (España). Limita al este y al sur con Aya y al \r\noeste con Guetaria. Posee cuatro enclaves que limitan con\r\n los anteriore', 'toldo.jpg');
INSERT INTO info (tipo, url_foto_info) VALUES ('', 'mapa.jpg');

INSERT INTO tipoInformacion (tipo, id_info) VALUES ('TipoAlgo6', 4);