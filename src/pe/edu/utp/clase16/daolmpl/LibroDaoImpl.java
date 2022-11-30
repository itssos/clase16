
package pe.edu.utp.clase16.daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.clase16.config.ConexionBD;
import pe.edu.utp.clase16.dao.Operaciones;
import pe.edu.utp.clase16.model.Autor;
import pe.edu.utp.clase16.model.Libro;
import java.sql.SQLException;

public class LibroDaoImpl implements Operaciones<Libro>{
    
    ConexionBD cx = new ConexionBD();
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
    
    @Override
    public int create(Libro t) {
        int x = 0;
        String SQL = "insert into libro (titulo, anio, npaginas, idautor) values (?,?,?,?)";
        try {
            con = cx.getConexion();
            ps = con.prepareStatement(SQL);
            ps.setString(1, t.getTitulo());
            ps.setInt(2, t.getAnio());
            ps.setInt(3, t.getNpaginas());
            ps.setInt(4, t.getIdautor());
            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return x;
        
    }

    @Override
    public int update(Libro t) {
        int x = 0;
        String SQL = "update libro set titulo=?, anio=?, npaginas=?, idautor=? where idlibro=?";
        try {
            con = cx.getConexion();
            ps = con.prepareStatement(SQL);
            ps.setString(1, t.getTitulo());
            ps.setInt(2, t.getAnio());
            ps.setInt(3, t.getNpaginas());
            ps.setInt(4, t.getIdautor());
            ps.setInt(5, t.getIdlibro());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        int x = 0;
        String SQL = "delete from libro where idlibro=?";
        try {
            con = cx.getConexion();
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Libro read(int id) {
        String SQL = "select *from libro where idlibro =?";
        Libro l = new Libro();
        try {
            con = cx.getConexion();
            ps = con.prepareStatement(SQL); 
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){                
                l.setIdlibro(rs.getInt("idlibro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAnio(rs.getInt("anio"));
                l.setNpaginas(rs.getInt("npaginas"));
                l.setIdautor(rs.getInt("idautor"));
 
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return l;
        
    }

    @Override
    public List<Libro> readAll() {
        String SQL = "select * from libro";
        List<Libro> datos = new ArrayList<>();
        
        try {
            con = cx.getConexion();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Libro l = new Libro();
                l.setIdlibro(rs.getInt("idlibro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAnio(rs.getInt("anio"));
                l.setNpaginas(rs.getInt("npaginas"));                
                l.setIdautor(rs.getInt("idautor"));                
                datos.add(l);
            }
            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return datos;
    }
    
}
