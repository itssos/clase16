
package pe.edu.utp.clase16.test;

import com.google.gson.Gson;
import pe.edu.utp.clase16.config.ConexionBD;
import java.sql.Connection;
import pe.edu.utp.clase16.daolmpl.AutorDaoImpl;
import pe.edu.utp.clase16.daolmpl.LibroDaoImpl;
import pe.edu.utp.clase16.model.Libro;
import pe.edu.utp.clase16.view.LibroFrame;
public class Test {
    
    static AutorDaoImpl adi = new AutorDaoImpl();
    static LibroDaoImpl lbi = new LibroDaoImpl();
    static Gson gson = new Gson();
    
    
    
    
    public static void main(String[] args) {
        
        LibroFrame lf = new LibroFrame();
        lf.setVisible(true);
        
        
        ConexionBD co = new ConexionBD();
        Connection cc = co.getConexion();
//        Listar();
//        Listar2();
    }
    
    static void conexion(){}
    
    static void Listar(){
        System.out.println(gson.toJson(adi.readAll()));
    }
    static void Listar2(){
        System.out.println(gson.toJson(lbi.readAll()));
    }
    static void crear(){
        System.out.println(lbi.create(new Libro(0,"Prueba",2022,315,1)));
    }
    static void modificar(){
        System.out.println(lbi.update(new Libro(2,"Prueba22",2020,320,1)));
    }
    static void read(){
        System.out.println(gson.toJson(lbi.read(2)));
    }
    static void eliminar(){
        System.out.println(lbi.delete(2));
    }
}
