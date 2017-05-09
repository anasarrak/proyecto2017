/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Al
 */
public class VehiculoBD extends GenericoBD
{
    public static ArrayList visualizar_lista_id_vehiculo() 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Vehiculo> idVehiculos=new ArrayList<>();
        Vehiculo v;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_VEHICULO2.visualizar_lista_id_vehiculo(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                v = new Vehiculo(rs.getInt(1),0,null,null);
                idVehiculos.add(v);
            }
        }
        catch(SQLException e)
        {
            
            
        }
        finally
        {
           cerrarConexion();
        }
        return idVehiculos;
    }
    
    public static ArrayList visualizar_lista_COD_vehiculos() 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Vehiculo> codVehiculos=new ArrayList<>();
        Vehiculo v;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_VEHICULO2.visualizar_lista_COD_vehiculos(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                v = new Vehiculo(0,rs.getInt(1),null,null);
                codVehiculos.add(v);
            }
        }
        catch(SQLException e)
        {
            
            
        }
        finally
        {
           cerrarConexion();
        }
        return codVehiculos;
    }
    
    public static Vehiculo visualizar_datos_vehiculo_cod(Vehiculo v) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int CodVehiculo=v.getCodigoV();
        ArrayList <Parte>partes=ParteBD.obtenerListaIdsPartes();
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_VEHICULO2.visualizar_datos_vehiculo_cod(?,?)}");

            cs.setInt(1, CodVehiculo);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            if(rs.next())
            {
                v = new Vehiculo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
               
            }
            for(Parte p:partes)
            {
                v.setPartes(p);
            }
            
        }
        catch(SQLException e)
        {
            
            
        }
        finally
        {
           cerrarConexion();
        }
        return v;
    }

    public static Vehiculo visualizar_datos_vehiculo_id(Vehiculo v) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idVehiculo=v.getIdVehiculo();
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_VEHICULO2.visualizar_datos_vehiculo_id(?,?)}");

            cs.setInt(1, idVehiculo);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            if(rs.next())
            {
                v = new Vehiculo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
               
            }
            else
            {
                v=null;
            }
        }
        catch(SQLException e)
        {
            
            
        }
        finally
        {
           cerrarConexion();
        }
        return v;
    }
    
    public static void actualizarVehiculo(Vehiculo v)
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int codVehiculo=v.getCodigoV();
        String plantilla;
        try
        {
           
                plantilla = "UPDATE VEHICULOS SET codVehiculo="+v.getCodigoV()+",MATRICULA="+v.getMatricula()
                        +",MARCA="+v.getMarca()
                        +" WHERE codVehiculo="+codVehiculo;
            

        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch(SQLException ex)
        {
            
        }
    }
    
    public static void insetarVehiculo(Vehiculo v)
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String plantilla;
        try
        {
           
                plantilla = "INSERT INTO VEHICULOS (codVehiculo,matricula,marca)"
                        + "VALUES("+v.getCodigoV()+",'"+v.getMatricula()+"','"+v.getMarca()+"')";
            

        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch(SQLException ex)
        {
            
        }
    }
    
    public static void borrarVehiculo(Vehiculo v)
    {
        abrirConexion();
        int codVehiculo=v.getCodigoV();
        String plantilla;
        Connection conn = GenericoBD.getCon();
        try 
        {
               
                plantilla = "DELETE FROM VEHICULOS WHERE codVehiculo="+codVehiculo;
            

        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch (SQLException e) 
        {
            
        }
    }
}
