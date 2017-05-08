CREATE OR REPLACE PACKAGE BODY PAQUETE_ALBARAN2 IS
  
  
  
  PROCEDURE visualizar_lista_id_albaran
  (
    un_cursor OUT ALBARAN_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select idAlbaran
      from ALBARANES; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON ALBARANES');
  END visualizar_lista_id_albaran;
  
  PROCEDURE visualizar_datos_albaran_id
  (
    pidAlbaran IN ALBARANES.idAlbaran%type, un_cursor OUT ALBARAN_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select idAlbaran,horaSalida,horaLlegada,matricula,parte
      from ALBARANES
      where idAlbaran=pidAlbaran; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON ALBARANES');
  END visualizar_datos_albaran_id;
  
  
 
END PAQUETE_ALBARAN2;
  