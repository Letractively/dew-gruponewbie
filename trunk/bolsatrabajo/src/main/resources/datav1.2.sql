insert into tb_tipopersona(id_tipper,descripcion_tipper) values(1,'Natural');
insert into tb_tipopersona(id_tipper,descripcion_tipper) values(2,'Juridica');

insert into tb_tipodocumento(id_tipdoc,descripcion_tipdoc) values(1,'DNI');
insert into tb_tipodocumento(id_tipdoc,descripcion_tipdoc) values(2,'RUC');

insert into tb_industria (id_ind,descripcion_ind) values(1,'Administracion');
insert into tb_industria (id_ind,descripcion_ind) values(2,'Agricultura');
insert into tb_industria (id_ind,descripcion_ind) values(3,'Arquitectura y Urbanismo');
insert into tb_industria (id_ind,descripcion_ind) values(4,'Arte');
insert into tb_industria (id_ind,descripcion_ind) values(5,'Informatica');
insert into tb_industria (id_ind,descripcion_ind) values(6,'Sistemas Informaticos');
insert into tb_industria (id_ind,descripcion_ind) values(7,'Call Center');
insert into tb_industria (id_ind,descripcion_ind) values(8,'Comercio Exterior');
insert into tb_industria (id_ind,descripcion_ind) values(9,'Comercio Interno');
insert into tb_industria (id_ind,descripcion_ind) values(10,'Comunicaciones');

insert into tb_tipocentroestudio (id_tipcen,nombre_tipcen) values (1,'Primaria');
insert into tb_tipocentroestudio (id_tipcen,nombre_tipcen) values (2,'Secundaria');
insert into tb_tipocentroestudio (id_tipcen,nombre_tipcen) values (3,'Superior Tecnica');
insert into tb_tipocentroestudio (id_tipcen,nombre_tipcen) values (4,'Superior Universitaria');
insert into tb_tipocentroestudio (id_tipcen,nombre_tipcen) values (5,'Postgrado o Diplomado');
insert into tb_tipocentroestudio (id_tipcen,nombre_tipcen) values (6,'Maestria');
insert into tb_tipocentroestudio (id_tipcen,nombre_tipcen) values (7,'Doctorado');

insert into tb_tipousuario (id_tipusu,des_tipusu) values (1,'Ofertante');
insert into tb_tipousuario (id_tipusu,des_tipusu) values (2,'Solicitante');
insert into tb_tipousuario (id_tipusu,des_tipusu) values (3,'Administrador');
insert into tb_tipousuario (id_tipusu,des_tipusu) values (4,'Visitante');

insert into tb_especialidad (id_Especialidad,nombre_espe) values(1,'Administracion');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(2,'Administracion Bancaria y Financiera');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(3,'Biologia');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(4,'Bioquimica');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(5,'Cosmetologia');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(6,'Ingenieria Agricola');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(7,'Ingenieria Industrial');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(8,'Ingenieria Informatica');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(9,'Ingenieria de Sistemas');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(10,'Publicidad');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(11,'Quimica');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(12,'Radiodifusion');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(13,'Radiologia');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(14,'Recursos Humanos');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(15,'Tecnicas');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(16,'Tecnico en Telefonia');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(17,'Tecnologia de Sistemas Informaticos');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(18,'Turisticas');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(19,'Urbanismo');
insert into tb_especialidad (id_Especialidad,nombre_espe) values(20,'Veterinaria');


insert into tb_categoria (id_cate,descripcion_cate) values (1,'Bienestar');
insert into tb_categoria (id_cate,descripcion_cate) values (2,'Busqueda Profesional');
insert into tb_categoria (id_cate,descripcion_cate) values (3,'Capacitacion');
insert into tb_categoria (id_cate,descripcion_cate) values (4,'Clima laboral');
insert into tb_categoria (id_cate,descripcion_cate) values (5,'Coaching');
insert into tb_categoria (id_cate,descripcion_cate) values (6,'Cursos');
insert into tb_categoria (id_cate,descripcion_cate) values (7,'CV');
insert into tb_categoria (id_cate,descripcion_cate) values (8,'Evaluacion de personal');
insert into tb_categoria (id_cate,descripcion_cate) values (9,'Gestion de Recursos Humanos');
insert into tb_categoria (id_cate,descripcion_cate) values (10,'Gestion Laboral');
insert into tb_categoria (id_cate,descripcion_cate) values (11,'Liderazgo');
insert into tb_categoria (id_cate,descripcion_cate) values (12,'Remuneracion');
insert into tb_categoria (id_cate,descripcion_cate) values (13,'Seleccion de personal');
insert into tb_categoria (id_cate,descripcion_cate) values (14,'Otros');

