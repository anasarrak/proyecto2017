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
public class Albaran 
{
    private int idAlbaran;
    private double horaSalida;
    private double horaLlegada;
    private Vehiculo v;
    private Parte p;

    public Albaran() 
    {
        
    }

    public Albaran(int idAlbaran, double horaSalida, double horaLlegada, Vehiculo v, Parte p) 
    {
        this.idAlbaran = idAlbaran;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.v = v;
        this.p = p;
    }
    
    

    public int getIdAlbaran() 
    {
        return idAlbaran;
    }

    public void setIdAlbaran(int idAlbaran) 
    {
        this.idAlbaran = idAlbaran;
    }

    public double getHoraSalida() 
    {
        return horaSalida;
    }

    public void setHoraSalida(double horaSalida) 
    {
        this.horaSalida = horaSalida;
    }

    public double getHoraLlegada() 
    {
        return horaLlegada;
    }

    public void setHoraLlegada(double horaLlegada) 
    {
        this.horaLlegada = horaLlegada;
    }

    public Vehiculo getVehiculo() 
    {
        return v;
    }

    public void setVehiculo(Vehiculo v) 
    {
        this.v = v;
    }

    public Parte getP() 
    {
        return p;
    }

    public void setP(Parte p) 
    {
        this.p = p;
    }
    
    
    
    
}
