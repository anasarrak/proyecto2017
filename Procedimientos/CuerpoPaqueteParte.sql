CREATE OR REPLACE PACKAGE BODY PAQUETE_PARTE2 IS

  PROCEDURE visualizar_lista_id_parte
  (
    un_cursor OUT PARTE_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select idParte
      from PARTES; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON PARTES');
  END visualizar_lista_id_parte;
  
  PROCEDURE visualizar_datos_parte_id
  (
    pIdParte IN PARTES.idParte%TYPE, un_cursor OUT PARTE_CURSOR
  )
  IS
  BEGIN  
     OPEN un_cursor FOR
        SELECT idParte,fecha,kmInicio,kmFinal,gasoil,dietas,otros,incidencias,trabajador,vehiculo,hExtra,estado
        FROM PARTES
        WHERE idParte = pIdParte;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL PARTE');
  END visualizar_datos_parte_id;
  
  
END PAQUETE_PARTE2;
