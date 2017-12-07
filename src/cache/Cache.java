package cache;

/**
 *
 * @author Marvin
 */
public class Cache {
    public static final int CORRESPONDENCIA_DIRECTA = 0;
    public static final int CORRESPONDENCIA_ASOCIATIVA = 1;
    public static final int CORRESPONDENCIA_POR_CONJUNTO = 2;
    public static final int TAMANIO_BLOQUE = 8;
    
    /**
     * Devuelve la etiqueta de una direccion fisica
     * @param direccion La direccion a la que se le extraera la etiqueta
     * @param correspondencia Funcion de correspondencia de la Cache
     * @return 
     */
    public static String generarEtiqueta(String direccion, int correspondencia){
        String etiquetaBin = null;
        String etiqueta = null;
        int decimal = Integer.parseInt(direccion, 16);
        String binario = Integer.toBinaryString(decimal);
        int relleno = 20 - binario.length();
        for(int i=0; i<relleno; i++){
            binario = "0" + binario;
        }
        switch(correspondencia){
            case CORRESPONDENCIA_DIRECTA:
                etiquetaBin = binario.substring(0, binario.length() - 10);
                etiqueta = Integer.toString(Integer.parseInt(etiquetaBin, 2), 16);
            break;
        }
        return etiqueta;
    }
    
    /**
     * Devuelve el numero de bloque al que corresponde la direccion
     * @param direccion La direccion a la que se le extraera el numero de bloque
     * @return El numero de bloque
     */
    public static int generarBloqueMP(String direccion){
        int bloque = 0;
        int decimal = Integer.parseInt(direccion, 16);
        String binario = Integer.toBinaryString(decimal);
        int relleno = 20 - binario.length();
        for(int i=0;i<relleno;i++){
            binario = "0" + binario;
        }
        String bloqueString = binario.substring(0, 17);
        bloque = Integer.parseInt(bloqueString, 2);
        return bloque;
    }
    
    /**
     * Retornar el numero de palabra solicitado
     * @param direccion La direccion completa
     * @return El numero de palabra que se solicita
     */
    public static int generarPalabra(String direccion){
        int palabra = 0;
        int decimal = Integer.parseInt(direccion, 16);
        String binario = Integer.toBinaryString(decimal);
        int longi = binario.length();
        String palabraString = binario.substring(longi-3, longi);
        palabra = Integer.parseInt(palabraString, 2);
        return palabra;
    }
}