insert into tb_departamento (id_dep,nombre_dep) values('15','Lima');

insert into tb_provincia(id_prov,nombre_prov,id_dep) values('1501','LIMA','15');

insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150101','LIMA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150102','ANCON','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150103','ATE','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150104','BARRANCO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150105','BREA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150106','CARABAYLLO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150107','CHACLACAYO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150108','CHORRILLOS','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150109','CIENEGUILLA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150110','COMAS','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150111','EL AGUSTINO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150112','INDEPENDENCIA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150113','JESUS MARIA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150114','LA MOLINA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150115','LA VICTORIA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150116','LINCE','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150117','LOS OLIVOS','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150118','LURIGANCHO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150119','LURIN','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150120','MAGDALENA DEL MAR','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150121','MAGDALENA VIEJA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150122','MIRAFLORES','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150123','PACHACAMAC','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150124','PUCUSANA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150125','PUENTE PIEDRA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150126','PUNTA HERMOSA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150127','PUNTA NEGRA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150128','RIMAC','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150129','SAN BARTOLO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150130','SAN BORJA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150131','SAN ISIDRO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150132','SAN JUAN DE LURIGANCHO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150133','SAN JUAN DE MIRAFLORES','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150134','SAN LUIS','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150135','SAN MARTIN DE PORRES','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150136','SAN MIGUEL','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150137','SANTA ANITA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150138','SANTA MARIA DEL MAR','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150139','SANTA ROSA','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150140','SANTIAGO DE SURCO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150141','SURQUILLO','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150142','VILLA EL SALVADOR','1501');
insert into tb_distrito(id_dis,nombre_dis,id_prov) values('150143','VILLA MARIA DEL TRIUNFO','1501');

