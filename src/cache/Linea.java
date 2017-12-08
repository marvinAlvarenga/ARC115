package cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una linea de datos en la cache
 * @author Marvin
 */
public class Linea {
    
    
    public List<String> linea = new ArrayList<>();
    public String etiqueta;
    public int usado = 0;
    public int ordenLLegada = 0;

    public void inicializarElementos(){
        for(int i=0;i<Cache.TAMANIO_BLOQUE;i++){
            linea.add("00");
        }
    }
    
}
