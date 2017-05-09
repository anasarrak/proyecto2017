/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.GenericoBD.cerrarConexion;
import UML.Aviso;
import UML.Categoria;
import UML.Centro;
import UML.Parte;
import UML.Trabajador;
import UML.Usuario;
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
public class TrabajadorBD extends GenericoBD
{
    public static ArrayList visualizarListaDnisTrabajador() 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Trabajador> dnisTrabajador=new ArrayList<>();
        Trabajador t;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_TRABAJADOR2.visualizar_lista_dnis(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                t = new Trabajador(0, rs.getString(1), null, null, null, null, null, 
                        null, null, null, null, 0.0, null,null,null,null,null);
                dnisTrabajador.add(t);
            }
        }
        catch(SQLException e)
        {
            
            
        }
        finally
        {
           cerrarConexion();
        }
        return dnisTrabajador;
    }
    
    public static ArrayList listaidTrabajadores()
    {
   
        abrirConexion();
        ArrayList <Trabajador> trabajadoresId=new ArrayList<>();
        String plantilla;
        ResultSet resultado;
        Trabajador t = null;
        
        Connection conn = GenericoBD.getCon();
        
        
        Statement s;
        try
        {
            
            
            
            plantilla="select idTrab from trabajadores ";
            
            
            s = conn.createStatement();
            
            resultado = s.executeQuery( plantilla );
            
            
            while(resultado.next())
            {
                t = new Trabajador(resultado.getInt(1),null, null, null, null, null, null, 
                        null, null, null, null, 0.0, null,null,null,null,null);
                trabajadoresId.add(t);
            }
        }
        catch(SQLException EX)
        {
         EX.printStackTrace();
        }
        return trabajadoresId;
    
    }
    
    public static Trabajador visualizar_datos_trabajador(Trabajador t) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList<Parte>partes=ParteBD.obtenerListaIdsPartes();
        String dni=t.getDni();
        System.out.println(t);
    
        
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_TRABAJADOR2.visualizar_datos_trabajador(?,?)}");

            cs.setString(1, dni);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            
            if(rs.next())
                
                t=new Trabajador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
                rs.getString(11), rs.getDouble(12), rs.getDate(13), 
                        new Centro(rs.getInt(14), null, null, 0, null, null, null,null),
                new Aviso(rs.getInt(15),null,null,null,null),
                        new Usuario(rs.getInt(16),null,null,null),
                        new Categoria(rs.getInt(17),null,null));
            for(Parte p:partes)
            {
                t.setPartes(p);
            }
                
            
            
            
        }
        catch(SQLException e)
        {
            
            e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
        return t;
    }
    
    public static Trabajador buscarIdTrabajadorParaLog(Usuario us) 
    {
        abrirConexion();
        String plantilla;
        ResultSet resultado;
        Trabajador t = null;
        Connection conn = GenericoBD.getCon();
        System.out.println(us);
        
        Statement s;
        try
        {
            
            
            
            plantilla="select dni from trabajadores where idTrab="+us.getT().getIdTrab();
            
            
            s = conn.createStatement();
            
            resultado = s.executeQuery( plantilla );
            
            
            if ( resultado.next() )
            
                
                t= new Trabajador(us.getIdUsuario(),resultado.getString(1),null,null,null,null,null,null,null, 
                        null,null,0.0,null,null,null,null,null);
                
            
            
        }
        catch(SQLException EX)
        {
         EX.printStackTrace();
        }
        return t;
    }
    
    public static Categoria buscarCategoria(Trabajador t)
    {
        abrirConexion();
        String plantilla;
        Categoria cat = null;
        ResultSet resultado;
        System.out.println(t);
        System.out.println(t);
        Connection c = GenericoBD.getCon();
        Statement s ;
        
        try
        {
            System.out.println(t.getIdTrab());
            
            
            plantilla="select idTipo,tipo from tipoTrabajadores where idTipo="+t.getCat().getIdTipo();
            
            System.out.println(plantilla);
            
            s = c.createStatement();
            
            resultado = s.executeQuery( plantilla );
            
            
            
            if ( resultado.next() )
            {
                
                cat=new Categoria(resultado.getInt(1),resultado.getString(2),new Trabajador(t.getIdTrab(),null,null,null,
                        null,null,null,null,null,null,null,0.0,null,null,null,null,null));
                
            }
            else
            {
                cat=null;
            }

            System.out.println(cat);
        }
        catch( SQLException ex)
        {
            
        }
        finally
        {
            cerrarConexion();
        }       
        return cat;
        
    }
    
   
    public static void actualizarTrabajador(Trabajador t) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String dniTrabajador=t.getDni();
        String plantilla;
        try
        {
            
                plantilla = "UPDATE TRABAJADORES SET NOMBRE='"+t.getNombre()
                        +"',APELLIDOUNO='"+t.getApellidouno()+"',APELLIDODOS='"+t.getApellidodos()
                        +"',CALLE='"+t.getCalle()+"',PORTAL='"+t.getPortal()+"',PISO='"+t.getPiso()
                        +"',MANO='"+t.getMano()+"',TELEFEMPRE='"+t.getTelefempre()+"',TELEFPERSO='"+t.getTelefperso()
                        +"',SALARIO="+t.getSalario()+",FECHA_NAC="+t.getFechaNac()
                        +",CENTRO="+t.getC().getIdCentro()
                        +",CATEGORIA="+t.getCat().getIdTipo()+" WHERE DNI='"+dniTrabajador+"'";
            

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
    
    public static void insertarTrabajador(Trabajador t) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String plantilla;
        try
        {
            
                plantilla = "INSERT INTO TRABAJADORES (DNI,NOMBRE,APELLIDOUNO,APELLIDODOS,CALLE,PORTAL,PISO,MANO,TELEFEMPRE"
                        + ",TELEFPERSO,SALARIO,FECHA_NAC,CENTRO,AVISO,USUARIO,CATEGORIA) VALUES ('"+t.getDni()+"',"
                        + "'"+t.getNombre()+"','"+t.getApellidouno()+"','"+t.getApellidodos()
                        +"','"+t.getCalle()+"','"+t.getPortal()+"','"+t.getPiso()
                        +"','"+t.getMano()+"','"+t.getTelefempre()+"','"+t.getTelefperso()
                        +"',"+t.getSalario()+","+t.getFechaNac()
                        +","+t.getC().getIdCentro()+","+t.getA().getIdAviso()+","+t.getU().getIdUsuario()
                        +","+t.getCat().getIdTipo()+")";
            

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
    
    public static void borrarTrabajador(Trabajador t) 
    {
        abrirConexion();
        Connection conn = GenericoBD.getCon();
        String dni = t.getDni();
        try
        {
            String plantilla = "DELETE FROM TRABAJADORES WHERE dni='" + dni+"'";
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