insert into tb_noticias (id_noti,titulo_noti,contenido_noti,fecha_noti,publicacion_noti,id_cate) values (1,'Implementando un Sistema de Enfoque a Resultados Administracion por Objetivos','El aspecto fundamental es que la empresa tenga un sistema que permita fehacientemente medir los indicadores que se utilizaran. Para esto la organizacion debe tener un sistema de control de gestion que sea confiable, creible y la informacion se pueda extraer de forma oportuna. Nuestra empresa cuenta con un sistema de administracion por objetivos, lo que permite a nuestros profesionales organizar su propio tiempo para cumplir con los proyectos asignados, dentro de los plazos y estandares establecidos. Tenemos un sistema de control de gestion, con un comite de seguimiento semanal con nuestros Directores de Proyectos en el cual revisamos el cumplimiento de los objetivos, compartimos casos de exito y casos de aprendizaje informacion mas relevante que le permite desarrollar su trabajo.','2011-04-01','P',9);
insert into tb_noticias (id_noti,titulo_noti,contenido_noti,fecha_noti,publicacion_noti,id_cate) values (2,'Reconociendo la Excelencia','Ana Maria Gubbins, es Administradora de la Universidad de Lima, con experiencia en el area de consultoria como freelance, en comunicacion institucional, comercial y ventas. Ha realizado trabajos de consultoria en temas relacionados a reestructuracion y reingenieria administrativa, imagen corporativa, marketing, servicio al cliente y planeamiento estrategico, trabajando en el analisis de comportamientos y estrategias para diversas categorias. Desde el 2002 labora como Gerente General de Metramark, empresa representante de Great Place to Work Institute Peru.','2011-04-01','P',1);
insert into tb_noticias (id_noti,titulo_noti,contenido_noti,fecha_noti,publicacion_noti,id_cate) values (3,'La Importancia de la Capacitacion','Si bien la capacitacion genera motivacion en los empleados, no la utilizamos como una herramienta exclusiva de motivacion. La inversion en capacitacion tiene un impacto muy positivo en la organizacion porque contribuye al logro de objetivos, mejora la productividad, desarrolla habilidades, genera fidelizacion, y desde el punto de vista de los empleados, incrementa su valor y competitividad en el mercado, los hace mas empleables, es decir, los ayuda a generar mas oportunidades dentro y fuera de la organizacion.','2011-04-02','P',3);
insert into tb_noticias (id_noti,titulo_noti,contenido_noti,fecha_noti,publicacion_noti,id_cate) values (4,'Gestion de la Respuesta Humanitaria','Martin Beaumont Franowsky, es Master of arts en Politicas alternativas de Desarrollo por el Instituto de Estudios Sociales de la Haya (1996). Sociologo, PUCP (1991). Ha sido gerente general de Oxfam en el Peru, tiene amplia experiencia en temas de desarrollo y cooperacion internacional con organizaciones de la sociedad civil e instituciones publicas de America Latina y Europa. Actualmente es el Responsable del Diploma de Gestion de la Respuesta Humanitaria y profesor de Gestion Estrategica de las Organizaciones de la Sociedad Civil, Incidencia Publica en Politicas Publicas de la Facultad de Gestion y Alta Direccion de la PUCP.','2011-04-02','P',6);
insert into tb_noticias (id_noti,titulo_noti,contenido_noti,fecha_noti,publicacion_noti,id_cate) values (5,'Fraude Laboral: No todo lo que brilla es Oro','Nunca acepte un trabajo cuyo esquema de negocios no entiende, siga este consejo para evitar ser victima de fraudes en su busqueda de empleo. Otro dicho conocido para tomar en cuenta: Si Ud. piensa que algo es demasiado bueno para ser verdad, probablemente tenga razon. Las razones por las que existen este tipo de trabajos falsos u ofertas de empleo falsas es porque personas inescrupulosas buscan ganar dinero facil: vendiendo bases de datos, accediendo a sus cuentas bancarias o tarjetas de credito o en el mejor de los casos pagando sueldos por debajo del mercado sin beneficios y solo comisiones.','2011-04-04','P',2);
insert into tb_noticias (id_noti,titulo_noti,contenido_noti,fecha_noti,publicacion_noti,id_cate) values (6,'Mejorando el Clima Laboral','Ricardo Marsano, es Administrador de empresas con experiencia en el area de Recursos Humanos. Ha trabajado como Gerente de Recursos Humanos de IBM Peru y Colombia, Director de Recursos Humanos de Lenovo para Latinoamerica y miembro del Comite de Recursos Humanos de Amcham. En que momento decidieron convertir IPAE en un mejor lugar para trabajar? Desarrollamos una vision de corto plazo con la que buscabamos  reconvertir a IPAE en una organizacion agil y moderna que permitiera afrontar los retos que el siglo XXI nos presentaba. La Vision consideraba un crecimiento muy agresivo en las diferentes Unidades de Negocio de la Institucion y cambios de importancia en nuestra manera de operar.','2011-04-03','P',4);
insert into tb_noticias (id_noti,titulo_noti,contenido_noti,fecha_noti,publicacion_noti,id_cate) values (7,'Noticia del Día','Detalle de la noticia del día','2011-04-15','P',4);
insert into tb_noticias (id_noti,titulo_noti,contenido_noti,fecha_noti,publicacion_noti,id_cate) values (8,'Noticia del Día inactiva','Detalle de la noticia del día inactiva','2011-04-15','I',4);

insert into tb_centroestudio (id_cen,nombre_cen,id_tipcen) values (1,'Colegio Magister',1);
insert into tb_centroestudio (id_cen,nombre_cen,id_tipcen) values (2,'Colegio Trilce',2);
insert into tb_centroestudio (id_cen,nombre_cen,id_tipcen) values (3,'Instituto Superior Tecnologico TECSUP',3);
insert into tb_centroestudio (id_cen,nombre_cen,id_tipcen) values (4,'Universidad Nacional de Ingenieria',4);
insert into tb_centroestudio (id_cen,nombre_cen,id_tipcen) values (5,'Universidad  Nacional Federico Villarreal',5);
insert into tb_centroestudio (id_cen,nombre_cen,id_tipcen) values (6,'Universidad Inca Garcilaso de la Vega',6);
insert into tb_centroestudio (id_cen,nombre_cen,id_tipcen) values (7,'Universidad Peruana de Ciencias Aplicadas',7);

