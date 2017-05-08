/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.ArrayList;

/**
 *
 * @author Al
 */
public class Centro 
{
    private int idCentro;
    private String nombre;
    private String calle;
    private int numero;
    private String cp;
    private String ciudad;
    private String provincia;
    private String telefono;
    private ArrayList <Trabajador> trabajadores;

    public Centro() 
    {
        
    }

    public Centro(int idCentro, String nombre, String calle, int numero, String cp, String ciudad, 
            String provincia, String telefono) 
    {
        this.idCentro = idCentro;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        trabajadores = new ArrayList<>();
    }

    public int getIdCentro() 
    {
        return idCentro;
    }

    public void setIdCentro(int idCentro) 
    {
        this.idCentro = idCentro;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getCalle() 
    {
        return calle;
    }

    public void setCalle(String calle) 
    {
        this.calle = calle;
    }

    public int getNumero() 
    {
        return numero;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
    }

    public String getCp() 
    {
        return cp;
    }

    public void setCp(String cp) 
    {
        this.cp = cp;
    }

    public String getCiudad() 
    {
        return ciudad;
    }

    public void setCiudad(String ciudad) 
    {
        this.ciudad = ciudad;
    }

    public String getProvincia() 
    {
        return provincia;
    }

    public void setProvincia(String provincia) 
    {
        this.provincia = provincia;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public ArrayList<Trabajador> getTrabajadores() 
    {
        return trabajadores;
    }

    public void setTrabajadores(Trabajador t) 
    {
        trabajadores.add(t);
    }
    
    
    
    
    
}
