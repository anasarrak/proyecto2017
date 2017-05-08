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
public class Vehiculo 
{
    private int idVehiculo;
    private int codigoV;
    private String matricula;
    private String marca;
    private ArrayList <Parte> partes;

    public Vehiculo() 
    {
        
    }

    public Vehiculo(int idVehiculo,int codigoV,String matricula, String marca) 
    {
        this.idVehiculo = idVehiculo;
        this.codigoV=codigoV;
        this.matricula = matricula;
        this.marca = marca;
        partes=new ArrayList<>();
    }
    
    public int getIdVehiculo() 
    {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) 
    {
        this.idVehiculo = idVehiculo;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula) 
    {
        this.matricula = matricula;
    }

    public String getMarca() 
    {
        return marca;
    }

    public void setMarca(String marca) 
    {
        this.marca = marca;
    }

    public ArrayList<Parte> getPartes() 
    {
        return partes;
    }

    public void setPartes(Parte p) 
    {
        partes.add(p);
    }

    public int getCodigoV() {
        return codigoV;
    }

    public void setCodigoV(int codigoV) {
        this.codigoV = codigoV;
    }
    
    
    
    
    
}