insert into tb_persona (id_per,email_per,password_per,titulo_per,resumen_per,disponibilidad_per,salario_per,nombreRazonSocial_per,apellidoPaterno_per,apellidoMaterno_per,direccion_per,numeroDocumento_per,sexo_per,fechaNacimiento_per,telefono_per,celular_per,id_tipper,id_tipusu,id_dis,id_tipdoc) values (1,'anisabelcueva@gmail.com','asd','Ingeniero','Desarrollador de Software','tiempo completo',2500.50,'Ana Isabel','Cueva','Castillo','por alli','94878985','F','1985-08-23','2645463','991410217',1,2,'150117',1);
insert into tb_persona (id_per,email_per,password_per,titulo_per,resumen_per,disponibilidad_per,salario_per,nombreRazonSocial_per,apellidoPaterno_per,apellidoMaterno_per,direccion_per,numeroDocumento_per,sexo_per,fechaNacimiento_per,telefono_per,celular_per,id_tipper,id_tipusu,id_dis,id_tipdoc) values (2,'ronaldtaipe@gmail.com','asd','Ingeniero','Desarrollador de Software','tiempo completo',3500.50,'Ronald David','Taipe','Aylas','por aca','45789658','M','1983-02-01','2641691','991542178',1,2,'150117',1);
insert into tb_persona (id_per,email_per,password_per,titulo_per,resumen_per,disponibilidad_per,salario_per,nombreRazonSocial_per,apellidoPaterno_per,apellidoMaterno_per,direccion_per,numeroDocumento_per,sexo_per,fechaNacimiento_per,telefono_per,celular_per,id_tipper,id_tipusu,id_dis,id_tipdoc) values (3,'ednvpr@gmail.com','asd','Ingeniero','Desarrollador de Software','tiempo completo',2500.50,'Edwin','Navarro','Prado','por algun lado','82415263','M','1974-03-01','2641692','993652418',1,2,'150133',1);
insert into tb_persona (id_per,email_per,password_per,titulo_per,resumen_per,disponibilidad_per,salario_per,nombreRazonSocial_per,apellidoPaterno_per,apellidoMaterno_per,direccion_per,numeroDocumento_per,sexo_per,fechaNacimiento_per,telefono_per,celular_per,id_tipper,id_tipusu,id_dis,id_tipdoc) values (4,'felixangelalfaroc@gmail.com','hola','Ingeniero','Desarrollador de Software','tiempo completo',2500.50,'Felix Angel','Alfaro','Cayllahua','por otro lado','65897412','M','1974-04-01','2641693','991313165',1,2,'150135',1);
insert into tb_persona (id_per,email_per,password_per,titulo_per,resumen_per,disponibilidad_per,salario_per,nombreRazonSocial_per,apellidoPaterno_per,apellidoMaterno_per,direccion_per,numeroDocumento_per,sexo_per,fechaNacimiento_per,telefono_per,celular_per,id_tipper,id_tipusu,id_dis,id_tipdoc) values (5,'rosmel45@gmail.com','asd','Ingeniero','Desarrollador de Software','tiempo completo',2500.50,'Rosmel','Huallpar','Torres','en el infinito','96425394','M','1980-05-01','2641694','993346785',1,2,'150135',1);
insert into tb_persona (id_per,email_per,password_per,titulo_per,resumen_per,disponibilidad_per,salario_per,nombreRazonSocial_per,apellidoPaterno_per,apellidoMaterno_per,direccion_per,numeroDocumento_per,sexo_per,fechaNacimiento_per,telefono_per,celular_per,id_tipper,id_tipusu,id_dis,id_tipdoc) values (6,'erickleo24@gmail.com','asd','Ingeniero','Desarrollador de Software','tiempo completo',1001.50,'Heribert','Roca','Ticona','en su casa','33478819','M','1980-06-01','2641695','995241529',1,2,'150133',1);
insert into tb_persona (id_per,email_per,password_per,titulo_per,resumen_per,disponibilidad_per,salario_per,nombreRazonSocial_per,apellidoPaterno_per,apellidoMaterno_per,direccion_per,numeroDocumento_per,sexo_per,fechaNacimiento_per,telefono_per,celular_per,id_tipper,id_tipusu,id_dis,id_tipdoc,id_ind) values (7,'evol@evol.com','asd','','Consultora de Software','',0.00,'Evol Software','','','Calle Los manzanos 1115','22222222222','M','1940-03-04','2641699','999999999',2,1,'150131',2,6);

