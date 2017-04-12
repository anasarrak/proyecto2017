DROP TABLE avisos CASCADE CONSTRAINTS;
DROP TABLE albaranes CASCADE CONSTRAINTS;
DROP TABLE partes CASCADE CONSTRAINTS;
DROP TABLE vehiculos CASCADE CONSTRAINTS;
DROP TABLE usuarios CASCADE CONSTRAINTS;
DROP TABLE trabajadores CASCADE CONSTRAINTS;
DROP TABLE centros CASCADE CONSTRAINTS;

CREATE TABLE centros
  (
    idCentro  NUMBER (3) NOT NULL,
    nombre    VARCHAR2 (30) NOT NULL ,
    calle     VARCHAR2 (30) NOT NULL,
    numero    NUMBER (2) NOT NULL,
    cp        VARCHAR2 (5) NOT NULL,
    ciudad    VARCHAR2 (15) NOT NULL,
    provincia VARCHAR2 (40) NOT NULL,
    telefono  VARCHAR2 (9) NOT NULL,
    
    CONSTRAINT pk_centro PRIMARY KEY (idCentro)
  );
  
CREATE TABLE trabajadores
  (
    idTrab    NUMBER(3) ,
    dni       VARCHAR2 (9) NOT NULL,
    jefe      VARCHAR2(9) NOT NULL,
    nombre    VARCHAR2 (30) NOT NULL ,
    apellidouno     VARCHAR2 (30) NOT NULL,
    apellidodos     VARCHAR2 (30) NOT NULL,
    calle     VARCHAR2(40) NOT NULL,
    portal    VARCHAR2 (2) NOT NULL,
    piso      VARCHAR2 (5) NOT NULL,
    mano      VARCHAR2 (15) NOT NULL,
    telefempre VARCHAR2 (40) NOT NULL,
    telefperso VARCHAR2 (9),
    salario NUMBER(4),
    fecha_nac DATE,
    categoria VARCHAR2(10) NOT NULL,
    centro VARCHAR2(30) NOT NULL,
    usuario VARCHAR2(20) NOT NULL,
    CONSTRAINT pk_trabajadores PRIMARY KEY (idTrab),
    CONSTRAINT fk_centros_id FOREIGN KEY (centro)
      REFERENCES centros(idCentro),
    CONSTRAINT ckCategoria CHECK (categoria IN ('Logistica','Administracion'))
  );
  
CREATE TABLE usuarios
  (
    idUsuario NUMBER (3) ,
    usuario VARCHAR2(20) NOT NULL,
    pass VARCHAR2 (35) NOT NULL,
    trabajador VARCHAR2 (9) NOT NULL,
    
    CONSTRAINT pf_usuario PRIMARY KEY (idUsuario),
    CONSTRAINT fk_trabajadores_id FOREIGN KEY (trabajador)
      REFERENCES trabajadores(idTrab)
  );

CREATE TABLE vehiculos
  (
    idVehiculo NUMBER(3),
    matricula VARCHAR2(7) NOT NULL,
    
    CONSTRAINT pk_vehiculo PRIMARY KEY (idVehiculo)
  );
  
  
CREATE TABLE partes
  (
    idParte  NUMBER(3) ,
    fecha DATE NOT NULL,
    kmInicio NUMBER(4) NOT NULL,
    kmFinal NUMBER(4) NOT NULL,
    gasoil NUMBER(4) NOT NULL,
    dietas NUMBER(4) NOT NULL,
    otros NUMBER(4) NOT NULL,
    incidencias NUMBER(4) NOT NULL,
    trabajador VARCHAR2(9) NOT NULL,
    vehiculo VARCHAR2(7) NOT NULL,
    CONSTRAINT pk_partes PRIMARY KEY (idParte),
    CONSTRAINT fk_id_traba FOREIGN KEY (trabajador)
      REFERENCES trabajadores(idTrab),
    CONSTRAINT fk_id_vehiculo FOREIGN KEY (vehiculo)
      REFERENCES vehiculos(idVehiculo),
    CONSTRAINT ck_kilometros CHECK (kmInicio < kmFinal)
  );
  
CREATE TABLE albaranes
  (
    idAlbaran NUMBER(3) NOT NULL,
    horaSalida VARCHAR2(10) NOT NULL,
    horaLlegada VARCHAR2(10) NOT NULL,
    matricula VARCHAR2(7) NOT NULL,
    parte VARCHAR2(30) NOT NULL,
    CONSTRAINT pk_albaranes PRIMARY KEY (idAlbaran),
    CONSTRAINT fk_vehiculos_id FOREIGN KEY (matricula)
      REFERENCES vehiculos(idVehiculo),
    CONSTRAINT fk_partes_id FOREIGN KEY (parte) 
      REFERENCES partes(idParte),
    CONSTRAINT ck_hora CHECK (horaSalida<horaLlegada)
  );
  
  
CREATE TABLE avisos
  (
    idAviso NUMBER(3) ,
    codAviso VARCHAR2 (20) NOT NULL,
    nombre VARCHAR2 (20) NOT NULL,
    descripcion VARCHAR2(500) NOT NULL,
    
    CONSTRAINT pk_avisos PRIMARY KEY (idAviso)
  );
  

  