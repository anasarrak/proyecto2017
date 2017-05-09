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
public class Parte 
{
    private int idParte;
    private Date fecha;
    private double kmInicio;
    private double kmFin;
    private String estado;
    private double gasoil;
    private double peaje;
    private double dietas;
    private double otros;
    private double incidencias;
    private double hExtra;
    private Trabajador t;
    private Vehiculo v;
    private ArrayList <Albaran> albaranes;

    public Parte() 
    {
        
    }

    public Parte(int idParte, Date fecha, double kmInicio, double kmFin, String estado, double gasoil, double peaje, 
            double dietas, double otros, double incidencias, double hExtra, Trabajador t, Vehiculo v) 
    {
        this.idParte = idParte;
        this.fecha = fecha;
        this.kmInicio = kmInicio;
        this.kmFin = kmFin;
        this.estado = estado;
        this.gasoil = gasoil;
        this.peaje = peaje;
        this.dietas = dietas;
        this.otros = otros;
        this.incidencias = incidencias;
        this.hExtra = hExtra;
        this.t = t;
        this.v = v;
        albaranes = new ArrayList<>();
    }

    public int getIdParte() 
    {
        return idParte;
    }

    public void setIdParte(int idParte) 
    {
        this.idParte = idParte;
    }

    public Date getFecha() 
    {
        return fecha;
    }

    public void setFecha(Date fecha) 
    {
        this.fecha = fecha;
    }

    public double getKmInicio() 
    {
        return kmInicio;
    }

    public void setKmInicio(double kmInicio) 
    {
        this.kmInicio = kmInicio;
    }

    public double getKmFin() 
    {
        return kmFin;
    }

    public void setKmFin(double kmFin) 
    {
        this.kmFin = kmFin;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public double getGasoil() 
    {
        return gasoil;
    }

    public void setGasoil(double gasoil) 
    {
        this.gasoil = gasoil;
    }

    public double getPeaje() 
    {
        return peaje;
    }

    public void setPeaje(double peaje) 
    {
        this.peaje = peaje;
    }

    public double getDietas() 
    {
        return dietas;
    }

    public void setDietas(double dietas) 
    {
        this.dietas = dietas;
    }

    public double getOtros() 
    {
        return otros;
    }

    public void setOtros(double otros) 
    {
        this.otros = otros;
    }

    public double getIncidencias() 
    {
        return incidencias;
    }

    public void setIncidencias(double incidencias) 
    {
        this.incidencias = incidencias;
    }

    public double gethExtra() 
    {
        return hExtra;
    }

    public void sethExtra(double hExtra) 
    {
        this.hExtra = hExtra;
    }

    public Trabajador getT() 
    {
        return t;
    }

    public void setT(Trabajador t) 
    {
        this.t = t;
    }

    public Vehiculo getV() 
    {
        return v;
    }

    public void setV(Vehiculo v) 
    {
        this.v = v;
    }

    public ArrayList<Albaran> getAlbaranes() 
    {
        return albaranes;
    }

    public void setAlbaranes(Albaran al) 
    {
        albaranes.add(al);
    }
    
    
    @Override
    public String toString() 
    {
       StringBuilder sb = new StringBuilder();
       sb.append("id: ").append(getIdParte());
       sb.append("\n");
       sb.append("Fecha: ").append(getFecha());
       sb.append("\n");
       sb.append("Km Inicio: ").append(getKmInicio());
       sb.append("\n");
       sb.append("Km fin: ").append(getKmFin()); 
       sb.append("\n");
       sb.append("Estado: ").append(getEstado());
       sb.append("\n");
       sb.append("Gasoil: ").append(getGasoil());
       sb.append("\n");
       sb.append("Peaje: ").append(getPeaje());
       sb.append("\n");
       sb.append("Dietas: ").append(getDietas());
       sb.append("\n");
       sb.append("Otros: ").append(getOtros());
       sb.append("\n");
       sb.append("Incidencias: ").append(getIncidencias());
       sb.append("\n");
       sb.append("hExtra: ").append(gethExtra());
       sb.append("\n");
       sb.append("Trabajador: ").append(t.getIdTrab());
       sb.append("\n");
       sb.append("Vehiculo: ").append(v.getIdVehiculo());
       sb.append("\n");
       sb.append("Km fin: ").append(getKmInicio());
       //bucle parea albaranes
       
       sb.append("\n\n------------------------------------------------");
       return sb.toString();

    }
    
    
    
    
}
