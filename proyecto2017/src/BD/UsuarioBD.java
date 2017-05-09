/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Al
 */
public class UsuarioBD extends GenericoBD
{
    public static Usuario comprobarUsuarioPassword(String usuario , String password )
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String plantilla;
        Usuario us = null;
        ResultSet resultado;
        String pass;
        Statement s ;
        
        try
        {
            
            
            pass = Seguridad.codificar(password);
            
            plantilla="select idUsuario, trabajador from usuarios where usuario ='"
                    +usuario+"'" + " and pass ='"+ pass+"'" ;
            s = conn.createStatement();
            
            resultado = s.executeQuery( plantilla );
            
            
            if(resultado.next())
            
           
                us=new Usuario(resultado.getInt(1), usuario, password, new Trabajador(resultado.getInt(2), null, null, null, null,
                       null,null, null, null, null, null, null, null, null, null, null, null));
                
            
        }
        catch( SQLException e)
        {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException | NoSuchAlgorithmException ex)
        {
            
        }
        finally
        {
            cerrarConexion();
        }       
        return us;
    }
    
    public static void actualizarUsuario(Usuario u) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idUsuario=u.getIdUsuario();
        String plantilla;
        try
        {
            
                plantilla = "UPDATE USUARIOS SET USUARIO='"+u.getUsuario()+"',PASS='"+u.getContraseña()
                        +"' WHERE IDUSUARIO="+idUsuario+")";
            

        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch(SQLException e)
        {
           
           
        }
        finally
        {
           cerrarConexion();
        }
    }
    
    public static void insertarUsuario(Usuario u) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String plantilla;
        try
        {
            
                plantilla = "INSERT INTO USUARIOS (USUARIO,PASS,TRABAJADOR) VALUES ('"+u.getUsuario()+"','"+u.getContraseña()
                        +"',"+u.getT().getIdTrab()+")";
            

        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch(SQLException e)
        {
           
          
        }
        finally
        {
           cerrarConexion();
        }
    }
    
    public static void borrarUsuario(Trabajador t) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idUsuario = t.getU().getIdUsuario();
        try
        {
            String plantilla = "DELETE FROM USUARIOS WHERE IDUSUARIO="+idUsuario;
            PreparedStatement ps = conn.prepareStatement(plantilla);
            ps.executeUpdate();
            conn.commit();
        }
        catch(SQLException e)
        {
           
        }
        finally
        {
           cerrarConexion();
        }
    }
}
