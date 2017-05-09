/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import BD.*;
import Parser.Parser;
import UML.*;
import Ventanas.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;


/**
 *
 * @author Al
 */
public class Programa {
    private static VentanaLogin vL;
    private static VentanaPrincipalAdmin vP;
    private static VentanaPrincipalAdmin vpA;
    private static VentanaPrincipalLogistica vpl;


    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException 
    {
        // TODO code application logic here7
        vL =new VentanaLogin(vP, true);
        vL.setVisible(true);
    }
    public static Trabajador buscarTrabajador(String dni)
    {
        Trabajador t=new Trabajador(0,dni,null,null,null,null,null,null,null,null,null,0.0,null,null,null,null,null);
        t=TrabajadorBD.visualizar_datos_trabajador(t);
        return t;
    }
    
    public static void actualizarTrabajador(String dni,String nombre,String apellidouno,String apellidodos,String calle,
            String portal,String piso,String mano,String telefempre,String telefperso,Double salario,Date fechaNac,
                    String nombreCentro, int Categoria)
    {   
        Centro c;
        c=new Centro(0, nombreCentro,null,0,null,null,null,null);
        c=CentroBD.visualizarCentroNombre(c);
        Trabajador t= new Trabajador(0, dni, nombre, apellidouno, apellidodos, calle, portal, piso, mano, telefempre, telefperso,
                salario, fechaNac,new Centro(c.getIdCentro(),null,null,0,null,null,null,null),
                null,null, new Categoria(Categoria,null,null));
        TrabajadorBD.actualizarTrabajador(t);
    }
    
    public static Trabajador buscarTrabajadorLog(String usuario,String password)
    {
       
        Usuario us= UsuarioBD.comprobarUsuarioPassword(usuario, password);
        
        Trabajador t=TrabajadorBD.buscarIdTrabajadorParaLog(us);
        
        t=TrabajadorBD.visualizar_datos_trabajador(t);
        
        Categoria cat = TrabajadorBD.buscarCategoria(t);

        
        
        
        if("admin".equals(cat.getTipo()))
        {
            Administrador admin=new Administrador(t.getIdTrab(),t.getDni(),t.getNombre(),t.getApellidodos(),t.getApellidodos(), 
                    t.getCalle(),t.getPortal(),t.getPiso(),t.getMano(),t.getTelefempre(),t.getTelefperso(),t.getSalario(),
                    t.getFechaNac(),new Centro(t.getC().getIdCentro(),null,null,0,null,null,null,null),
                    new Aviso(t.getA().getIdAviso(),null,null,null,null),
                    new Usuario(t.getU().getIdUsuario(),null,null,null),
                    new Categoria(t.getCat().getIdTipo(),null,null));
            
            return admin;
        }
        System.out.println(t);
        return t;
    }

   
   /* public static Usuario buscarUsuario(String usuario, String password) 
    {
        
        
        Trabajador t =buscarTrabajadorLog(usuario,password);
    
      return us;
    }*/
    
    public static void cargarPartesParser()
    {
        
        ArrayList <Parte> partes=ParteBD.obtenerListaIdsPartes();
        ArrayList <Parte> partes2=new ArrayList<>();
        for(Parte p: partes)
        {
            
            p=ParteBD.visualizar_datos_parte(p);
            partes2.add(p);
            
        }
        
        try 
        {
            Parser dpe = new Parser(partes2);
            dpe.runParser();
        } 
        catch (IOException ex) 
        {
            
        }
        
    }

    public static void insertarTrabjador(String dni,String nombre,String apellidouno,String apellidodos,String calle,
            String portal,String piso,String mano,String telefempre,String telefperso,Double salario,Date fechaNac,
                    String nombreCentro, int Categoria) 
    {
         Centro c;
        c=new Centro(0, nombreCentro,null,0,null,null,null,null);
        c=CentroBD.visualizarCentroNombre(c);
        Trabajador t= new Trabajador(0, dni, nombre, apellidouno, apellidodos, calle, portal, piso, mano, telefempre, telefperso,
                salario, fechaNac,new Centro(c.getIdCentro(),null,null,0,null,null,null,null),
                null,null, new Categoria(Categoria,null,null));
        TrabajadorBD.insertarTrabajador(t);
    }
    
