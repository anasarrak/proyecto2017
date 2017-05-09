/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.sql.Date;



/**
 *
 * @author Al
 */
public class Administrador extends Trabajador
{

    public Administrador(int idTrab, String dni, String nombre, String apellidouno, String apellidodos, String calle, 
            String portal, String piso, String mano, String telefempre, String telefperso, Double salario, Date fechaNac, 
            Centro pc, Aviso av, Usuario us, Categoria catt) 
    {
        super(idTrab, dni, nombre, apellidouno, apellidodos, calle, portal, piso, mano, telefempre, telefperso, salario, 
                fechaNac, pc, av, us, catt);
        
    }
   

    

    

    
    
    
    
    
    
}
