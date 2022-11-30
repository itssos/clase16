
package pe.edu.utp.clase16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    private int idlibro;
    private String titulo;
    private int anio;
    private int npaginas;
    private int idautor;
}
