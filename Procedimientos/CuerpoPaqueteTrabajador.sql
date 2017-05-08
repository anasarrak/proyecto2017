CREATE OR REPLACE PACKAGE BODY PAQUETE_TRABAJADOR2 IS
  

  PROCEDURE visualizar_lista_dnis
  (
    un_cursor OUT TRABAJADOR_CURSOR 
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select dni
      from trabajadores; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON TRABAJADORES');
  END visualizar_lista_dnis;
  
  
  
  PROCEDURE visualizar_datos_trabajador
  (
    pDni IN TRABAJADORES.DNI%TYPE, un_cursor OUT TRABAJADOR_CURSOR
  )
  IS
  BEGIN  
     OPEN un_cursor FOR 
        SELECT idTrab, dni, nombre, apellidouno, apellidodos, calle, portal, piso, mano, telefempre, telefperso, salario , fecha_nac , centro  
        FROM TRABAJADORES
        WHERE dni = pDni;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL TRABAJADOR');
  END visualizar_datos_trabajador;
  
  
END PAQUETE_TRABAJADOR2;
  
  
