
package pe.edu.utp.clase16.dao;

import java.util.List;

public interface Operaciones<T>{
    
    int create(T t);
    int update(T t);
    int delete(int t);
    T read(int id);
    List<T> readAll();
}
