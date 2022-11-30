package pe.edu.utp.clase16.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionBD {
    String DRIVER = "com.mysql.jdbc.Driver";
    String USUARIO = "root";
    String PASSWORD = "olqaikws123AZ";
    String URL = "jdbc:mysql://localhost:3306/bdclase16";
    static Connection con;
    
    public ConexionBD(){
        con = null;
        try {
            Class.forName(DRIVER);
            con = (Connection) DriverManager.getConnection(URL, USUARIO, PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexión establecida");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión " + e.getMessage());
        }
    }
    
    public Connection getConexion()
    {
        return con;
    }
    public void desconectar()
    {
        con=null;
        if(con == null)
           JOptionPane.showMessageDialog(null,"conexión terminada"); 
    }
    
}
