CREATE OR REPLACE PACKAGE PAQUETE_VEHICULO2 IS
  TYPE VEHICULO_CURSOR IS REF CURSOR;
  PROCEDURE visualizar_lista_id_vehiculo(un_cursor OUT VEHICULO_CURSOR);
  PROCEDURE visualizar_lista_COD_vehiculos(un_cursor OUT VEHICULO_CURSOR);
  PROCEDURE visualizar_datos_vehiculo_cod(pCodVehiculo IN VEHICULOS.codVehiculo%type, un_cursor OUT VEHICULO_CURSOR);
END PAQUETE_VEHICULO2;
