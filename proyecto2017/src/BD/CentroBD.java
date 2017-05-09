/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.Centro;
import UML.Trabajador;
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
public class CentroBD extends GenericoBD
{
    
    
    
    public static ArrayList visualizarListaNombreCentros() 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Centro> nombreCentros=new ArrayList<>();
        Centro c;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_CENTRO2.visualizar_lista_nombre_centro(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                c = new Centro(0,rs.getString(1),null,0,null,null,null,null);
                nombreCentros.add(c);
            }
        }
        catch(SQLException e)
        {
            
            
        }
        finally
        {
           cerrarConexion();
        }
        return nombreCentros;
    }
    
    
    public static Centro visualizarCentroNombre(Centro c) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String nombreCentro=c.getNombre();
        ArrayList<Trabajador>trabajadores=TrabajadorBD.listaidTrabajadores();
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_CENTRO2.visualizar_datos_centro_nombre(?,?)}");
            cs.setString(1, nombreCentro);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                c = new Centro(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8));
            }
            for(Trabajador t:trabajadores)
            {
                c.setTrabajadores(t);
            }
        }
        catch(SQLException e)
        {
           c = null;
        }
        finally
        {
           cerrarConexion();
        }
       return c;
    }
    
   
    public static void insertarCentro(Centro c)
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        try
        {
        String plantilla = "INSERT INTO CENTROS (NOMBRE, CALLE, NUMERO, CP, CIUDAD, PROVINCIA, TELEFONO) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.setString(1,c.getNombre());
        ps.setString(2,c.getCalle());
        ps.setInt(3,c.getNumero());
        ps.setString(4,c.getCp());
        ps.setString(5,c.getCiudad());
        ps.setString(6,c.getProvincia());
        ps.setString(7,c.getTelefono());
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
        
    public static void modificar(Centro c) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idCentro=c.getIdCentro();
        String plantilla = "UPDATE CENTROS SET(NOMBRE, CALLE, NUMERO, CP, CIUDAD, PROVINCIA, TELEFONO) "
                + "VALUES (?,?,?,?,?,?,?) WHERE IDCENTRO = "+ idCentro;
        try
        {
        PreparedStatement ps=conn.prepareStatement(plantilla);
        ps.setString(1,c.getNombre());
        ps.setString(2,c.getCalle());
        ps.setInt(3,c.getNumero());
        ps.setString(4,c.getCp());
        ps.setString(5,c.getCiudad());
        ps.setString(6,c.getProvincia());
        ps.setString(7,c.getTelefono());
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
        
    public static void borrarCentro(Centro c)
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idCentro = c.getIdCentro();
        try
        {
        String plantilla = "DELETE FROM CENTROS WHERE idCentro=" + idCentro;
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
