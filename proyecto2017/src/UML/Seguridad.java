/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.io.*;
import java.math.BigInteger;
import java.security.*;

/**
 *
 * @author Maisu
 */
public class Seguridad 
{
    
    public static String codificar( String pClave ) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
         MessageDigest md = MessageDigest.getInstance("MD5");

         //Indicamos los caracteres contenidos en la clave y su longitud.

         md.update(pClave.getBytes("UTF-8"), 0, pClave.length());

         //Debido a que la clase MessageDigest devuelve el valor como un vector de bytes, deberemos realizar el siguiente proceso para transformar bytes–>BigInteger–>String

         byte[] bt = md.digest();

         BigInteger bi = new BigInteger(1, bt);

         String md5 = bi.toString(16);  //16 por hexadecimal.

         return md5;
     }
	
    public static  boolean comprobarClave( String pClave , String pClaveBD )
    {
        try {

                String codificada = codificar( pClave );

                return pClaveBD.equalsIgnoreCase(codificada);

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                System.err.println ( e.getMessage() );;
        }
        // TODO Auto-generated catch block

        return false;

    }

    
    
}
