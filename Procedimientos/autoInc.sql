  DROP SEQUENCE seq_centrosSalud_idCentro;
  
  CREATE SEQUENCE seq_centrosSalud_idCentro
    START WITH 1 
    INCREMENT BY 1 
    NOMAXVALUE; 
    
  CREATE OR REPLACE TRIGGER trig_centos_seq
    BEFORE INSERT ON centros
    FOR EACH ROW
     BEGIN
      SELECT seq_centrosSalud_idCentro.nextval INTO :new.idCentro FROM dual;
    END;
  
  DROP SEQUENCE seq_avisos_idAviso;
    
  CREATE  SEQUENCE seq_avisos_idAviso --nombre de la secuencia
    START WITH 1 --la secuencia empieza por 1
    INCREMENT BY 1 --se incrementa de uno en uno
    NOMAXVALUE; --no tiene valor maximo
    
  CREATE OR REPLACE TRIGGER trig_avisos_seq
    BEFORE INSERT ON avisos
    FOR EACH ROW
     BEGIN
      SELECT seq_avisos_idAviso.nextval INTO :new.idAviso FROM dual;
    END;
    
    DROP SEQUENCE seq_vehiculos_idVehiculo;
    
   CREATE  SEQUENCE seq_vehiculos_idVehiculo --nombre de la secuencia
    START WITH 1 --la secuencia empieza por 1
    INCREMENT BY 1 --se incrementa de uno en uno
    NOMAXVALUE; --no tiene valor maximo
    
  CREATE OR REPLACE TRIGGER trig_vehiculos_seq
    BEFORE INSERT ON vehiculos
    FOR EACH ROW
     BEGIN
      SELECT seq_vehiculos_idVehiculo.nextval INTO :new.idVehiculo FROM dual;
    END;
  
  DROP SEQUENCE seq_trabajadores_idTrabajador;
  
  CREATE  SEQUENCE seq_trabajadores_idTrabajador --nombre de la secuencia
    START WITH 1 --la secuencia empieza por 1
    INCREMENT BY 1 --se incrementa de uno en uno
    NOMAXVALUE; --no tiene valor maximo
    
  CREATE OR REPLACE TRIGGER trig_trabajadores_seq
    BEFORE INSERT ON trabajadores
    FOR EACH ROW
     BEGIN
      SELECT seq_trabajadores_idTrabajador.nextval INTO :new.idTrab FROM dual;
    END;
    
  DROP SEQUENCE seq_usuarios_idUsuario;
    
  CREATE  SEQUENCE seq_usuarios_idUsuario --nombre de la secuencia
    START WITH 1 --la secuencia empieza por 1
    INCREMENT BY 1 --se incrementa de uno en uno
    NOMAXVALUE; --no tiene valor maximo
    
  CREATE OR REPLACE TRIGGER trig_usuarios_seq
    BEFORE INSERT ON usuarios
    FOR EACH ROW
     BEGIN
      SELECT seq_usuarios_idUsuario.nextval INTO :new.idUsuario FROM dual;
    END;
    
  DROP SEQUENCE seq_partes_idParte;
    
  CREATE  SEQUENCE seq_partes_idParte --nombre de la secuencia
    START WITH 1 --la secuencia empieza por 1
    INCREMENT BY 1 --se incrementa de uno en uno
    NOMAXVALUE; --no tiene valor maximo
    
  CREATE OR REPLACE TRIGGER trig_partes_seq
    BEFORE INSERT ON partes
    FOR EACH ROW
     BEGIN
      SELECT seq_partes_idParte.nextval INTO :new.idParte FROM dual;
    END;
  
  DROP SEQUENCE seq_Albaranes_idAlbaran;
  
  CREATE  SEQUENCE seq_Albaranes_idAlbaran --nombre de la secuencia
    START WITH 1 --la secuencia empieza por 1
    INCREMENT BY 1 --se incrementa de uno en uno
    NOMAXVALUE; --no tiene valor maximo
    
  CREATE OR REPLACE TRIGGER trig_Albaranes_seq
    BEFORE INSERT ON albaranes
    FOR EACH ROW
     BEGIN
      SELECT seq_albaranes_idAlbaran.nextval INTO :new.idAlbaran FROM dual;
    END;
    
  DROP SEQUENCE seq_TipoTrab_idTipo;
  
  CREATE  SEQUENCE seq_TipoTrab_idTipo --nombre de la secuencia
    START WITH 1 --la secuencia empieza por 1
    INCREMENT BY 1 --se incrementa de uno en uno
    NOMAXVALUE; --no tiene valor maximo
    
  CREATE OR REPLACE TRIGGER trig_tipo_seq
    BEFORE INSERT ON tipoTrabajadores
    FOR EACH ROW
     BEGIN
      SELECT seq_TipoTrab_idTipo.nextval INTO :new.idTipo FROM dual;
    END;  