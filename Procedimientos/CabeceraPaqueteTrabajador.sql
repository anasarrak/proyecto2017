CREATE OR REPLACE PACKAGE PAQUETE_TRABAJADOR2 IS
  TYPE TRABAJADOR_CURSOR IS REF CURSOR;
  PROCEDURE visualizar_lista_dnis(un_cursor OUT TRABAJADOR_CURSOR);
  PROCEDURE visualizar_datos_trabajador(pDni IN TRABAJADORES.DNI%TYPE, un_cursor OUT TRABAJADOR_CURSOR);
END PAQUETE_TRABAJADOR2;