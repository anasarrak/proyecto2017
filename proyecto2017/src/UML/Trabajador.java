/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Al
 */
public class Trabajador 
{
    private int idTrab;
    private String dni;
    private String nombre;   
    private String apellidouno;
    private String apellidodos;
    private String calle;
    private String portal;
    private String piso;
    private String mano;
    private String telefempre;
    private String telefperso;
    private Double salario;
    private Date fechaNac;
    private Centro  c;
    private Aviso a;
    private Usuario u;
    private Categoria cat;
    private ArrayList <Parte> partes;

    public Trabajador() 
    {
        
    }

    public Trabajador(int idTrab, String dni, String nombre, String apellidouno,
            String apellidodos, String calle, String portal, String piso, 
            String mano, String telefempre, String telefperso, Double salario,
            Date fechaNac, Centro pc, Aviso av, Usuario us, Categoria catt) 
    {
        this.idTrab = idTrab;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidouno = apellidouno;
        this.apellidodos = apellidodos;
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
        this.mano = mano;
        this.telefempre = telefempre;
        this.telefperso = telefperso;
        this.salario = salario;
        this.fechaNac = fechaNac;
        c=pc;
        a=av;
        u=us;
        cat=catt;
        partes=new ArrayList<>();
    }

    public int getIdTrab() 
    {
        return idTrab;
    }

    public void setIdTrab(int idTrab) 
    {
        this.idTrab = idTrab;
    }

    public String getDni() 
    {
        return dni;
    }

    public void setDni(String dni) 
    {
        this.dni = dni;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellidouno() 
    {
        return apellidouno;
    }

    public void setApellidouno(String apellidouno) 
    {
        this.apellidouno = apellidouno;
    }

    public String getApellidodos() 
    {
        return apellidodos;
    }

    public void setApellidodos(String apellidodos) 
    {
        this.apellidodos = apellidodos;
    }

    public String getCalle() 
    {
        return calle;
    }

    public void setCalle(String calle) 
    {
        this.calle = calle;
    }

    public String getPortal() 
    {
        return portal;
    }

    public void setPortal(String portal) 
    {
        this.portal = portal;
    }

    public String getPiso() 
    {
        return piso;
    }

    public void setPiso(String piso) 
    {
        this.piso = piso;
    }

    public String getMano() 
    {
        return mano;
    }

    public void setMano(String mano) 
    {
        this.mano = mano;
    }

    public String getTelefempre() 
    {
        return telefempre;
    }

    public void setTelefempre(String telefempre) 
    {
        this.telefempre = telefempre;
    }

    public String getTelefperso() 
    {
        return telefperso;
    }

    public void setTelefperso(String telefperso) 
    {
        this.telefperso = telefperso;
    }

    public Double getSalario() 
    {
        return salario;
    }

    public void setSalario(Double salario) 
    {
        this.salario = salario;
    }

    public Date getFechaNac() 
    {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) 
    {
        this.fechaNac = fechaNac;
    }
    
    public Centro getC() 
    {
        return c;
    }

    public void setC(Centro cent) 
    {
        c=cent;
    }

    public Aviso getA() 
    {
        return a;
    }

    public void setA(Aviso avi) 
    {
        a = avi;
    }

    public Usuario getU() 
    {
        return u;
    }

    public void setU(Usuario u) 
    {
        this.u = u;
    }

    public Categoria getCat()
    {
        return cat;
    }

    public void setCat(Categoria cat)
    {
        this.cat = cat;
    }
    
    public ArrayList<Parte> getPartes() 
    {
        return partes;
    }

    public void setPartes(Parte p) 
    {
        partes.add(p);
    }
    
}
