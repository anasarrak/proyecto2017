/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;



/**
 *
 * @author Al
 */
public class Usuario 
{
    private int idUsuario;
    private String usuario;
    private String contraseña;
    private Trabajador t;

    public Usuario() 
    {
        
    }

    public Usuario(int idUsuario, String usuario, String contraseña, Trabajador t) 
    {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.t=t;
    }

    public int getIdUsuario() 
    {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) 
    {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    public String getContraseña() 
    {
        return contraseña;
    }

    public void setContraseña(String contraseña) 
    {
        this.contraseña = contraseña;
    }

    public Trabajador getT() 
    {
        return t;
    }

    public void setT(Trabajador t) 
    {
        this.t = t;
    }
    
    
    
    
    
}
