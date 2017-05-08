/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author IFONS
 */
public class LoginIncorrecto extends Exception
{

    public LoginIncorrecto() 
    {
        
    }

    public LoginIncorrecto(String message) 
    {
        super(message);
    }
    
    
}