    public static void abrirVentanaAdmin()
    {
        vL.dispose();
        vpA=new VentanaPrincipalAdmin();
        vpA.setVisible(true);
    }
    
    public static void abrirVentanaLogistic()
    {
        vL.dispose();
        vpl=new VentanaPrincipalLogistica();
        vpl.setVisible(true);
    }

    public static Parte buscarParte(Date fecha)
    {
        
        Parte p=new Parte(0, fecha, 0, 0,null, 0, 0, 0, 0, 0, 0,null,null);
        p=ParteBD.visualizar_datos_parte(p);
        return p;
    }

    public static void insertarParte(Date fecha,double kmInicio,double kmFin,String estado,double gasoil,double peaje,
    double dietas,double otros,double incidencias,double hExtra, String dni, int codVehiculo)
    {
        Vehiculo v=new Vehiculo(0, codVehiculo, null, null);
        v=VehiculoBD.visualizar_datos_vehiculo_cod(v);
        Trabajador t=new Trabajador(0, dni, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        t=TrabajadorBD.visualizar_datos_trabajador(t);
        Parte p=new Parte(0, fecha, 0, 0, estado, 0, 0, 0, 0, 0, 0,
                new Trabajador(t.getIdTrab(),null ,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null), 
                new Vehiculo(v.getIdVehiculo(),0,null,null));
        ParteBD.insertarParte(p);
    }

    public static void cerrarParte(Date fecha,String estado) 
    {
        Parte p = new Parte(0, fecha, 0, 0, null, 0, 0, 0, 0, 0, 0, null, null);
        p=ParteBD.visualizar_datos_parte(p);
        p.setEstado(estado);
        ParteBD.actualizarPartes(p);
    }

    public static Centro buscarCentro(String NombreC) 
    {
        Centro c=new Centro(0, NombreC,null, 0,null,null,null,null);
         c=CentroBD.visualizarCentroNombre(c);
        
        return c;
    }

    public static void actualizarCentro(String nombre,String calle,int numero,String cp,String ciudad,String provincia ,
            String telefono) 
    {
        Centro c=new Centro(0, nombre, calle,numero, cp, ciudad, provincia, telefono);
        CentroBD.modificar(c);
    }

    

    public static void insertarCentro(String nombre,String calle,int numero,String cp,String ciudad,String provincia ,
            String telefono) 
    {
        Centro c=new Centro(0, nombre, calle,numero, cp, ciudad, provincia, telefono);
       CentroBD.insertarCentro(c);
    }

    public static Albaran buscarAlbaran(double hLlegada) 
    {
        Albaran al=new Albaran(0, 0.0, hLlegada,null,null);
        al=AlbaranBD.visualizar_datos_albaran(al);
        return al;
    }

    public static void actualizarAlbaran(double hsalida,double hllegada, int parte,int vehiculo) 
    {
        Albaran al=buscarAlbaran(hllegada);
        Vehiculo v=new Vehiculo(0, vehiculo,null,null);
        v=VehiculoBD.visualizar_datos_vehiculo_cod(v);
        al=new Albaran( al.getIdAlbaran(),hsalida, hllegada, 
               new Vehiculo(v.getIdVehiculo(),0,null,null),
                new Parte(parte,null,0.0,0.0,null,0.0,0.0,0.0,0.0,0.0,0.0,null,null));
        AlbaranBD.actualizarAlbaranes(al);
    }

    public static void insertarAlbaran(Double hSalida, Double hLlegada, int vehiculo, int parte) 
    {
        Albaran al;
        Vehiculo v=new Vehiculo(0, vehiculo,null,null);
        v=VehiculoBD.visualizar_datos_vehiculo_cod(v);
        al=new Albaran( 0,hSalida, hLlegada, 
               new Vehiculo(v.getIdVehiculo(),0,null,null),
                new Parte(parte,null,0.0,0.0,null,0.0,0.0,0.0,0.0,0.0,0.0,null,null));
        AlbaranBD.insertarAlbaran(al);
    }
}
