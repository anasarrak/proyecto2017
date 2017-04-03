CREATE TABLE centros
  (
    idCentro  VARCHAR2 (30) NOT NULL,
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
    idCentro VARCHAR2(30) NOT NULL,
    usuarioTrab
    CONSTRAINT pk_trabajadores PRIMARY KEY (dni),
    CONSTRAINT fk_centros_id FOREIGN KEY (idCentro)
      REFERENCES centros(idCentro)
  );
  
CREATE TABLE usuarios
  (
    usuario VARCHAR2(20) NOT NULL,
    pass VARCHAR2 (35) NOT NULL,
    dni VARCHAR2 (9) NOT NULL,
    
    CONSTRAINT pf_usuario PRIMARY KEY (usuario),
    CONSTRAINT fk_trabajadores_dni FOREIGN KEY (dniTrab)
      REFERENCES trabajadores(dni)
  );
  
CREATE TABLE partes
  (
    idParte  VARCHAR2(30) NOT NULL,
    fecha DATE NOT NULL,
    kmInicio NUMBER(4) NOT NULL,
    kmFinal NUMBER(4) NOT NULL,
    gasoil NUMBER(4) NOT NULL,
    dietas NUMBER(4) NOT NULL,
    otros NUMBER(4) NOT NULL,
    incidencias NUMBER(4) NOT NULL,
    dniTrab VARCHAR2(9) NOT NULL,
    matriVehi VARCHAR2(7) NOT NULL,
    CONSTRAINT pk_partes PRIMARY KEY (idParte),
    CONSTRAINT fk_dni_traba FOREIGN KEY (dniTrab)
      REFERENCES trabajadores(dni),
    CONSTRAINT fk_matri_vehiculo FOREIGN KEY (matriVehi)
      REFERENCES vehiculos(matricula),
    CONSTRAINT ck_kilometros CHECK (kmInicio < kmFinal)
  );
  
CREATE TABLE albaranes
  (
    idAlbaran VARCHAR2(30) NOT NULL,
    horaSalida VARCHAR2(10) NOT NULL,
    horaLlegada VARCHAR2(10) NOT NULL,
    matricula VARCHAR2(7) NOT NULL,
    idParte VARCHAR2(30) NOT NULL,
    CONSTRAINT pk_albaranes PRIMARY KEY (idAlbaran),
    CONSTRAINT fk_vehiculos_matricula FOREIGN KEY (matricula)
      REFERENCES vehiculos(matricula),
    CONSTRAINT fk_partes_id FOREIGN KEY (idParte) 
      REFERENCES partes(idParte)
  );
  
CREATE TABLE vehiculos
  (
    matricula VARCHAR2(7) NOT NULL,
    
    CONSTRAINT pk_vehiculo PRIMARY KEY (matricula)
  );
  
CREATE TABLE avisos
  (
    codAviso VARCHAR2 (20) NOT NULL,
    nombre VARCHAR2 (20) NOT NULL,
    descripcion VARCHAR2(500) NOT NULL,
    
    CONSTRAINT pk_avisos PRIMARY KEY (codAviso)
  );
  