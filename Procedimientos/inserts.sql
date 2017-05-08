INSERT INTO CENTROS (nombre,calle,numero,cp,ciudad,provincia,telefono) VALUES('FEWF','SFEW',11,'WEE','WER','EWRW','EWRW');
INSERT INTO TRABAJADORES(dni,nombre,apellidouno,apellidodos,calle,portal,piso,mano,telefempre,centro)VALUES('11111111R','pepe','wfwe','weqrq','we','we','werwr','werw','retre',1);
INSERT INTO USUARIOS (USUARIO,PASS,TRABAJADOR) VALUES('pepe','81dc9bdb52d04dc20036dbd8313ed055',1);
DESC USUARIOS
select idUsuario, trabajador from usuarios where usuario='pepe' and pass='81dc9bdb52d04dc20036dbd8313ed055';
select * from USUARIOS;
SELECT * FROM CENTROS;
SELECT * FROM TRABAJADORES;
