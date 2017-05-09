/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.Albaran;
import UML.Parte;
import UML.Trabajador;
import UML.Vehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Al
 */
public class ParteBD extends GenericoBD
{
    public static ArrayList obtenerListaIdsPartes() 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Parte> idsPartes=new ArrayList<>();
        Parte p;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_PARTE2.visualizar_lista_id_parte(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                p = new Parte(rs.getInt(1), null, 0, 0, null, 0, 0, 0, 0, 0, 0, null, null);
                idsPartes.add(p);
            }
        }
        catch(SQLException e)
        {
            
        }
        finally
        {
           cerrarConexion();
        }
        return idsPartes;
    }
    
     public static Parte visualizar_datos_parte(Parte p) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        Date fecha=p.getFecha();
        ArrayList<Albaran>albaranes= AlbaranBD.visualizarListaIdsAlbaranes();
    
        
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_PARTE2.visualizar_datos_parte_fecha(?,?)}");

            cs.setDate(1, fecha);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                p= new Parte(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),
                        rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),
                        new Trabajador(rs.getInt(12),null,null,null,null,null,null,null,null,null,null,0.0, null, 
                                null, null, null, null),
                        new Vehiculo(rs.getInt(13), 0, null,null));
                for(Albaran al:albaranes)
                {
                    p.setAlbaranes(al);
                }
               
                
            }
        }
        catch(SQLException e)
        {
            
        }
        finally
        {
           cerrarConexion();
        }
        return p;
    }
     
    
     
    public static void actualizarPartes(Parte p) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idParte=p.getIdParte();
        String plantilla;
        try
        {
            
                plantilla = "UPDATE PARTES SET FECHA="+p.getFecha()+",KMINICIO="+p.getKmFin()+",KMFIN="+p.getKmFin()
                        +",ESTADO='"+p.getEstado()+"',GASOIL="+p.getGasoil()+",PEAJE="+p.getPeaje()+",DIETAS="+p.getDietas()
                        +",OTROS="+p.getOtros()+",INCIDENCIAS="+p.getIncidencias()+",HEXTRA="+p.gethExtra()
                        +",TRABAJADOR="+p.getT().getIdTrab()+",VEHICULO="+p.getV().getIdVehiculo()
                        +" WHERE IDPARTE="+idParte;
            

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
    
    public static void insertarParte(Parte p) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String plantilla;
        try
        {
            
                plantilla = "INSERT INTO PARTES (FECHA,KMINICIO,KMFIN,ESTADO,GASOIL,PEAJE,DIETAS,OTROS,INCIDENCIAS,HEXTRA,"
                        + "TRABAJADOR,VEHICULO) VALUES ("+p.getFecha()+","+p.getKmFin()+","+p.getKmFin()
                        +",'"+p.getEstado()+"',"+p.getGasoil()+","+p.getPeaje()+","+p.getDietas()
                        +","+p.getOtros()+","+p.getIncidencias()+","+p.gethExtra()
                        +","+p.getT().getIdTrab()+","+p.getV().getIdVehiculo()+")";
            

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
    
    public static void borrarParte(Parte p) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idParte = p.getIdParte();
        try
        {
            String plantilla = "DELETE FROM PARTES WHERE idParte='" +idParte;
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
