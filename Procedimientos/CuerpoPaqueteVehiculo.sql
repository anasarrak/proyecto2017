CREATE OR REPLACE PACKAGE BODY PAQUETE_VEHICULO2 IS
  PROCEDURE visualizar_lista_id_vehiculo
  (
    un_cursor OUT VEHICULO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select idVehiculo
      from VEHICULOS; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON VEHICULOS');
  END visualizar_lista_id_vehiculo;
  
  PROCEDURE visualizar_lista_COD_vehiculos
  (
    un_cursor OUT VEHICULO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select codVehiculo
      from VEHICULOS; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON VEHICULOS');
  END visualizar_lista_COD_vehiculos;
  
  PROCEDURE visualizar_datos_vehiculo_cod
  (
    pCodVehiculo IN VEHICULOS.codVehiculo%type, un_cursor OUT VEHICULO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select idVehiculo,codVehiculo,matricula,marca
      from VEHICULOS
      where codVehiculo=pCodVehiculo; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON VEHICULOS');
  END visualizar_datos_vehiculo_cod;
  
END PAQUETE_VEHICULO2;
