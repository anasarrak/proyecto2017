CREATE OR REPLACE PACKAGE PAQUETE_CENTRO2 IS
  TYPE CENTRO_CURSOR IS REF CURSOR;
  PROCEDURE visualizar_lista_nombre_centro(un_cursor OUT CENTRO_CURSOR);
  PROCEDURE visualizar_datos_centro_nombre(pNombreCentro IN CENTROS.nombre%TYPE, un_cursor OUT CENTRO_CURSOR);
END PAQUETE_CENTRO2;