insert into tb_experiencia_laboral (nombreEmpresa_exp,cargo_exp,fechaInicio_exp,fechaFin_exp,descripcion_exp,id_per,id_ind) values ('Overall Systems Support','Encargado','2007-03-15','2010-01-10','Trabajo con personal',6,6);
insert into tb_experiencia_laboral (nombreEmpresa_exp,cargo_exp,fechaInicio_exp,fechaFin_exp,descripcion_exp,id_per,id_ind) values ('Adexus Peru S.A.','Supervisor','2010-03-15','2011-02-12','Control de procesos',4,5);
insert into tb_experiencia_laboral (nombreEmpresa_exp,cargo_exp,fechaInicio_exp,fechaFin_exp,descripcion_exp,id_per,id_ind) values ('Advance Technology Service S.R.L.','Consultor','2010-03-15','2011-03-11','analisis de sistemas',2,6);

insert into tb_aviso(cargo_avi,inicio_avi,fin_avi,descripcion_avi,jornadaLaboral_avi,requerimientos_avi,beneficios_avi,sueldo_avi,estado_avi,conteoLectura_avi,id_per,id_Especialidad) values ('Jefe de area Informatica','2011-03-15','2011-04-10','oficina requiere Jefe de area Informatica','tiempo completo','saber dirigir','Beneficios de Ley mas utilidades por mes',3500.70,'P',15,7,17);
insert into tb_aviso(cargo_avi,inicio_avi,fin_avi,descripcion_avi,jornadaLaboral_avi,requerimientos_avi,beneficios_avi,sueldo_avi,estado_avi,conteoLectura_avi,id_per,id_Especialidad) values ('Jefe de area de Sistemas','2011-02-10','2011-02-20','oficina requiere Jefe de area de Sistemas','tiempo completo','coordinar con personal','Beneficios de Ley mas utilidades por mes',4500.70,'P',2,7,17);
insert into tb_aviso(cargo_avi,inicio_avi,fin_avi,descripcion_avi,jornadaLaboral_avi,requerimientos_avi,beneficios_avi,sueldo_avi,estado_avi,conteoLectura_avi,id_per,id_Especialidad) values ('Jefe de area de Base de Datos','2011-01-10','2011-01-20','oficina necesita Jefe de area de Base de Datos','tiempo completo','coordinar con personal','Beneficios de Ley mas utilidades por mes',5500.70,'P',3,7,17);

insert into tb_estudios (titulo_est,fechaInicio_est,fechaFin_est,estado_est,id_per,id_cen,id_Especialidad) values ('Tecnico en Computacion','2008-02-01','2011-03-10','C',6,3,8);
insert into tb_estudios (titulo_est,fechaInicio_est,fechaFin_est,estado_est,id_per,id_cen,id_Especialidad) values ('Ingeniero de Software','2005-07-01','2008-07-12','C',4,4,17);
insert into tb_estudios (titulo_est,fechaInicio_est,fechaFin_est,estado_est,id_per,id_cen,id_Especialidad) values ('Ingeniero de Sistemas Alternos ','2006-05-01','2011-05-01','C',2,5,9);

insert into tb_detalle_aviso_postulante (id_per,id_avi,estado_avi) values (6,1,'E');
insert into tb_detalle_aviso_postulante (id_per,id_avi,estado_avi) values (2,2,'E');
insert into tb_detalle_aviso_postulante (id_per,id_avi,estado_avi) values (4,3,'E');

insert into tb_publicidad (desc_corta_publi,cuerpo_publi,enlace_publi,fechaInicial_publi,fecha_Fin,estado_publi) VALUES('Publicidad ejemplo 1','Esta es una demo del cuerpo de la publicidad 1','hhtp://www.google.com.pe','2010-03-10','2011-05-10','P');
insert into tb_publicidad (desc_corta_publi,cuerpo_publi,enlace_publi,fechaInicial_publi,fecha_Fin,estado_publi) VALUES('Publicidad ejemplo 2','Esta es una demo del cuerpo de la publicidad 2','hhtp://www.google.com.pe','2010-06-10','2011-09-10','P');
insert into tb_publicidad (desc_corta_publi,cuerpo_publi,enlace_publi,fechaInicial_publi,fecha_Fin,estado_publi) VALUES('Publicidad ejemplo 3','Esta es una demo del cuerpo de la publicidad 3','hhtp://www.google.com.pe','2010-10-10','2011-12-10','P');