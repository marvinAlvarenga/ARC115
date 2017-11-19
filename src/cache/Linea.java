package cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una linea de datos en la cache
 * @author Marvin
 */
public class Linea {
    
    public static final int CORRESPONDENCIA_DIRECTA = 0;
    public static final int CORRESPONDENCIA_ASOCIATIVA = 1;
    public static final int CORRESPONDENCIA_POR_CONJUNTO = 2;
    public static final int TAMANIO_BLOQUE = 8;
    
    public List<String> linea = new ArrayList<>();
    public String etiqueta;

    public void inicializarElementos(){
        for(int i=0;i<8;i++){
            linea.add("00");
        }
    }
    
}
