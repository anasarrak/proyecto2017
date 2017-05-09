/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;


import UML.Albaran;
import UML.Parte;
import UML.Vehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Al
 */
public class AlbaranBD extends GenericoBD
{
    public static ArrayList visualizarListaIdsAlbaranes() 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Albaran> idsAlbaranes=new ArrayList<>();
        Albaran a;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_ALBARAN2.visualizar_lista_id_albaran(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                a = new Albaran(rs.getInt(1), 0, 0, null, null);
                idsAlbaranes.add(a);
            }
        }
        catch(SQLException e)
        {
            
        }
        finally
        {
           cerrarConexion();
        }
        return idsAlbaranes;
    }
    
    
    
     public static Albaran visualizar_datos_albaran(Albaran al) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        double hLLegada=al.getHoraLlegada();
    
        
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_ALBARAN2.visualizar_datos_albaran_hL(?,?)}");

            cs.setDouble(1, hLLegada);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                al= new Albaran(rs.getInt(1), rs.getDouble(2),rs.getDouble(3) ,
                        new Vehiculo(rs.getInt(4),0, null, null)
                        ,new Parte(rs.getInt(5), null, 0, 0, null, 0, 0, 
                                0, 0, 0, 0, null, null));
                
            }
        }
        catch(SQLException e)
        {
            
        }
        finally
        {
           cerrarConexion();
        }
        return al;
    }
     
    public static void actualizarAlbaranes(Albaran al) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idAlbaran=al.getIdAlbaran();
        String plantilla;
        try
        {
            
                plantilla = "UPDATE ALBARANES SET HORASALIDA="+al.getHoraSalida()+",HORALLEGADA="+al.getHoraLlegada()
                        +",VEHICULO="+al.getVehiculo().getIdVehiculo()+",PARTE="+al.getP().getIdParte()
                        +" WHERE idAlbaran="+idAlbaran;
            

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
    
    public static void insertarAlbaran(Albaran al) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String plantilla;
        try
        {
            
                plantilla = "INSERT INTO ALVARANES (HORASALIDA,HORALLEGADA,VEHICULO,PARTE) VALUES ("+al.getHoraSalida()+","
                        +al.getHoraLlegada()+","+al.getVehiculo().getIdVehiculo()+","+al.getP().getIdParte()+")";
            

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
    
    public static void borrarAlbaran(Albaran al) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idAlbaran = al.getIdAlbaran();
        try
        {
            String plantilla = "DELETE FROM ALBARANES WHERE idAlbaran=" +idAlbaran;
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
