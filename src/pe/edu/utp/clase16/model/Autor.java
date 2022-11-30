
package pe.edu.utp.clase16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor { 
    private int idautor;
    private String nombres;
    private String apellidos;
    private String pais;
}
