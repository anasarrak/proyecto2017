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
public class Categoria 
{
    private int idTipo;
    private String tipo;
    private Trabajador t;

    public Categoria() 
    {
        
    }
    
    public Categoria(int idTipo, String tipo,Trabajador t) 
    {
        this.idTipo = idTipo;
        this.tipo = tipo;
        this.t=t;
    }

    public int getIdTipo() 
    {
        return idTipo;
    }

    public void setIdTipo(int idTipo) 
    {
        this.idTipo = idTipo;
    }

    public String getTipo() 
    {
        return tipo;
    }

    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
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
