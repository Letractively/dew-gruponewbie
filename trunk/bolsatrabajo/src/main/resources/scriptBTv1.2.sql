CREATE TABLE tb_publicidad (
  id_publi bigint AUTO_INCREMENT,
  desc_corta_publi VARCHAR(100) NULL,
  cuerpo_publi VARCHAR(2500) NULL,
  enlace_publi VARCHAR(300) NULL,
  fechaInicial_publi DATE NULL,
  fecha_Fin DATE NULL,
  estado_publi CHAR(1) NULL,
  PRIMARY KEY(id_publi)
);

CREATE TABLE tb_tipopersona (
  id_tipper bigint AUTO_INCREMENT,
  descripcion_tipper VARCHAR(20) NULL,
  PRIMARY KEY(id_tipper)
);

CREATE TABLE tb_tipodocumento (
  id_tipdoc bigint AUTO_INCREMENT,
  descripcion_tipdoc VARCHAR(50) NULL,
  PRIMARY KEY(id_tipdoc)
);

CREATE TABLE tb_industria (
  id_ind bigint AUTO_INCREMENT,
  descripcion_ind VARCHAR(70) NULL,
  PRIMARY KEY(id_ind)
);

CREATE TABLE tb_tipocentroestudio (
  id_tipcen bigint AUTO_INCREMENT,
  nombre_tipcen VARCHAR(300) NULL,
  PRIMARY KEY(id_tipcen)
);

CREATE TABLE tb_tipousuario (
  id_tipusu bigint AUTO_INCREMENT,
  des_tipusu VARCHAR(50) NULL,
  PRIMARY KEY(id_tipusu)
);

CREATE TABLE tb_especialidad (
  id_Especialidad bigint AUTO_INCREMENT,
  nombre_espe VARCHAR(100) NULL,
  PRIMARY KEY(id_Especialidad)
);

CREATE TABLE tb_categoria (
  id_cate bigint AUTO_INCREMENT,
  descripcion_cate VARCHAR(50) NULL,
  PRIMARY KEY(id_cate)
);

CREATE TABLE tb_departamento (
  id_dep VARCHAR(6) NOT NULL,
  nombre_dep VARCHAR(100) NULL,
  PRIMARY KEY(id_dep)
);

CREATE TABLE tb_provincia (
  id_prov VARCHAR(6) NOT NULL,
  nombre_prov VARCHAR(100) NULL,
  id_dep VARCHAR(6) NOT NULL REFERENCES tb_departamento,  
  PRIMARY KEY(id_prov)
);

CREATE TABLE tb_noticias (
  id_noti bigint AUTO_INCREMENT,
  titulo_noti VARCHAR(300) NULL,
  contenido_noti VARCHAR(2500) NULL,
  fecha_noti DATE NULL,
  publicacion_noti CHAR(1) NULL,
  id_cate INTEGER NOT NULL REFERENCES tb_categoria,
  PRIMARY KEY(id_noti)
);

CREATE TABLE tb_centroestudio (
  id_cen INTEGER NOT NULL,
  nombre_cen VARCHAR(300) NULL,
  id_tipcen INTEGER NOT NULL REFERENCES tb_tipocentroestudio,
  PRIMARY KEY(id_cen)
);

CREATE TABLE tb_distrito (
  id_dis VARCHAR(6) NOT NULL,
  nombre_dis VARCHAR(100) NULL,
  id_prov VARCHAR(6) NOT NULL REFERENCES tb_provincia,
  PRIMARY KEY(id_dis)
);

CREATE TABLE tb_persona (
  id_per bigint AUTO_INCREMENT,
  email_per VARCHAR(100) NULL,
  password_per VARCHAR(50) NULL,
  titulo_per VARCHAR(50) NULL,
  resumen_per VARCHAR(200) NULL,
  disponibilidad_per VARCHAR(50) NULL,
  salario_per DECIMAL(10,2) NULL,
  nombreRazonSocial_per VARCHAR(70) NULL,
  apellidoPaterno_per VARCHAR(70) NULL,
  apellidoMaterno_per VARCHAR(70) NULL,
  direccion_per VARCHAR(150) NULL,
  numeroDocumento_per VARCHAR(20) NULL,
  sexo_per char(1) NULL,
  fechaNacimiento_per DATE NULL,
  telefono_per VARCHAR(15) NULL,
  celular_per VARCHAR(20) NULL,
  id_tipper INTEGER NULL REFERENCES tb_tipopersona,
  id_tipusu INTEGER NULL REFERENCES tb_tipousuario,
  id_dis VARCHAR(6) NULL REFERENCES tb_distrito,
  id_tipdoc INTEGER NULL REFERENCES tb_tipodocumento,
  id_ind INTEGER NULL REFERENCES tb_industria,
  PRIMARY KEY(id_per)
);

CREATE TABLE tb_experiencia_laboral (
  id_exp bigint AUTO_INCREMENT,
  nombreEmpresa_exp VARCHAR(100) NULL,
  cargo_exp VARCHAR(100) NULL,
  fechaInicio_exp DATE NULL,
  fechaFin_exp DATE NULL,
  descripcion_exp VARCHAR(300) NULL,
  id_per INTEGER NOT NULL REFERENCES tb_persona,
  id_ind INTEGER NOT NULL REFERENCES tb_industria,
  PRIMARY KEY(id_exp)
);

CREATE TABLE tb_aviso (
  id_avi bigint AUTO_INCREMENT,
  cargo_avi VARCHAR(100) NULL,
  inicio_avi DATE NULL,
  fin_avi DATE NULL,
  descripcion_avi VARCHAR(500) NULL,
  jornadaLaboral_avi VARCHAR(30) NULL,
  disponibilidad_avi VARCHAR(100) NULL,
  requerimientos_avi VARCHAR(500) NULL,
  beneficios_avi VARCHAR(500) NULL,
  sueldo_avi DECIMAL(10,2) NULL,
  estado_avi CHAR(1) NULL,
  conteoLectura_avi INTEGER NULL,
  id_per INTEGER NOT NULL REFERENCES tb_persona,
  id_Especialidad INTEGER NOT NULL REFERENCES tb_especialidad,
  PRIMARY KEY(id_avi)
);

CREATE TABLE tb_estudios (
  id_est bigint AUTO_INCREMENT,
  titulo_est VARCHAR(100) NULL,
  fechaInicio_est DATE NULL,
  fechaFin_est DATE NULL,
  estado_est CHAR(1) NULL,
  id_per INTEGER NOT NULL REFERENCES tb_persona,
  id_cen INTEGER NOT NULL REFERENCES tb_centroestudio,
  id_Especialidad INTEGER NOT NULL REFERENCES tb_especialidad,
  PRIMARY KEY(id_est)
);

CREATE TABLE tb_detalle_aviso_postulante (
  id_per INTEGER NOT NULL REFERENCES tb_persona,
  id_avi INTEGER NOT NULL REFERENCES tb_aviso,
  estado_avi CHAR(1) NULL,
  PRIMARY KEY(id_per,id_avi)
);
