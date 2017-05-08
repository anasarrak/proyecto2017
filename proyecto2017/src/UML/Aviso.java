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
public class Aviso 
{
    private int idAviso;
    private String codAviso;
    private String nombre;
    private String descripcion;
    private Trabajador t;

    public Aviso() 
    {
        
    }

    public Aviso(int idAviso, String codAviso, String nombre, String descripcion, Trabajador t) 
    {
        this.idAviso = idAviso;
        this.codAviso = codAviso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.t=t;
    }

    public int getIdAviso() 
    {
        return idAviso;
    }

    public void setIdAviso(int idAviso) 
    {
        this.idAviso = idAviso;
    }

    public String getCodAviso() 
    {
        return codAviso;
    }

    public void setCodAviso(String codAviso) 
    {
        this.codAviso = codAviso;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
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
