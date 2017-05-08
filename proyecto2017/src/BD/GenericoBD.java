package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericoBD {
    private static Connection con;

    public static boolean abrirConexion()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            
            String login="PRUEBASC";
            String password= "soybatman94";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            con = DriverManager.getConnection(url,login,password);
            return true;     
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("No se pudo abrir la conexion");
            return false;
            
        }
        
    }
    
    public static boolean cerrarConexion()
    {
        try
        {
            con.close();
            return true;
        }
        catch(SQLException e){
            System.out.println("No se pudo cerrar la conexion");
            return false;
        }
    }

    public static Connection getCon() 
    {
        return con;
    }
    
}
