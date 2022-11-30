
package pe.edu.utp.clase16.daolmpl;

import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.clase16.dao.Operaciones;
import pe.edu.utp.clase16.model.Autor;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import pe.edu.utp.clase16.config.ConexionBD;

public class AutorDaoImpl implements Operaciones<Autor>{
    
    ConexionBD cx = new ConexionBD();
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
    
    
    @Override
    public int create(Autor t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Autor t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Autor read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Autor> readAll() {
        String SQL = "select * from autor";
        List<Autor> datos = new ArrayList<>();
        
        try {
            con = cx.getConexion();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Autor a = new Autor();
                a.setIdautor(rs.getInt("idautor"));
                a.setNombres(rs.getString("nombres"));
                a.setApellidos(rs.getString("apellidos"));
                a.setPais(rs.getString("pais"));                
                datos.add(a);
            }
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
        return datos;
    }
    
}
