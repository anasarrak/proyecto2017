/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import BD.*;
import UML.*;
import Ventanas.*;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Al
 */
public class Programa {
    private static VentanaLogin vL;
    private static VentanaPrincipal vP;
    private static Centro c;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException 
    {
        // TODO code application logic here7
        vL =new VentanaLogin(vP, true);
        vL.setVisible(true);
    }
    
    public static Trabajador buscarTrabajadorLog(Usuario us)
    {
        
        Trabajador t=TrabajadorBD.buscarIdTrabajadorParaLog(us);
        t=TrabajadorBD.visualizar_datos_trabajador(t);
        return t;
    }

    public static Categoria buscarCategoria(Usuario us)
    {
        Categoria cat = TrabajadorBD.buscarCategoria(us);
        buscarTrabajadorLog(us);
        return cat;
    }
     
    public static Usuario buscarUsuario(String usuario, String password) 
    {
        Usuario us= UsuarioBD.comprobarUsuarioPassword(usuario, password);
        
      return us;
    }
    
}
