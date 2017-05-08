
DROP TABLE albaranes CASCADE CONSTRAINTS;
DROP TABLE partes CASCADE CONSTRAINTS;
DROP TABLE usuarios CASCADE CONSTRAINTS;
DROP TABLE trabajadores CASCADE CONSTRAINTS;
DROP TABLE vehiculos CASCADE CONSTRAINTS;
DROP TABLE avisos CASCADE CONSTRAINTS;
DROP TABLE centros CASCADE CONSTRAINTS;
DROP TABLE tipoTrabajadores CASCADE CONSTRAINTS;

  CREATE TABLE tipoTrabajadores
  (
    idTipo INT,
    tipo varchar2 (20),
    constraint pk_ttrab_pk PRIMARY KEY (idTipo),
    constraint ck_ttrab_tipo check(tipo='admin' or tipo='logic')
  );
  
  CREATE TABLE centros
  (
    idCentro  INT,
    nombre    VARCHAR2 (30) NOT NULL ,
    calle     VARCHAR2 (30) NOT NULL,
    numero    NUMBER (2) NOT NULL,
    cp        VARCHAR2 (5) NOT NULL,
    ciudad    VARCHAR2 (15) NOT NULL,
    provincia VARCHAR2 (40) NOT NULL,
    telefono  VARCHAR2 (9) NOT NULL,
    
    CONSTRAINT pk_centro PRIMARY KEY (idCentro)
     
  );

  
  CREATE TABLE avisos
  (
    idAviso INT ,
    codAviso VARCHAR2 (20) NOT NULL,
    nombre VARCHAR2 (20) NOT NULL,
    descripcion VARCHAR2(500) NOT NULL,
    
    CONSTRAINT pk_avisos PRIMARY KEY (idAviso)
  );
  
  CREATE TABLE vehiculos
  (
    idVehiculo INT,
    codVehiculo number(8),
    matricula VARCHAR2(7) NOT NULL,
    marca VARCHAR2(10),
    
    CONSTRAINT pk_vehiculo PRIMARY KEY (idVehiculo)
  );
  
  
  CREATE TABLE trabajadores
  (
    idTrab    INT ,
    dni       VARCHAR2 (9) NOT NULL,
    nombre    VARCHAR2 (30) NOT NULL ,
    apellidouno     VARCHAR2 (30) NOT NULL,
    apellidodos     VARCHAR2 (30) NOT NULL,
    calle     VARCHAR2(40) NOT NULL,
    portal    VARCHAR2 (2) NOT NULL,
    piso      VARCHAR2 (5) NOT NULL,
    mano      VARCHAR2 (15) NOT NULL,
    telefempre VARCHAR2 (40) NOT NULL,
    telefperso VARCHAR2 (9), 
    salario NUMBER(7,2),
    fecha_nac DATE,
    centro INT NOT NULL,
    aviso INT,
    usuario INT,
    categoria INT,
    CONSTRAINT pk_trabajadores PRIMARY KEY (idTrab),
    CONSTRAINT fk_centros_id FOREIGN KEY (centro)
      REFERENCES centros(idCentro),
    CONSTRAINT fk_tipoTrab_fk FOREIGN KEY (categoria)
      REFERENCES tipoTrabajadores(idTipo),
    CONSTRAINT fk_aviso FOREIGN KEY (aviso)
      REFERENCES avisos(idAviso)
    
  );
  

  
  CREATE TABLE usuarios
  (
    idUsuario INT,
    usuario VARCHAR2(20) NOT NULL,
    pass VARCHAR2 (35) NOT NULL,
    trabajador INT NOT NULL,
    
    CONSTRAINT pk_usuario PRIMARY KEY (idUsuario),
    CONSTRAINT fk_trabajadores_id FOREIGN KEY (trabajador)
      REFERENCES trabajadores(idTrab)
  );


  
  
  CREATE TABLE partes
  (
    idParte  INT ,
    fecha DATE NOT NULL,
    kmInicio NUMBER(8,2) NOT NULL,
    kmFin NUMBER(8,2) NOT NULL,
    estado VARCHAR2(20) NOT NULL,
    gasoil NUMBER(8,2),
    peaje NUMBER (8,2),
    dietas NUMBER(8,2),
    otros NUMBER(8,2),
    incidencias NUMBER(8,2),
    hExtra NUMBER(4,2),
    trabajador INT NOT NULL,
    vehiculo  INT NOT NULL,
    CONSTRAINT pk_partes PRIMARY KEY (idParte),
    CONSTRAINT fk_id_traba FOREIGN KEY (trabajador)
      REFERENCES trabajadores(idTrab),
    CONSTRAINT fk_id_vehiculo FOREIGN KEY (vehiculo)
      REFERENCES vehiculos(idVehiculo),
    CONSTRAINT ck_kilometros CHECK (kmInicio < kmFin),
    CONSTRAINT ck_estado CHECK (estado='abierto' or estado='cerrado')
  );
  
  CREATE TABLE albaranes
  (
    idAlbaran INT,
    horaSalida NUMBER (4,2) NOT NULL,
    horaLlegada NUMBER (4,2) NOT NULL,
    vehiculo INT NOT NULL,
    parte INT NOT NULL,
    CONSTRAINT pk_albaranes PRIMARY KEY (idAlbaran),
    CONSTRAINT fk_vehiculos_id FOREIGN KEY (vehiculo)
      REFERENCES vehiculos(idVehiculo),
    CONSTRAINT fk_partes_id FOREIGN KEY (parte) 
      REFERENCES partes(idParte),
    CONSTRAINT ck_hora CHECK (horaSalida<horaLlegada)
  );
  

  
